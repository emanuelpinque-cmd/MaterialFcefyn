Un semaforo puede comprenderse como un contador que protege el acceso a uno o mas recursos compartidos

#### Cuando un hilo quiere acceder a un recurso compartido primero debe adquirir el semaforo

- Si el valor del contador es mayor a 0, se decrementa y ACCEDE al recursos

- Si el valor del contador es 0, el acceso es negado y el hilo se va a dormir a la cola del semaforo

- Cuando un hilo finaliza el uso del recurso debe liberar el semaforo, lo que incrementa el valor del contador de dicho semaforo

---

## <font color="#2DC26B">Tipos de semáforo</font>

- Cuando un semaforo protege un solo recurso sus valores pueden ser 0 y 1, en ese caso se denomina **semaforo binario**
- Cuando protege varias copias de un mismo recurso, el contador puede tomar cualquier valor entero **mientras sea positivo**, en ese caso se denomina **semaforo general** (o contador)

---

## Construcción de un semáforo (Java)

Al crear un semáforo se le deben pasar **2 parámetros**:
1. El **número de recursos** disponibles (valor inicial del contador)
2. Un valor **booleano** que determina el **fairness** (equidad): si es `true`, los hilos acceden al recurso en el mismo orden en que lo solicitaron (FIFO); si es `false`, no hay garantía de orden.

## Semáforo vs. Synchronized
Un semáforo es una herramienta de sincronización de **más alto nivel** que `synchronized`, ya que puede proteger **varios recursos** a la vez (con un contador > 1), y no necesariamente el mismo bloque de código: los recursos protegidos pueden o no estar en el mismo bloque.
- El semáforo tiene su propia **cola asociada**, donde se acumulan los hilos puestos a dormir que están esperando poder acceder al recurso.

### Ver también
- [[Concurrencia]]
- [[Thread]]
