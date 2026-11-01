Esta modulacion es utilizada para transmitir datos a distancias lejanas usando poca energia pero con poco ancho de banda

### Primera formula

La primera formula que utilizaremos es un decodificador de binario a decimal, esta parte es importante para asignarle la frecuencia inicial a la chirp la cual codifica la informacion del simbolo en esta frecuencia inicial

$$\Huge s[nT_s]= \sum_{h=0}^{SF-1}w[nT_s]_h2^h$$
donde:
- $SF$ spreading factor el largo de la palabra
- $w[nT]$ es el vector de digitos de binario de largo SF
- $T_s$ perido de muetreo de cada simbolo


```python
def sum(v):
    x = 0
    indx = 0
    for e in reversed(v):
        x += e*(2**indx)
        indx +=1
    return x
```

donde v
```python
v = [1,0,1,0,0,0]

```
### Formula de señal exponencial compleja

Apartir del símbolo (que es un numero real) podemos hallar su función que es una exponencial compleja




código en python tiempo

```python
import numpy as np
import matplotlib.pyplot as plt

def c(s,sf):
    k = np.linspace(0,2**sf,1000)
    A = 1/np.sqrt(2**sf)
    theta = 2*np.pi*(s+k)*k/2**sf
    f = A*np.exp(1j*theta)
    return k,f
for i in range(4):
    result = c(2*i,4)
    plt.plot(result[0],result[1].real)

plt.show()

```


![[Pasted image 20261023155306.png]]




Para verlo en frecuencia podemos hallar esta misma sabiendo que la frecuencia es la derivada de la fase
```python
import numpy as np
import matplotlib.pyplot as plt

def c(s,sf):
    k = np.linspace(0,2**sf,1000)
    A = 1/np.sqrt(2**sf)
    theta = 2*np.pi*(s+k)*k/2**sf
    return k,theta

for i in range(4):
    result = c(2*i,4)
    omega = np.gradient(result[1])
    plt.plot(result[0],omega)

plt.show()

```

![[Pasted image 20261023161153.png]]

Como se puede apreciar el símbolo depende de la frecuencia inicial

### Ortogonalidad de 2 señales

Queremos hallar una forma de dadas 2 señales ver cual símbolo de ellas se trasmitió, como el único parámetro que cambia el p lo que podemos hacer es comparar con los distintos valores del mismo para diferenciar una señal de otra.

Esto se logra con un criterio de ortogonalidad, formamos una base ortogonal dependiente del simbolo de tal modo que para cada simbolo distinto el producto interior dara 0 para el mismo dara un numero distinto de 0 (definicion de producto interior)

formalmente definimos el producto interior

$$ \huge \left\langle r(nT_s + kT), c(nT_s + kT) \Big\vert{}_{s(nT_s)=p} \right\rangle$$

Separando esta ecuacion

$\Huge \sum_{k=0}^{2^{SF}-1} e^{-j2\pi \frac{k^2}{2^{SF}}}\frac{1}{\sqrt{2^{SF}}}e^{-j2\pi p k \frac{1}{2^{SF}}}$

De aqui podemos halla una transformada de fourier con respecto al simbolo p y el tiempo discreto k

recordemos la DFT 

$\Huge X_k = \sum_{n=0}^{N-1}x_n e^{-j2\pi n \frac{k}{N}}$
- donde N es es periodo de la señal

básicamente tenemos la misma ecuación lo uni-co que cambia es que N= 2^SF el periodo de la señal ademas de que el en este caso el indice de frecuencia es p en vez de n en esta notación