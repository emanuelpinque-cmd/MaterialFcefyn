*Referencias:** 🟢 = respuesta/comentario del profe (tomado de los "Comentario:" de tus parciales) · 🔵 = respuesta mía, porque el profe no dejó comentario.

---

## Prioridad de estudio (de más a menos crítico)

*Estimación según cuántas veces apareció cada tema en los parciales 2020, 2021 y 2023 y las respuestas escritas.*

### ⚠️⚠️⚠️ Críticos (salen casi siempre)
1. **Interleaving, no determinismo, testing y condición de carrera:** cómo se ejecutan los concurrentes, por qué distintos interleavings dan distintos resultados, por qué el testing no alcanza y qué son las operaciones atómicas.
2. **Estados de hilo/proceso (creación, bloqueo, desbloqueo, listo):** de dónde viene, a dónde va y qué hace la MV.
3. **Cantidad de estados de un proceso con N hilos** (ojo con el "12" vs. 81 de más abajo).
4. **wait(), notify(), notifyAll() y la precaución del try/catch.**
5. **Monitor:** qué es y qué ventaja tiene.
6. **Autómatas y gramáticas con las fórmulas aⁿbⁿ y aⁿbᵐ:** qué tipo corresponde a cada una y por qué el autómata finito no puede con aⁿbⁿ.
7. **Turing vs. autómata lineal acotado vs. autómata a pila**, y si un programa se puede expresar con cada uno.
8. **Definiciones de lenguaje, gramática (cuádrupla) y su relación con el autómata.**

### ⚠️⚠️ Importantes (salen seguido)
9. **Starvation** en tiempo real.
10. **Programa reactivo:** la característica principal.
11. **synchronized y su argumento (el lock).**
12. **Sección crítica y cómo se protegen los recursos compartidos.**

### ⚠️ Medios (salieron pocas veces, pero son puntos fáciles)
13. **Semáforo:** qué es, tipos y fairness.
14. **Limitaciones de la verificación automática** (terminación y computabilidad).
15. **Paralelo vs. concurrente.**
16. **Propiedades de seguridad y progreso, y modelado con Petri** (solo lo básico).
17. **Grafo de transición de estados:** nodos = estados, aristas = acciones.

### Bajos (pocos archivos, pero de los parciales más recientes: no los dejes para el final)
18. **Temas de Java del 2023 y las respuestas escritas:** excepciones checked vs. unchecked, ownership de lock y semáforo, hilos daemon, variable local de hilo, Mealy vs. Moore.
19. **Redes de Petri** más allá de lo básico (no salieron preguntas directas en ningún parcial).

---

## ¿Cómo se ejecutan los procesos concurrentes? (interleaving)

🟢 Los procesos concurrentes se ejecutan intercalando las acciones atómicas que los componen. Llamamos a esto interleaving. El orden en que se ejecutan las acciones atómicas no puede decidirse en general, y un mismo par de procesos puede tener diferentes ejecuciones debido al no determinismo en la elección de las acciones atómicas a ejecutar.

---

## ¿Qué diferencia hay entre la ejecución de procesos paralelos y procesos concurrentes? (interleaving)

🟢 En el paralelo los dos se ejecutan al mismo tiempo. En el concurrente el interleaving puede ser cualquiera, incluso el simultáneo.

---

## ¿El orden en que se ejecutan las sentencias atómicas de un programa concurrente es siempre igual?

🔵 No. Como la ejecución concurrente intercala las acciones atómicas y la elección de cuál se ejecuta es no determinística, el orden no puede decidirse y distintas corridas pueden tener distintas ejecuciones.

---

## ¿Si el sistema es determinístico, los interleavings de acciones atómicas llevan a diferentes resultados o comportamientos?

🟢 No.

---

## ¿Por qué diferentes interleavings de acciones atómicas pueden llevar a diferentes resultados o comportamientos de los sistemas concurrentes?

