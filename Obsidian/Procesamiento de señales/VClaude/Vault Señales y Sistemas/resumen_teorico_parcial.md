# Resumen teórico para el parcial
**Signals, Systems and Inference (Oppenheim & Verghese)**
Cap. 10 (10.1, 10.2, 10.3, 10.5) · Cap. 11 · Cap. 12 (12.1, 12.2) · Cap. 13 (13.1, 13.2)

> Convención: $x(t)$ en tiempo continuo (CT), $x[n]$ en tiempo discreto (DT). $\mu$ = media, $R$ = correlación, $C$ = covarianza, $S$ = PSD, $D$ = FSD.

---

# CAPÍTULO 10 — Procesos aleatorios

## 10.1 Definición y ejemplos

**Proceso aleatorio** $X(t)$ o $X[n]$: función que asigna a cada resultado $\omega$ de un experimento probabilístico una señal $x(t;\omega)$ (una **realización**). El conjunto de todas las realizaciones es el **ensamble**.

Dos lecturas equivalentes:
- Fijo $\omega$ → una **función determinista** del tiempo (realización).
- Fijo $t$ → una **variable aleatoria** $X(t)$.
- Un proceso es una **familia de variables aleatorias indexadas por el tiempo**, con distribución conjunta para cualquier conjunto de instantes.

**Ejemplos del libro (qué enseña cada uno):**

| Ejemplo | Idea clave |
|---|---|
| Ensamble de lanzadores de monedas | Cada miembro genera una secuencia de valores **independientes**. Saber el valor en $n=10$ no dice nada del de $n=11$. |
| Ensamble de baterías | Cada realización es una **constante** (voltaje de la batería elegida al azar). Una sola medición en un instante revela toda la realización. |
| Oscilador aleatorio $X(t)=A\cos(\omega_0 t+\theta)$ | $A$ y/o $\theta$ son variables aleatorias. Toda la aleatoriedad se resuelve con un par de valores. |
| Proceso de Bernoulli (DT) | Muestras i.i.d. que toman dos valores ($\pm1$). Sin memoria. |
| Onda telegráfica aleatoria (CT) | Valores $\pm1$ que cambian de signo en instantes de un proceso de Poisson de tasa $\lambda$. |

## 10.2 Caracterización por momentos de 1.º y 2.º orden

- **Media:** $\mu_X(t)=E[X(t)]$
- **Autocorrelación:** $R_{XX}(t_1,t_2)=E[X(t_1)X(t_2)]$
- **Autocovarianza:** $C_{XX}(t_1,t_2)=E\big[(X(t_1)-\mu_X(t_1))(X(t_2)-\mu_X(t_2))\big]$

$$C_{XX}(t_1,t_2)=R_{XX}(t_1,t_2)-\mu_X(t_1)\,\mu_X(t_2)$$

- Varianza: $\sigma_X^2(t)=C_{XX}(t,t)$.
- **Correlación cruzada** entre dos procesos: $R_{XY}(t_1,t_2)=E[X(t_1)Y(t_2)]$ (análogo con $C_{XY}$).
- **Procesos gaussianos:** todas las PDF conjuntas son gaussianas multivariadas, por lo que **quedan completamente especificados por la media y la autocovarianza**. Es una propiedad especial que no vale para procesos en general.

## 10.3 Estacionariedad

- **Estrictamente estacionario (SSS):** todas las PDF conjuntas son invariantes ante traslaciones en el tiempo.
- **Estacionario en sentido amplio (WSS):** solo se piden los momentos de 1.º y 2.º orden:
  1. $\mu_X(t)=\mu_X$ (constante).
  2. $R_{XX}(t_1,t_2)=R_{XX}(\tau)$ con $\tau=t_1-t_2$ (depende solo del desfase).
- SSS ⇒ WSS (si existen los momentos). WSS ⇏ SSS, salvo en procesos **gaussianos**, donde WSS ⇒ SSS.
- Propiedades de un proceso WSS real: $R_{XX}(\tau)=R_{XX}(-\tau)$ (par); $|R_{XX}(\tau)|\le R_{XX}(0)=E[X^2]$; $C_{XX}(\tau)=R_{XX}(\tau)-\mu_X^2$.
- **Conjuntamente WSS:** ambos son WSS y $R_{XY}(t_1,t_2)$ depende solo de $\tau$.

