---
tags: [cap10, procesos-aleatorios, WSS, ergodicidad]
cap: 10
---
# 01 · Procesos Aleatorios
← [[00 Índice]] · Siguiente: [[02 Densidad Espectral de Potencia]]

## Idea central
Un **proceso aleatorio** $X(t)$ o $X[n]$ **no es una señal, es un ensamble de señales**. El experimento probabilístico elige *una* realización (señal determinista) del ensamble.

- Antes del experimento: incertidumbre sobre cuál señal sale. Después: todo determinado.
- Fijando el tiempo $t_0$: $X(t_0)$ es una **variable aleatoria** (mirar "hacia abajo" a través del ensamble).
- Fijando $\ell$ tiempos: $X(t_1),\dots,X(t_\ell)$ son VA **conjuntamente distribuidas**; la descripción completa es la PDF conjunta $f_{X(t_1),\dots,X(t_\ell)}$ para todo $\ell$ y todos los tiempos.
- En la práctica se usan los **momentos de 1.º y 2.º orden** (suficientes para trabajar con sistemas lineales).

### Ejemplos del ensamble
| Ejemplo | Fuente de aleatoriedad | Lo que enseña |
|---|---|---|
| Osciladores: $X=A\sin(\omega t+\Theta)$ | elegir un oscilador (amplitud, fase, frecuencia aleatorias) | observar un tramo puede determinar toda la realización |
| **i.i.d.** | cada muestra independiente con misma PDF | $f$ conjunta = producto de marginales; es SSS; modela ruido aditivo |
| Baterías ($v_i$ constante en el tiempo) | elegir una batería | SSS pero **no ergódico** |
| Lanzadores de moneda | cadenas de 1s y 0s independientes | observar el pasado no predice el futuro |

## Momentos de primer y segundo orden
$$\mu_X(t)=E[X(t)],\qquad R_{XX}(t_1,t_2)=E[X(t_1)X(t_2)]$$
$$C_{XX}(t_1,t_2)=E[(X(t_1)-\mu_X(t_1))(X(t_2)-\mu_X(t_2))]=R_{XX}(t_1,t_2)-\mu_X(t_1)\mu_X(t_2)$$

- **Proceso gaussiano**: muestras siempre conjuntamente gaussianas → los momentos de 1.º y 2.º orden lo determinan por completo.
- **Dos procesos** $X,Y$: *independientes* si toda PDF conjunta se factoriza; en términos de momentos:
$$R_{XY}(t_1,t_2)=E[X(t_1)Y(t_2)],\quad C_{XY}=R_{XY}-\mu_X\mu_Y$$
- **Incorrelacionados** ⇔ $C_{XY}\equiv 0$ (covarianza cero, *no* correlación cero).

## Estacionariedad
- **SSS** (sentido estricto): todas las PDF conjuntas son invariantes a desplazamientos de tiempo $\alpha$. Los i.i.d. son SSS.
- **WSS** (sentido amplio): $\mu_X(t)=\mu_X$ constante y $R_{XX}(t_1,t_2)=R_{XX}(t_1-t_2)$ (equivalente con $C_{XX}$).
  - SSS ⇒ WSS, pero no al revés. **Excepción: en un proceso gaussiano WSS ⇒ SSS.**
  - Notación: $R_{xx}(\tau)=E[x(t+\tau)x(t)]$, con $\tau$ la **variable de retardo**.
- **Conjuntamente WSS**: ambos WSS y $R_{xy}(\tau)=E[x(t+\tau)y(t)]$ depende solo de $\tau$. ⚠️ Otras fuentes definen $R_{xy}(\tau)=E[x(t)y(t+\tau)]$, que aquí sería $R_{xy}(-\tau)$.

> [!example] Oscilador de fase aleatoria
> $X(t)=A\cos(\phi_0 t+\Theta)$, $A\perp\Theta$.
> - Con $\Theta=\theta_0$ fijo: **no es WSS** (la media $\mu_A\cos(\phi_0 t+\theta_0)$ varía; y aun con $\mu_A=0$ la autocorrelación depende de $t$).
> - Con $\Theta\sim U[-\pi,\pi]$ y $\mu_A=0$: **es WSS** (y SSS):
> $$\mu_X=0,\qquad C_{XX}(t_1,t_2)=R_{XX}=\tfrac{E[A^2]}{2}\cos\big(\phi_0(t_2-t_1)\big)$$