🔵 Porque en un sistema concurrente no se puede determinar el orden de ejecución de las acciones atómicas de los distintos procesos (hay no determinismo), y según el orden en que se intercalen, los resultados pueden ser distintos.

---

## ¿Por qué diferentes corridas en un programa concurrente con acciones no atómicas pueden llevar a diferentes resultados o comportamientos erróneos?

🟢 Problemas de carrera (condición de carrera).

---

## En un programa concurrente el número de interleavings posibles es en general muy grande. ¿Es factible diseñar un testing para verificar su buen funcionamiento? (de una razón)

🟢 No. En general es muy difícil razonar sobre programas concurrentes, y el número de interleavings posibles es muy grande, lo que hace que el testing difícilmente pueda dar confianza de que funcionan correctamente. Las instancias a testear crecen exponencialmente.

---

## En un programa concurrente, ¿podría garantizar que es correcto realizando testing?

🔵 No. En cada ejecución los resultados pueden ser distintos, por lo que el testing nunca puede garantizar que el programa es correcto: un programa concurrente puede funcionar bien 10.000 veces y fallar en 1. El testing puede advertir la presencia de errores pero nunca confirmar su ausencia.

---

## ¿Cómo son las operaciones atómicas?

🔵 Son las que se ejecutan hasta terminar todo, sin interrupciones: o se ejecutan completas o no se ejecutan, no pueden quedar a medio realizarse.

---

## ¿Para qué son las operaciones atómicas?

🔵 Para garantizar que una operación se ejecute hasta finalizar (o está completa o no empezó), y así proteger los recursos compartidos.

---

## ¿Qué es una sección crítica?

🔵 Es una región de código en la que se accede a un recurso compartido y en la que no puede ejecutarse más de un hilo o proceso al mismo tiempo. Si esto ocurre puede haber comportamientos erróneos. Su implementación busca que solo acceda un hilo por vez.

---

## ¿De una idea (comparativa) de tiempo de una sección crítica?

🟢 5 veces más lenta.

---

## Dé un ejemplo de recursos compartidos que es necesario proteger.

🔵 Variables, estructuras de datos, archivos.

---

## ¿Cómo se protegen los recursos compartidos?

🔵 Determinando una sección crítica que proteja el recurso y restringiendo el acceso a ella a un solo hilo a la vez (por ejemplo con synchronized, locks o semáforos), evitando así que el recurso se corrompa.

---

## Explique el modificador synchronized(argumento) y su argumento.

🔵 synchronized delimita una sección crítica y permite que solo un hilo a la vez la ejecute (exclusión mutua). El argumento es el lock (la "llave"): un objeto (conviene un Object, no un wrapper como Integer) cuyo lock debe tomar el hilo para entrar a la sección; al salir lo devuelve para que otro hilo pueda tomarlo. Si otro hilo quiere entrar mientras tanto, queda dormido hasta que se libere el lock.

---

## Explique el modificador synchronized (a) y el rol de su argumento, donde a es un objeto.

🔵 Igual que la anterior: synchronized(a) define una sección crítica y el objeto a actúa como lock. Cada objeto (al heredar de Object) tiene asociado su propio lock; el hilo lo toma para entrar, lo devuelve al salir, y los demás hilos que quieran entrar esperan hasta que se libere.

---

## ¿Qué es un Monitor?

🔵 Es una herramienta de alto nivel (módulo de abstracción) que permite la gestión de recursos que van a ser utilizados concurrentemente, centralizando la exclusión mutua y la sincronización.

---

## ¿Qué ventaja tiene un Monitor?

🟢 Por ser un patrón de alto nivel y centralizar la gestión de los hilos, mantiene todos los mecanismos (exclusión mutua, sincronización, etc.) en la misma estructura.

---

## ¿Qué es un semáforo?

