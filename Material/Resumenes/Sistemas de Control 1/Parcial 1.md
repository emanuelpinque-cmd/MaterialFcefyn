# Modelado matemático

**El analisis de sistemas invariables en el tiempo se basa en el estudio de su funcion de transferencia**

## Funcion de transferencia

**Se define como la transformada de laplace de la respuesta del impulso con todas las condiciones iniciales iguales a cero**

- Se extresa como una funcion de la variable compleja S

- Permite predecir la estabilidad la forma de la salida y tambien el valor final de dicha salid

### Componentes

- Las raices del polinomio denominador son llamados polos del sistema

- Las raices del polinomio numerador son llamados ceros del sistema

- El orden del sistema corresponde con el grado del denominador


### Forma en octave:

**Habitualmente la mejor manera de hallar una funcion de transferencia es**

1) Identificar las incógnitas del sistema (variables que no conocemos o variables auxiliares) 
- Ej. la corriente de un circuito, o si por ejemplo creamos una variable auxiliar por comodidad y legibilidad del circuito 
- Ej. el voltaje de un capacitor $\huge V_{c1} = \frac{1}{C} \frac{di}{dt}$

2) Identificar las variables conocidas es decir valores como resistencia masa coeficiente de rozamiento y la propia entrada del sistema

3) declarar la entrada y salida, la entrada es un valor conocido, mientras que la salida es un valor que no conocemos variable en el tiempo ejemplo posicion velocidad voltaje corriente etc

4) realizar el cociente, este paso es simple simplemente hacer la division Out/In

5) Verificicar el sistema, debe cumplirse que la funcion de transferencia no dependa de la entrada, ademas se puede hacer en lo posible verificaciones intuitivas.

##### Algunas intuiciones

- una de ellas en un circuito electrónico tratar a los capacitares como llaves abiertas inductores llaves cerradas convertir el circuito en un circuito puramente resistivo para ver si la respuesta es igual a la del estado final

- en sistemas físicos sucede de forma similar, por ejemplo un objeto que es aplicado una fuerza constante en presencia de una fuerza de rozamiento (proportional a la velocidad) siempre alcanzara un regimen de velocidad constante y su posición crecerá sin limite, también de otra forma 2 objetos que son unidos por un resorte en presencia de una fuerza constante estos alcanzaran una posición relativa constante entre ellos (piense en mover 2 objetos unidos por un resorte con una fuerza constante, en un tiempo infinito estos objetos se estabilizaran en una distancia relativa entre ellos constante)

- también puede imaginarse un análogo a un circuito RLC serie con un capacitor si considera un objeto con masa (analogo a la inductancia) atado a un resorte(analogo al capacitor) en una superficie o techo inamovible, también esta presente el rozamiento del aire (analogo a una resistencia) ahora vamos a aplicarle a ese objeto una fuerza constante (analogo a la corriente continua) y vemos que pasa en el infinito, intuitivamente usted puede concluir en una situacion asi que llega un momento al estirar el objeto la fuerza del resorte supera la fuerza constante de su brazo, en ese momento el sistema se equilibra, pero puede ver que la posicion del objeto cambio con respecto a su posicion original, esto es exactamente igual con el estado estable de un RLC serie la carga queda constante (la posicion del objeto queda constante en un valor distinto de 0 el reposo) ademas la corriente no fluye es decir la velocidad es 0 como en su sistema de modo que esa posicion en su sistema depende unicamente de su fuerza y que tan "fuerte" sea el resorte es decir $x = \frac{F}{k}$ exactamente lo mismo que $Q = CV$ la analogia en el estado final es identica

- como puede observar la resistencia/rozamiento y inductancia/masa no influiyen en el estado final en ambos sistemas masa resorte y RLC serie aunque si influyen en el transitorio




### Diagramas en bloques