### Ejemplos desarrollados

**Oscilador aleatorio** $X(t)=A\cos(\omega_0 t+\theta)$, con $\theta\sim U[-\pi,\pi]$ **independiente** de $A$:
- $E[X(t)]=E[A]\,E[\cos(\omega_0 t+\theta)]=0$ para todo $t$ (el coseno con fase uniforme promedia cero).
- $R_{XX}(t_1,t_2)=\dfrac{E[A^2]}{2}\cos(\omega_0 (t_1-t_2))$ → depende solo de $\tau$ → **WSS**.
- Si $\theta$ es constante, la media $E[A]\cos(\omega_0 t+\theta_0)$ depende de $t$ → **no WSS**.

**Proceso de Bernoulli DT** (muestras i.i.d. $\pm1$ con $P(+1)=p$):
- Media $2p-1$; varianza $4p(1-p)$.
- Muestras independientes ⇒ covarianza nula para $m\neq0$:

$$C_{xx}[m]=4p(1-p)\,\delta[m]$$

**Onda telegráfica aleatoria** (cambios de signo según Poisson de tasa $\lambda$):
- $R_{xx}(\tau)=P(\text{mismo signo})-P(\text{distinto signo})$.
- Misma señal ⇔ número **par** de transiciones en $|\tau|$: $P=\tfrac12\big(1+e^{-2\lambda|\tau|}\big)$.

$$R_{xx}(\tau)=e^{-2\lambda|\tau|}$$

Decae exponencialmente; $\lambda$ grande ⇒ decorrelación rápida.

## 10.5 Estimación lineal de procesos aleatorios

### Predictor afín de un paso (o $m$ pasos)
Estimar $x[n_0+m]$ a partir de $x[n_0]$: $\hat x[n_0+m]=a\,x[n_0]+b$, minimizando $E[(x[n_0+m]-\hat x[n_0+m])^2]$.

**Principio de ortogonalidad:** el error óptimo es **ortogonal a los datos** y de **media cero** (estimador insesgado):

$$E[e]=0,\qquad E[e\,x[n_0]]=0,\qquad e=x[n_0+m]-\hat x[n_0+m]$$

Resolviendo para un proceso WSS:
$$a=\frac{C_{xx}[m]}{C_{xx}[0]},\qquad b=\mu_x(1-a)$$

Para **media cero** ($\mu_x=0$): $b=0$ y

$$a=\frac{R_{xx}[m]}{R_{xx}[0]}$$

Error mínimo: $\;\text{MMSE}=C_{xx}[0]\Big(1-\rho_m^2\Big)$ con $\rho_m=C_{xx}[m]/C_{xx}[0]$. A mayor correlación, menor error.

### Filtro FIR causal para estimar una señal en ruido
Recibimos $r[n]=s[n]+d[n]$ y estimamos $s[n]$ con $\hat s[n]=\sum_{k=0}^{L-1}h[k]\,r[n-k]$.

Exigiendo que el error $s[n]-\hat s[n]$ sea ortogonal a cada dato usado, $r[n-m]$, $m=0,\dots,L-1$, se obtienen las **ecuaciones normales (Wiener-Hopf)**:

$$\sum_{k=0}^{L-1}h[k]\,R_{rr}[m-k]=R_{sr}[m],\qquad m=0,1,\dots,L-1$$

Si $s$ y $d$ son **de media cero e incorrelados**: $R_{sd}=R_{ds}=0$, de donde

$$R_{sr}[m]=R_{ss}[m],\qquad R_{rr}[m]=R_{ss}[m]+R_{dd}[m]$$

---

# CAPÍTULO 11 — Densidad espectral de potencia

## 11.1 PSD y su interpretación

**Definición (Einstein-Wiener-Khinchin):** la PSD es la transformada de Fourier de la autocorrelación:

$$S_{xx}(j\omega)=\int_{-\infty}^{\infty}R_{xx}(\tau)e^{-j\omega\tau}d\tau,\qquad R_{xx}(\tau)=\frac1{2\pi}\int S_{xx}(j\omega)e^{j\omega\tau}d\omega$$

