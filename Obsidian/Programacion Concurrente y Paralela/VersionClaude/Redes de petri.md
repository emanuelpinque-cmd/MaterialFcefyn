### Conceptos basicos

**Es una red bipartita**

- Tiene nodos y arcos
- Los nodos son de dos tipos: **Plazas** y **Transiciones**
- Los arcos siempre conectan un nodo de un tipo con un nodo del otro tipo (nunca dos plazas entre sí, ni dos transiciones entre sí)
- Es **obligatorio** que cada arco tenga un nodo en cada uno de sus extremos (desde un lugar, hasta una transición, o desde una transición, hasta un lugar). Entre un lugar y una transición (o viceversa) hay como máximo un arco.

#### Plazas
- Su numero es finito y no cero, se representan con un circulo
- Representan condiciones, recursos o estados parciales del sistema

#### Transiciones
- Su numero es finito y no cero
- Se representan con una barra o rectángulo
- Representan eventos o acciones que pueden ocurrir

#### Arcos
- Se representan con una flecha y tienen una de dos direcciones:
	- De una plaza a una transición
	- De una transición a una plaza
- Tienen un **peso** (por defecto 1) que indica cuántos tokens consume/produce el disparo

#### Definición formal (red de Petri ordinaria, sin marcar)
$$N = (P,T,F)$$
- $P = \{P_1,P_2,...,P_n\}$: conjunto finito de plazas
- $T = \{T_1,T_2,...,T_m\}$: conjunto finito de transiciones
- $F \subseteq (P\times T)\cup(T\times P)$: conjunto de arcos

- Se dice que el lugar **P3** es **upstream** o una **entrada** de la transición **T3** porque hay un arco dirigido de P3 a T3.
- Se dice que el lugar **P5** es **downstream** o una **salida** de la transición **T3** porque hay un arco dirigido de T3 a P5.
- Una transición sin lugar de entrada es una **transición fuente**. Una transición sin lugar de salida es una **transición sumidero**.

---

### Marcado

- Una RdP con marca **m0**, denota un vector columna cuyo i-ésimo componente es la marca del lugar Pi en ese momento.
- Para el marcado se emplea la notación:
$$m(P_i) \; \text{ó} \; m_i$$
- La marca (o marcado) **m** de la red es entonces representada por el **vector de marcado**:
$$\mathbf{m} = (m_1, m_2, m_3, ..., m_n)$$
- La marca define el **estado** de la RdP en un momento dado. La evolución del estado del sistema descrito por la PN es precisamente la evolución del marcado, y esa evolución es causada por el disparo de transiciones (ya lo veremos).
- Las RdP marcadas se consideran prácticamente siempre. Las llamamos simplemente **Redes de Petri**. Por otro lado, las PN no marcadas se especificarán cuando sea necesario.

---

### Disparo de una transicion

Una transicion es un detector de condiciones y transformador de estado

Solo si se cumplen las condiciones decimos que la transicion se dispara y cambia su estado

#### Condicion (sensibilización)
Para que una transicion se dispare, cada plaza de entrada a la transicion tiene que tener al menos el mismo numero de tokens que el peso del arco que las conecta

Cuando se sensibiliza una transición, esto **no implica** que se disparará inmediatamente: esto solo indica que es una posibilidad.

#### Disparo

1) Consume de las plazas que entran a la transicion el numero de tokens del peso del arco que une esa plaza con la transicion
2) Genera a las plazas de salida de la transicion el numero de tokens del peso del arco que une la transicion con la plaza

<font color="#ff0000">Los disparos son atómicos</font>: aunque no está sincronizado (no tiene una duración física), se considera que el disparo de una transición tiene duración cero, para facilitar la comprensión del concepto de indivisibilidad.

---

### RdP automatas y no-Automatas

**Cuando un RdP evoluciona por los disparos de sus transiciones**

