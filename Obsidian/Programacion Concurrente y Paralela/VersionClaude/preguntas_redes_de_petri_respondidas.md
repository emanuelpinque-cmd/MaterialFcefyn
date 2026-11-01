Con un grafo de marcado podemos determinar todas las propiedades de una RdP, si o no. Si contesto no diga porque, si contesto si explique cómo encuentra que la red es acotada.

Profe: Sí, se realiza la suma de tokens para todos los estados y se verifica que no supere un valor. (En otro intento el profesor agregó como comentario: "¿Y cómo veo si es acotada en el grafo?")

Claude: Sí se puede: el grafo de marcado (grafo de eventos) es una red ordinaria, y sus propiedades aplican para las ordinarias y todas sus extensiones. Para ver si es acotada hay que recorrer todos los marcados (nodos) del grafo y verificar que, para cada plaza, la cantidad de tokens en cualquiera de esos marcados no supere un valor k finito (no crece sin límite).

---

Con un grafo de marcado podemos determinar todas las propiedades de una RdP, si o no. Si contesto no diga porque, si contesto si explique cómo encuentra que la red es segura.

Profe: null

Claude: Sí. Una red es segura para un marcado inicial M0 si en todos los marcados alcanzables ninguna plaza tiene más de un token (k=1). Se verifica recorriendo todos los nodos del grafo de marcado y comprobando que ningún valor de plaza supere 1.

---

Con un grafo de marcado podemos determinar todas las propiedades de una RdP, si o no. Si contesto no diga porque, si contesto si explique cómo encuentra un interbloqueo.

Profe: null

Claude: Sí. Un interbloqueo se visualiza en el grafo de marcado como un nodo terminal ("punto muerto"): un marcado alcanzable desde el cual no sale ningún arco, es decir, no hay ninguna transición sensibilizada.

---

Con un grafo de marcado podemos determinar todas las propiedades de una RdP, si o no. Si contesto no diga porque, si contesto si explique cómo encuentra un invariante de transición.

Profe: [podria estar mal!] "Sí" — el profesor corrigió a un alumno que había respondido "No".
Justificación de la duda: el comentario es de una sola palabra, sin desarrollo. Aunque coincide con el patrón de las otras variantes de esta misma pregunta (acotada, segura, interbloqueo, todas respondidas "Sí"), al no explicar el método esperado no puedo confirmar que la forma de encontrar el invariante de transición que doy en "Claude" sea exactamente la que el profesor tenía en mente.

Claude: Sí se puede. Un invariante de transición es una secuencia de disparos (un vector con la cantidad de veces que se dispara cada transición) que devuelve la red a su marcado inicial. En el grafo de marcado esto corresponde a un ciclo que vuelve al mismo nodo; contando cuántas veces se dispara cada transición a lo largo de ese ciclo se obtiene el invariante de transición.

---

Si una red de Petri es viva se puede garantizar que de una determinada marca se pueda llegar a cualquier marca del sistema

Profe: null

Claude: Sí. Si la red es viva, desde cualquier marcado alcanzable siempre existe alguna secuencia de disparos que permite disparar cualquier transición, lo que garantiza poder seguir evolucionando y alcanzar otros marcados del sistema.

---

Si una red de Petri es seudo viva y sus transiciones quasi vivas se pueden garantizar que de una determinada marca se pueda llegar a cualquier marca del sistema

Profe: null

Claude: No. La seudo-vivacidad solo garantiza que existen transiciones vivas y otras quasi-vivas (que se disparan al menos una vez), pero no que desde cualquier marcado se pueda alcanzar cualquier otro marcado; eso solo está garantizado si la red es completamente viva.

---

Una red de Petri seudo viva puede bloquearse totalmente

Profe: null

Claude: No. En una red seudo viva siempre existe al menos un subconjunto de transiciones que permanece vivo, por lo que la red nunca queda completamente sin transiciones sensibilizadas (no hay bloqueo total, aunque sí pueda haber transiciones que dejen de dispararse).

---

¿Que tipo de fenómenos de control e informáticos modelan las Redes de Petri?

Profe: null

Claude: Paralelismo, concurrencia, sincronización y compartición (intercambio) de datos y recursos, incluyendo exclusión mutua y prioridad.