En DT: $S_{xx}(e^{j\Omega})=\sum_m R_{xx}[m]e^{-j\Omega m}$, periódica en $\Omega$ con período $2\pi$.

**Propiedades (proceso real WSS):**
1. **Real** (porque $R_{xx}$ es par).
2. **Par** en $\omega$.
3. **No negativa:** $S_{xx}(j\omega)\ge0$.
4. **Potencia total:** $\dfrac{1}{2\pi}\displaystyle\int S_{xx}(j\omega)d\omega=R_{xx}(0)=E[x^2(t)]$.

**Interpretación física:** pasar $x(t)$ por un filtro pasa-banda ideal ($|H|=1$ en la banda, 0 fuera) y medir la potencia de salida:

$$E[y^2(t)]=\frac1{2\pi}\int_{\text{banda}}S_{xx}(j\omega)\,d\omega$$

(la banda incluye la parte de frecuencias negativas). Por eso $S_{xx}$ es una **densidad de potencia por unidad de frecuencia**, y su no negatividad se deduce de que la potencia de salida no puede ser negativa.

## 11.2 Densidad espectral de fluctuación (FSD)

Con media $\mu_x\neq0$: $R_{xx}(\tau)=C_{xx}(\tau)+\mu_x^2$. Definimos $D_{xx}(j\omega)=\mathcal F\{C_{xx}(\tau)\}$. Como la transformada de una constante es un impulso:

$$S_{xx}(j\omega)=D_{xx}(j\omega)+2\pi\mu_x^2\,\delta(\omega)$$

La media aporta un impulso en $\omega=0$; la FSD describe solo las **fluctuaciones**.

**Cruzadas:** $S_{yx}$, $D_{yx}$. Para procesos conjuntamente WSS vale, en cada frecuencia,

$$|D_{yx}(j\omega)|^2\le D_{xx}(j\omega)\,D_{yy}(j\omega)$$

(análoga a Cauchy-Schwarz $\sigma_{XY}^2\le\sigma_X^2\sigma_Y^2$). Se deduce exigiendo $D_{zz}\ge0$ para $z(t)=x(t)+\alpha y(t-\Delta)$ para todo $\alpha$ y $\Delta$ (discriminante $\le0$).

## 11.3 Ergodicidad de la media

Promedio temporal sobre ventana $2T$: $y=\dfrac1{2T}\displaystyle\int_{-T}^{T}x(t)dt$. Su media es $\mu_x$ y su varianza es

$$\operatorname{Var}\{y\}=\frac1{2\pi}\int_{-\infty}^{\infty}D_{xx}(j\omega)\left(\frac{\sin\omega T}{\omega T}\right)^2d\omega$$

Cuando $T\to\infty$, $\left(\frac{\sin\omega T}{\omega T}\right)^2$ se angosta alrededor de $\omega=0$ con altura 1. La varianza → 0 (**ergodicidad en media, en sentido cuadrático medio**) **si y solo si $D_{xx}$ no tiene un impulso en $\omega=0$**.

## 11.4 Periodograma y teorema EWK

Se trunca con ventana rectangular de duración $2T$: $x_T(t)$, con transformada $X_T(j\omega)$. El **periodograma** es $\frac{1}{2T}|X_T(j\omega)|^2$.

La autocorrelación determinista de la ventana es un pulso triangular $\Delta(\tau)$, de modo que el valor esperado es la PSD **suavizada**:

$$\frac1{2T}E\big[|X_T(j\omega)|^2\big]=\frac1{2\pi}S_{xx}(j\omega)*\left[\frac{2\sin^2(\omega T)}{\omega^2T}\right]$$

- El núcleo $\operatorname{sinc}^2$ tiene lóbulo principal de ancho $\approx\pm\pi/T$ ⇒ **resolución frecuencial** $\Delta\omega\approx\pi/T$. Dos picos más cercanos que eso se funden.
- Para mejorar resolución hay que **aumentar $T$**.
- Cuando $T\to\infty$ el valor esperado tiende a $S_{xx}$ (es asintóticamente insesgado), pero la **varianza del periodograma no disminuye** → se **promedian periodogramas** de segmentos (Welch/Bartlett) para reducir varianza, a costa de resolución.

## 11.5 Procesos blancos

