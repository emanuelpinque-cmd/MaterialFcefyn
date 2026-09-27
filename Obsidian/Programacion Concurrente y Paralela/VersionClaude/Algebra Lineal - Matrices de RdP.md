# Álgebra Lineal aplicada a Redes de Petri

Este formalismo permite definir una RdP (y algunas de sus propiedades, como los invariantes) mediante matrices, en lugar de razonar solo gráficamente. Se aplica tanto a RdP ordinarias como a RdP generalizadas.

---

## <font color="#ff0000">Definición formal con matrices Pre y Post</font>

Una RdP ordinaria **no marcada** es la cuádrupla:
$$Q = \langle P, T, Pre, Post \rangle$$

donde:
- $P = \{P_1, P_2, ..., P_n\}$: conjunto finito y no vacío de lugares
- $T = \{T_1, T_2, ..., T_m\}$: conjunto finito y no vacío de transiciones
- $P \cap T = \emptyset$, es decir, los conjuntos P y T son inconexos (disjuntos)
- **Pre**: $P \times T \rightarrow \{0,1\}$ es la aplicación de **incidencia de entrada**
- **Post**: $P \times T \rightarrow \{0,1\}$ es la aplicación de **incidencia de salida**

Donde:
- $Pre(P_i,T_j)$ es el **peso del arco** $P_i \rightarrow T_j$ (cuánto consume el disparo de Tj del lugar Pi)
- $Post(P_i,T_j)$ es el **peso del arco** $T_j \rightarrow P_i$ (cuánto produce el disparo de Tj en el lugar Pi)

> Para **RdP generalizadas** (con pesos de arco mayores a 1), Pre y Post se generalizan a $P\times T \rightarrow \mathbb{N}$ en lugar de $\{0,1\}$.

### Notación de conjuntos de entrada/salida de una transición
- $^{\bullet}T_j = \{P_i \in P \mid Pre(P_i,T_j) > 0\}$ = conjunto de lugares de **entrada** de Tj
- $T_j^{\bullet} = \{P_i \in P \mid Post(P_i,T_j) > 0\}$ = conjunto de lugares de **salida** de Tj

### RdP marcada
Un RdP marcado es un par $R = \langle Q, m_0 \rangle$, donde $Q$ es una RdP no marcada y $m_0$ es la marca inicial.

**Condición de habilitación con esta notación**: la transición $T_j$ está habilitada para un marcado $m_k$ si:
$$m_k(P_i) \geq Pre(P_i,T_j) \quad \forall P_i \in {}^{\bullet}T_j$$

---

## <font color="#ff0000">Matriz de incidencia (o matriz de flujo)</font>

Se arman dos matrices (filas = lugares, columnas = transiciones):

- **Matriz de incidencia de entrada**: $\mathbf{W^-} = [w_{ij}^-]$, donde $w_{ij}^- = Pre(P_i,T_j)$
- **Matriz de incidencia de salida**: $\mathbf{W^+} = [w_{ij}^+]$, donde $w_{ij}^+ = Post(P_i,T_j)$

Y la **matriz de incidencia total** (matriz de flujo):
$$\mathbf{W} = \mathbf{W^+} - \mathbf{W^-} = [w_{ij}]$$

**Observación**: si una RdP es **pura** (sin autoloops, ver [[Redes de petri]]), su matriz de incidencia $W$ contiene toda la información necesaria para reconstruir la RdP no marcada (no hace falta guardar Pre y Post por separado).

### Ejemplo numérico
Para una RdP con lugares $P_1..P_5$ y transiciones $T_1..T_4$:

$$\mathbf{W^-} = \begin{bmatrix} 1&0&0&0\\0&1&0&0\\0&0&0&1\\0&0&1&0\\0&0&0&1 \end{bmatrix} \qquad \mathbf{W^+} = \begin{bmatrix} 0&0&0&1\\1&0&0&0\\0&1&0&0\\1&0&0&0\\0&0&1&0 \end{bmatrix}$$

$$\mathbf{W} = \mathbf{W^+}-\mathbf{W^-} = \begin{bmatrix} -1&0&0&+1\\+1&-1&0&0\\0&+1&0&-1\\+1&0&-1&0\\0&0&+1&-1 \end{bmatrix}$$

