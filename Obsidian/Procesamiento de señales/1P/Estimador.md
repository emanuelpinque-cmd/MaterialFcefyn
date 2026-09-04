### A diferencia de la [[Estimacion]] de Y esta basado en conocer un numero especifico x que una variable aleatoria X toma, Si bien X es una variable aleatoria el valor especifico x no los es lo que implica que tampoco $y(x)$ es una variable aleatoria.


## TODO


#### La notacion $\hat{y}(x)$ fue intruducida en la [[Estimacion]] para estimar Y dado $X = x$, la funcion $\hat{y}(.)$ determina el correpondiente estimador el cual es denota como  $\hat{y}(X)$ o de forma mas simple $\hat{Y}$

#### Ahora si $\hat{Y}=\hat{y} (X)$ es una variable aleatoria otra forma natural de verlo es con la media condicional es decir:

$$\Huge \hat{Y} = \hat{y}(X)= E[Y|X]$$


## Notese que E[Y|X] denota una variable aleatoria, no un numero particular

---
### Se aplica la misma logica con un vector en el caso que multiples variables fueron observadas, ordenadas en un vector 
$$\Huge \hat{Y} = \hat{y}(\textbf{X})= E[Y|\textbf{X}]$$

___

### No es de sorpresa que el estimador MMSE minimice el error cuadratico medio promedio sobre todos lo valores de X y Y Esto se debe que el estimador <font color="#ff0000">MMSE minimiza el error cuadratico medio para cada valor particular de x de X</font>


$$\Huge E_{Y,\textbf{X}}([Y-\hat{y}\textbf(X)]^2 = E(E_{Y|\textbf{X}}([Y-\hat{y}(\textbf{X})]^2|\textbf{X}))$$
$$\int_{-\infty}^{\infty} (E_{Y|X}())$$