| | CT | DT |
|---|---|---|
| Autocorrelación | $R_{xx}(\tau)=K\delta(\tau)$ | $R_{xx}[m]=\sigma^2\delta[m]$ |
| PSD | $S_{xx}(j\omega)=K$ (plana en todo $\omega$) | $S_{xx}(e^{j\Omega})=\sigma^2$ (plana en $[-\pi,\pi]$) |
| Potencia $E[x^2]$ | $R_{xx}(0)=\infty$ | $\sigma^2$ (finita) |

- El blanco CT **no es físicamente realizable** (potencia infinita), pero es una idealización muy útil en el análisis de sistemas LTI. Se aproxima con ruido de banda ancha.
- Blanco DT no exige media no nula; la PSD es **constante**, no lineal.

## 11.6 Filtrado LTI de procesos WSS

Para un sistema LTI estable con $h[n]$ (o $h(t)$) y entrada WSS:
- $\mu_y=H(0)\,\mu_x$ (o $H(e^{j0})\mu_x$).
- $R_{yy}[m]=R_{xx}[m]*R_{hh}[m]$, con $R_{hh}[m]=h[m]*h[-m]$ cuya DTFT es $|H|^2$.

$$S_{yy}(e^{j\Omega})=|H(e^{j\Omega})|^2\,S_{xx}(e^{j\Omega}),\qquad S_{yx}(e^{j\Omega})=H(e^{j\Omega})\,S_{xx}(e^{j\Omega})$$

(en CT: $S_{yy}(j\omega)=|H(j\omega)|^2S_{xx}(j\omega)$).

**Filtro blanqueador** $H_w$: convierte $x$ (coloreado) en $w$ blanco de varianza $\sigma_w^2$. De $S_{ww}=|H_w|^2S_{xx}=\sigma_w^2$:

$$|H_w(e^{j\Omega})|^2=\frac{\sigma_w^2}{S_{xx}(e^{j\Omega})}$$

Solo se fija la **magnitud**; la fase se elige (típicamente por **factorización espectral**) para que $H_w$ sea causal, estable y de fase mínima. Su inverso es el filtro "colorizador" que genera $x$ a partir de ruido blanco.

---

# CAPÍTULO 12 — Estimación LMMSE y filtros de Wiener

## 12.1 Estimador lineal de mínimo error cuadrático medio

**Problema:** estimar $Y$ a partir de mediciones $\mathbf X=[X_1,\dots,X_L]^T$ con un estimador afín $\hat Y=a_0+\mathbf a^T\mathbf X$, minimizando $E[(Y-\hat Y)^2]$. Solo se necesitan **momentos de 1.º y 2.º orden**.

**Forma óptima:**

$$\hat Y=\mu_Y+\mathbf a^T(\mathbf X-\boldsymbol\mu_X)$$

- **Insesgado:** $E[\hat Y]=\mu_Y=E[Y]$ (porque $E[\mathbf X-\boldsymbol\mu_X]=0$).

### Principio de ortogonalidad
El error $e=Y-\hat Y$ debe ser ortogonal a cada medición (centrada):

$$E\big[(Y-\hat Y)(X_i-\mu_{X_i})\big]=0,\quad i=1,\dots,L$$

Esto da las **ecuaciones normales**:

$$\mathbf C_{XX}\,\mathbf a=\mathbf c_{XY}\;\Rightarrow\;\mathbf a=\mathbf C_{XX}^{-1}\mathbf c_{XY}$$

con $\mathbf C_{XX}$ la matriz de covarianza de $\mathbf X$ y $\mathbf c_{XY}$ el vector de covarianzas $\operatorname{Cov}(X_i,Y)$.

**Error mínimo:**
$$\text{MMSE}=\sigma_Y^2-\mathbf c_{YX}^T\mathbf C_{XX}^{-1}\mathbf c_{XY}$$

### Caso escalar
$$\hat Y=\mu_Y+\frac{C_{XY}}{\sigma_X^2}(X-\mu_X),\qquad \text{MMSE}=\sigma_Y^2\,(1-\rho_{XY}^2),\quad\rho_{XY}=\frac{C_{XY}}{\sigma_X\sigma_Y}$$

- $\rho=0$ ⇒ MMSE $=\sigma_Y^2$ (la medición no ayuda; $\hat Y=\mu_Y$).
- $|\rho|=1$ ⇒ MMSE $=0$ (relación lineal exacta).

