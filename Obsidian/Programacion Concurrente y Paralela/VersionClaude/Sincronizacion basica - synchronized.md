# Sincronización básica en Java: `synchronized`

## Sección crítica
Una **sección crítica** es una región de código en la que se accede a un recurso compartido, y en la que **no puede ejecutarse más de un hilo o proceso al mismo tiempo**.
- Si esto ocurre (dos hilos ejecutan la sección crítica a la vez) puede haber comportamientos erróneos (condición de carrera).
- La implementación de la sección crítica busca que solo un hilo pueda acceder por vez, para evitar que el recurso se corrompa.

---

## <font color="#ff0000">El modificador `synchronized`</font>

- `synchronized` delimita una sección crítica y garantiza **exclusión mutua**: solo un hilo a la vez puede ejecutarla.
- Se puede usar de dos formas:

```java
// 1) Como modificador de un método
public synchronized void metodo() { ... }

// 2) Como bloque, indicando explícitamente el objeto lock
synchronized (objeto) {
    ...
}
```

### El argumento (el "lock")
- El argumento de `synchronized(a)` es un **objeto** que actúa como llave (**lock**). Cada objeto, al heredar de `Object`, tiene asociado su propio lock.
- El hilo debe **tomar** el lock del objeto para poder entrar a la sección crítica.
- Al salir de la sección, el hilo **devuelve** el lock, para que otro hilo pueda tomarlo.
- Si otro hilo intenta entrar mientras el lock está tomado, queda **dormido** hasta que se libere.
- **Recomendación**: usar el lock de un objeto del tipo `Object` (o un objeto dedicado), para evitar problemas con locks de objetos "wrapped" (como `Integer`), que pueden compartirse involuntariamente entre distintas partes del código (por el cacheo interno de la JVM).

---

## <font color="#ff0000">Tiempo de una sección crítica</font>
Ejecutar código dentro de una sección crítica (con `synchronized`) es, en promedio, **5 veces más lento** que ejecutarlo sin sincronización. Por eso conviene:
- Minimizar la **cantidad** de secciones críticas en el código.
- Minimizar el **tamaño** (duración) de cada sección crítica.

---

## `wait()`, `notify()` y `notifyAll()`

Estos métodos solo se pueden invocar dentro de un bloque `synchronized` sobre el mismo objeto.

- **`wait()`**: le dice al hilo que llama que **abandone el lock** y se vaya a dormir, hasta que algún otro hilo ingrese al mismo monitor y llame a `notify()`. Libera el lock antes de esperar, y vuelve a adquirirlo antes de regresar de dormir. Debe ir siempre dentro de un `try { wait(); } catch (InterruptedException e) {...}`.
- **`notify()`**: despierta **un solo** hilo que había invocado `wait()` en el mismo objeto. No cede el lock inmediatamente: el hilo despertado deberá esperar a que termine el bloque `synchronized` del notificador para poder retomar el lock.
- **`notifyAll()`**: despierta a **todos** los hilos que llamaron a `wait()` sobre ese objeto.

### Ver también
- [[Semaforo]]
- [[Thread]]
- [[Excepciones]]
- [[Proceso]]
