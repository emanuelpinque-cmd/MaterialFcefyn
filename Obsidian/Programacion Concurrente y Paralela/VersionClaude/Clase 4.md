## Interrupcion de un Thread

- En java un programa finaliza SOLO cuando todos sus Threads terminan su ejecucion (**excepto** los hilos [[Thread|daemon]], que no cuentan para esto)

- Puede ser necesario finalizar la ejecucion de un hilo, un ejemplo seria un generador de numeros primos en algun momento debe terminarse

- Java provee un mecanismo para indicarle al hilo de detenerlo (es simplemente un flag, se activa con `interrupt()`)

- Puede ser ignorado si no implementamos ninguna logica con ese flag

- Si el hilo está bloqueado en `wait()`, `sleep()` o `join()` cuando se interrumpe, se lanza una `InterruptedException` (excepción [[Excepciones|checked]]) para sacarlo de ese estado de espera.

### Ver también
- [[Thread]]
- [[Excepciones]]