### Interpretación geométrica (espacio de Hilbert)
Variables aleatorias de media cero como vectores, con **producto interno** $\langle U,V\rangle=E[UV]$ y norma $\|U\|^2=E[U^2]$.
- $\hat Y$ es la **proyección ortogonal** de $Y$ sobre el subespacio generado por las mediciones.
- El error $Y-\hat Y$ es perpendicular a ese subespacio (ortogonalidad = condición de proyección).
- $\rho^2=\cos^2\theta$, con $\theta$ el ángulo entre $Y$ y el subespacio; $\text{MMSE}=\sigma_Y^2\sin^2\theta$ (Pitágoras: $\sigma_Y^2=\|\hat Y\|^2+\|e\|^2$).
- Si $X,Y$ son **conjuntamente gaussianas**, el LMMSE coincide con el MMSE general (la media condicional $E[Y|X]$ es lineal).

## 12.2 Filtros FIR de Wiener

**Setup:** $x[n]$, $y[n]$ conjuntamente WSS. Estimar $y[n]$ con un FIR de $L$ coeficientes usando $x[n],x[n-1],\dots,x[n-L+1]$.

**Estructura:**
1. **Restar la media** de la entrada: $\breve x[n]=x[n]-\mu_x$ (proceso de fluctuación de media cero).
2. Filtrar con el FIR.
3. **Sumar la media** deseada:

$$\hat y[n]=\mu_y+\sum_{j=0}^{L-1}h[j]\,\breve x[n-j]$$

**Ecuaciones normales:** $\mathbf C_{XX}\mathbf h=\mathbf c_{XY}$, donde por WSS

$$[\mathbf C_{XX}]_{i,j}=C_{xx}[i-j],\qquad [\mathbf c_{XY}]_i=C_{yx}[i]$$

$\mathbf C_{XX}$ es **simétrica y Toeplitz** (cada diagonal es constante). Error: $\text{MMSE}=C_{yy}[0]-\sum_j h[j]\,C_{yx}[j]$.

### Ejemplo 12.1: señal en ruido blanco
$x[n]=2y[n]+v[n]$, con $v$ blanco, incorrelado con $y$. Entonces $C_{xx}[m]=4C_{yy}[m]+\sigma_v^2\delta[m]$ y $C_{yx}[m]=2C_{yy}[m]$.
- $\sigma_v^2\to\infty$ (ruido dominante): $\mathbf C_{XX}$ se vuelve grande, $\mathbf h\to0$ y **$\hat y[n]\to\mu_y$** (se ignora la medición, se usa la media a priori; MMSE → $C_{yy}[0]$).
- $\sigma_v^2\to0$ (sin ruido): $\hat y[n]\to x[n]/2$ (se invierte la ganancia, error → 0).
- Es un compromiso: cuanto menor la SNR, más "suaviza" el filtro y más confía en la media.

### Predicción de un paso
Estimar $x[n+1]$ con $x[n],\dots,x[n-L+1]$ (proceso WSS): $\hat x[n+1]=\mu_x+\sum_j h[j](x[n-j]-\mu_x)$. Aquí $C_{yx}[i]=C_{xx}[i+1]$:

$$\sum_{j=0}^{L-1}h[j]\,C_{xx}[i-j]=C_{xx}[i+1],\qquad 0\le i\le L-1$$

Estas son las **ecuaciones de Yule-Walker** (sistema simétrico de Toeplitz).

**Ejemplo A — autocovarianza exponencial** $C_{xx}[m]=C_0\rho^{|m|}$, $|\rho|<1$:
- Solución: $h[0]=\rho$ y $h[j]=0$ para $j\ge1$. Verificación: $\rho\,C_0\rho^{i}=C_0\rho^{i+1}$ ✓.
- **Solo la muestra más reciente importa** (propiedad Markoviana de primer orden). $\text{MMSE}=C_0(1-\rho^2)$.

