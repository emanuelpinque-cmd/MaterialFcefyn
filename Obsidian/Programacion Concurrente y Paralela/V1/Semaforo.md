Un semaforo puede comprenderse como un contador que protege el acceso a uno o mas recursos compartidos

#### Cuando un hilo quiere acceder a un recurso compartido primero debe adquirir el semaforo

- Si el valor del contador es mayor a 0, se decrementa y ACCEDE al recursos

- Si el valor del contador es 0, el acceso es negado y el hilo se va a dormir a la cola del semaforo

- Cuando un hilo finaliza el uso del recurso debe liberar el semaforo, lo que incrementa el valor del contador de dicho semaforo

---

- Cuando un semadoro protege un solo recurso sus valores pueden ser 0 y 1, en ese caso se denomina semaforo binario

