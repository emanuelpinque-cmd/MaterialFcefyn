## Control de temperatura lazo cerrado

## Introducción

El control de temperatura es una de las aplicaciones más comunes de la ingeniería de control: hornos, incubadoras, impresoras 3D, procesos químicos y equipos electrónicos necesitan mantener una temperatura estable, aun cuando cambian las condiciones del entorno.

En este trabajo se estudia un sistema simple pero representativo. Una **fuente de calor** de potencia $Q$ entrega energía a un medio sólido, y un **sensor de temperatura** $T$, ubicado a una distancia $x$ de la fuente, mide cómo llega ese calor. El calor se propaga por conducción a lo largo del medio, en una sola dirección, como en una barra.

El **objetivo** es lograr que la temperatura medida por el sensor se mantenga constante en un valor deseado (la referencia), de forma estable y sin depender de ajustes manuales.

### Por qué un lazo cerrado

Si se aplicara una potencia fija a la fuente (lazo abierto), la temperatura final dependería de condiciones que no controlamos, como la temperatura ambiente o las pérdidas de calor, y no habría forma de corregir el error. En un **lazo cerrado**, en cambio, la temperatura medida se compara con la referencia, y la diferencia (el error) decide cuánta potencia entregar a la fuente. Esta realimentación permite corregir las desviaciones de manera automática.

### Lo que hace difícil el problema

El calor no llega al sensor de inmediato: se propaga con retardo, y ese retardo y la atenuación aumentan con la distancia $x$. Además, el sistema no se describe con una ecuación diferencial ordinaria sencilla, sino con la **ecuación de calor de Fourier**, una ecuación en derivadas parciales. Esto condiciona el modelado y el diseño del controlador.

### Etapas del trabajo

1. **Modelo matemático:** se plantea la ecuación de calor y se la reduce a una ecuación diferencial ordinaria, considerando una fuente puntual y un sensor puntual, para obtener la función de transferencia de la planta $G(s)$.
2. **Lazo cerrado sin compensador:** se arma el diagrama en bloques con realimentación unitaria y se analiza la respuesta del sistema tal como está.
3. **Diseño del compensador:** se diseña un compensador $C(s)$ (PID o de adelanto-atraso de fase, a definir) para mejorar la respuesta y cumplir las especificaciones.
4. **Resultados y conclusiones:** se comparan las respuestas con y sin compensador.

![[Pasted image 20261031152533.png]]

## Modelo matemático

