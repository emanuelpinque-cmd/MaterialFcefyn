### Tambien es comun trabajar con una forma normalizada de la [[Covarianza]] llamada coeficiente de correlacion $\huge \rho_{X,Y}$:

$$\Huge \rho_{X,Y} = \frac{\sigma_{X,Y}}{\sigma_X \sigma_Y}$$
#### Esta normalizacion se asegura que el coeficiente de correlacion no cambie si X o Y son multiplicadas por una constante distinta de 0 o si fue añadida una constante, Por ejemplo el valor centrado y normalizado de las variables aleatorias:

#### Para demostrar esta propiedad normalizamos las variables con una transformacion

$$\Huge V= \frac{X-\mu_x}{\sigma_x},W= \frac{Y-\mu_y}{\sigma_y},$$

## Calculamos la correlacion $\huge E[VW]$

$$\Huge E[VW]=E[(\frac{X-\mu_X}{\sigma_X})(\frac{Y-\mu_Y}{ \sigma_Y})]$$

### Por linealidad



$$\Huge E[VW]=\frac{E[(X-\mu_x)(Y-\mu_y)]}{\sigma_x \sigma_y}$$


$$\huge\rho_{X,Y}=\frac{\sigma_{X,Y}}{\sigma_X \sigma_X}$$


---
## Se puede probar que:

$$\boxed{\Huge|\rho_{X,Y}| \leq 1}$$
### Debido a las definicion previas, una correlacion positiva es decir $r_{X,Y} > 0$ indica que tanto X e Y tienden a tener <font color="#ff0000">el mismo signo.</font> en promedio

### De forma opuesta una correlacion negativa indica que tanto X e Y tienen <font color="#ff0000">distintos signos</font> en promedio

### Mientras que una [[Covarianza]] o Coeficiete de correlacion negativo indica que las desviaciones de X e Y de sus respectivos promedios tiende a tener signos opuestos en promedio

---

