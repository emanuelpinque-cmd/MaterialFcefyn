### La gramatica ==es un ente formal== para especificar, de una manera finita, ==el conjunto de cadenas== de simbolos que constituyen un lenguaje

## Automata
### Un automata es una construccion logica que recibe una entrada y produce una salida en funcion de todo lo recibido hasta ese instante


## Definicion formal de gramatica

### Una gramatica es una cuadrupla : $G = (VT,VN,P,S)$

### Donde : 

- ### VT = {confunto finito de simbolos terminales} (estados)
- ### VN = {conjunto finito de simbolos no terminales}(eventos)
- ### S es el simbolo inicial y pertenece a VN
- ### P = {conjunto de produccion o reglas de derivacion}

#### Se comienza con un tipo de gramaticas que pretende ser universal, aplicando restricciones a sus reglas de derivacion se van a obtener otros tres tipos de gramaticas

# Jerarquias entre gramaticas y lenguajes

### <u>Esta clasificacion es jererquica es decir cada tipo de gramatica engloba a todos los tipos siguientes</u>

### <font color="#2DC26B">Gramatica de tipo 0</font>
#### Tambien llamdas gramaticas no restringidas o gramaticas con estructura de rase
### <font color="#2DC26B">Gramaticas de tipo 1</font>
#### Tambien llamdas gramaticas sensibles al contexto
### <font color="#2DC26B">Gramaticas de tipo 2</font>
#### Tambien se denominan grmaticas de contexto libre o libres de contexto
### <font color="#2DC26B">Gramaticas de tipo 3 </font>
#### Tambien denominadas regulares o gramatica

---

## Jerarquia entre las gramaticas

| Gramaticas tipo      |             0              |                        1                         | 2                 | 3                  |
| :------------------- | :------------------------: | :----------------------------------------------: | ----------------- | ------------------ |
| Reglas de derivacion | $\alpha \rightarrow \beta$ | $\alpha A \beta \rightarrow \alpha \gamma \beta$ | $A \rightarrow a$ | $A \rightarrow aB$ |


---
# Correspondencia entre gramaticas y lenguajes

- ### Se denomina ==lenguaje de tipo 0== al generado por una gramatica de tipo 0

- ### De la misma forma, se denomina ==lenguaje de tipo 1, tipo 2, y tipo 3, a los genrados por las gramaticas de tipo 1, tipo 2, y tipo 3, respectivamente.==

- ### Si los lenguajes generados por los distintos tipos de gramticas se relacion entre si con respecto a la relacion de inclusion se obtiene![[Pasted image 20260829074235.png]]