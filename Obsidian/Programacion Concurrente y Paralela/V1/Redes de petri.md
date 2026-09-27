### Disparo de una transicion

Una transicion es un detector de condiciones y tranformador de estado

Solo si se cumplen las condiciones decimos que la transicion se dispara y cambia su estado

#### Condicion
Para que una transicion se dispare cada plaa de entrada a la transicion tiene que tener al menos el mismo numero de tokens que el peso del arco que las conecta
#### Disparo

1) Consume de las plazas que entran a la transicion con el numero de tokens del peso del arco que una la plaza con la transicion
2) Genera a las plazas de salida de la transicion el numero de tokens del peso del arco que une la transicion con la plaza



### RdP automatas y no-Automatas

**Cuando un RdP evoluciona por los disparos de sus transiciones**

Una red de petri es autonoma si sus disparos son desconocidos o no estan indicados

en cambio una RdP no-autonoma es aquella que su transicion se dispara:
- por que se cumplen las condiciones de sensibilizado
- y esta asociada a un evento externo
Una RdP no automata describe el funcionamiento de un sistema cuya evolucion esta condicionada por eventos externos y/o por el tiempo


### Redes de petri especiales

#### Red de petri ordinaria

su definicion formal 
$$N = (P,T,F)$$


### Subclases de redes de petri

| Clase                             | Condición formal                                                                              | Idea intuitiva                                                       |
| --------------------------------- | --------------------------------------------------------------------------------------------- | -------------------------------------------------------------------- |
| **Máquina de estado (SM)**        | $\|{}^\bullet t\| = \|t^\bullet\| = 1 \; \forall t \in T$                                     | Solo hay elección, sin sincronización ni concurrencia real           |
| **Grafo de marcado/eventos (MG)** | $\|{}^\bullet p\| = \|p^\bullet\| = 1 \; \forall p \in P$                                     | No hay conflicto, pero sí puede haber concurrencia/sincronización    |
| **Libre de conflicto**            | Cada plaza tiene como máximo 1 transición de salida                                           | Nunca hay competencia real por los tokens de un lugar                |
| **Libre elección (FC)**           | $p_1 \bullet \cap p_2 \bullet \neq \emptyset \Rightarrow \|p_1\bullet\| = \|p_2\bullet\| = 1$ | Si hay conflicto, la elección es "limpia" (no depende de otro lugar) |
| **Simple (SPL)**                  | Cada transición está afectada por **como máximo un** conflicto estructural                    | Evita conflictos cruzados sobre una misma transición                 |
| **RdP pura**                      | No tiene *auto-loops* (una plaza que sea entrada y salida de la misma transición)             | Toda RdP impura puede convertirse en una pura equivalente            |

