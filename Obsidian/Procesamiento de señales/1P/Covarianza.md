#### El problema que existe con la [[Varianza]] es que solo nos dan una vision parcial en sus respectivas variables, ahora quisieramos determinal cual es la dispercion en cualquier direccion atravez de los ejes de coordenadas

###### Tomemos una variable Z definida como

$$\Huge Z=\alpha X + \beta Y$$
donde $\alpha$ y $\beta$ son constantes arbitrarias, otra cosa que podemos notar que elijiendo $\alpha$ y $\beta$  de forma apropiada se reduce a $Z=X$
o $Z=Y$ 

#### Antes de realizar los demas calculos vamos a calcular el valor de medio de Z

$$\Huge E[Z] = \alpha E[X]+\beta E[y]$$
#### Ahora recordemos la definicion de varianza

$$\Huge \sigma_z² = E[(Z-E[Z])²] = E[(\alpha X+\beta Y -E[\alpha X+\beta Y ])^2]$$


$$\Huge \sigma_z² = E[(\alpha X+\beta Y -\alpha E[X]+\beta  E[Y])^2]$$

### Agrupando terminos

$$\Huge \sigma_z² =E[(\alpha(X-E[X])+\beta(Y-E[Y]))^2]$$
### Resolvemos el cuadrado

$$\Huge \sigma_z² =E[\alpha^2(X-E[X])^2+\beta^2 (Y-E[Y])^2 + 2\alpha \beta(X-E[X])(Y-E[Y])]$$

### Linealidad de esperanza

$$\Huge \sigma_z² =\alpha^2E[(X-E[X])^2]+\beta^2 E[(Y-E[Y])^2] + 2\alpha \beta E[(X-E[X])(Y-E[Y])]$$

### Reemplazando por la varianza

$$\Huge \sigma_z² =\alpha^2 \sigma_x²+\beta^2 \sigma_y² + 2\alpha \beta E[(X-E[X])(Y-E[Y])]$$

## A este termino que queda lo llamamos Covarianza

#### Es definido como

$$\Huge \boxed{\sigma_{XY}=E[(X-E[X])(Y-E[Y])]}$$
#### O tambien
$$\Huge \boxed{\sigma_{XY}=E[XY]-E[X]E[Y]}$$