---

Un red de Petri, que es un grafo de marcado, puede tener conflicto

Profe: null

Claude: No. En un grafo de marcado (grafo de eventos) cada plaza tiene exactamente un arco de entrada y un arco de salida, por lo que estructuralmente no puede haber dos transiciones compitiendo por los tokens de una misma plaza.

---

La constante de marcado de un invariante de plaza, componente conservador, depende de la marca, de la estructura de la red o ambas

Profe: null

Claude: Depende únicamente de la estructura de la red (es una propiedad estructural); el valor numérico concreto de la constante varía según el marcado inicial, pero la existencia del invariante depende solo de la estructura.

---

Un invariante de plaza, componente conservador, es dependiente de la marca inicial, de la estructura de la red o ambas

Profe: null

Claude: Depende de la estructura de la red; es independiente de la marca inicial (el valor de la constante sí cambia con el marcado, pero la propiedad conservadora en sí es estructural).

---

Con un arco inhibidor, puede controlar la prioridad en una red que comparte un recurso. Explique porqué o cómo con un arco inhibidor controla la prioridad en un productor con más prioridad que un consumidor

Profe: [podria estar mal!] "Justamente al revés" — el profesor corrigió a un alumno cuya explicación describía el mecanismo invertido.
Justificación de la duda: el comentario solo dice que la explicación estaba "al revés", sin describir el mecanismo correcto en detalle. Como esta pregunta es la contracara de la siguiente (productor con menos prioridad), existe riesgo de que "al revés" solo intercambie los roles productor/consumidor sin que yo pueda verificar que el arco quede exactamente donde lo describo en "Claude"; al faltar el texto completo esperado, no puedo confirmar con certeza que mi reconstrucción sea idéntica a la que el profesor daría por buena.

Claude: Se coloca un arco inhibidor desde la plaza del consumidor (o del recurso/buffer) hacia la transición de entrada del que tiene menor prioridad, de modo que mientras el productor (mayor prioridad) tenga margen para producir, se bloquee al consumidor; así el productor siempre puede seguir generando tokens sin que el consumidor lo vacíe por completo.

---

Con un arco inhibidor, puede controlar la prioridad en una red que comparte un recurso. Explique porqué o cómo con un arco inhibidor controla la prioridad en un productor con menos prioridad que un consumidor

Profe: "En un productor-consumidor se coloca un arco inhibidor entre la plaza del consumidor y la transición de entrada del productor."

Claude: Se coloca un arco inhibidor que va desde la plaza del consumidor hacia la transición de entrada (producción) del productor: mientras el consumidor tenga tokens/recurso disponible, esa condición inhibe que el productor dispare, dándole prioridad al consumidor.

---

Con un arco lector, puede controlar la prioridad en una red que comparte un recurso. Cómo o porqué?

Profe: "Sí, colocando una plaza de control con un arco lector asociado a la transición que deseamos priorizar."

Claude: Sí. Se agrega una plaza de control con un arco lector hacia la transición que se quiere priorizar: el arco lector solo verifica que haya tokens (sin consumirlos), sensibilizando esa transición sin quitarle recursos a la otra, lo que permite establecer prioridad sin gastar tokens compartidos.

---

En una red de Petri ordinaria, cuál es la condición para que una transición esté sensibilizada?

Profe: [podria estar mal!] "Ordinaria? peso?" — comentario del profesor sobre la respuesta de un alumno.
Justificación de la duda: el comentario es una pregunta retórica, no una afirmación ni una respuesta corregida. No queda claro si el profesor señalaba que faltaba mencionar explícitamente el peso de los arcos (=1) o si cuestionaba el uso del término "ordinaria" en la respuesta del alumno; por eso no puede tomarse como una respuesta confirmada, sino como una pista de que algo faltaba en la explicación.

Claude: En una red ordinaria todos los arcos tienen peso 1. Una transición está sensibilizada cuando todas sus plazas de entrada contienen al menos un token.

---

Si una Red de Petri tiene un Home State "mh", de cualquier marca es posible alcanzar el estado "mh"

Profe: null

Claude: Sí. Que "mh" sea un Home State significa, por definición, que desde cualquier marcado alcanzable existe al menos una secuencia de disparos que permite volver a mh.