Cada **columna** de W representa el efecto neto de disparar esa transición: cuánto se resta (-) o suma (+) en cada lugar.

---

## <font color="#ff0000">Ecuación fundamental</font>

Sea $S$ una secuencia de disparos que lleva a la red del estado $m_i$ al estado $m_k$: $m_i \xrightarrow{S} m_k$.

El **vector característico** de la secuencia $S$, escrito $\mathbf{s}$, es el vector cuya componente $j$ corresponde a la **cantidad de veces** que se disparó la transición $T_j$ en la secuencia $S$.
- Ejemplo: si $S = T_2$, entonces $\mathbf{s} = (0,1,0,0)$.

La **ecuación fundamental** relaciona el marcado final con el inicial y la matriz de incidencia:
$$\mathbf{m_k} = \mathbf{m_i} + \mathbf{W} \cdot \mathbf{s}$$

### Ejemplo
Con $\mathbf{m_1}=(0,1,0,1,0)$, $\mathbf{s_1}=(1,0,0,0)$ (se disparó solo $T_1$ una vez):
$$\mathbf{m_2} = \mathbf{m_1} + \mathbf{W}\cdot\mathbf{s_1} = (0,1,0,1,0)+(1,-1,0,0,0) = (0,0,1,1,0)$$

### <font color="#2DC26B">Observaciones importantes</font>
- El vector $\mathbf{s}$ es un vector característico **"posible"** solo si existe al menos una secuencia de disparos real que lo produzca. **No todo** vector de enteros positivos o cero es posible (puede que ninguna secuencia de disparos válida le corresponda).
- **Varias secuencias de disparo distintas pueden corresponder al mismo vector característico** $\mathbf{s}$ (por ejemplo $T_2T_3$ y $T_3T_2$ dan el mismo $\mathbf{s}=(0,1,1,0)$). Según la ecuación fundamental, ambas llevan al **mismo marcado final** (el orden de disparo no cambia el resultado neto).
- Lo contrario **no es cierto**: dos secuencias que llegan al mismo marcado final no necesariamente tienen el mismo vector característico.

---

## <font color="#ff0000">Marking Invariants (Invariantes de marca / P-invariantes)</font>

Se considera un **vector de ponderación** para los lugares $\mathbf{x} = (q_1,q_2,...,q_n)$, donde cada $q_i$ es un entero positivo o cero (el peso asociado al lugar $P_i$).

Sea $P(\mathbf{x})$ el conjunto de lugares cuyo peso **no es cero**: $P(\mathbf{x}) \subseteq P$.

### Propiedad (componente conservador)
Un conjunto $B$ de lugares es un **componente conservador** si y solo si existe un vector de ponderación $\mathbf{x}$ tal que:
$$P(\mathbf{x}) = B \quad \text{y} \quad \mathbf{x}^T \cdot \mathbf{W} = 0$$

### Derivación de por qué el peso ponderado se mantiene constante
A partir de la ecuación fundamental $\mathbf{m_k} = \mathbf{m_0} + \mathbf{W}\cdot\mathbf{s}$, multiplicando ambos lados por $\mathbf{x}^T$:
$$\mathbf{x}^T \cdot \mathbf{m_k} = \mathbf{x}^T \cdot \mathbf{m_0} + \mathbf{x}^T \cdot \mathbf{W} \cdot \mathbf{s}$$

Si $\mathbf{x}^T \cdot \mathbf{W} = 0$, entonces:
$$\mathbf{x}^T \cdot \mathbf{m_k} = \mathbf{x}^T \cdot \mathbf{m_0}$$

Es decir: **la suma ponderada de tokens (con los pesos de x) es siempre la misma**, para cualquier marcado alcanzable $\mathbf{m_k}$. Esto es exactamente la idea intuitiva de "componente conservador" que se vio en [[Propiedades de las redes de petri]] (por ejemplo, en una exclusión mutua, "libre + ocupado = 1" siempre).

**El vector x es un invariante P** (un invariante P es un vector no negativo que cumple $\mathbf{x}^T\cdot\mathbf{W}=0$).

### Ver también
- [[Redes de petri]]
- [[Propiedades de las redes de petri]]
- [[Arboles y Grafos de Alcanzabilidad]]