Para este planteo se investigó cuál es el modelo más utilizado para describir cómo se propaga el calor, y se llegó a la conclusión de que es la **ecuación de calor de Fourier** (fuente: [Wikipedia, Ecuación del calor](https://es.wikipedia.org/wiki/Ecuaci%C3%B3n_del_calor)):

$$\frac{\partial\theta}{\partial t}=\alpha\,\frac{\partial^2\theta}{\partial x^2}$$

Esta ecuación es una EDP (ecuación en derivadas parciales), tema que no entra en la materia. Por eso se la lleva a una **EDO** aplicando la transformada de Laplace solo respecto al tiempo, considerando una fuente puntual de calor y un sensor puntual. El desarrollo completo está en el **Anexo (opcional)** al final.

### Hipótesis simplificatorias

- El calor se propaga en una sola dimensión, a lo largo de una barra de sección $A$.
- Las propiedades del material ($k$, $\alpha$) son constantes y no hay pérdidas laterales.
- La barra es larga, de modo que el calor nunca llega al otro extremo.
- La fuente es **puntual**, está en $x=0$ y reparte su potencia $Q$ en partes iguales hacia ambos lados.
- El sensor es **puntual**, está en $x=x_s$ y mide $\theta(x_s,t)$ sin dinámica propia.
- La barra parte a temperatura ambiente $T_0$.

### Variables

|Símbolo|Significado|Unidad|
|---|---|---|
|$\theta(x,t)=T(x,t)-T_0$|temperatura respecto de la ambiente|K|
|$\Theta(x,s)$|transformada de Laplace de $\theta$ respecto de $t$|K·s|
|$Q$|potencia de la fuente (entrada)|W|
|$x_s$|distancia entre la fuente y el sensor|m|
|$k$|conductividad térmica|W/(m·K)|
|$\alpha$|difusividad térmica|m²/s|
|$A$|sección de la barra|m²|

### EDO resultante

Para $x>0$ se obtiene la siguiente EDO, donde $s$ actúa como una constante:

$$\frac{d^2\Theta}{dx^2}=\frac{s}{\alpha}\,\Theta$$

El flujo de calor que entra por $x=0$ hacia cada lado es la mitad de la potencia de la fuente (ley de Fourier):

$$-kA\,\frac{d\Theta}{dx}(0)=\frac{Q(s)}{2}$$

### Solución y función de transferencia de la planta

$$\Theta(x,s)=\frac{Q(s)}{2kA\sqrt{s/\alpha}}\;e^{-x\sqrt{s/\alpha}}$$

Tomando como entrada la potencia $Q(s)$ y como salida la temperatura en el sensor $\Theta(x_s,s)$:

$$\boxed{G(s)=\frac{\Theta(x_s,s)}{Q(s)}=\frac{e^{-x_s\sqrt{s/\alpha}}}{2kA\sqrt{s/\alpha}}}$$

Para una potencia constante $Q$ aplicada en $t=0$ (escalón), la temperatura en el sensor en el tiempo es:

$$\theta(x_s,t)=\frac{Q}{2kA}\left[2\sqrt{\frac{\alpha t}{\pi}}\;e^{-x_s^2/4\alpha t}-x_s\,\operatorname{erfc}\!\left(\frac{x_s}{2\sqrt{\alpha t}}\right)\right]$$

### Observaciones

- $G(s)$ **no es una función racional** (contiene $\sqrt{s}$), por lo que no tiene un número finito de polos y ceros. Para diseñar el controlador se la analiza con su respuesta en frecuencia o se la aproxima por un modelo más simple, como un sistema de primer orden con retardo.
- Cuanto mayor es la distancia $x_s$, menor es la ganancia y mayor es el atraso con el que el sensor percibe el calor.

---

## Anexo (opcional): desarrollo de la EDP a la EDO

**Paso 0: planteo.** Para $x>0$ no hay fuentes dentro de la barra, solo difusión, y la temperatura inicial es la ambiente, es decir $\theta(x,0)=0$.

**Paso 1: herramienta.** La transformada de Laplace respecto del tiempo,

$$\Theta(x,s)=\int_0^\infty \theta(x,t)\,e^{-st}\,dt,$$

cumple $\mathcal{L}\{f'(t)\}=sF(s)-f(0)$. Derivar en el tiempo pasa a ser multiplicar por $s$. La posición $x$ no se transforma.

**Paso 2: aplicar a la ecuación.**

- Lado izquierdo: $\dfrac{\partial\theta}{\partial t}\;\to\;s\,\Theta-\theta(x,0)=s\,\Theta$.
- Lado derecho: la derivada en $x$ no depende del tiempo, así que queda $\alpha\,\dfrac{d^2\Theta}{dx^2}$.

$$s\,\Theta=\alpha\,\frac{d^2\Theta}{dx^2}\quad\Longrightarrow\quad\frac{d^2\Theta}{dx^2}=\frac{s}{\alpha}\,\Theta$$

Ya es una EDO común: solo aparece $x$, y $s$ se comporta como un número.

**Paso 3: resolver.** Se prueba $\Theta=e^{rx}$. Al reemplazar queda $r^2=s/\alpha$, es decir $r=\pm\lambda$ con $\lambda=\sqrt{s/\alpha}$:

$$\Theta(x,s)=C\,e^{-\lambda x}+D\,e^{+\lambda x}$$

**Paso 4: descartar una constante.** Lejos de la fuente la barra sigue fría, por lo que $\Theta$ no puede crecer sin límite. Como $e^{+\lambda x}$ crece, $D=0$:

$$\Theta(x,s)=C\,e^{-\lambda x}$$

**Paso 5: calcular $C$ con la fuente.** El flujo de calor en $x=0$ es la mitad de la potencia. Como $\dfrac{d\Theta}{dx}(0)=-\lambda C$:

$$kA\,\lambda\,C=\frac{Q(s)}{2}\quad\Rightarrow\quad C=\frac{Q(s)}{2kA\lambda}$$

Reemplazando $C$ y evaluando en $x=x_s$ se obtiene el $G(s)$ del modelo.






## Graficos

Diagrama de bloques

![[Pasted image 20261031154456.png]]

Grafico de numpy

![[Pasted image 20261031154546.png]]

Script de octave 
(no hay inversa de laplace con funciones no racionales hay que usar metodos numericos)
```
% lazo cerrado sin compensador, barra de aluminio
pkg load symbolic
1;

% inversa de laplace numerica (metodo de talbot)
function f = ilt(F, t)
  N = 32;
  th = -pi + ((0:N-1)+0.5)*2*pi/N;
  z  = N/t*(0.5017*th./tan(0.6407*th) - 0.6122 + 0.2645i*th);
  dz = N/t*(0.5017./tan(0.6407*th) - 0.5017*0.6407*th./sin(0.6407*th).^2 + 0.2645i);
  f  = real(sum(exp(z*t).*F(z).*dz)/(1i*N));
end

k = 237; alpha = 9.7e-5; A = 1e-4;   % aluminio, 1 cm^2
R0 = 10;                             % escalon de referencia [K]
xs_v = [0.02 0.04 0.06];             % distancia fuente-sensor [m]
t  = linspace(0.5, 1000, 400);
tl = logspace(-1, 6, 1500);

syms s
figure; hold on; grid on
for i = 1:3
  xs = xs_v(i);

  % planta y lazo cerrado en forma simbolica
  G = exp(-xs*sqrt(s/alpha)) / (2*k*A*sqrt(s/alpha));
  T = G/(1+G);

  % error en estado estable (limite simbolico)
  ess = double(R0*(1 - limit(T, s, 0, 'right')));

  % para el tiempo uso la misma T pero numerica
  Tn = @(s) exp(-xs*sqrt(s/alpha))./(2*k*A*sqrt(s/alpha)) ./ ...
            (1 + exp(-xs*sqrt(s/alpha))./(2*k*A*sqrt(s/alpha)));
  Y  = @(s) R0./s .* Tn(s);
  y  = arrayfun(@(ti) ilt(Y,ti), t);
  yl = arrayfun(@(ti) ilt(Y,ti), tl);
  plot(t, y, 'linewidth', 2)

  ess_t = R0 - y(end);                  % error a los 1000 s
  Mp = max(0, (max(yl)-R0)/R0*100);     % sobrepasamiento
  tr = tl(find(yl >= 0.9*R0, 1)) - tl(find(yl >= 0.1*R0, 1));   % subida 10-90%
  ts = tl(find(yl >= 0.98*R0, 1));      % establecimiento 2%

  printf('xs = %g cm\n', xs*100)
  printf('  ess = %.4f K (a los 1000 s: %.2f K)\n', ess, ess_t)
  printf('  Mp = %.2f %%\n', Mp)
  printf('  tr = %.0f s\n', tr)
  printf('  ts = %.0f s\n', ts)
end

plot([0 1000], [R0 R0], 'k--')
xlabel('t [s]'), ylabel('temperatura en el sensor [K]')
title('Lazo cerrado sin compensador')
legend('xs = 2 cm', 'xs = 4 cm', 'xs = 6 cm', 'referencia', 'location', 'southeast')
axis([0 1000 0 11])

```