---
tags: [cap11, PSD, espectro, periodograma, modelado, blanqueo]
cap: 11
---
# 02 · Densidad Espectral de Potencia
← [[01 Procesos Aleatorios]] · [[00 Índice]] · Siguiente: [[03 Estimación de Señales]]

## Por qué hace falta
Las realizaciones de un proceso WSS suelen durar todo el eje temporal, con potencia ≠ 0 y **energía infinita**: no tienen TF "normal". La salida es mirar **cómo se distribuye en frecuencia la potencia esperada**, que es una propiedad de segundo momento del *proceso* completo.

## PSD: definición e interpretación
Si $E[x^2(t)]=R_{xx}(0)<\infty$:
$$E[x^2(t)]=R_{xx}(0)=\frac1{2\pi}\int_{-\infty}^{\infty}S_{xx}(j\omega)\,d\omega,\qquad S_{xx}(j\omega)=\mathcal F\{R_{xx}(\tau)\}$$
**Interpretación física:** pasar $x$ por un filtro pasabanda ideal (ancho $2\Delta$ centrado en $\pm\omega_0$, ganancia 1) da $y$ con
$$E[y^2]=\frac1{2\pi}\int_{\text{banda}}S_{xx}\,d\omega\ \approx\ \frac{1}{\pi}S_{xx}(j\omega_0)\Delta\ \ge 0$$
Es decir, $S_{xx}$ es la potencia instantánea esperada **por unidad de frecuencia**.

**Propiedades:** real, par y **no negativa** en $\omega$; los impulsos tienen área positiva; integral finita.

> [!important] Teorema de Bochner (CT) / Herglotz (DT)
> $R(\tau)$ es autocorrelación de un proceso WSS **⇔** su TF es real, par, no negativa (con integral finita).
> - ❌ Pulso **rectangular** no puede ser autocorrelación (su TF es un sinc, toma valores negativos).
> - ✅ Pulso **triangular** sí (su TF es un sinc², no negativo).

- **PSD compleja** $S_{xx}(s)$ = transformada de Laplace de $R_{xx}$ (en DT, $S_{xx}(z)$).
- **FSD** (densidad espectral de fluctuación) $D_{xx}=\mathcal F\{C_{xx}\}\ge0$: PSD de $x-\mu_x$. Relación: $S_{xx}(e^{j\Omega})=D_{xx}(e^{j\Omega})+2\pi\mu_x^2\delta(\Omega)$ (DT). De $D\ge0$ se deduce $|C_{xx}(\tau)|\le C_{xx}(0)$.

### Catálogo de ejemplos
| Proceso | Autocorr./autocov. | PSD / FSD |
|---|---|---|
| Sinusoide de fase aleatoria $A\sin(\omega_0t+\Theta)$ | $\tfrac{E[A^2]}{2}\cos\omega_0\tau$ | $S=\tfrac{\pi E[A^2]}{2}[\delta(\omega-\omega_0)+\delta(\omega+\omega_0)]$ → **espectro de líneas** |
| Suma de sinusoides (amplitudes ortogonales) | $\sum \tfrac{E[A_i^2]}2\cos\omega_i\tau$ | $S=\tfrac{\pi}{2}\sum_i E[A_i^2][\delta(\omega-\omega_i)+\delta(\omega+\omega_i)]$ |
| Exponencial (telegráfica, $\alpha=2\lambda$) | $e^{-\alpha\lvert\tau\rvert}$ | $\dfrac{2\alpha}{\omega^2+\alpha^2}$ (ancho ≈ $\omega_0=\pi\alpha/2$) |
| Correlacionado un paso (DT) | $\sigma^2(\delta[m]+\rho\,\delta[m\pm1])$ | $D=\sigma^2(1+2\rho\cos\Omega)$, válido sii $\lvert\rho\rvert\le0.5$ |
| i.i.d. / Bernoulli | $C=\sigma^2\delta[m]$ | $D=\sigma^2$ (plano); $S=\sigma^2+2\pi\mu^2\delta(\Omega)$ |
| Blanco banda limitada (CT) | $R=K\,\frac{\sin\omega_m\tau}{\pi\tau}$ | $S=K$ para $\lvert\omega\rvert<\omega_m$ |

> [!note] Lectura del caso correlacionado un paso
> $\rho$ cerca de $+0.5$ → pico en $\Omega=0$ (señales lentas). $\rho$ cerca de $-0.5$ → pico en $\Omega=\pm\pi$ (el signo alterna de muestra en muestra).

