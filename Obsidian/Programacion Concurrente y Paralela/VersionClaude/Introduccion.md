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

---

## <font color="#ff0000">Sistemas críticos</font>

- Un sistema es **crítico** cuando una falla puede traer consecuencias graves: pérdidas económicas importantes, daño ambiental, o incluso pérdida de vidas humanas.
- Ejemplos: sistemas de control de vuelo, sistemas médicos, control de plantas nucleares o industriales, sistemas de transporte.
- En estos sistemas, **no alcanza** con probar (testear) que el software funciona: se requieren métodos formales de verificación.

## <font color="#ff0000">Limitaciones del testing en sistemas concurrentes</font>

- En un programa concurrente, el **número de interleavings posibles es en general muy grande** (crece exponencialmente con la cantidad de procesos y acciones).
- Por lo tanto, **no es factible diseñar un testing que verifique exhaustivamente** el buen funcionamiento de un programa concurrente: puede haber un interleaving particular que ocurra bajo condiciones muy específicas, y el testing puede no haberlo contemplado.
- **Un programa concurrente puede funcionar bien 10.000 veces y fallar solo 1**: el testing puede advertir la **presencia** de errores, pero nunca puede confirmar su **ausencia**.
- Por esto, para sistemas críticos se recurre a **verificación formal** (modelos matemáticos, como las [[Redes de petri]] o los autómatas), que sí puede dar garantías sobre **todos** los comportamientos posibles del sistema, no solo los que se probaron.

## Enfoque de modelo
- En lugar de razonar directamente sobre el código (muy complejo, con detalles de implementación que no son relevantes), se construye un **modelo abstracto** del sistema (por ejemplo, una red de Petri o una máquina de estados) que captura sus características esenciales:
	- **Datos**
	- **Recursos**
	- **Interacción con el medio**
	- **Concurrencia**
- Sobre ese modelo se pueden introducir mecanismos para verificar formalmente que satisface condiciones particulares de **seguridad** (nunca pasa algo malo) y **propiedades de progreso** (eventualmente pasa algo bueno).
- Estas propiedades que se cumplen a lo largo de la ejecución del programa incluyen: exclusión mutua, sincronización, invariantes referidos a los recursos, invariantes referidos a las acciones, concurrencia, persistencia y conflicto.

### Ver también
- [[Concurrencia]]
- [[Proceso]]
- [[Redes de petri]]