---

Si una red de Petri tiene una marca "mh" la cual se puede alcanzar de cualquier estado, ¿qué tipo de red es?

Profe: "RdP con Home State" — el profesor corrigió a un alumno que había respondido "es una red reversible".

Claude: Es una red con Home State (no necesariamente reversible: solo sería reversible si mh coincide con el marcado inicial m0).

---

¿Si una red tiene un home state, qué tipo de red es?

Profe: null

Claude: Es una red con Home State (si además ese estado es el marcado inicial, la red es reversible).

---

Si una Red de Petri es reversible para una marca "m0", de cualquier marca es posible alcanzar el estado inicial "m0"

Profe: null

Claude: Sí, por definición de reversibilidad: si la red es reversible respecto de m0, entonces m0 es un Home State, y desde cualquier marcado alcanzable siempre existe una secuencia de disparos que devuelve el sistema a m0.

---

Defina una Red de Petri No Autónoma

Profe: null

Claude: Es aquella en la que el disparo de las transiciones no depende únicamente de estar sensibilizadas, sino también de eventos externos y/o del tiempo (por ejemplo una señal externa o un temporizador); su dinámica está condicionada por factores externos al propio marcado.

---

Que caracteriza a una red de Petri para que se comporte como una máquina de estado

Profe: [podria estar mal!] "Y el marcado?" — el profesor señaló que a la respuesta le faltaba algo.
Justificación de la duda: el comentario es una pregunta abierta, no una corrección explícita, por lo que no queda 100% claro qué debía agregarse: podría referirse a la condición de que el marcado inicial tenga un único token total (interpretación que uso en "Claude"), o a otra propiedad relacionada con el marcado que el profesor tenía en mente y no se llegó a explicitar.

Claude: Estructuralmente, cada transición debe tener exactamente una plaza de entrada y una plaza de salida (todos los arcos con peso 1). Además, para que efectivamente se comporte como máquina de estados, el marcado inicial debe tener un único token en el conjunto de plazas (el sistema está siempre en un único "estado" a la vez).

---

Cuando usamos prioridades para el disparo de un conjunto de transiciones

Profe: null

Claude: Cuando hay varias transiciones en conflicto (sensibilizadas simultáneamente, compitiendo por los mismos tokens) y hace falta definir cuál debe dispararse primero.

---

Qué relación tiene que una RdP, que modela un sistema, sea segura con los hilos del programa que implementa el modelo, donde se ha instanciado un hilo por plaza

Profe: null

Claude: Si la red es segura (cada plaza tiene como máximo un token), entonces, con un hilo por plaza, nunca habrá más de una instancia/ejecución concurrente asociada a esa plaza; es decir, ese hilo no se ejecutará más de una vez en simultáneo.

---

Qué relación tiene que una RdP, que modela un sistema, tenga una plaza limitada la que modela el buffer, con el programa que implementa el modelo

Profe: null

Claude: Que esa plaza esté limitada a k tokens significa que, en la implementación, el buffer del programa tiene una capacidad máxima finita de k elementos (no es infinito).

---

Qué relación tiene que una RdP, que modela un sistema, sea acotada con los buffer del programa que implementa el modelo

Profe: null

Claude: Que la red sea acotada significa que todas sus plazas están limitadas por una constante k; en la implementación esto se traduce en que el buffer (modelado por esa plaza) no es infinito, sino que tiene una capacidad máxima finita.

---

Qué relación tiene que una RdP, que modela un sistema, tenga una secuencia de disparos infinita con el programa que implementa el modelo

Profe: null

Claude: Que la implementación tenga también una ejecución que nunca termina: siempre hay al menos alguna transición (hilo/tarea) que puede seguir disparándose indefinidamente, análogo a un sistema operativo que corre en un bucle infinito.

---

Que entiende por persistencia (conflicto) en una red de petri?

Profe: null

Claude: Persistencia es la ausencia de conflicto efectivo: dos transiciones sensibilizadas simultáneamente pueden dispararse en cualquier orden (o al mismo tiempo) sin que el disparo de una deshabilite a la otra.

---

Que entiende por concurrencia (conflicto) en una red de petri?