### Propiedades de $R$ y $C$ para procesos WSS reales
$$R_{xx}(\tau)=R_{xx}(-\tau),\qquad R_{xy}(\tau)=R_{yx}(-\tau)$$
(simetría par; intercambiar las VA = reflejar respecto de $\tau=0$). Además, por $|\rho|\le 1$:
$$-C_{xx}(0)\le C_{xx}(\tau)\le C_{xx}(0),\qquad -R_{xx}(0)+2\mu_x^2\le R_{xx}(\tau)\le R_{xx}(0)$$
Más adelante se verá que están **caracterizadas** por tener TF real y no negativa → [[02 Densidad Espectral de Potencia#PSD: definición e interpretación]].

### Dos procesos canónicos
> [!example] Proceso de Bernoulli (i.i.d., valores ±1)
> $P(x=1)=p$. $\mu_x=2p-1$; $C_{xx}[m]=4p(1-p)\,\delta[m]$ (no correlacionado entre tiempos distintos).

> [!example] Onda telegráfica aleatoria
> $x(0)=\pm1$ equiprobable; cambia de signo en **instantes de Poisson** con tasa $\lambda$: $P(k\text{ cambios en }T)=\frac{(\lambda T)^k e^{-\lambda T}}{k!}$.
> - $P(\text{par})=\tfrac12(1+e^{-2\lambda T})$, $P(\text{impar})=\tfrac12(1-e^{-2\lambda T})$.
> - $\mu_x=0$, $R_{xx}(\tau)=e^{-2\lambda|\tau|}$ → **WSS, exponencialmente correlacionado**.

## Ergodicidad
Idea: ¿pueden reemplazarse **promedios de ensamble** por **promedios temporales** sobre *una* realización?
$$E[x(t)]=\lim_{T\to\infty}\frac1{2T}\int_{-T}^{T}x'(t)\,dt,\qquad E[x(t)x(t-\tau)]=\lim_{T\to\infty}\frac1{2T}\int_{-T}^{T}x'(t)x'(t-\tau)\,dt$$
($x'$ = una realización particular.) Versión DT: $E\{x[n]\}=\lim_{K\to\infty}\frac1{2K+1}\sum_{k=-K}^{K}x[k]$.

- **Ergódico en la media / en distribución / en correlación / de 2.º orden**: según qué estadística se pueda sustituir.
- Una media que varía con el tiempo ⇒ no ergódico en la media.
- **Criterio práctico**: WSS con varianza finita y $C_{xx}(\tau)\to0$ cuando $\tau\to\infty$ ⇒ ergódico en la media. (Criterio espectral exacto en [[02 Densidad Espectral de Potencia#Ergodicidad de la media]].)
- **Contraejemplo clásico**: el ensamble de baterías (SSS pero cada realización es una constante distinta). También $y=W+x[n]$ con $W$ aleatoria constante.
- A menudo la ergodicidad se **asume por conveniencia**.

## Estimación lineal: primer vistazo
**Predicción lineal afín** de $x[n_0+m]$ a partir de $x[n_0]$ en un proceso WSS: $\hat x[n_0+m]=a\,x[n_0]+b$ minimizando el ECM. Condiciones: error **ortogonal al dato** y **media del error nula**:
$$a=\frac{C_{xx}[m]}{C_{xx}[0]},\qquad b=\mu_x(1-a)\ \ \Rightarrow\ \ \hat x[n_0+m]=\mu_x+\frac{C_{xx}[m]}{C_{xx}[0]}(x[n_0]-\mu_x)$$
**Filtrado FIR** de $s[n]$ desde $r[n]=s[n]+d[n]$ ($s\perp d$, media cero): ecuaciones normales
$$\sum_{k=0}^{L-1}h[k]R_{rr}[m-k]=R_{sr}[m],\quad R_{sr}=R_{ss},\ R_{rr}=R_{ss}+R_{dd}$$
Esto se generaliza en [[03 Estimación de Señales]].

## Filtrado LTI de procesos WSS
Entrada $x(t)$ WSS con $E[x^2]<\infty$, sistema LTI estable (BIBO) con respuesta $h$; salida $y=h*x$. **Resultado: $x$ e $y$ son conjuntamente WSS.**

| Cantidad | CT | DT |
|---|---|---|
| Media | $\mu_y=\mu_x\int h = H(j0)\,\mu_x$ | $\mu_y=H(e^{j0})\mu_x$ |
| Correlación cruzada | $R_{yx}(\tau)=h(\tau)*R_{xx}(\tau)$ | $R_{yx}[m]=h[m]*R_{xx}[m]$ |
| Cruzada inversa | $R_{xy}(\tau)=h(-\tau)*R_{xx}(\tau)$ | |
| Autocorrelación salida | $R_{yy}=R_{hh}*R_{xx}$ | $R_{yy}[m]=R_{hh}[m]*R_{xx}[m]$ |
| Autocorr. determinista | $R_{hh}(\tau)=h(-\tau)*h(\tau)=\int h(t+\tau)h(t)\,dt$ | $R_{hh}[m]=\sum_n h[n+m]h[n]$ |

- Las mismas relaciones valen para **covarianzas** (aplicar el sistema a $x-\mu_x$): $C_{yx}=h*C_{xx}$, $C_{yy}=R_{hh}*C_{xx}$. La $R_{hh}$ sigue siendo la determinista de $h$.
- En frecuencia ($S$ = TF de $R$, $D$ = TF de $C$):
$$S_{yx}(j\omega)=H(j\omega)S_{xx}(j\omega),\qquad S_{yy}(j\omega)=|H(j\omega)|^2S_{xx}(j\omega)$$
$$S_{yx}(s)=H(s)S_{xx}(s),\quad S_{yy}(s)=H(s)H(-s)S_{xx}(s);\qquad S_{yy}(z)=H(z)H(1/z)S_{xx}(z)$$
- Se aplica incluso a entradas de potencia infinita (ruido blanco CT, $R_{xx}=\delta$) o a sistemas no BIBO con $H(j\omega)$ bien definida (p. ej. pasabajos ideal).

> [!tip] Identificación de sistemas con procesos aleatorios
> - Con entrada blanca ($R_{xx}[m]=\delta[m]$): $R_{yx}[m]=h[m]$ → **medir la correlación cruzada da la respuesta al impulso**. Un proceso i.i.d. de $\pm1$ equiprobables sirve.
> - Con telegráfica ($R_{xx}=e^{-2\lambda|\tau|}$): $H(s)=S_{yx}(s)/S_{xx}(s)$.
> - Si solo se mide $R_{yy}$: $R_{yy}=R_{hh}*R_{xx}$ ⇒ solo se recupera $H(z)H(1/z)$ (módulo), y con hipótesis de estabilidad/causalidad (fase mínima) se llega a $H(z)$. Ej.: $R_{yy}[m]=(1/2)^{|m|}$.

Siguiente paso: la interpretación de $S_{xx}$ como "potencia por frecuencia" → [[02 Densidad Espectral de Potencia]].