**Ejemplo B — correlación de alcance limitado** $C_{xx}[m]=C_0\big(\rho\,\delta[m+1]+\delta[m]+\rho\,\delta[m-1]\big)$ (requiere $|\rho|\le\tfrac12$ para ser covarianza válida):
- $x[n+1]$ solo está correlacionada directamente con $x[n]$ (retardo 1).
- Sin embargo, $h[1],h[2],\dots\ne0$: $x[n-1]$ está correlacionada con $x[n]$ y permite **estimar y cancelar la fluctuación** presente en $x[n]$, "limpiando" la muestra más reciente. Se mejora la predicción aunque no haya correlación directa a ese retardo.

### Filtro centrado vs. causal
- **Causal (estricto):** usa $x[n-L+1],\dots,x[n]$ (solo pasado y presente). Realizable en tiempo real.
- **Centrado:** usa $x[n-L],\dots,x[n+L]$, es decir, también **muestras futuras** ⇒ **no causal** (procesamiento offline o con retardo).
- Ambos se derivan con el mismo principio de ortogonalidad (cambia el conjunto de datos). Con más datos disponibles (ventana que incluye a la causal), el centrado logra MMSE **menor o igual**.

---

# CAPÍTULO 13 — Detección (13.1 y 13.2)

## 13.1 Prueba de hipótesis con múltiples mediciones

Dos hipótesis $H_0$, $H_1$ con probabilidades a priori $P(H_0)=p_0$, $P(H_1)=p_1$, y un vector de observaciones $\mathbf R=\mathbf r$ con verosimilitudes $f_{\mathbf R|H}(\mathbf r|H_i)$.

### Regla MAP
Minimizar $P(\text{error}|\mathbf R=\mathbf r)$ equivale a decidir la hipótesis con **mayor probabilidad a posteriori**:

$$P(H_1|\mathbf r)\ \overset{H_1}{\underset{H_0}{\gtrless}}\ P(H_0|\mathbf r)$$

Con Bayes, $P(H_i|\mathbf r)=\dfrac{p_i f(\mathbf r|H_i)}{f(\mathbf r)}$; el denominador común se cancela y queda la **prueba de razón de verosimilitud (LRT)**:

$$\Lambda(\mathbf r)=\frac{f_{\mathbf R|H}(\mathbf r|H_1)}{f_{\mathbf R|H}(\mathbf r|H_0)}\ \overset{H_1}{\underset{H_0}{\gtrless}}\ \frac{p_0}{p_1}$$

- Con **prioris iguales** se obtiene la regla de **máxima verosimilitud (ML)**: umbral 1.
- Equivalente con logaritmos (**log-LRT**): $\ln\Lambda(\mathbf r)\gtrless\ln(p_0/p_1)$. Útil con densidades exponenciales/gaussianas.
- Toda la información relevante para decidir está en $\Lambda(\mathbf r)$ (estadístico suficiente).

### Probabilidades de error
- **Falsa alarma:** $P_{FA}=P(\text{decidir }H_1\,|\,H_0)$.
- **Fallo / pérdida:** $P_M=P(\text{decidir }H_0\,|\,H_1)$; **detección:** $P_D=1-P_M$.
- **Error total:** $P_e=p_0P_{FA}+p_1P_M$.

### Ejemplo 13.1 (idea principal)
- Con **una** medición, la regla MAP resulta declarar **siempre $H_0$** (el $p_1f(x|H_1)$ nunca supera a $p_0f(x|H_0)$), y $P_e=p_1=1/4$.
- Con **dos** mediciones independientes procesadas **óptimamente** (LRT conjunta), aparece una región de decisión no trivial donde se declara $H_1$, y $P_e$ baja de $1/4$ a $3/16$.
- Con una regla **no óptima**, basada solo en el promedio $(X_1+X_2)/2$, no se mejora: el mejor desempeño equivale a declarar siempre $H_0$ ($P_e=1/4$).
- **Moraleja:** más mediciones ayudan solo si se procesan según la verosimilitud **conjunta**; resumirlas mal puede descartar la información útil.

## 13.2 Detección de una señal conocida en ruido gaussiano i.i.d.

**Modelo**, $n=0,\dots,L-1$, con $s[n]$ determinista y conocida, $W[n]\sim\mathcal N(0,\sigma^2)$ i.i.d.:

$$H_0:\ r[n]=w[n],\qquad H_1:\ r[n]=s[n]+w[n]$$