Profe: [podria estar mal!] "Cuando dos transiciones en conflicto pueden ser disparadas en cualquier secuencia o simultáneamente"
Justificación de la duda: esta es textualmente la misma definición que en otro examen se usó para responder "persistencia" (la pregunta anterior de esta lista), y ahí sí fue aceptada sin corrección. En la teoría clásica de RdP, concurrencia (habilitación simultánea de transiciones independientes, sin competir por los mismos tokens) y persistencia (que el disparo de una transición en conflicto no deshabilite a la otra) son conceptos distintos. Es posible que el profesor haya reutilizado o confundido la definición entre ambas preguntas, o que en esta cursada se usen como sinónimos; por eso conviene tomar esta respuesta con cautela.

Claude: Concurrencia (en contraposición a conflicto) es cuando dos transiciones están sensibilizadas simultáneamente y ambas pueden dispararse, en cualquier orden o al mismo tiempo, sin interferirse entre sí.

---

Como solucionamos el problema del conflicto efectivo en un conjunto de transiciones

Profe: "Se puede establecer una política de prioridades que resuelva el orden de ejecución de este conjunto de transiciones."

Claude: Mediante un arco inhibidor (para eliminar directamente el conflicto) o estableciendo una política de prioridades que determine el orden en que deben dispararse las transiciones en conflicto.

---

Explique la diferencia entre conflicto estructural y efectivo

Profe: null

Claude: El conflicto estructural existe cuando una plaza tiene más de una transición de salida (es una propiedad de la estructura, independiente del marcado). El conflicto efectivo se da cuando, para un marcado concreto, esa plaza tiene tokens suficientes para sensibilizar simultáneamente a más de una de esas transiciones, pero no para disparar todas: disparar una deshabilita a las demás.

---

¿Las propiedades de vivacidad e interbloqueo se mantienen al aumentar el marcado de una red?

Profe: null

Claude: No necesariamente. Aumentar el marcado puede evitar un interbloqueo que existía antes, o al contrario, puede abrir un nuevo camino hacia un estado muerto que antes no era alcanzable; en general la vivacidad no es monótona respecto del marcado.

---

¿Qué es una red de petri pura?

Profe: null

Claude: Es una red en la que ninguna transición tiene una misma plaza como entrada y como salida a la vez (no hay arcos de "ida y vuelta" entre una plaza y una transición).

---

Es posible convertir una red de petri impura en pura?

Profe: null

Claude: Sí. Se agrega una nueva plaza (y, si hace falta, una transición) que reproduce el efecto del par de arcos duplicados, de forma que ninguna transición quede con la misma plaza como entrada y salida simultáneamente.

---

Cuando una transición se dispara, que pasa con los tokens de las plazas que tienen arcos lectores que llegan a la transición?

Profe: "Nada, un arco lector no consume tokens" — corrección del profesor a una respuesta incorrecta.

Claude: No pasa nada con esos tokens: el arco lector solo verifica que haya tokens suficientes para sensibilizar la transición, pero no los consume ni los mueve.

---

Cuando una transición se dispara, que pasa con los tokens de las plazas que tienen arcos que llegan a la transición?

Profe: null

Claude: Si son arcos normales (comunes), los tokens se consumen de esas plazas según el peso del arco. Si son arcos lectores, la transición se sensibiliza pero no se consumen los tokens; tampoco se consumen si son arcos inhibidores.

---

Cuando una transición se dispara, que pasa con los tokens de las plazas que tienen arcos que salen de la transición?

Profe: null

Claude: Se generan (agregan) tokens en esas plazas de salida, en la cantidad indicada por el peso de cada arco de salida.

---

Que tipo de red es una que evoluciona por los disparos de sus transiciones que cumplen con la condición de sensibilidad

Profe: "Autónoma" — corrección del profesor a una respuesta incorrecta.

Claude: Es una red autónoma: su dinámica depende solo de que las transiciones estén sensibilizadas, sin necesidad de eventos externos ni del tiempo.

---

Que tipo de red es una que evoluciona por los disparos de sus transiciones sensibilizadas y asociadas a un evento externo

Profe: null

Claude: Es una red no autónoma, ya que su evolución depende de eventos externos además de la sensibilización.

---

