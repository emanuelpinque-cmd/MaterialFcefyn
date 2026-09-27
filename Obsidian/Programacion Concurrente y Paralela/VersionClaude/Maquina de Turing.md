# Máquina de Turing

## Definición
### Es el autómata más potente de la jerarquía: reconoce exactamente los lenguajes **de tipo 0 (sin restricción, recursivamente enumerables)**.
- Posee una **cinta infinita**, dividida en celdas.
- Tiene un **cabezal de lectura/escritura** que se mueve sobre dicha cinta **en ambos sentidos** (izquierda y derecha).
- Es el modelo teórico de cómputo más general que existe: se considera que **todo lo que es computable, es computable por una máquina de Turing** (Tesis de Church-Turing).

---

## <font color="#ff0000">¿Un programa puede ser expresado por una máquina de Turing?</font>

**Sí.** De hecho, todo programa tiene una máquina de Turing asociada, ya que el cabezal de la máquina de Turing puede moverse para cualquier lado (izquierda o derecha) de a una posición, y puede leer/escribir en cualquier estructura de datos que un programa use.

---

## Comparaciones típicas de parcial

| Comparado con | ¿Por qué la máquina de Turing es más potente? |
|---|---|
| [[Automata de Pila]] | Lee **y escribe** en una cinta infinita, en ambos sentidos. El autómata a pila solo lee la cinta de entrada (en un sentido) y solo puede usar una pila como memoria auxiliar. |
| [[Automata Lineal Acotado]] | Su cinta es **infinita** (no acotada por # y $) y el cabezal lee/escribe en ambos sentidos; el ALA tiene cinta finita y cabezal solo de lectura en un sentido. |

---

## Limitaciones de la verificación automática de software
La máquina de Turing, al ser el modelo más general, también trae consigo sus limitaciones teóricas:
- El **problema de la parada**: decidir si un programa dado termina o no, **no es computable** en general.
- Si se imponen restricciones sobre las propiedades que se quieren verificar, algunas tareas sí podrán verificarse automáticamente (de ahí el interés en modelos más restringidos, como las [[Redes de Petri]], para poder razonar formalmente sobre programas concurrentes).

### Ver también
- [[Automata]]
- [[Automata Lineal Acotado]]
- [[Automata de Pila]]