Una red de petri es autonoma si sus disparos son desconocidos o no estan indicados. El instante de disparo de sus transiciones son desconocidos o no están indicados.

en cambio una RdP no-autonoma es aquella que su transicion se dispara:
- por que se cumplen las condiciones de sensibilizado
- y esta asociada a un evento externo y/o al tiempo

Una RdP no autónoma describe el funcionamiento de un sistema cuya evolucion esta condicionada por eventos externos y/o por el tiempo (por ejemplo, un semáforo que cambia de luz cada cierto tiempo, o una alarma que arranca y para con un auto).

---

### Redes de petri especiales

#### Red de petri ordinaria
su definicion formal 
$$N = (P,T,F)$$

- Formalmente, una **estructura de RdP ordinaria** es la tupla $N = (P,T,F)$, donde:
	- $P$ es el conjunto de lugares
	- $T$ es el conjunto de transiciones
	- $F \subseteq (P\times T) \cup (T\times P)$ es el conjunto de arcos de la relación de flujo
- Una **estructura de RdP marcada** N con una marca inicial $m_0$ se denota mediante $(N,m_0)$
- La estructura de RdP ordinaria y se denotará $RdP\ ordinaria$

### Subclases de redes de petri

| Clase                             | Condición formal                                                                              | Idea intuitiva                                                       |
| --------------------------------- | --------------------------------------------------------------------------------------------- | -------------------------------------------------------------------- |
| **Máquina de estado (SM)**        | $\|{}^\bullet t\| = \|t^\bullet\| = 1 \; \forall t \in T$                                     | Solo hay elección, sin sincronización ni concurrencia real           |
| **Grafo de marcado/eventos (MG)** | $\|{}^\bullet p\| = \|p^\bullet\| = 1 \; \forall p \in P$                                     | No hay conflicto, pero sí puede haber concurrencia/sincronización    |
| **Libre de conflicto**            | Cada plaza tiene como máximo 1 transición de salida                                           | Nunca hay competencia real por los tokens de un lugar                |
| **Libre elección (FC)**           | $p_1 \bullet \cap p_2 \bullet \neq \emptyset \Rightarrow \|p_1\bullet\| = \|p_2\bullet\| = 1$ | Si hay conflicto, la elección es "limpia" (no depende de otro lugar) |
| **Simple (SPL)**                  | Cada transición está afectada por **como máximo un** conflicto estructural                    | Evita conflictos cruzados sobre una misma transición                 |
| **RdP pura**                      | No tiene *auto-loops* (una plaza que sea entrada y salida de la misma transición)             | Toda RdP impura puede convertirse en una pura equivalente            |

**Nota sobre RdP máquina de estado**: un RdP sin marcar es un grafo de estado si y solo si cada transición tiene exactamente un lugar de entrada y un lugar de salida. Cada disparo de transición equivale al movimiento de un único token de una plaza a otra, como en un diagrama clásico de estados.

**Nota sobre RdP grafo de marcado (de eventos)**: una RdP ordinaria N es grafo de eventos si y solo si cada lugar tiene exactamente una transición de entrada y una de salida. En este tipo de red **nunca hay conflicto estructural** (a diferencia de la máquina de estado), pero sí puede haber concurrencia y sincronización real.

### <font color="#ff0000">Autoloop</font>
- Una plaza cuya transición es auto-alimentada (la misma plaza es a la vez entrada y salida de la misma transición) se llama **autoloop**.
- El autoloop distorsiona la información del disparo (no queda claro si consumió/produjo o si simplemente "no pasó nada" desde afuera).
- Se denomina **RdP pura** a una red de Petri que **no tiene ningún autoloop**.
- Toda RdP impura se puede transformar en una RdP pura equivalente.
- Existe también el atributo de **capacidad** de la matriz (una forma de representar autoloops mediante matrices con valores negativos), pero **no es recomendable** usarlo porque pierde información.

### Ver también
- [[Propiedades de las redes de petri]]
- [[Concurrencia]]
