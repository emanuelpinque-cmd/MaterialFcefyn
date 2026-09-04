

## Nuestro objetivo sera hallar un estimador denotado $\hat{y}$ el cual queremos que estime lo mejor posible la variable $Y$ para ello queremos minimizar el error cuadrado entre Y e $\hat{y}$ es decir:

$$\Huge E[(Y-\hat{y})^2]=\int_{- \infty}^{\infty}(y-\hat{y})^2f_Y(y)dy $$

### Como queremos hallar su minimo aplicamos la regla de igualar su derivada a 0 derivar nuevamente y si es positivo significa un minimo local minimizamos su error

$$\Huge \frac{d}{d \hat{y}}E[(Y-\hat{y})^2]=-2\int_{- \infty}^{\infty}(y-\hat{y})f_Y(y)dy = 0$$
$$\Huge -2\int_{- \infty}^{\infty}(yf_Y(y)-\hat{y}f_Y(y))dy = 0$$

$$\Huge \int_{- \infty}^{\infty}yf_Y(y)dy-\hat{y}\int_{-\infty}^{\infty}1*f_Y(y)dy = 0$$$$\Huge E[y]-\hat{y} = 0$$
$$\Huge \boxed{E[y]=\hat{y}}$$

##### Se puede verificar que es un minimo al derivar por segunda vez
$$\huge \frac{d^2}{d \hat{y^2}}E[(Y-\hat{y})^2]=2\int_{- \infty}^{\infty}f_Y(y)dy =2$$

##### Como es un valor positivo concluimos que es un minimo

---

Por eso el MMSE estimado de Y es en este caso simplemente su valor medio
El error asociado el el mismo MMSE que se obtiene si reemplazamos $\hat{y}=E[y]$
que es simplemente la varianza de Y:
$$\huge min( E[(Y- \hat{y})^2] ) = E[(Y-E[Y])^2] = \sigma_y^2$$
---
#### Ahora tenemos un nuevo caso en el cual <font color="#ff0000">Informacion adicional esta disponible</font> en forma de mediciones u observaciones de un valor x de una variable aleatoria X que esta relacionada de alguna manera con Y.

##### El unico cambio al problema previo es la nueva informacion adicional, debemos distiguir entre 2 tipos de funciones de probablidad: la funcion de denisdad condicional $f_{Y|X}(y|x)$ y la funcion de densidad incondicional $f_{Y}(y)$ queremos ahora minimizarla

$$\Huge E[ \{Y-\hat{y}(x) \}^2 |X=x ]=\int_{-\infty}^{\infty}\{y-\hat{y}(x) \}^2 f_{Y|X}(y|x)dy$$
#### Notemos que ahora escribimos $\hat{y}(x)$ para mostrar que el <font color="#ff0000">estimador depende del valor especifico x</font> 
##### llegamos a los mismos calculos que el problema anterior asi que podemos saltarlos quedando
$$\Huge \hat{y}=E[Y|X=x]$$
### Es decir la esperanza condicional de Y dado que X=x, El error asociado MMSE es la varianza $\sigma_{Y|x}^2$ de la funcion de densidad condicional  $f_{Y|Y}(y|x)$ es decir la varianza condicional.

---
#### yendo un paso mas adelante, si tenemos multiples mediciones es decir $X_1 = x_1,X_2 = x_2,...X_L=x_l$  , para ello se usa la funcion de distribucion de probabilidad $\huge f_{Y|X_1 , X_2 ... , X_l}(y|x_1,x_2,...,x_L)$ es decir la probablidad de Y dado que ocurrieron $X_1 , X_2 ... , X_l$ 

##### Para una notacion mas conveniente, la medicion de las variables aleatorias pueden ser colocadas en un vector columna $\textbf{X}$ y sus correspondientes medidiones en otro vector columna $\textbf{x}$

#### La dependencia de la estimacion MMSE en la mediciones puede inficarse con la notacion $\hat{y}(x)$

$$\Huge \hat{y}(x) = \int_{-\infty}^{\infty} yf_{Y|\textbf{X}}(y|\textbf{x})dy = E[Y|\textbf{X=x}]$$

#### El minimo error medio cuadritico para el valor de $\textbf{X}$ es de nuevo la varianza esto es $\sigma_{Y|\textbf{x}}^2$ de la funcion de densidad condicional $f_{Y|\textbf{X}}(y|\textbf{x})$