🟢 Un semáforo es una herramienta de sincronización que nos permite proteger varios (o uno) recursos. Cuenta con una cola en la que se irán poniendo los hilos puestos a dormir que están esperando para ingresar a estos recursos. Se le deben ingresar 2 parámetros: uno con el número de recursos y otro booleano para determinar el fairness.

---

## ¿Qué tipos de semáforo conoce?

🔵 Dos tipos: semáforo binario (solo puede tomar los valores 0 y 1) y semáforo general (puede tomar cualquier valor mientras sea positivo).

---

## Explique el concepto de OWNERSHIP (dueño) en las primitivas de LOCK y SEMAPHORE en Java.

🔵 Ownership es el concepto de qué hilo tiene la posibilidad de modificar el valor del cerrojo. Los locks tienen owner: solo puede liberarlo el hilo que lo tomó. En los semáforos no hay owner: cualquier hilo puede liberar.

---

## Explique cuáles son las acciones que realiza wait().

🟢 Le dice al hilo que llama que abandone el bloqueo y se vaya a dormir hasta que algún otro hilo ingrese al mismo monitor y llame a notify(). Libera el bloqueo antes de esperar y vuelve a adquirirlo antes de regresar de dormir. Está estrechamente integrado con el bloqueo de sincronización.

---

## Explique cuáles son las acciones que realiza notify().

🟢 Despierta un solo hilo que invocó wait() en el mismo objeto. Las llamadas a notify() en realidad no ceden el bloqueo de un recurso: le dice a un hilo en espera que puede despertarse, pero el bloqueo no se abandona hasta que el bloque sincronizado del notificador se ha completado.

---

## Explique cuáles son las acciones que realiza notifyAll().

🔵 Despierta a todos los hilos que llamaron a wait() sobre un objeto en particular.

---

## Explique qué precaución tiene que tomar para incluir wait() en un código.

🟢 Ponerlo entre un try { wait(); } catch (InterruptedException ...).
🔵 Además, debe existir otro hilo que se encargue de despertarlo (notify/notifyAll), para no dejar a todos los hilos dormidos.

---

## Explique las diferencias entre las Excepciones CHECKED y UNCHECKED.

🟢 El momento de control de las excepciones: las checked son verificadas en compilación, las otras (unchecked) en ejecución.

---

## Explique un caso en el cual sea necesario utilizar una LOCAL THREAD VARIABLE (variable local de hilo) y por qué.

🔵 Cuando hay un conjunto de hilos que deben realizar la misma actividad sobre datos diferentes. Cada hilo tiene su propia copia de la variable: solo la modifica ese hilo y ningún otro hilo puede ver la variable local del otro.

---

## En un programa con un hilo Main, múltiples hilos productores y dos hilos daemons, indicar ¿cuándo finaliza la ejecución del programa y por qué?

🔵 Finaliza cuando terminan todos los hilos NO daemon (Main y productores). Los hilos daemon no impiden que el programa termine: la JVM los termina automáticamente cuando ya no quedan hilos no daemon.

---

## Estados de un hilo, Creación (explíquelo, de dónde viene, a dónde va y qué hace la MV).

🔵 Es el inicio del hilo: se crea cuando es necesario ejecutar una tarea. Cuenta con contador de programa propio, registros y pila. Una vez creado pasa a la cola de listos/preparados.

---

## Estados de un hilo, Bloqueo (explíquelo, de dónde viene, a dónde va y qué hace la MV).

🟢 Viene del estado ejecución. Se bloquea porque necesita esperar algún suceso; la MV toma otro hilo de la cola de preparados. Cuando recibe la señal de desbloqueo va a listo/preparado. Lo que hace es esperar la condición de desbloqueo (señal).

---

## Estados de un hilo, Desbloqueo (explíquelo, de dónde viene, a dónde va y qué hace la MV).

🟢 Viene del estado bloqueado; cuando recibe la señal de desbloqueo va a listo/preparado (ready to run). Lo que hace es esperar la condición de desbloqueo (señal). Quien maneja estos cambios de estado es la JVM.

