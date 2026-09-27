#### La concurrencia puede presentarse en 3 contextos
##### Multiples aplicaciones:
  ###### la multiprogramacion se creo para que el tiempo del procesador fuera compartido entre varias aplicaciones
##### Aplicaciones estructuradas:
###### Algunas aplicaciones pueden implementarse eficazmente como un conjunto de hilos concurrente

##### Estructura del sistema operativo
###### Algunos sistemas operativos estan implementado como un conjunto de procesos o hilos

---
## Concurrente
 Un sistema concurrente correcto es aquel en el que un conjunto de computos avanzan colaborativamente para lo cual esta garantizada y coordinar la secuencia de las interacciones o comunicaciones entre diferentes computos como asi tambien el acceso a recursos que se comparten
## Paralela
Es una forma de computo en al que muchas instrucciones se ejectutan simultaneamente operando sobre un principio de que problemas grandes a menudo pueden divirse en problemas mas pequeños, que luego son resueltos simulataneamente (en paralelo)

---

## <font color="#ff0000">Concurrente vs. Paralelo (comparación para el parcial)</font>

| | Concurrente | Paralelo |
|---|---|---|
| Ejecución | Se **intercalan** (interleaving) las acciones atómicas; puede ser simultáneo o no | Se ejecutan realmente **al mismo tiempo**, en distintos procesadores/núcleos |
| Recursos | Comparten recursos (memoria, variables) | En general no comparten recursos entre sí |
| Determinismo | El interleaving puede ser cualquiera, incluso el simultáneo | Depende de la capacidad real del sistema (núcleos disponibles) |

---

## <font color="#2DC26B">Multiprogramación, multiprocesamiento y procesamiento distribuido</font>

- **Multiprogramación**: varios programas compiten por los recursos de **un único procesador**. El tiempo de CPU se reparte entre ellos (dando la ilusión de simultaneidad).
- **Multiprocesamiento**: varios programas compiten por los recursos de **varios procesadores** que comparten memoria (en la misma máquina).
- **Procesamiento distribuido**: varios procesadores, **cada uno con su propia memoria local**, cooperan para resolver un problema común, comunicándose por pasaje de mensajes (no comparten memoria).

---

## Principios generales de la concurrencia
- Compartir recursos globales de manera segura es **riesgoso**: si dos o más procesos manipulan la misma variable global y las operaciones que se ejecutan sobre ella no son atómicas, se pueden producir resultados erróneos (condición de carrera).
- Es **difícil** para el sistema operativo (o el runtime) gestionar de manera óptima la asignación de recursos.
- Los errores de concurrencia son **difíciles de localizar**: no siempre son reproducibles (dependen del interleaving particular que ocurrió esa vez).

---

## <font color="#ff0000">Interacción entre procesos</font>

### Niveles de conocimiento entre procesos
1. **Procesos ajenos entre sí (no se conocen)**: compiten por recursos, pero no interactúan directamente. Ej: dos procesos que compiten por la CPU o por un archivo.
2. **Procesos que se conocen indirectamente**: colaboran a través de un recurso compartido (memoria, archivo), sin conocer la identidad del otro proceso directamente.
3. **Procesos que se conocen directamente**: se comunican explícitamente entre sí (por ejemplo, mediante pasaje de mensajes con un identificador de destinatario).

### Competencia entre procesos por los recursos
Cuando dos o más procesos necesitan acceder a un recurso que no puede ser compartido de forma segura (por ejemplo, una variable, un archivo, una impresora), se debe garantizar la **exclusión mutua**.

#### <font color="#2DC26B">Requisitos para la exclusión mutua</font>
1. La exclusión mutua debe cumplirse sin importar la velocidad relativa de los procesos.
2. Un proceso que se detiene fuera de la sección crítica no debe interferir con otros procesos.
3. No se debe producir **deadlock** ni **starvation** (inanición).
4. Un proceso no debe esperar indefinidamente para entrar a su sección crítica.
5. No se debe asumir nada sobre el número de CPUs ni sus velocidades relativas.
6. Un proceso permanece dentro de su sección crítica solo por un tiempo finito.

### Sincronización entre procesos (pasaje de mensajes)
- **Send/Receive bloqueante o no bloqueante**: las primitivas de comunicación pueden ser bloqueantes (el proceso espera hasta que la operación se complete) o no bloqueantes (el proceso continúa inmediatamente).
- Combinaciones típicas: envío bloqueante/recepción bloqueante (rendezvous), envío no bloqueante/recepción bloqueante (buzón), etc.

### Ver también
- [[Proceso]]
- [[Thread]]
- [[Introduccion]]
- [[Semaforo]]
