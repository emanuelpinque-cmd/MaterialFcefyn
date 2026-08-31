
- #### Características reactivas de de los sistemas concurrentes

- #### Muchos de los programas concurrentes suelen ser reactivos es decir su funcionalidad involucra una interacción permanentes con el ambiente (y otros procesos)

- ##### Los sistemas reactivos tiene características diferentes a los programas transformacionales, Estos no computan resultados y suele no requerirse que terminen

#### Ej sistemas operativos software de control, hardware etc.

---

## Interacción de programas concurrentes

#### Los programas concurrentes estan compuestos por procesos (o threads, o componentes) que necesitan interactuar

#### Existen varios mecanicos de interaccion entre procesos

#### Entre estos se sncuentran la memoria compartida y el pasaje de mensajes

#### Ademas los programas concurrentes deben, en general colaborar para llegar a un objetivo común, para lo cual la sincronizacion entre procesos es crucial

---
## Los problemas mas comunes con los programas concurrentes

#### Violación de propiedades universales 

#### Starvation: Uno o mas procesos quedan esperando indefinidamente un mensaje o la liberacion de un recurso

#### Deadlock: dos o mas procesos esperan mutuamente el avance del otro

#### Problemas de uso no exclusivo de recursos compartidos

#### Livelock: Dos o mas procesos no pueden avanzar en su ejecucion por que continuamente responden a los cambios en el estado de otros procesos

---
## Ejecución de procesos concurrentes

- #### Los procesos concurrentes se ejecutan intercalando las acciones atómicas que los componen 

- #### Llamamos a esto, interliving.

- #### El orden en que se ejecutan las acciones atomicas no puede decicdirse en general y un mismo par de procesos puede tener diferentes ejecuciones debido al no determinismo en la eleccion de las acciones atomicas a ejecutar.