---

## Explique el estado LISTO PARA EJECUTAR de un hilo (de dónde viene, a dónde va y qué hace la Máquina Virtual).

🔵 Viene de creado (recién creado) o de bloqueado (al recibir la señal de desbloqueo), y también de ejecución si se le quita la CPU. Espera en la cola de listos/preparados hasta que la MV le asigna CPU y pasa a ejecución (running), donde realiza sus tareas.
🟢 (Comentario del profe sobre una respuesta: "¿Y si fue recientemente creado?", es decir, también viene del estado creado.)

---

## Estados de un proceso, Creación (explíquelo, de dónde viene, a dónde va y qué hace el SO).

🔵 Es el momento en que el proceso está siendo creado. Desde aquí pasa a preparado, donde espera que el SO le asigne los recursos necesarios para pasar a running.

---

## Estados de un proceso, Bloqueo (explíquelo, de dónde viene, a dónde va y qué hace).

🔵 Viene del estado de ejecución. Se bloquea porque no puede avanzar (espera una señal, la finalización de una operación de E/S, la disponibilidad de un recurso, etc.). Al recibir la señal de desbloqueo pasa a preparado.

---

## Estados de un proceso, Desbloqueo (explíquelo, de dónde viene, a dónde va y qué hace).

🟢 Viene del estado bloqueado; cuando recibe la señal de desbloqueo va a listo/preparado. Lo que hace es esperar la condición de desbloqueo (señal).

---

## ¿Cuántos son los estados posibles que tendría un proceso compuesto por dos hilos los cuales tienen 2 estados cada uno?

🟢 4 (2² combinaciones).

---

## ¿Cuántos son los estados posibles que tendría un proceso compuesto por dos hilos los cuales tienen 3 estados cada uno?

🟢 3² = 9 (cantidad de combinaciones).

---

## ¿Cuántos son los estados posibles que tendría un proceso compuesto por cuatro hilos los cuales tienen 3 estados cada uno?

🟢 En el parcial el profe puso como comentario "12".
🔵 Ojo: siguiendo la misma lógica de combinaciones que usó el profe en las dos anteriores (2² = 4 y 3² = 9), daría 3⁴ = 81. Conviene aclararlo con el profe.

---

## ¿Cuándo se produce Starvation? / ¿Qué entiende por Starvation en un sistema de tiempo real?

🟢 Cuando no se atienden las solicitudes de un proceso (hilo) en el tiempo que se requiere la respuesta.

---

## Indique qué caracteriza un programa reactivo. / ¿Cuál es la característica principal de un programa reactivo?

🟢 Su funcionalidad involucra la interacción permanente con el ambiente (y otros procesos). En muchos casos no computan resultados y suele no requerirse que terminen. Ejemplos de sistemas reactivos: sistemas operativos, software de control, hardware, etc.

---

## Los modelos abstractos de los programas que diseñamos se centran en características reales; ¿por qué cree que éstas son importantes: Datos, Recursos, interacción con el medio y concurrencia?

🟢 Introduciremos mecanismos para verificar que el modelo satisface condiciones particulares de seguridad y las propiedades de progreso, que se requiere representar en el modelo: datos, asignación de recursos y la interacción con el usuario.

---

## La semántica de un programa concurrente se basa en los sistemas de transición de estados, los que podemos representar por grafos dirigidos: ¿los nodos qué representan? ¿las aristas o vínculos entre nodos qué representan? (¿quién representa las acciones? ¿quién representa los eventos?)

🔵 Los nodos representan los estados del sistema y las aristas son las transiciones atómicas (acciones) entre estados.

---

## ¿Cómo se realizan los mecanismos introducidos para verificar que el modelo satisface condiciones particulares de seguridad y las propiedades de progreso?

