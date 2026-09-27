# Definiciones
#### Un autómata es una construcción lógica que recibe una entrada y produce una salida en función de todo lo recibido hasta ese instante

## Defincion formal de automata
### Un automata es una quintupla $A = (E,S,Q,f,g)$ donde:
### E = {conjunto de entradas o vocabulario de entrada}
- E es un conjunto finito, y sus elementos se llaman entradas o simbolos de entrada.

### S = {conjunto de salidas o vocabulario de salida}
- S es un conjunto finito, y sus elementos se llaman salidas o simbolos de salida

### Q = {conjunto de estados}
- Q es el conjunto de estados posibles, puede ser finito o infinito

### $f:ExQ \rightarrow Q$

- es la funcion de transicion o funcion del estado siguiente y para un par del conjunto
- $ExQ$ devuelve un estado perteneciente al conjunto Q
- $ExQ$ es el conjunto producto cartesiano de E por Q
### $g : ExQ \rightarrow S$
- es la funcion de salida y para un par del conjunto E Q, devuelve un simbolo de salida del conjunto S.

#### Los automatas se pueden representar mediante:
- Tabla de transiciones
- Diagramas de estado (grafo dirigido, nodos = estados, aristas etiquetadas = entrada/salida)
- Diagramas de Moore

---
### Notacion
#### Los elementos del vocabulario terminal se representan por :
- letras minusculas de comienzo del abecedario : a,b,c...g
- operadores tales como: +,-,...
- caracteres especiales:  # , @ , (,)
- los digitos:0,1,...9
- las palabras reservadas if else..
### Vocabulario no terminal
#### Los elementos del vocabulario no terminal se representan por:
- letras mayusculas de comienzo del abecedario: A,B,...,G.
- La unica excepcion suele ser el simbolo inicial que se representa con S
- nombres en minusculas pero encerrados entre parentesis angulares <>
### Cadenas
- Las cadenas que contienen simbolos terminales y no terminales indiferenciados se representan por: letras minusculas griegas: $\alpha, \beta, \gamma...$

---

# <font color="#ff0000">Jerarquía de autómatas</font>

Así como hay una jerarquía de gramáticas (tipo 0, 1, 2 y 3), existe una jerarquía de autómatas equivalente, cada uno **más potente** (reconoce más lenguajes) que el siguiente:

$$[[Automatas\ Finitos]] \subset [[Automata\ de\ Pila]] \subset [[Automata\ Lineal\ Acotado]] \subset [[Maquina\ de\ Turing]]$$

| Autómata | Tipo de gramática/lenguaje | Memoria auxiliar | Cabezal |
|---|---|---|---|
| [[Automatas Finitos]] (AFD/AFND) | Tipo 3 - regular | Ninguna (solo estado) | Solo lectura, se mueve a la derecha |
| [[Automata de Pila]] | Tipo 2 - libre de contexto | Una pila (LIFO) | Solo lectura |
| [[Automata Lineal Acotado]] | Tipo 1 - sensible al contexto | Cinta finita (acotada por # y $) | Lectura/escritura, ambos sentidos |
| [[Maquina de Turing]] | Tipo 0 - sin restricción | Cinta infinita | Lectura/escritura, ambos sentidos |

- Cada autómata de la jerarquía **incluye** las capacidades del anterior: todo lo que reconoce un autómata finito lo reconoce también un autómata a pila, y así sucesivamente.
- **¿Un programa puede ser expresado por una máquina de Turing?** Sí, de hecho todo programa tiene una máquina de Turing asociada (es el autómata más potente, sin restricciones).
- **¿Cualquier programa puede ser expresado por un autómata lineal acotado?** Sí, ya que un autómata lineal acotado es una máquina de Turing con la cinta finita, y los programas reales están siempre acotados en código y memoria.
- **¿Un programa cualquiera puede ser expresado por un autómata a pila?** No, un autómata a pila es menos potente (tipo 2) y no puede reconocer, por ejemplo, lenguajes tipo 1 como $\{a^nb^nc^n\}$.

---

# Diagramas de Mealy / Moore

Son dos formas equivalentes de representar autómatas **con salida** (transductores), muy usados para modelar sistemas secuenciales.

## <font color="#2DC26B">Máquina de Mealy</font>
- La **salida depende del estado actual Y de la entrada actual**: $g: E \times Q \rightarrow S$
- La salida se asocia a los **arcos** (transiciones) del diagrama.
- Suele necesitar **menos estados** que una máquina de Moore equivalente, porque aprovecha la combinación estado+entrada para generar la salida.

## <font color="#2DC26B">Máquina de Moore</font>
- La **salida depende únicamente del estado actual**: $g: Q \rightarrow S$
- La salida se asocia a los **nodos** (estados) del diagrama.
- En una máquina de Moore, **el símbolo de salida está relacionado con el estado en el que se encuentra** la máquina (no con la entrada).
- Los cambios de estado (y por lo tanto de salida) se producen recién al **borde del reloj** (un ciclo más tarde que la entrada que los provocó).

## <font color="#ff0000">Comparación (pregunta típica de parcial)</font>

| | Mealy | Moore |
|---|---|---|
| Salida depende de | Estado + entrada | Solo del estado |
| Cantidad de estados | **Menor** (tiende a tener menos) | Mayor |
| Seguridad / estabilidad | Puede reaccionar en el mismo ciclo (más rápido pero más sensible a glitches) | **Más segura**: los cambios de estado se dan al borde de reloj (un ciclo más tarde), lo que evita comportamientos transitorios (glitches) |

- **¿Cuál máquina tiende a tener menos estados y por qué: Mealy o Moore?** Mealy, porque genera la salida en base a su estado actual y a la entrada, no necesita un estado adicional solo para representar una salida distinta.
- **¿Cuál máquina es más segura de utilizar y por qué: Mealy o Moore?** Moore, porque sus cambios de estado (y de salida) se producen al borde del reloj, un ciclo más tarde, evitando problemas de sincronización.

### Ver también
- [[Gramatica]]
- [[Automatas Finitos]]
- [[Automata de Pila]]
- [[Automata Lineal Acotado]]
- [[Maquina de Turing]]
- [[Expresiones Regulares]]
