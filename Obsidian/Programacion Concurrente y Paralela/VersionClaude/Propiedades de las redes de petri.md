## Secuencia de disparo finita
### Definición:
**Existe una secuencia de disparos finita si: para un $\sigma \in T^{\infty}$ cualquier prefijo $\sigma '$  de $\sigma$ es una secuencia de disparos finita de disparos**
### Otra caracteristica
- Cuando una red no tiene una secuencia finita de disparos se dice que cumple con las propiedades de terminación.

---

## RdP limitada

**Vamos a dar una defincion previa**
### Lugar K-acotado
**Una plaza Pi esta delimitado por una marca inicial $m_0$ si hay un entero natural k tal que para todas las marcas alcanzables desde $m_0$ el numero de tokens de Pi no es mayor a K**

### Definición
**Una RdP esta limitada (acotada) para una marca inicial $m_0$ si todos los lugares están limitados para $m_0$**

<font color="#ff0000">Depende de la marca inicial!!</font>

---

## RdP segura

### Definicion: se dice que una RdP es segura para una marca inicial si para cada marca alcanzable, cada lugar contiene cero o un token

Una RdP segura es un caso particular de RdP limitada donde K=1

---

## <font color="#ff0000">Vivacidad (Liveness)</font>

### RdP Seudo Viva
**Seudo Vicacidad**: una RdP es Seudo viva si:
$$\forall m \in M(R,m_0)\; \exists t \in T \; s.t.\; m \xrightarrow{t}$$
- Es una RdP seudo-viva cuando **existen** algunas transiciones vivas por lo que no se bloquea totalmente. Es decir, desde cualquier marca alcanzable hay **al menos alguna** transición que puede disparar.

### RdP Quasi Viva
Se dice que una transición es **Quasi-viva** si es posible dispararla al menos una vez.

**Definición** (Quasi Vivacidad): una RdP es Quasi Viva si:
$$\forall t \in T \; \exists m \in M(R,m_0)\; s.t.\; m \xrightarrow{t}$$
- Las propiedades de Quasi-viva no pueden garantizar que una determinada marca alcanzable pueda llegar a cualquier otro marcado en un futuro para alcanzar un **estado determinado**.

### RdP Viva (Liveness)
Se dice que una transición Tj es **viva** para una marca m0 si:
$$\forall m \in M(N,m_0)\; \exists\sigma \; \text{tal que}\; \sigma \; \text{es disparable desde}\; m \;\text{y contiene a}\; Tj$$

- Una RdP (N,m0) es **viva** si todas sus transiciones son vivas para m0.
- Es la propiedad más fuerte de las tres: desde **cualquier** marca alcanzable, siempre existe la posibilidad de eventualmente disparar **cualquier** transición.

### <font color="#ff0000">Jerarquía de vivacidad</font>
$$Viva \Rightarrow Quasi\text{-}viva \Rightarrow Seudo\text{-}viva$$

---

## Deadlock

**Definición**: un **Deadlock** (o estado sumidero) es una marca tal que no se puede disparar ninguna transición.

- Se dice que una RdP está **libre de interbloqueo** para una marca inicial m0 si ninguna marca alcanzable es un Deadlock.

### <font color="#ff0000">Relaciones relativas a la vivacidad y el deadlock</font>

- Si $T_j$ es viva para una marca inicial $m_0$, es cuasi-viva para una marca inicial $m_0$: $m_0^j \geq m_0$
- Si $T_j$ es viva en marca $m_0$, no es necesariamente viva en vivo: $m_0^j \geq m_0$
- Si una RdP está libre de deadlock (interbloqueo) para $m_0$, no es necesariamente así para $m_0^j \geq m_0$
- Las propiedades de liveness, cuasi-liveness y deadlock dependen claramente de la marca inicial.

**Observación**: las propiedades de vivacidad y quasi-vivacidad no son independientes entre sí. La RdP anterior con quasi-viva (la primera tiene un ejemplo con m0 puede evolucionar) es viva. Todas las propiedades de liveness, cuasi-liveness y deadlock-freeness son no independientes.

---

## Home state

**Definición**:
- a) Una RdP tiene **Home state** $m_r$ para una marca inicial $m_0$ si para cada marca alcanzable $m \in M(N,m_0)$, existe una secuencia de disparo tal que:
$$m \xrightarrow{s} m_r$$
- b) Una RdP es reversible para una marca inicial $m_0$ si $m_0$ es un Home state (es decir, siempre se puede volver a la marca inicial).

Está claro que la existencia de un Home state depende de la marca inicial. Por otro lado, tiene dos estados de origen para marca m0 (0, 1, 0, 0).

**El conjunto de Home state es el home state.**

Esta noción de estado de origen puede aplicarse a todos los tipos y extensiones de RdP.

---

## Conflictos

En esta sección, consideramos explícitamente las RdP generalizadas. Ahora especificamos los conceptos de:
- **conflicto efectivo**
- **conflicto general**
- **persistencia y concurrencia**

### Conflicto efectivo
En una RdP ordinaria, un **conflicto efectivo** es la existencia de un conflicto estructural K, y de una marca m, tal que el número de tokens en Pi es menor que el número de transiciones de salida de Pi que son habilitadas por m.

- Un conflicto efectivo, denotado por $K^E = \langle P_i, \{T_1, T_2, ...\}, m \rangle$ es la existencia de un conflicto estructural $K = \langle P_i, \{T_1,T_2,...\}\rangle$, y de una marca $m$, tal que están habilitadas por $m$ y el número de tokens en Pi es menor que la suma de los pesos de los arcos.
$$P_i \rightarrow T_1,\; P_i \rightarrow T_2, ...$$

