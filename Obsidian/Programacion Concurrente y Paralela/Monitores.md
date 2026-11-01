
### Motivacion

Nuestra principal motiviacion es el problema de los semáforos los cuales tienen muchos propósitos estos pueden ser.
- Exclusion Mutua
- Sincronizacion
- Compartir recursos
El código se vuelve difícil de leer mas cuando el problema crece lo suficiente
Incrementa la complejidad por lo tanto el testing

Debilidades de los semáforos:
- La omision de una de estas primitivas puede corromper la operación de un sistema concurrente.
- El control de la concurrencia es responsabilidad del programador
- Las primitivas de control se encuentran esparcidas por todo el código

Otros inconvenientes

Los semáforos llevan fácilmente a errores

La ejecucion de cada sección critica sobre un semáforo debe:

- Comenzar con wait()
- Terminal con signal() No se puede restringir el tipo de operación sobre recurso

Se debe incluir todas las sentencias criticas en la sección critica

Tanto la sección critica como la sincronizacion se implementan usando las mismas primitivas y luego son dificiles de identificar

Los programas que usan semáforos son difícil de mantener

### Que buscasmos?

Lo que buscamos es compartir un recurso, es decir muchos procesos comparten un mismo recurso nuestra intencion es que cada proceso tenga metodos para accionar sobre ese recurso

La comunicacion entre procesos se realizan mediante las operaciones sobre el recurso compartido

La exclusion mutua se produce entre todas las operaciones del recurso

Por ejemplo un Proceso obtiene informacion del estado del recurso consultando su disponibilidad, en caso de estar ocupado este esperar

---
Los monitores están vivos solo por sus hilos que lo invocan

Solo va a haber un hilo ejecutándose dentro del monitor

Los procesos dentro de un monitor suelen estar en 2 estados

- Activo:modifica las variables de condicion del monitor atraves de sus métodos
- Bloqueados:Estan esperando a que se cumplan las variables de condición, cuando se cumplan vuelven al estado Activo

#### El monitor consta de 2 partes logicas

- algoritmo para la manipulacion de recursos y sincronizacion
- Mecanismos para asignar el orden en el cual los procesos asociados pueden compartir el recurso y/o son sincronizados

Como dijimos antes los procesos ACTIVOS que usan el monitor, este(el monitor) ofrece un conjunto de procedimientos para utilizar recursos compartidos y sincronizar actividades

##### Se cumple que
- Todos los metodos de un monitor deben ejecutarse en exclusion mutua TODOS sus metodos pasar por un mutex, es decir un semaforo todos los metodos tienen que pasar por el el cual es inicializado en 1

- Se define la sincronizacion por condicion de cada uno de los metodos del monitor

##### Para que sirven las variables de condición?

- Bloquear procesos hasta que se cumplan las condiciones para que puede ejecutar
- Notificar (señalizar) a un procesos bloqueado para que pueda continuar su ejecución cuando se cumplan las condiciones para ejecutarse

---
Estructura básica de un monitor

Para que un proceso obtenga un recurso que espera necesitamos que la logica del monitor le de prioridad sobre los nuevos procesos que solicitan entrar al monitor

Si no tenemos en cuenta esto los nuevos procesos que quieren entrar al monitor tomaran el recurso l que puede postergar indefinidamente la obtencion del recurso de ese proceso esperando
![[Pasted image 20261024145154.png]]

Por eso el monitor no solo administra los recursos sino que entrega dichos recursos de tal forma que no exista inanición entre los procesos

---
### Colas de prioridad

Colas de variable de condicion:Estas pueden ser N colas, como dijimos el monitor tiene variables de condicion 
- en caso de no cumplirse ejecuto un wait dicho procesos se va a la cola de variable de condicion.

- En caso de cumplirse dicha condicion(las mira el proceso que actualmente tiene el monitor) dicho proceso ejecuta un signal para despertar al proceso que cumplio la condicion, evidentemente este hilo va a tener que abandonar su ejecucion depende de las politicas

---
Variables del monitor
- Declaracion de variables Globales
- Procedimientos Variables locales
- Procedimientos dentro del monitor
- Procedimientos de inicializacion

---
## Elementos que componen al Monitor

#### Conjunto de variables locales

#### Constructor

#### conjunto de procedimientos internos

#### Declaracion de procedimientos que son exportados