**En la sección anterior definimos [[Variable Aleatoria]] a una función que a cada resultado de un experimento probabilistico le asigna un numero real**

**De manera similar un procesos aleatorio de valor real de tiempo continuo CT o de tiempo discreto DT es decir X(t) o X[n] respectivamente **

**Es una función que mapea cada resultado de un experimento probabilistico a una señal CT O DT,  denominada realización del proceso aleatorio en ese experimento**

**Para cualquier instante de tiempo $t=t_0$ o $n=n_o$ las cantidades $X(t_0)$ y $X_[n_0]$ son simplemente variables aleatorias**

**Es decir que para cada instante la funcion puede llegar a tomar varios valores (que al momento de la realización sera uno solo) eso es exactamente la definición de función de probabilidad**

---
**La colección de señales que puede producir el proceso aleatorio se denomina ensamble de señales del proceso aleatorio.**

---
## Funciones de densidad de Procesos Aleatorios

**Sabemos que para cada instante de tiempo $t_0$ se le corresponde una funcion Aleatoria $X(t_1)$  

**Ahora vamos a ver que sucede cuando tomamos una coleccion arbitraria de $l$ instantes de tiempo fijos, es decir $t_1 \le t_2 \le .. \le t_l$  conseguimos $l$ funciones aleatorias conjuntamente distribuidas $X(t_1),X(t_2),...X(t_l)$ 

**Desde este punto de vista, un proceso aleatorio puede considerarse una familia de variables aleatorias conjuntamente distribuidas ==indexadas por t== 
![[Pasted image 20260904002128.png]]

**Es decir tomamos la variable aleatoria  $X(t_0)$ esta posee una funcion de densidad $f_{X(t_1)}(x_1)$**
La pdf seria:

$$\Huge f_{X(t_1),X(t_2),...X(t_l)}(x_1,x_2,...,x_l)$$

![[Pasted image 20260904003159.png|327]]
---
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

## Estacionariedad

### Sentido estricto

se esperaria que las pdfs conjuntas asociadas con las variables aleatorias obtenidas muetreando un proceso aleatorio en un numero arbitrrio $l$ de tiempo arbitrario ==dependean del tiempo== es decir:

$$\huge f_{X(t_1),...,X(t_l)}(x_1,...x_l)$$

dependerà de los valores especificos de $t_1,...,t_l$ .Si todas las PDFs conjuntas permanecen iguales bajo desplazamientos de tiempo (Puesto que $x_1 =x(t_1)$)

**Si sucede que:**

$$\huge f_{X(t_1),...,X(t_l)}(x_1,...x_l)=\huge f_{X(t_1+\alpha),...,X(t_l+\alpha)}(x_1,...x_l)$$

**Para un $\alpha$ arbitrario se dice que el proceso aleatorio es estacionario en sentido estricto (SSS)**

## Estacionariedad en sentido amplio


**De particular utilidad es un tipo menos restringido de estacionariedad, Especificamente si el valor $\mu_x(t)$ es invariable con el tiempo y la autocorrelacion $R_{XX}(t_1,t_2)$ **

**De forma equivalente la covarianza $C_{XX}(t_1,t_2)$ ==es una funcion solo de la diferencia de tiempo== $t_1 - t_2$ 

**Si todo esto sucede entonces el proceso se denomina estacionario en sentido amplio WSS**

Tambien sabemos que si un procesos es SSS entonces necesariamente sera WSS

el reciproco no es cierto

$$\Huge \mu_x(t) = \mu_X$$
$$\Huge R_{XX}(t_1,t_2) = R_{XX}(t_1+\alpha,t_2+\alpha)$$
para todo $\alpha$

Despejando llegamos a que 

$$\Huge R_{XX}(t_1-t_2,0)$$

$$\Huge R_{XX}(t_1-t_2)$$
**Esto es de suma importancia ya que la correlacion unicamente depende de la diferencia de tiempo, de manera similar tambien $\Huge C_{XX}(t_1,t_2)$ se escribe como *$\Huge C_{XX}(t_1-t_2)$*


