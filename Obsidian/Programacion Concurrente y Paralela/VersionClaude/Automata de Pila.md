# Autómata a Pila (Pushdown Automaton)

## Definición
### Reconoce exactamente los lenguajes **de tipo 2 (libres de contexto)**.
- Además de los estados, cuenta con una **pila** (estructura LIFO) como memoria auxiliar.
- El cabezal de la cinta de entrada **solo lee**, y se mueve en un único sentido (izquierda a derecha).
- Sobre la pila **sí puede leer y escribir** (apilar y desapilar símbolos).

---

## <font color="#ff0000">¿Con un autómata a pila puede derivar la siguiente fórmula, por qué?</font> $\{a^nb^n : n\geq1\}$

**Sí.** Por cada "a" de entrada, se apila una "a" en la pila. Luego, por cada "b" que entra, se desapila una "a". Si al terminar de leer la cadena la pila queda vacía (y se consumieron todas las b necesarias), la cantidad de a y b coincide y la cadena es aceptada.

---

## <font color="#ff0000">¿Por qué una máquina de Turing es más potente que un autómata a pila?</font>

La máquina de Turing puede **leer y escribir en una cinta infinita**, moviéndose en ambos sentidos, mientras que en el autómata de pila:
- La cinta de entrada se recorre en un solo sentido y el cabezal **solo lee**.
- La única memoria auxiliar es la pila (acceso LIFO, no acceso aleatorio).

La máquina de Turing es de **tipo 0** y el autómata a pila es de **tipo 2**.

---

## Relación con las gramáticas
Reconoce el lenguaje generado por una gramática de **tipo 2** (libre de contexto). Ver [[Gramatica]].

### Ver también
- [[Automata]]
- [[Automatas Finitos]]
- [[Automata Lineal Acotado]]