### 13.2.1 Regla óptima
Verosimilitudes (gaussianas i.i.d.):
$$f(\mathbf r|H_0)=\frac{1}{(2\pi\sigma^2)^{L/2}}e^{-\sum r^2[n]/2\sigma^2},\quad f(\mathbf r|H_1)=\frac{1}{(2\pi\sigma^2)^{L/2}}e^{-\sum (r[n]-s[n])^2/2\sigma^2}$$

Tomando log-LRT y expandiendo $(r-s)^2=r^2-2rs+s^2$ (los $r^2$ se cancelan):

$$g=\sum_{n=0}^{L-1}r[n]\,s[n]\ \overset{H_1}{\underset{H_0}{\gtrless}}\ \gamma,\qquad \boxed{\gamma=\sigma^2\ln\frac{p_0}{p_1}+\frac{E}{2}},\quad E=\sum_{n=0}^{L-1}s^2[n]$$

- $g$ es una **correlación** entre lo recibido y la señal conocida: el detector de correlación.
- Con prioris iguales: $\gamma=E/2$ (punto medio entre las medias de $G$ bajo cada hipótesis).

### 13.2.2 Desempeño
Bajo cada hipótesis $G=\sum R[n]s[n]$ es gaussiana (combinación lineal de gaussianas), con la misma varianza:

| | $E[G]$ | $\operatorname{Var}(G)$ |
|---|---|---|
| $H_0$ | $0$ | $\sigma^2\sum s^2[n]=\sigma^2E$ |
| $H_1$ | $E$ | $\sigma^2E$ |

(Bajo $H_1$: $G=\sum(s+W)s=E+\sum W s$.)

Con $Q(x)=\frac1{\sqrt{2\pi}}\int_x^\infty e^{-u^2/2}du$:

$$P_{FA}=Q\!\left(\frac{\gamma}{\sigma\sqrt E}\right)=Q\!\left(\frac{\sigma\ln(p_0/p_1)}{\sqrt E}+\frac{\sqrt E}{2\sigma}\right),\qquad P_M=Q\!\left(\frac{E-\gamma}{\sigma\sqrt E}\right)$$

$$P_e=p_0P_{FA}+p_1P_M$$

Con prioris iguales: $P_e=Q\!\left(\dfrac{\sqrt E}{2\sigma}\right)$.

**Resultado clave:** el desempeño depende **solo de $E/\sigma^2$** (relación señal-ruido) y de las prioris, **no de la forma temporal de $s[n]$**. Dos señales distintas con igual energía rinden igual en ruido blanco gaussiano. Más energía o menos ruido ⇒ menor error.

### 13.2.3 Filtro adaptado (matched filter)
Calcular $g=\sum_k r[k]s[k]$ con un sistema LTI y **muestrear la salida en $n=0$**:

$$y[n]=\sum_k r[k]\,h[n-k]\ \Rightarrow\ y[0]=\sum_k r[k]\,h[-k]$$

Para que $y[0]=g$ se requiere $h[-k]=s[k]$:

$$\boxed{h[k]=s[-k]}\quad\text{(inversión temporal de la señal)}$$

(Si se quiere un filtro causal: $h[n]=s[L-1-n]$ y se muestrea en $n=L-1$.)

**Salida con entrada $s[n]$ sin ruido:**
$$y[n]=\sum_k s[k]\,s[k-n]=R_{ss}[n]$$
Es la **autocorrelación determinista** de $s$, con **pico $R_{ss}[0]=E$ en $n=0$** (por eso se muestrea ahí).

**Dominio de la frecuencia:** $H(e^{j\Omega})=S^*(e^{j\Omega})=|S(e^{j\Omega})|\,e^{-j\angle S(e^{j\Omega})}$
- **Magnitud $|S|$:** enfatiza las frecuencias donde la señal tiene más energía (y atenúa donde hay poca señal, mayormente ruido).
- **Fase $-\angle S$:** cancela la fase de la señal recibida ⇒ todas las componentes espectrales de la señal **suman constructivamente** en $n=0$.
- Resultado: **maximiza la SNR** en el instante de muestreo (por Cauchy-Schwarz). SNR de salida $=\dfrac{E^2}{\sigma^2E}=\dfrac{E}{\sigma^2}$.

---

# Fórmulas de repaso rápido