### Conflicto general
**Definición**: un conflicto general, denotado por $K^G = \langle P_i, \{T_1,T_2,...\}\rangle$, es la existencia de un conflicto estructural $K = \langle P_i, \{T_1,T_2,...\}\rangle$ en la marca $m$, tal que el número de tokens en Pi es igual a los grados habilitantes.

- De acuerdo con la definición de conflicto efectivo, esta situación **no es un conflicto efectivo**, aunque sí puede ser un conflicto general si tanto T1 como T2 pueden dispararse simultáneamente.
- Sin embargo, existe un tipo de conflicto en el que **ambas** transiciones no se pueden disparar simultáneamente de acuerdo con los grados de habilitación: el disparo de T2 disminuye el grado de habilitación de T1 (y el disparo de T1 disminuye el de T2), los conflictos (T1T1, T2) son posibles, pero no (T1T1T2). Esto se llama **conflicto general**.

---

## Múltiples disparos

En la RdP con un marcado m2, es posible disparar T1 y T2 puesto que son independientes (no comparten lugares de entrada y hay suficientes tokens).

- Es posible el disparo concurrente.
- Se denota $\{T1T2\}$ al disparo concurrente, el disparo puede ser realizado en cualquier orden o simultáneamente.

## Concurrencia
Se dice que dos (o más) transiciones son **simultáneas** si están habilitadas y son causalmente independientes, es decir, pueden dispararse antes o después de una respecto de la otra.

- En la mayoría de los casos, estas dos transiciones no tienen ningún lugar de entrada en común: no hay conflicto entre T1 y T2.
- Las transiciones pueden tener un lugar en común de entrada, pero, en este caso, hay suficientes tokens en ese lugar común, en ese caso, hay suficientes tokens para activar ambas transiciones al mismo tiempo, sin que uno le quite el token al otro.
- Si, por marca alcanzable $m \in M(N,m_0)$, no hay conflicto efectivo, entonces cualquier momento las transiciones habilitadas son concurrentes.

## Persistencia
Una RdP es **persistente** si para cada marca alcanzable $m \in M(N,m_0)$ existe la siguiente propiedad:
- por cada par de transiciones Tj y Tk habilitadas marcando m, la secuencia de disparo de $m$ es una secuencia de disparo de $m_i$ (así como en sentido opuesto de Tj).

Una transición habilitada solo se puede desactivar mediante su propio disparo.

- Se puede observar que una RdP persistente cualquiera, si una transición Tj está habilitada, entonces $T_j$ permanece siempre concurrente hasta que se disparó, es decir, la RdP no tiene comportamiento de conflicto entre transiciones habilitadas simultáneamente.
- En el caso de dos habilitadas hay conflicto efectivo entre ellas, la RdP no es persistente.
- Por otro lado, hay una relación entre concurrencia efectiva y la persistencia: en el caso de la Figura 1, la persistencia significa cada dos transiciones concurrentes Tj,Tk son concurrentes posibles, entonces esto se llama.

## Grado de Habilitando
- Por lo general, la habilitación de una transición se considera como una propiedad "booleana".
	- la transición está habilitada o no está habilitada.
- Podemos tener en cuenta el grado de habilitación de una transición, que corresponde al número máximo de disparos que puede ocurrir en ese instante, sin importar de qué otras transiciones se disparen antes.
- Tenga en cuenta que dos disparos de una transición no son concurrentes, es decir, la secuencia de disparo puede ser $\{T_j,T_j\} = T_jT_j$

---

## <font color="#ff0000">Invariantes (nociones intuitivas)</font>

A partir de una marca inicial, el marcado de una RdP puede evolucionar mediante el disparo de transiciones y, sin embargo, **si no hay punto muerto, el número de disparos es ilimitado**.

Los invariantes permiten caracterizar ciertas propiedades de las marcas alcanzables y de las transiciones inalterables, independientemente de la evolución del sistema.

### Componentes conservadores
Vemos que una combinación de plazas de la red **cumple una propiedad de invariante**: la suma ponderada de las marcas de ciertas plazas permanece **constante** a lo largo de toda la evolución de la red, sin importar qué secuencia de transiciones se dispare.
- Ejemplo típico: en una RdP con exclusión mutua (un recurso compartido con un lugar "libre" y un lugar "ocupado"), la suma de tokens entre ambos lugares es siempre constante (1 recurso, 1 token en total entre las dos plazas).

### Invariante de plaza
Un invariante de plaza es un conjunto de lugares (con pesos asociados) tal que la suma ponderada de sus marcas **nunca cambia** al dispararse ninguna transición de la red, sin importar cuántas veces se dispare.

### Componente repetitivo
Una secuencia de disparo es **repetitiva** si, a partir de un cierto marcado, existe una secuencia de transiciones cuyo disparo devuelve la red **exactamente al mismo marcado** del que partió (un "ciclo" en la evolución de la red).
- El conjunto de transiciones involucradas en esa secuencia repetitiva se llama **componente repetitivo**.

**Nota**: el desarrollo formal y riguroso de invariantes (mediante matrices de incidencia y ecuación fundamental / álgebra lineal) **no entra en el primer parcial**.

---

## <font color="#2DC26B">Problema de la Barbería (caso de aplicación)</font>
- Es un problema clásico modelado con RdP (por ejemplo con la herramienta PIPE), donde se combinan varios de los conceptos anteriores: clientes que llegan, sillas de espera limitadas (capacidad finita), barberos que atienden (recurso compartido / exclusión mutua), y posibilidad de deadlock si no está bien diseñado.
- Sirve como ejemplo integrador de: acotación (cantidad finita de sillas), exclusión mutua (barbero atendiendo a un solo cliente), vivacidad (que el sistema nunca se bloquee) y conflicto (varios clientes compitiendo por el mismo barbero).

### Ver también
- [[Redes de petri]]
- [[Concurrencia]]
