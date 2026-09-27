# Excepciones en Java

## Definición
Una excepción es un evento que ocurre durante la ejecución de un programa y que **interrumpe el flujo normal** de las instrucciones. Java provee un mecanismo (`try`/`catch`/`finally`) para manejarlas.

---

## <font color="#ff0000">Excepciones CHECKED vs UNCHECKED</font>

La diferencia principal está en el **momento del control**:

| | Checked | Unchecked |
|---|---|---|
| Momento de verificación | En **compilación** | En **ejecución** |
| Obligación de manejo | El compilador **obliga** a capturarla o declararla (`throws`) | No es obligatorio capturarla |
| Ejemplos | `IOException`, `InterruptedException` | `NullPointerException`, `ArithmeticException`, `RuntimeException` |
| Uso típico | Errores esperables por condiciones externas (archivo no encontrado, hilo interrumpido) | Errores de programación (bugs) |

---

## Relación con la concurrencia
- El método `wait()` lanza una excepción **checked** (`InterruptedException`), por lo que siempre debe usarse dentro de un bloque `try/catch`:

```java
try {
    wait();
} catch (InterruptedException e) {
    // manejo de la interrupción
}
```

### Ver también
- [[Thread]]
- [[Semaforo]]