🟢 Se realiza con el modelado a través de redes de Petri y autómatas finitos. Son propiedades que se cumplen a lo largo de la ejecución del programa, como: exclusión mutua, sincronización, invariantes referidos a los recursos, invariantes referidos a las acciones, concurrencia, persistencia, conflicto.

---

## ¿Cuáles son las limitaciones de la verificación automática de software? / Enumere dos limitaciones de la verificación automática de software.

🟢 Existen serias limitaciones. Por ejemplo, el problema de decidir si un programa dado termina o no no es computable. Si imponemos algunas restricciones sobre las propiedades que queremos verificar, algunas tareas podrán verificarse automáticamente.
🟢 Otras (comentario del profe): la verificación automática se basa en el modelo, y el modelo debe ser correcto; se requiere que haya finalizado la fase de codificación para poder empezar a testear; si se cambia la estructura del código deben rehacerse los casos; la fase más compleja es determinar las trazas de programa particulares según las entradas y estados del sistema.

---

## Defina qué es un lenguaje y relaciónelo con las gramáticas.

🟢 Un lenguaje es un conjunto de cadenas de símbolos de un alfabeto (palabras, oraciones, textos o frases). Los lenguajes están compuestos por sintaxis (gramática), que define las secuencias de símbolos que forman cadenas válidas de un lenguaje, y por semántica, que es el significado de las cadenas que componen un lenguaje.

---

## Defina qué es un lenguaje del tipo 1 y relaciónelo con las gramáticas correspondientes.

🟢 Un lenguaje es un conjunto de cadenas de símbolos de un alfabeto; está compuesto por sintaxis (gramática) y semántica. Un lenguaje de tipo 1 es generado por una gramática de tipo 1 (sensible al contexto), cuya regla de producción es α1Aα2 → α1βα2, con A ∈ VN y α1, α2, β ∈ Σ*. Solo se permite sustituir el símbolo A por la cadena β cuando A aparece en el contexto indicado, es decir, con α1 a su izquierda y α2 a su derecha.

---

## Defina qué es una gramática y relacione la regla de producción con un autómata.

🟢 La gramática es un ente formal para especificar, de manera finita, el conjunto de cadenas de símbolos que constituyen un lenguaje. Es una cuádrupla G = (VT, VN, S, P): VT conjunto finito de símbolos terminales, VN conjunto finito de símbolos no terminales, S símbolo inicial (pertenece a VN) y P conjunto de producciones o reglas de derivación. Entre un autómata y la regla de producción de una gramática, del mismo tipo, existe una relación biunívoca (dada una gramática es posible encontrar un autómata que reconozca las mismas palabras). Si la gramática es de tipo 0, el autómata que la reconoce es de tipo 0.

---

## Defina qué es un autómata y relaciónelo con las gramáticas.

🔵 Un autómata es un sistema que recibe información en forma de símbolos, la transforma y produce otra información que transmite al entorno.
🟢 La gramática es un ente formal para especificar, de manera finita, el conjunto de cadenas de símbolos de un lenguaje. Dada una gramática (sus reglas de producción) es posible encontrar un autómata que reconozca las mismas palabras que la gramática.

---

## Dar un fundamento de por qué una gramática del tipo 2 tiene menos capacidad de expresión que una gramática del tipo 1 (recuerde la relación).

🔵 Cada tipo de gramática se corresponde con un tipo de autómata: tipo 2 con autómata a pila y tipo 1 con autómata lineal acotado. La gramática tipo 2 (libre de contexto) tiene reglas de la forma A → α, donde se reemplaza un no terminal sin mirar su contexto, y el autómata a pila solo lee la cinta y usa una pila auxiliar. La tipo 1 (sensible al contexto) puede condicionar la sustitución al contexto (α1Aα2 → α1βα2), y su autómata lineal acotado puede leer y escribir sobre la cinta, moviéndose en ambos sentidos. Por eso los lenguajes tipo 2 están incluidos en los tipo 1, pero no al revés.

---

