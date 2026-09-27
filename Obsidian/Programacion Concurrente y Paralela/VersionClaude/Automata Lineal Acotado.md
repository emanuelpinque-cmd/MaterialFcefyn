# Autómata Lineal Acotado (ALA)

## Definición
### Reconoce exactamente los lenguajes **de tipo 1 (sensibles al contexto)**.
- Es equivalente a una [[Maquina de Turing]] pero con la cinta **finita**, limitada por dos símbolos especiales de extremo: **#** (límite izquierdo) y **$** (límite derecho).
- El cabezal **es de lectura**, y **no escribe** por fuera de la zona delimitada. Se mueve en un solo sentido de recorrido (a diferencia de la máquina de Turing).

> Nota de comparación con la máquina de Turing: el cabezal del ALA es de lectura y no escribe en ninguna parte, se mueve en un solo sentido, y la cinta es finita.

---

## <font color="#ff0000">¿Por qué una máquina de Turing es más potente que un autómata lineal acotado?</font>

Una máquina de Turing tiene **menos restricciones**: no está acotada (su cinta es infinita) y su cabezal es de lectura/escritura en ambos sentidos.

El autómata lineal acotado, en cambio, tiene su cinta limitada por izquierda y derecha (representada con los símbolos **#** y **$** respectivamente), por lo que el cabezal no puede desplazarse fuera de esos límites, es decir, no puede moverse fuera de la cadena de entrada.

Estas restricciones hacen que el autómata lineal acotado no pueda representar gramáticas de **tipo 0**, mientras que la máquina de Turing sí.

---

## <font color="#ff0000">¿Cualquier programa puede ser expresado por un autómata lineal acotado?</font>

**Sí.** Dado que un autómata lineal acotado es una máquina de Turing (tipo 0) con limitaciones de izquierda a derecha, puede ser expresado por un ALA, ya que se supone que los programas reales están **acotados en código y memoria** (no usan cinta infinita).

---

## Relación con las gramáticas
Reconoce el lenguaje generado por una gramática de **tipo 1** (sensible al contexto), cuya regla de producción es:
$$\alpha_1 A \alpha_2 \rightarrow \alpha_1 \beta \alpha_2$$
donde $A \in V_N$, $\alpha_1,\alpha_2,\beta \in \Sigma^*$: solo se permite sustituir $A$ por $\beta$ cuando $A$ aparece en el contexto indicado (con $\alpha_1$ a la izquierda y $\alpha_2$ a la derecha). Ver [[Gramatica]].

### Ver también
- [[Automata]]
- [[Automata de Pila]]
- [[Maquina de Turing]]