En la red de Petri, que se usó en el ejemplo de las cuatro estaciones, cómo interpreta el invariante donde la suma de las marcas de todas las plazas es siempre uno

Profe: "Que se puede estar en solo una estación a la vez"

Claude: Ese invariante de plaza (componente conservador) indica que el sistema solo puede estar en un único estado (estación) a la vez: la suma de tokens en ese conjunto de plazas se mantiene constante e igual a uno en todo momento.

---

Cuántas veces se puede disparar una transición quasi viva

Profe: "Al menos una vez"

Claude: Al menos una vez; no hay un límite máximo definido, solo se garantiza que puede dispararse como mínimo una vez.

---

Son adecuadas las Redes de Petri para modelar sistemas informáticos que tengan concurrencia y sincronización. En caso de que la respuesta es afirmativa, que otras propiedades puede visualizar

Profe: "Paralelismo e intercambio de recursos"

Claude: Sí, son adecuadas. Además de concurrencia y sincronización permiten visualizar paralelismo, exclusión mutua/competencia por recursos, conflictos, prioridades, y detectar interbloqueos.

---

Es posible relacionar totalmente la estructura de una red de Petri con su comportamiento?

Profe: "No, es necesario además de la estructura el marcado."

Claude: No. El comportamiento dinámico de la red depende tanto de su estructura (plazas, transiciones, arcos) como de su marcado (inicial y los alcanzables); la estructura sola no determina completamente el comportamiento.

---

Como define una plaza limitada de una red de Petri?

Profe: null

Claude: Una plaza p es k-limitada (para un marcado M0) si, para todo marcado Mi alcanzable desde M0, la cantidad de tokens en p es siempre menor o igual a k.

---

Como define una red de Petri limitada?

Profe: null

Claude: Una RdP está limitada/acotada si todas sus plazas están limitadas, es decir, existe una constante k tal que ninguna plaza supera k tokens en ningún marcado alcanzable desde el marcado inicial.

---

En el grafo de cobertura, que representa w?

Profe: "Representa el marcado de una plaza que crece indefinidamente."

Claude: El símbolo ω (omega) indica que el número de tokens en esa plaza puede crecer indefinidamente (no está acotado); se usa cuando la red no es limitada y el grafo de alcanzabilidad completo sería infinito.

---

Que caracteriza a una Red de Petri de libre elección extendida (relación plaza-transición, conflicto)

Profe: null

Claude: En una red de libre elección extendida, para cada conflicto (plazas con más de una transición de salida en conflicto), todas las transiciones involucradas comparten exactamente el mismo conjunto de plazas de entrada.

---

Qué representa el marcado de una plaza en una red de Petri?

Profe: [podria estar mal!] "El marcado de una plaza representa el estado local de la parte del sistema que esa plaza representa" — matización del profesor sobre una respuesta que ya había sido puntuada como correcta.
Justificación de la duda: no queda claro qué distinción exacta buscaba el profesor entre "estado local de la parte del sistema" y la respuesta del alumno ("representa el estado del sistema en un momento dado"); podría ser solo una cuestión de precisión terminológica (local vs. global) más que una corrección de fondo, así que no es seguro que agregue información adicional relevante más allá de matizar la redacción.

Claude: Representa el estado (local) del sistema en un momento dado, en términos de cuántos tokens contiene esa plaza.

---

Como se representa la dinámica de un sistema descripto por una red de Petri?

Profe: null

Claude: Mediante la evolución del marcado a medida que se van disparando las transiciones sensibilizadas (la secuencia de marcados/estados que va alcanzando el sistema).

---

Si una petri está libre de interbloqueo para m0, ¿es libre de interbloqueo para un marcado m>m0? ¿Por qué?

Profe: null

Claude: No necesariamente. Puede que con el marcado original nunca se habilite una transición que lleve a un deadlock, y que al aumentar el marcado sí se sensibilice esa transición, llevando a la red a un estado desde el cual ya no pueda evolucionar más.

---

Las redes de Petri permiten modelar/visualizar cierto tipo de comportamientos en los sistemas informáticos y de control, ¿cuáles son?

Profe: null

Claude: Permiten modelar y visualizar paralelismo, concurrencia, sincronización y compartición (intercambio) de recursos entre procesos.
