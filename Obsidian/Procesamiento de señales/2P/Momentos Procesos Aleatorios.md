## Caracterizacion de los momentos de primer y segundo orden de los procesos aleatorios


Un proceso aleatorio puede considerarse como una familia de variables aleatorias conjuntamente distribuidas indexadas por t o n.

Seria extremadamente dificil o imposible representar analiticamente un proceso aleatorio de este manera

Afortunadamente, los modelos de procesos aleaotrios mas ampliamente usados tienen una estructura especial que permite el calculo de tal espefificacion estadistica


### Primer momento

El promero momento o funcion de media de un proceso aleatorio CT $X(t)$, que se denota tambien como $\mu_x$ , es el valor esperado de la variable aleatoria $X(t)$ en cada tiempo t, es decir:

$$\mu_x(t) = E[X(t)]$$
## Funcion de autocorrelacion

$$R_{XX}(t_1,t_2)=E[X(t_1)X(t_2)]$$

**Tambien se puede calcular como**
$$\huge E[X_1X_2]=\sum\sum x_1x_2f(x_1,x_2)$$
## Funcion de covarianza

De forma analoga a capitulos anteriores

$$C_{XX}(t_1,t_2)=E[(X(t_1)-\mu_x(t_1))(X(t_2)-\mu_x(t_2))]$$
$t_1$ y $t_2$ son instantes de tiempo arbitrarios, esto es de suma importancia por que nos dice como se relaciona ambas funciones aleatorias (Producida por el mismo proceso aleatorio $X(t)$ en 2 instantes de tiempos arbitrarios $t_1$ y $t_2$ 


### Multiples procesos aleatorios

Consideremos los procesos $X(.)$ y $Y(.)$ , Una caracterizacion estocastica completa de esto requiere las PDFs ed todas las combinaciones posbles de nuestras de  $X(.)$ y $Y(.)$, para ello vamos a decir que $X(.)$ y  $Y(.)$ son independientes entre si, lo que se reduce su PDF a:

$$f_X(t_1),...X(t_k),Y(t'_1),...Y(t'_l)(x_1,...x_k,y_1,...,y_l) =f_{X(t_1),...X(t_k)}(x_1,...x_k) *f_{Y(t'_1),...Y(t'_k)
}(y_1,...y_l)   $$
para todo k, l y todas las elecciones de tiempos de muestreo

**En este caso tambien debemos considerar las funciones de momento curzado**

## Correlacion cruzada

$$R_{XY}(t_1,t_2) = E[X(t_1)Y(t_2)]$$
y
$$C_{XY}(t_1,t_2) = )=E[(X(t_1)-\mu_x(t_1))(Y(t_2)-\mu_y(t_2))]$$
**Para tiempos arbitrarios $t_1,t_2$ Si  $C_{XY}(t_1,t_2)=0$ para todos los $t_1$ y $t_2$  decimos que los procesos $X(.)$ y $Y(.)$ son incorrelacionados.**

**Se aplica la misma logica para procesos aleatorios de tiempo discreto con la excepcion de que ahora el tiempo de muestreo esta restringido**