### Ruido blanco
- **DT blanco de intensidad $K$**: $R_{xx}[m]=K\delta[m]$, espectro plano. Vale con *no correlación* (no hace falta independencia).
- **Recíproco**: un WSS con espectro plano tiene **media cero** y no está correlacionado (si $\mu\ne0$ aparecería un impulso negativo en $D$).
- Proceso coloreado = no blanco.
- **Blanco CT**: $S=K$, $R=K\delta(\tau)$ ⇒ potencia infinita: **idealización** (como el impulso). Físico cercano: **ruido de Johnson–Nyquist** en una resistencia $R$ a temperatura $T$: $S=2kTR$ hasta ~terahertz.
- Media cero ≠ sin impulso en $S$ en $\Omega=0$: $y[n]=A+x[n]$ con $A$ de media cero y varianza $\sigma_A^2$ → $S_{yy}=2\pi\sigma_A^2\delta(\Omega)+K$, y **no es ergódico en la media**.

## Ergodicidad de la media
Promedio temporal sobre ventana $2T$ = salida en $t=0$ de un filtro $h(t)=\frac1{2T}$ ($|t|<T$). Entonces
$$\mathrm{Var}\{y(0)\}=C_{yy}(0)=\frac1{2T}\int_{-2T}^{2T}\Lambda\!\left(\tfrac{\tau}{2T}\right)C_{xx}(\tau)\,d\tau=\frac1{2\pi}\int D_{xx}|H|^2d\omega$$
($\Lambda$: triángulo de altura 1; $|H|^2$: sinc² cuyo ancho → 0 y altura 1 en el origen.)
- Condición temporal suficiente: $C_{xx}(\tau)\to0$ cuando $\tau\to\infty$.
- **Condición espectral (necesaria y suficiente):** ergódico en la media ⇔ **la FSD no tiene impulso en el origen**.
- (Convergencia en media cuadrática. Es la ley débil de los grandes números para procesos correlacionados.)

