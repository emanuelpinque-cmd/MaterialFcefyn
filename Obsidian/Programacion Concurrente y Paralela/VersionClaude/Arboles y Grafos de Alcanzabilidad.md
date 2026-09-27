# Árboles y Grafos de Alcanzabilidad (Analysis methods)

Son dos **métodos de análisis** de una RdP, complementarios al álgebra lineal (ver [[Algebra Lineal - Matrices de RdP]]):
- **Graph of Markings** (Grafo de marcas / grafo de alcanzabilidad)
- **Coverability Root Tree** (Árbol de raíz de cobertura) → cuando la red no es acotada, se usa el **Reachability tree** (árbol de alcanzabilidad) como caso particular cuando sí es acotada.

---

## <font color="#ff0000">Graph of Markings (Grafo de marcas / grafo de alcanzabilidad)</font>

### Definición
El **gráfico de marcas** está formado por:
- **Vértices**: corresponden a las **marcas alcanzables** de la red.
- **Arcos**: corresponden a los **disparos de transiciones** que llevan de una marca a otra.

### Ejemplo
Con marca inicial $m_0 = (2,0)$:
- Desde $m_0$ solo se puede disparar $T_1$ → se llega a $m_1 = (1,1)$.
- Desde $m_1$, ambas transiciones están habilitadas: si se dispara $T_1$ se llega a $m_2=(0,2)$; si se dispara $T_2$ se llega a $m_3=(0,1)$.
- $m_2$ y $m_3$ son puntos muertos (deadlock) en este ejemplo.

**El grafo de marcas se puede usar para encontrar todas las propiedades de una RdP**: por ejemplo, observando el grafo se puede ver directamente si la red es **segura**, **viva**, **reversible**, si existen **secuencias repetitivas** (ciclos que vuelven al mismo marcado, ej: $T_1T_2T_3$ y $T_1T_4T_5$), y si una secuencia de disparo es **completa** (vuelve a $m_0$: $m_0 \xrightarrow{S} m_0$, lo que indica que la RdP es **consistente**).

### <font color="#ff0000">Limitación</font>
Este método **solo es aplicable si la RdP es acotada** (ver [[Propiedades de las redes de petri]]): si el número de marcas alcanzables es infinito, el grafo de marcas no se puede terminar de construir.

---

## <font color="#ff0000">Reachability Tree (Árbol de alcanzabilidad)</font>

### Definición
El árbol de alcanzabilidad (también llamado gráfico de marcado) de una red de Petri $(N, m_0)$ es un gráfico en el que:
- Los **nodos** corresponden a marcas alcanzables.
- Los **arcos** están correlacionados con las transiciones factibles de dispararse.

Es una representación en forma de **árbol** (en lugar de grafo, con posibles nodos repetidos) del mismo espacio de marcas.

**Observación**: el árbol de alcance de una RdP **sin límites es ilimitado** (infinito), por lo que no siempre se puede construir completo.

---

## <font color="#ff0000">Coverability Root Tree (Árbol de raíz de cobertura)</font>

### Motivación
Cuando la RdP **no es acotada** (el número de marcas alcanzables es infinito), no se puede construir el grafo de marcas completo. Para resolver esto se construye un **árbol de raíz** que sí tiene, por construcción, un **número finito de vértices**: el árbol de raíz de cobertura.

### El símbolo ω (omega)
Se introduce un símbolo especial $\omega$ tal que, para cualquier entero $n$:
$$n < \omega \qquad \text{y} \qquad n + \omega = \omega$$

- $\omega$ representa un **número no acotado** (una cantidad que puede crecer indefinidamente).
- Se lo usa en una componente del vector de marcado cuando esa componente puede tomar valores arbitrariamente grandes.
- Al vector que contiene algún $\omega$ se lo llama **macro marcado**, porque en realidad representa un **conjunto infinito** de posibles marcas.

### <font color="#2DC26B">Algoritmo de construcción (resumen)</font>
Cada vértice del árbol corresponde a una marca o macro marca.

1. **Paso 1**: a partir de la marca inicial $m_0$, se indican todas las transiciones habilitadas y las marcas sucesivas. Si alguna marca resultante es **mayor o igual** que $m_0$ (componente a componente, y estrictamente mayor en al menos una), se reemplaza por $\omega$ en cada componente que sea mayor que la correspondiente de $m_0$.
2. **Paso 2**: para cada nuevo vértice $m_i$ del árbol:
   - **Paso 2.1**: si ya existe un vértice $m_j = m_i$ en el camino de $m_0$ a $m_i$ (sin incluir a $m_i$), entonces $m_i$ **no tiene sucesor** (se cierra esa rama, es un ciclo ya visto).
   - **Paso 2.2**: si no existe tal vértice repetido, se expande el árbol con todos los sucesores de $m_i$. Para cada sucesor $m_k$:
     1. Cualquier componente que ya era $\omega$ en $m_i$, sigue siendo $\omega$ en $m_k$.
     2. Si existe un vértice en el camino de $m_0$ a $m_k$ tal que $m_k \geq m_j$, se coloca $\omega$ en cada componente de $m_k$ que sea mayor que la correspondiente de $m_j$.

### <font color="#ff0000">Limitaciones del árbol de cobertura</font>
- El árbol de raíz de cobertura **siempre tiene un número finito de vértices**, pero a cambio **pierde información** (por el uso del símbolo $\omega$).
- **No resuelve, en general, el problema de alcanzabilidad**: dado un marcado cualquiera, no siempre se puede saber con certeza si es alcanzable o no a partir del árbol de cobertura (aunque una marca "quepa" bajo un macro-marcado con $\omega$, eso no garantiza que sea realmente alcanzable).
- Tampoco resuelve, en general, el problema de la **vivacidad** (liveness).
- **Caso especial**: si la RdP **es acotada**, el árbol de raíz de cobertura contiene efectivamente **todas** las marcas alcanzables posibles, y en ese caso se lo llama **árbol de raíz de alcanzabilidad**. Fusionando los vértices repetidos de este árbol se obtiene el **gráfico de alcanzabilidad** (el grafo de marcas visto arriba).

### Ver también
- [[Propiedades de las redes de petri]]
- [[Algebra Lineal - Matrices de RdP]]
- [[Redes de petri]]
