### La gramatica ==es un ente formal== para especificar, de una manera finita, ==el conjunto de cadenas== de simbolos que constituyen un lenguaje

## Automata
### Un automata es una construccion logica que recibe una entrada y produce una salida en funcion de todo lo recibido hasta ese instante
Ver [[Automata]]

## Definicion formal de gramatica

### Una gramatica es una cuadrupla : $G = (VT,VN,P,S)$

### Donde : 

- ### VT = {conjunto finito de simbolos terminales}
- ### VN = {conjunto finito de simbolos no terminales}
- ### S es el simbolo inicial y pertenece a VN
- ### P = {conjunto de producciones o reglas de derivacion}

#### Todas las cadenas del lenguaje definido por la gramática están formadas con símbolos del vocabulario terminal VT.
#### El vocabulario no terminal VN son elementos auxiliares para la definición de la gramática, y no figuran en las cadenas del lenguaje.

- La intersección entre VT y VN es vacía: $VN \cap VT = \emptyset$
- La unión entre VT y VN es el vocabulario: $VN \cup VT = V$

#### Se comienza con un tipo de gramaticas que pretende ser universal, aplicando restricciones a sus reglas de derivacion se van a obtener otros tres tipos de gramaticas

---

# Jerarquias entre gramaticas y lenguajes

### <u>Esta clasificacion es jerarquica, es decir cada tipo de gramatica engloba a todos los tipos siguientes</u> (Chomsky, 1959)

### <font color="#2DC26B">Gramatica de tipo 0</font>
#### Tambien llamadas gramaticas no restringidas o gramaticas con estructura de frase
### <font color="#2DC26B">Gramaticas de tipo 1</font>
#### Tambien llamadas gramaticas sensibles al contexto
### <font color="#2DC26B">Gramaticas de tipo 2</font>
#### Tambien se denominan gramaticas de contexto libre o libres de contexto
### <font color="#2DC26B">Gramaticas de tipo 3</font>
#### Tambien denominadas regulares o gramaticas lineales a la derecha; comienzan sus reglas de producción por un símbolo terminal, que puede ser seguido o no por un símbolo no terminal

---

## Jerarquia entre las gramaticas (tabla completa)

| Gramática tipo | 0 | 1 | 2 | 3 |
|---|---|---|---|---|
| Regla de derivación | $\alpha \rightarrow \beta$ | $\alpha A \beta \rightarrow \alpha \gamma \beta$ | $A \rightarrow \alpha$ | $A \rightarrow aB$  ó  $A \rightarrow a$ |
| Siendo | $\alpha \in (T\cup N)^+$, $\beta \in (T\cup N)^*$ | $A\in N$, $\gamma \in (T\cup N)^+$, $\alpha,\beta \in (T\cup N)^*$ | $A \in N$, $\alpha \in (T\cup N)^+$ | $A,B \in N$, $a \in T$ |
| Restricción | $\lambda \to \beta$ | Se puede reemplazar $A$ por $\gamma$ solo si está en el contexto $\alpha ... \beta$ (la parte derecha es $\geq$ que la izquierda en longitud) | Cada regla es un par ordenado $(A,\alpha)$ | La regla de producción comienza por un símbolo terminal, seguido o no de un no terminal |
| Ejemplo de lenguaje | $\{0^i1^{i+k}2^k3^{n+1} : i,k,n\geq 0\}$ | $\{a^nb^nc^n : n>0\}$ | $\{a^nb^n : n\geq 1\}$ | $aa^*bb^*$ |

**Nota**: <font color="#ff0000">Gramática tipo 3 == gramática regular</font>. Es la más restringida y la más simple de reconocer (con un autómata finito).

---

# CORRESPONDENCIA ENTRE GRAMÁTICAS Y LENGUAJES

- ### Se denomina ==lenguaje de tipo 0== al generado por una gramatica de tipo 0

- ### De la misma forma, se denomina ==lenguaje de tipo 1, tipo 2, y tipo 3, a los generados por las gramaticas de tipo 1, tipo 2, y tipo 3, respectivamente.==

- ### Si los lenguajes generados por los distintos tipos de gramáticas se relacionan entre sí con respecto a la relación de inclusión se obtiene:

![[Pasted image 20260829074235.png]]

**Los lenguajes forman una jerarquía anidada**: todo lenguaje tipo 3 es también tipo 2, todo tipo 2 es también tipo 1, y todo tipo 1 es también tipo 0.
$$ L_{tipo3} \subset L_{tipo2} \subset L_{tipo1} \subset L_{tipo0}$$

---

## <font color="#ff0000">Correspondencia gramática ↔ autómata (repaso rápido para el parcial)</font>

| Tipo de gramática | Tipo de lenguaje | Autómata que lo reconoce |
|---|---|---|
| Tipo 0 (sin restricción) | Recursivamente enumerable | [[Maquina de Turing]] |
| Tipo 1 (sensible al contexto) | Dependiente del contexto | [[Automata Lineal Acotado]] |
| Tipo 2 (libre de contexto) | Libre de contexto | [[Automata de Pila]] |
| Tipo 3 (regular) | Regular | [[Automatas Finitos]] |

- **Teorema**: para toda gramática de un tipo dado existe un autómata (del tipo correspondiente) que reconoce exactamente el mismo lenguaje, y viceversa (relación biunívoca).
- Dada una gramática (sus reglas de producción) siempre es posible encontrar el autómata correspondiente que reconoce las mismas palabras.

### Ver también
- [[Definiciones previas]]
- [[Automata]]
- [[Automatas Finitos]]
- [[Expresiones Regulares]]
