
# Definiciones
#### Un autómata es una construcción lógica que recibe una entrada y produce una salida en función de todo lo recibido hasta ese instante

## Defincion formal de automata
### Un automata es una quintupla $A = (E,S,Q,f,g)$ donde:
### E = {conjunto de entreadas o vocabulario de entrada}
- E es un conjunto finito, y sus elementos ese llaman entradas o simbolos de entrada.

### S = {conjunto de salidas o vocabbulario de salida}
- S es un conjunto finito, y sus elementos se llaman salidas o simbolos de salida

### Q = {conjunto de estados}
- Q es el conjunto de estados posibles, puede ser finito o infinito

### $f:ExQ \rightarrow W$

- es la funcion de transicion o funcion del estado siguiente y para un par del conjunto
- $ExQ$ devuelve un estado perteneciente al conjunto Q
- $ExQ$ es el conjunto producto cartesiano de E por Q
### $g : ExQ \rightarrow S$
- es la funcion de salida y para un par del conjunto E Q, devuelve un simobolo de salida del conjunto S.

#### Los automatas se pueden representar mediante:
- Tabla de transiciones
- DIagramas de Moore
---
### Notacion
#### Los elementos del vocabulario terminal se representan por :
- letras minusculas de comienzo del abecedario : a,b,c...g
- operadores tales como: +,-,...
- caracteres especiales:  # , @ , (,)
- los disgitos:0,1,...9
- las palabras reservadas if else..
### Vocabulario no terminal
#### Los elementos del vocabulario no terminal se representan por:
- letras mayusculas de comienzo del abecedario: A,B,...,G.
- La unica excepcion suele ser el simbolo inicial que se representa con S
- nombres en minusculas pero encerrados entre parentesis angulares <>
### Cadenas
- Las cadenas que contienen simbolos terminales y no terminales indfiferenciados se presentan por: letras minusculas griegas;

---

# Diagramas de Mealy / Moore