| Tema | Fórmula |
|---|---|
| Autocovarianza | $C_{XX}=R_{XX}-\mu_X(t_1)\mu_X(t_2)$ |
| WSS | $\mu$ constante y $R_{XX}$ depende solo de $\tau=t_1-t_2$ |
| Oscilador $\theta\sim U[-\pi,\pi]$ | $R_{XX}(\tau)=\frac{E[A^2]}{2}\cos(\omega_0\tau)$ |
| Bernoulli $\pm1$ | $C_{xx}[m]=4p(1-p)\delta[m]$ |
| Telegráfica | $R_{xx}(\tau)=e^{-2\lambda\lvert\tau\rvert}$ |
| Predictor media 0 | $a=R_{xx}[m]/R_{xx}[0]$ |
| PSD | $S_{xx}=\mathcal F\{R_{xx}\}$; $\frac1{2\pi}\int S_{xx}=E[x^2]$ |
| PSD con media | $S_{xx}=D_{xx}+2\pi\mu_x^2\delta(\omega)$ |
| LTI | $S_{yy}=\lvert H\rvert^2S_{xx}$ |
| Blanqueador | $\lvert H_w\rvert^2=\sigma_w^2/S_{xx}$ |
| Periodograma esperado | $S_{xx}$ suavizada por $\operatorname{sinc}^2$; resolución $\approx\pi/T$ |
| LMMSE vector | $\mathbf C_{XX}\mathbf a=\mathbf c_{XY}$; $\text{MMSE}=\sigma_Y^2-\mathbf c_{YX}^T\mathbf C_{XX}^{-1}\mathbf c_{XY}$ |
| LMMSE escalar | $\text{MMSE}=\sigma_Y^2(1-\rho^2)$, $\rho^2=\cos^2\theta$ |
| Wiener FIR | $\sum_j h[j]C_{xx}[i-j]=C_{yx}[i]$ |
| Yule-Walker (1 paso) | $\sum_j h[j]C_{xx}[i-j]=C_{xx}[i+1]$ |
| LRT | $\Lambda(\mathbf r)\gtrless p_0/p_1$ |
| Detector señal conocida | $g=\sum rs\gtrless\sigma^2\ln\frac{p_0}{p_1}+\frac E2$ |
| Desempeño | depende solo de $E/\sigma^2$ |
| Filtro adaptado | $h[k]=s[-k]$; salida $R_{ss}[n]$, pico $E$ |

---

# Qué saber explicar o demostrar (preguntas típicas de teoría)

1. Definir proceso aleatorio, realización y ensamble; diferencia entre los ejemplos del libro.
2. Diferencia entre SSS y WSS; cuándo coinciden (gaussianos). Probar que el oscilador con fase uniforme es WSS.
3. Deducir $R_{xx}(\tau)=e^{-2\lambda|\tau|}$ para la telegráfica.
4. Enunciar y aplicar el **principio de ortogonalidad**; deducir $\mathbf C_{XX}\mathbf a=\mathbf c_{XY}$ y $a=R_{xx}[m]/R_{xx}[0]$.
5. Propiedades de la PSD y su interpretación con un filtro pasa-banda.
6. Relación $S_{xx}$ vs. $D_{xx}$ y condición espectral de ergodicidad de la media.
7. Por qué el periodograma esperado es una PSD suavizada y qué limita la resolución.
8. Proceso blanco CT vs. DT; por qué el CT es una idealización.
9. Deducir $S_{yy}=|H|^2S_{xx}$ y el filtro blanqueador.
10. Interpretación geométrica del LMMSE ($\rho^2=\cos^2\theta$).
11. Estructura del Wiener FIR (restar/sumar medias), matriz Toeplitz, ecuaciones de Yule-Walker, casos exponencial y de alcance limitado.
12. Deducir la regla MAP/LRT con Bayes; efecto de usar bien o mal múltiples mediciones (Ej. 13.1).
13. Deducir $g=\sum rs$ y el umbral $\gamma$; distribuciones de $G$; $P_{FA}$, $P_M$ con $Q(\cdot)$; por qué solo importa $E/\sigma^2$.
14. Derivar $h[k]=s[-k]$; salida $R_{ss}[n]$; interpretación de magnitud y fase de $H=S^*$.