## Densidad espectral cruzada y desigualdad fundamental
$S_{yx}$, $D_{yx}$ = TF de $R_{yx}$, $C_{yx}$. Para $z(t)=x(t)+\alpha y(t-\Delta)$:
$$D_{zz}=D_{xx}+\alpha^2D_{yy}+2\alpha\,\mathrm{Re}\{e^{-j\omega\Delta}D_{yx}\}\ \ge0\quad\Rightarrow\quad \boxed{|D_{yx}(j\omega)|^2\le D_{xx}(j\omega)\,D_{yy}(j\omega)}$$
Análoga a $\sigma_{YX}^2\le\sigma_{XX}\sigma_{YY}$. En cada frecuencia, procesos conjuntamente WSS se comportan como **dos variables aleatorias**. (Reaparece como **coherencia** en [[03 Estimación de Señales#Filtro de Wiener no restringido]].)

## Teorema de Einstein–Wiener–Khinchin y periodograma
Sea $x_T(t)=w_T(t)x(t)$ (ventana rectangular en $(-T,T)$): energía finita, TF $X_T$ y ESD $|X_T|^2$. Dividiendo por $2T$ y tomando esperanza:
$$R_{xx}(\tau)\Lambda\!\left(\tfrac{\tau}{2T}\right)\leftrightarrow E\!\left[\tfrac1{2T}|X_T(j\omega)|^2\right]\ \xrightarrow{T\to\infty}\ \boxed{S_{xx}(j\omega)=\lim_{T\to\infty}E\!\left[\tfrac1{2T}|X_T(j\omega)|^2\right]}$$
Cruzada: $S_{xy}=\lim E[\tfrac1{2T}X_T(j\omega)Y_T(-j\omega)]$.
- **Periodograma** = $\frac1{2T}|X_T|^2$ (potencia/Hz de *una* realización). La **PSD es la esperanza del periodograma** en el límite: la potencia *instantánea* esperada y la *promediada en el tiempo* coinciden.

### Estimación espectral por promediado de periodogramas
1. Elegir longitud de ventana $T$; calcular el periodograma en $M$ ventanas no superpuestas.
2. Promediar: la **varianza baja por $1/M$** (desviación estándar por $1/\sqrt M$).
3. Pero el valor esperado del periodograma **no es la PSD**, sino una versión suavizada: 
$$E\!\left[\tfrac1{2T}|X_T|^2\right]=\tfrac1{2\pi}S_{xx}(j\omega)*\frac{2\sin^2(\omega T)}{\omega^2T}$$
   Lóbulo principal en $\pm\pi/T$ ⇒ **resolución** ≈ $\pi/T$: dos picos más cerca que eso no se distinguen. Mejor resolución ⇒ ventana más larga (mayor $T$). En el límite $T\to\infty$ el sinc² → $\delta$ y se recupera EWK.
4. Ventanas **cónicas** (no rectangulares) dan cortes más nítidos en frecuencia; se pueden **superponer** → **método de Welch**.

> [!example] Periodogramas de Bernoulli ±1 ($S=1$ plana)
> Un periodograma ($M=1$, ventana 50) fluctúa mucho: no interpretar picos sueltos. Con $M=4$ la dispersión baja a la mitad; con ventana 200 la variación es más fina ($\pi/200$ vs $\pi/50$). Promediando 16 realizaciones la desviación baja ×4.

## Aplicaciones
### Revelar componentes cíclicos (variabilidad de la frecuencia cardíaca)
Señal HR(t) constante por tramos → muestrear a ≥ frecuencia cardíaca más rápida (≈2 Hz), pasar antes por un filtro antialiasing, **restar la media** en cada ventana (estimar la FSD) y promediar periodogramas (Welch, $M=4$). Pico en **0.166 Hz** = tasa respiratoria: la HR oscila con la respiración (efecto mecánico + reflejos barorreceptores).

### Filtros de modelado y de blanqueo
**Modelado (conformación):** para generar un proceso coloreado con FSD dada, filtrar ruido blanco unitario:
$$D_{xx}(e^{j\Omega})=|H(e^{j\Omega})|^2=H(e^{j\Omega})H(e^{-j\Omega})\ \Rightarrow\ H=\text{factor espectral (raíz cuadrada generalizada)}$$
- Todas las soluciones: $H(e^{j\Omega})=A(e^{j\Omega})\sqrt{D_{xx}}$ con $A$ **pasa-todo** ($|A|=1$). Se elige la de fase mínima para tener inverso estable y causal.
- Luego se suma $\mu_x$. Para impulsos en $D$: sumar una constante aleatoria (impulso en $0$) o un coseno de fase aleatoria (en $\pm\Omega_i$).
- Es lo que garantiza el recíproco de Herglotz/Bochner: toda función real, par, no negativa e integrable es una PSD.

> [!example] Modelar el proceso correlacionado de un paso
> $h[n]=a\delta[n]+b\delta[n-1]$ ⇒ $R_{hh}=ab\,\delta[m\mp1]+(a^2+b^2)\delta[m]$. Igualando con $C_{xx}$:
> $$a^2+b^2=\sigma_x^2,\qquad ab=\sigma_x^2\rho\ \Rightarrow\ (a\pm b)^2\ge0\iff|\rho|\le0.5$$
> $a^2=\tfrac{\sigma_x^2}{2}\big(1\pm\sqrt{1-4\rho^2}\big)$. Hay **hasta 4 soluciones** reales; en frecuencia: $D_{xx}(z)=(a+bz)(a+bz^{-1})$, $H(z)=A(z)(a+bz^{-1})$. Con $\rho=0.5$ la muestra varía lento; con $\rho=-0.5$ alterna signo.

**Blanqueo:** dado un proceso coloreado $x$, hallar $H$ tal que la salida sea blanca con varianza $\sigma_w^2$:
$$S_{ww}=|H|^2S_{xx}\ \Rightarrow\ |H(e^{j\Omega})|^2=\frac{\sigma_w^2}{S_{xx}(e^{j\Omega})}$$
Se obtiene factorizando $S_{xx}(z)$ (Capítulo 2) y tomando el inverso del factor espectral. Elegir el estable y causal (inverso también estable y causal si es de fase mínima). Ejemplo: $S_{xx}=\tfrac54-\cos\Omega=(1-\tfrac12e^{j\Omega})(1-\tfrac12e^{-j\Omega})$ y $\sigma_w^2=1$ ⇒ $H(z)=\dfrac1{1-\frac12z^{-1}}$ con RDC $|z|>\tfrac12$ (causal y estable), multiplicable por cualquier pasa-todo.
> Los filtros de modelado y blanqueo son **inversos** uno del otro. Las dos vistas ("el coloreado es blanco filtrado" / "el coloreado se puede blanquear") sirven para reducir problemas de ruido coloreado a ruido blanco: [[04 Detección de Señales#Ruido de color]], [[03 Estimación de Señales#Filtro de Wiener causal]].

### Muestreo de procesos de banda limitada
Si $S_{x_cx_c}(j\omega)=0$ para $|\omega|\ge\pi/T$, el proceso muestreado $x[n]=x_c(nT)$ es WSS con $R_{xx}[m]=R_{x_cx_c}(mT)$, y la reconstrucción sinc
$$y_c(t)=\sum_n x[n]\frac{\sin(\pi(t-nT)/T)}{\pi(t-nT)/T}\ \Rightarrow\ E\{[x_c(t)-y_c(t)]^2\}=0$$
Es decir, **potencia esperada del error nula**: teorema de muestreo estocástico (demostración vía filtros con $H_1=H_2$ en la banda).
