# Autómata Finito

## Definición
### Es el autómata más simple de la jerarquía: reconoce exactamente los lenguajes **de tipo 3 (regulares)**.
- No tiene memoria auxiliar: solo cuenta con un número finito de estados.
- El cabezal de lectura recorre la cadena de entrada de izquierda a derecha, sin retroceder ni escribir.

---

## <font color="#2DC26B">Autómata Finito Determinístico (AFD)</font>

- Para cada estado y cada símbolo del alfabeto de entrada, existe **exactamente una** transición posible.
- La función de transición es $f: E \times Q \rightarrow Q$ (una función, no una relación).
- Es completamente predecible: dado un estado y una entrada, se sabe con certeza a qué estado se va.

## <font color="#2DC26B">Autómata Finito No Determinístico (AFND)</font>

### ¿Cuál es la principal característica de un autómata finito NO determinístico?
**Posee al menos un estado tal que, para un símbolo del alfabeto, existen más de una transición posible** (o ninguna).

- Puede tener varias transiciones válidas desde un mismo estado con el mismo símbolo.
- Puede tener transiciones espontáneas (con $\lambda$, sin consumir símbolo).

> **Teorema de equivalencia**: todo AFND tiene un AFD equivalente que reconoce el mismo lenguaje (se puede construir por el método de subconjuntos). Es decir, el no determinismo no agrega poder de expresión, solo comodidad de representación.

---

## <font color="#ff0000">¿Por qué un autómata a pila es más potente que un autómata finito?</font>

Porque además de los estados, el autómata a pila cuenta con una **pila** como memoria auxiliar, que le permite recordar información sobre lo ya leído (por ejemplo, contar símbolos). El autómata finito no tiene ninguna forma de "recordar" cuántos símbolos ya procesó.

### Ejemplo clásico: $\{a^nb^n : n\geq1\}$
- **¿Con un autómata finito puede derivar esta fórmula?** No, porque necesitaría saber la cantidad exacta de "a" que ingresaron para luego verificar que haya la misma cantidad de "b", y el autómata finito no tiene forma de resguardar esa información (memoria).
- Esto es justamente lo que sí puede hacer un [[Automata de Pila]].

---

## Relación con las gramáticas
Un autómata finito reconoce el lenguaje generado por una gramática de **tipo 3** (regular). Ver [[Gramatica]].

## Relación con expresiones regulares
Todo lenguaje regular puede describirse con una expresión regular, y viceversa: existe un autómata finito equivalente para toda expresión regular. Ver [[Expresiones Regulares]].

### Ver también
- [[Automata]]
- [[Automata de Pila]]
