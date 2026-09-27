# Proceso

## Definición
### Un proceso es un **programa en ejecución**, junto con todo el contexto necesario para ejecutarlo: su código, su memoria de datos, su pila, sus registros, y los recursos que tiene asignados (archivos abiertos, etc.)

- Un proceso **no es lo mismo** que un programa: el programa es estático (código en disco), el proceso es dinámico (una instancia en ejecución).
- Un proceso puede contener uno o más [[Thread|hilos]] de ejecución.

---

## <font color="#ff0000">Estados de un proceso</font>

Un proceso puede transitar por varios estados a lo largo de su vida. El **Sistema Operativo (SO)** es el encargado de gestionar estos cambios de estado.

### Creación
- Es el momento en que el proceso está siendo creado por el SO.
- Desde aquí, el proceso pasa al estado **preparado**, en espera de que el SO le asigne los recursos necesarios para poder pasar a ejecución (running).

### Preparado / Listo
- El proceso tiene todo lo necesario para ejecutar, pero está esperando que el SO (el scheduler) le asigne la CPU.

### Ejecución (Running)
- El proceso está usando la CPU en este momento.

### Bloqueo
- **¿De dónde viene, a dónde va y qué hace?** Viene de estar en ejecución. Se dirige a **bloqueado** y espera una señal (una condición de desbloqueo) dada que finaliza una operación (por ejemplo E/S) o ocurre un evento externo.
- Por lo general un proceso se bloquea cuando necesita esperar algún input/output (algún carácter de texto o un dispositivo a conectar, por ejemplo) o porque fue bloqueado al no poder ingresar a una zona de exclusión mutua. Una vez bloqueado, el proceso "duerme".

### Desbloqueo
- **¿De dónde viene, a dónde va y qué hace?** Viene del estado **bloqueado**; cuando recibe la señal de desbloqueo, va a **listo/preparado**. Lo que hace es esperar la condición de desbloqueo (la señal) para poder retomar la cola de listos.
- El bloqueo se libera o desbloquea cuando se ha completado la E/S del sistema, o se adquirió la llave (lock) para ingresar a la zona de exclusión mutua.

### Terminación
- El proceso finaliza su ejecución y libera todos los recursos que tenía asignados.

---

## <font color="#2DC26B">Diagrama simplificado de transición de estados</font>

```
Creación → Preparado ⇄ Ejecución → Terminación
                ↑            ↓
              Desbloqueo ← Bloqueo
```

---

## Diferencia con los hilos (threads)
- Un **proceso** tiene su propio espacio de memoria, aislado de otros procesos.
- Un **thread** (hilo) comparte el espacio de memoria con los demás hilos del mismo proceso, y es una unidad más liviana de ejecución.
- Ver [[Thread]] para el detalle de sus estados en Java.

### Ver también
- [[Concurrencia]]
- [[Thread]]