## ¿Con qué tipo de gramática puede derivar la siguiente fórmula { aⁿ bⁿ : n>=1 }?

🟢 Tipo 2.

---

## ¿Con qué tipo de gramática puede derivar la siguiente fórmula { aⁿ bᵐ : n>=1, n>=m>=n }?

🟢 Tipo 1 (respuesta del profe en los parciales).

---

## ¿Con qué tipo de autómata puede derivar la siguiente fórmula { aⁿ bⁿ : n>=1 }?

🔵 Con un autómata de pila.

---

## ¿Con qué tipo de autómata puede derivar la siguiente fórmula { aⁿ bᵐ : n>=1, m>=0 }?

🟢 AFND (autómata finito no determinístico).

---

## ¿Con un autómata a pila puede derivar la siguiente fórmula, por qué? { aⁿ bⁿ : n>=1 }

🟢 Sí (comentario del profe: "y la respuesta a la pregunta... la cual es sí").
🔵 Por cada "a" de entrada se apila una "a", y luego se desapila una "a" por cada "b" que entra; si la pila queda vacía al terminar, la cantidad de a y b coincide.

---

## ¿Con un autómata finito puede derivar la siguiente fórmula, por qué? { aⁿ bⁿ : n>=1 }

🔵 No. Necesitaría saber cuántas "a" ingresaron para verificar que haya la misma cantidad de "b", y el autómata finito no tiene memoria para guardar esa información (sí puede hacerlo un autómata de pila).

---

## ¿Cuál es la principal característica de un autómata finito NO determinístico?

🔵 Que tiene al menos un estado tal que, para un mismo símbolo del alfabeto, existe más de una transición posible.

---

## ¿Por qué un autómata a pila es más potente que un autómata finito?

🔵 Porque además de los estados tiene una pila como memoria auxiliar, que le permite recordar información (por ejemplo, contar las "a" para compararlas con las "b"). Los lenguajes que reconoce un autómata finito están incluidos entre los que reconoce un autómata a pila.

---

## ¿Por qué una máquina de Turing es más potente que un autómata lineal acotado?

🟢 En la máquina de Turing el cabezal es de lectura/escritura y se mueve sobre la cinta en ambos sentidos (y la cinta es infinita). En el autómata lineal acotado el cabezal es de lectura, no escribe en ninguna parte, se mueve en un solo sentido y la cinta es finita (delimitada con # y $).

---

## ¿Por qué una máquina de Turing es más potente que un autómata a pila?

🔵 La máquina de Turing lee y escribe en una cinta infinita y se mueve en ambos sentidos, mientras que en el autómata de pila la cinta se recorre en un solo sentido y el cabezal solo lee. La máquina de Turing es de tipo 0 y el autómata a pila de tipo 2.

---

## ¿Un programa puede ser expresado por una máquina de Turing?

🔵 Sí. Todo programa puede ser implementado por una máquina de Turing (tiene una máquina de Turing asociada).

---

## ¿Cualquier programa puede ser expresado por un autómata lineal acotado?

🔵 Sí, porque un autómata lineal acotado es una máquina de Turing con cinta finita, y los programas reales están acotados en código y memoria.

---

## ¿Un programa cualquiera puede ser expresado por un autómata a pila?

🔵 No. El autómata a pila (tipo 2) es menos potente que la máquina de Turing, que es la que puede expresar cualquier programa.

---

## En una máquina de Moore, el símbolo de salida, ¿con qué está relacionado?

🟢 Con el estado en el que se encuentra.

---

## ¿Cuál máquina tiende a tener menos estados (para reconocer una misma fórmula) y por qué: MEALY o MOORE?

🔵 Mealy, porque genera la salida en función del estado actual y de la entrada.

---

## ¿Cuál máquina es más segura de utilizar y por qué: MEALY o MOORE?

🔵 Moore, porque la salida depende solo del estado y los cambios se producen al borde de reloj (un ciclo más tarde), lo que evita problemas de glitches.
