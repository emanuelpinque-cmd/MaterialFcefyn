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


## Ergodicidad
