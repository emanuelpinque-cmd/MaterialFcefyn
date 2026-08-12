# Algoritmo de mason

Nos sirve para hallar funciones de transferencia de forma deterministica en un sistema en bloques o de nodos.



### Formula:

$\huge \frac{C(s)}{R(s)} =\sum_{i=1}^{N} \frac{P_i\Delta_i}{\Delta}$



donde:

$N$:numero de trayectorias directas del nodo de entra a nodo de salida

$P_i$: ganancia de la i - esima trayectoria directa

$\Delta_i$:i-esimo determinante de trayectoria directa (Es decir $1-\sum l_i$ sumatoria de los lazos que no contienen nodos en comun con la trayectoria directa)

$\Delta$ : Discriminante de la funcion, es decir $1-\sum l_{m1} + \sum l_{m2} -...$ 

donde:

-  $l_{m1}$:sumatoria de las ganancias de los lazos individuales 

- $l_{m2}$: la sumatoria de las ganancias de lazos tomados de a 2 que no se toquen

- $l_{mn}$:la sumatoria de las ganancias de los lazos tomados en un grupo n que no se toquen en ese grupo
























