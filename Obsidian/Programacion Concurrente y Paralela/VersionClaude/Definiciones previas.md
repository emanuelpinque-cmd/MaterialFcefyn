## <font color="#ff0000">Simbolo</font>
### Es una entidad abstracta, que no se va a definir pues se dejara como axioma

- #### Normalmente los símbolos son letras (a, b, c, ..., z), dígitos (0, 1, ..., 9), y otros caracteres (+, -, *, /, ?, ...)
- #### Los símbolos también pueden estar formados por varias letras o caracteres

## <font color="#ff0000">Vocabulario o alfabeto</font>
### Es un conjunto finito de simbolos, no vacio.

- ####  Para definir que un simbolo pertenece a un alfabeto V se utiliza la notacion   $a\in V$ 
- #### Los alfabetos se definenen por enumeracion de los simbolos que contienen
- #### Tambien se puede definir tablas ASCII y EBCDIC como alfabetos

## <font color="#ff0000">Cadena</font>
- ### Una cadena es una secuencia finita de simbolos de un determinado alfabeto
- #### Longitud de la cadena
#### La longitud de la cadena es el numero de simbolos que contiene, la notacion empleada es la que se indica:
$$\huge |abcb| \rightarrow 4$$
$$\huge |a + 2*b|\rightarrow 5$$
## <font color="#ff0000">Cadena vacia</font>
#### Existe una cadena denominada cadena vacia, que no tiene simbolos y se denota con  $\lambda$ entonce su longitud es $|\lambda| \rightarrow 0$ 

---

## <font color="#ff0000">Concatenacion de cadenas</font>
### Sean $\alpha$ y $\beta$ dos cadenas cualesquiera, se denomina concatenacion de $\alpha$ y $\beta$ a una nueva cadena $\alpha \beta$ constituida por los simbolos de la cadena $\alpha$ seguidos por los de la cadena $\beta$

### El elemento neutro de la concatenacion es $\lambda$, se cumple
$\Huge \alpha \lambda = \lambda \alpha = \alpha$

---

## <font color="#ff0000">Universo del discurso</font>
### El conjunto de todas las cadenas que se pueden formar con los simbolos de un alfabeto V se denomina universo del discurso de V y se representa por W(V)

### Evidentemente W(V) es un conjunto infinito

### La cadena vacia pertenece a W(V)

### Ej
#### Sea un alfabeto con una sola letra V = {a}, entonces el universo del discurso es:
####  $W(V) = \{ \lambda, a,aa,aaa..\}$ que contiene infinitas cadenas

#### <font color="#2DC26B">Clausura y clausura positiva de un alfabeto</font>
- **Cierre o Clausura de un Alfabeto ($V^*$)**: es el Universo de Discurso de V, ==incluyendo== la cadena vacía. Es decir $V^* = W(V)$.
- **Clausura Positiva de un Alfabeto ($V^+$)**: es el Universo de Discurso de V, ==sin incluir== la cadena vacía.
- Se cumple: $V^+ = V^* - \{\lambda\}$ y $V^* = V^+ \cup \{\lambda\}$

---

## <font color="#ff0000">Lenguaje</font>

### Se denomina lenguaje sobre un alfabeto V ==a un subconjunto del universo del discurso==

### Tambien se puede definir como ==un conjunto de palabras de un determinado alfabeto==

#### Los lenguajes no se definen por enumeración de sus cadenas (es ineficiente y en general imposible si son infinitas): se definen **por las propiedades que cumplen** las cadenas del lenguaje.

- Ej: el conjunto de palíndromos (cadenas que se leen igual hacia adelante que hacia atrás) sobre el alfabeto $\{0,1\}$ es un lenguaje de infinitas cadenas:
	$$\lambda, 0, 1, 00, 11, 010, 0110, 000000, 101101, ...$$

## <font color="#ff0000">Lenguaje vacio</font>

### El lenguaje vacio es un conjunto vacio se denota $\{\emptyset\}$

<font color="#ff0000">No confundir</font>: el lenguaje vacío $\{\emptyset\}$ **no es lo mismo** que el lenguaje que contiene únicamente a la cadena vacía $\{\lambda\}$, ya que su cardinalidad es distinta:
$$Cardinal(\{\emptyset\}) = 0 \qquad Cardinal(\{\lambda\}) = 1$$

---

### Ver también
- [[Gramatica]] — ente formal para especificar de manera finita el conjunto de cadenas de un lenguaje
- [[Automata]] — construcción lógica que recibe una entrada y produce una salida en función de todo lo recibido hasta ese instante
