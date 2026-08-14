
### Una imagen de vectores es aveces muy util para recordar las relaciones entre los momentos de primer y segundo orden entre 2 variables aleatorias X e Y

###### Esta imagen no es una nmotecnia, tiene un sentido preciso en cual de las variables aleatorias puede pensarse (o ser) vectores en el espacio vectorial(o en infinitas dimensiones)

![[Pasted image 20260813140432.png]]


#### Unas consideraciones a continuacion para desarroyar esta imagen, vamos a definir el cuadrado de las longitudes de estos vectores como $E[X]\space y \space E[Y]$.

###### Recuerde que la longitud de un vector al cuadrado es el producto punto del vector consigo mismo.

### Ahora vamos a definir el producto punto entre 2 vectores X e Y como su correlacion es decir.

$$\Huge X \cdot Y = E[XY] = r_{X,Y}$$
###### Se conserva la definicion de ortogonalidad 


$$\huge X \cdot Y=E[XY]=0 \iff X \perp Y$$

#### Con esto podemos definir unos nuevos vectores $\widetilde{X}$ y $\widetilde{Y}$ que serian las variables aleatorias restadas sus respectivas medias es decir $X-\mu_{x}$ y $Y-\mu_{y}$ ahora podemos representar los siguente:


$$\Huge ||\widetilde{X} ||^2 = \widetilde{X} \cdot \widetilde{X} = \sigma_{X}^2$$
$$\Huge||\widetilde{Y} ||^2  =\widetilde{Y} \cdot \widetilde{Y} = \sigma_{Y}^2$$
$$\Huge \widetilde{X} \cdot \widetilde{Y} = \sigma_{X,Y}$$

#### Ahora recordemos la defincion de producto punto

$$\Huge \overrightarrow{A} \cdot \overrightarrow{B} = ||A||||B||cos(\theta) $$
#### Reemplazando

$$\Huge \sigma_{X,Y} =  \sigma_{X}\sigma_{Y} cos(\theta)$$
$$\Huge \frac{\sigma_{X,Y}}{\sigma_{X}\sigma_{Y}} =\rho =   cos(\theta)$$

 #### No es de sorprender que por eso el valor de $\rho$ este entre $-1 \leq \rho \leq 1$ cuandp $\rho$ esta cerca de -1 estan alineados de forma opesta lo que un incremento en una variable causa la disminucion en otra de forma equivalente cuando $\rho$ es 0 es decir que su variacion no afecta a la otra variable por eso se dice que las desviaciones de estos vectores $\widetilde{X}$ y $\widetilde{Y}$ son ortogonales lo que implica cero covarianza.
 