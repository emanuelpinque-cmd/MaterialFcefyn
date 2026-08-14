

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
$$min E[(Y- \hat{y})^2] = E[(Y-E[Y])^2] = \sigma_y^2$$
