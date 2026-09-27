
**Vamos a definir la potencia de una señal como $x^2(t)$ es decir el cuadrado de la misma señal, suponemos que $x^2(t)$ es un proceso WSS con un poder esperado finito esto es**

$$E[x^2(t)]=R_{xx}(0)=\frac{1}{2\pi}\int_{-\infty}^{\infty} S_{xx}(j \omega) d\omega$$
**donde  $S_{xx}(j \omega)$ es la tranformada de fourier de la funcion de autocorrelacion $R_{xx}(\tau)$**


## Densidad Espectral de poder

**Ahora nuestro objetivo sera hallar el valor de potencia en una frecuencia particular para esto vamos a hacer pasqar la señal $S_{xx}(j\omega)$  atravez de un filtro pasabanda ideal $H(j\omega)$**

![[Pasted image 20260910005514.png]]


**De este modo como y esta relacionado con X se obtine**

**TODO demostrar que es siempre positiva**

## Denisdad espectral de fluctuacion

**En el anterior caso usabamos la correlacion sin utilizar la media recordemos ahora que la funcion de autocovarianza $C_{xx}(\tau)$ de un proceso WSS $x(t)$ es es funcion de el proceso WSS $x(t) - \mu_x$ el cual representa las desviaciones o fluctuacion del proceso sobre su media $\mu x$  **

**Como en la seccion anterior denotamos la transforamada de fourier $C_{xx}(\tau)$ denotada como $D_{xx}(j \omega)$ como la densidad espectral de fluctuacion FSD del procesos $x(t)$ **

Tambien se puede demostrar de que $$D_{xx}(j\omega) \geq 0$$
