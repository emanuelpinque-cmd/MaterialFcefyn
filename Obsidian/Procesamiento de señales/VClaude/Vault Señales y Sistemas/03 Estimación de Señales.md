---
tags: [cap12, LMMSE, Wiener, Kalman, estimacion]
cap: 12
---
# 03 · Estimación de Señales (Wiener y Kalman)
← [[02 Densidad Espectral de Potencia]] · [[00 Índice]] · Siguiente: [[04 Detección de Señales]]

**Problema:** estimar un proceso $y$ a partir de mediciones de otro proceso $x$, ambos **conjuntamente WSS**, con el estimador lineal de error cuadrático medio mínimo (**LMMSE**). Solo hacen falta **medias, autocovarianzas y covarianza cruzada**. Esto es el **filtrado de Wiener** (Wiener resolvió la versión causal en los '40). Kalman (años '60) lo extendió a procesos no estacionarios con modelos de espacio de estado.

## Base: LMMSE para variables aleatorias
Estimar $Y$ desde $\mathbf X=(X_1..X_L)^T$:
$$\hat Y=\mu_Y+\mathbf a^T(\mathbf X-\boldsymbol\mu_X)=\mu_Y+\mathbf c_{XY}^T C_{XX}^{-1}(\mathbf X-\boldsymbol\mu_X),\qquad C_{XX}\mathbf a=\mathbf c_{XY}$$
- **Insesgado** ($E[\hat Y]=\mu_Y$) y **error ortogonal a los datos**: $E[(Y-\hat Y)X_i]=0$ (⇒ ecuaciones normales).
- **MMSE** $=E[(Y-\hat Y)Y]=\sigma_Y^2-\mathbf c^T_{XY}C_{XX}^{-1}\mathbf c_{XY}=\sigma_Y^2(1-\rho_{XY}^2)$, con $\rho_{XY}^2$ = cuadrado del coseno del ángulo entre $Y$ y el subespacio generado por las $X_i$.
- Para procesos WSS, solo importan los tiempos **relativos**: el mismo filtro es óptimo para todo $n$.

## Filtro de Wiener FIR
Estimador $\hat y[n]=\mu_y+\sum_{j=0}^{L-1}h[j](x[n-j]-\mu_x)$. Las ecuaciones normales usan $C_{xx}[i-j]$ y $C_{xy}[i-1]$ (matriz **simétrica de Toeplitz**).

> [!example] Señal en ruido aditivo (FIR)
> $x[n]=2y[n]+v[n]$, $v$ blanco $\perp y$, $\mu_y=1$, $C_{yy}[m]=0.3^{|m|}$. Entonces $\mu_x=2$, $C_{xx}=4\cdot0.3^{|m|}+\sigma^2\delta[m]$, $C_{xy}=2\cdot0.3^{|m|}$.
> - Sin ruido ($\sigma^2=0$): $h=[\tfrac12,0,0]$ ⇒ $\hat y=x/2$ ✓.
> - Ruido alto ($\sigma^2\gg1$): $h\approx0$ ⇒ $\hat y\approx\mu_y$ ✓ (sin información, la mejor estimación es la media).
> Implementación: restar $\mu_x$ → filtro $h$ → sumar $\mu_y$. Variaciones: ventana **no causal** $[n-L,n+L]$ (estimar el centro), o **predicción**.

### Predicción FIR de un paso ($y[n]=x[n+1]$): ecuaciones de Yule–Walker
$$\begin{bmatrix}C_{xx}[0]&C_{xx}[1]&\cdots\\C_{xx}[1]&C_{xx}[0]&\cdots\\\vdots&&\ddots\end{bmatrix}\mathbf h=\begin{bmatrix}C_{xx}[1]\\C_{xx}[2]\\\vdots\\C_{xx}[L]\end{bmatrix}$$

| Caso | $C_{xx}[m]$ | Resultado |
|---|---|---|
| **Geométricamente correlacionado** | $C_0\rho^{\lvert m\rvert}$ | $h[0]=\rho$, resto 0 ⇒ $\hat x[n+1]=\mu_x+\rho(x[n]-\mu_x)$; **solo importa la última medición**. MMSE $=C_0(1-\rho^2)$ |
| **Próximamente correlacionado** (en banda) | $C_0(\rho\delta[m+1]+\delta[m]+\rho\delta[m-1])$, $\lvert\rho\rvert\le0.5$ | con $L=3$: $h[0]=\frac{\rho(1-\rho^2)}{1-2\rho^2}$, $h[1]=-\frac{\rho^2}{1-2\rho^2}$, $h[2]=\frac{\rho^3}{1-2\rho^2}$; MMSE $=C_0\!\left(1-\frac{\rho^2(1-\rho^2)}{1-2\rho^2}\right)$ |

Con $\rho=0.5$, $C_0=1$: $h=[0.75,-0.5,0.25]$, MMSE $=0.625$ (con una sola medición: $0.75$, mejora del 16.7 % en varianza). Los estimados son "atraídos" hacia $\mu_x$; ese efecto disminuye al aumentar $L$.

## Filtro de Wiener no restringido
Se usan **todos** los valores $x[k]$, $-\infty<k<\infty$: $\hat y[n]=\mu_y+\sum_{j=-\infty}^{\infty}h[j](x[n-j]-\mu_x)$.
- Ortogonalidad ⇒ $C_{\hat y x}[m]=C_{yx}[m]$ para **todo** $m$, y como $C_{\hat yx}=h*C_{xx}$:
$$h[m]*C_{xx}[m]=C_{yx}[m]\ \ \Longrightarrow\ \ \boxed{H(e^{j\Omega})=\frac{D_{yx}(e^{j\Omega})}{D_{xx}(e^{j\Omega})}}$$
(donde $D_{xx}=0$ la elección es irrelevante: no hay señal medida ahí; también $D_{yx}=0$ por la [[02 Densidad Espectral de Potencia#Densidad espectral cruzada y desigualdad fundamental|desigualdad fundamental]].)
- Estructura: $x\to(-\mu_x)\to H\to(+\mu_y)\to\hat y$.
- **Error** $e=y-\hat y$: $C_{ee}[m]=C_{yy}[m]-(h*C_{xy})[m]$, 
$$D_{ee}=D_{yy}\big(1-|\rho_{yx}|^2\big),\quad \rho_{yx}(e^{j\Omega})=\frac{D_{yx}}{\sqrt{D_{yy}D_{xx}}}\ \ (\text{**coherencia**}),\qquad \mathrm{MMSE}=\frac1{2\pi}\int_{-\pi}^{\pi}D_{yy}(1-|\rho_{yx}|^2)\,d\Omega$$
Cuanto más cerca de 1 esté $|\rho_{yx}|$ en una banda, mejor se estima $y$ en esa banda. Es el $\sigma_Y^2(1-\rho^2)$ de las VA, **frecuencia por frecuencia**.

### Ejemplos
- **Predicción no causal** $y[n]=x[n+n_0]$: $H=e^{j\Omega n_0}$, $h[n]=\delta[n+n_0]$, MMSE $=0$.
- **Señal en ruido** ($x=2y+v$, $v\perp y$): 
$$H(e^{j\Omega})=\frac{2D_{yy}}{4D_{yy}+D_{vv}}$$
 No causal (respuesta real y par). Donde la señal domina ⇒ $H\approx\tfrac12$ (invertir la escala); donde domina el ruido ⇒ $H\approx0$. Con $D_{yy}=2(1+\cos\Omega)$ y ruido blanco $\sigma^2=4$, $H$ es pasabajos. MMSE $=\frac1{2\pi}\int\frac{D_{yy}D_{vv}}{4D_{yy}+D_{vv}}d\Omega$ (≈ $C_{vv}[0]/4$ con poco ruido; ≈ $C_{yy}[0]$ con mucho).
- **Deconvolución / desborronado:** $r=g*y$ (sensor $G$), medimos $x=r+v$:
$$H=\frac{G(e^{-j\Omega})D_{yy}}{G(e^{j\Omega})G(e^{-j\Omega})D_{yy}+D_{vv}}=\frac1{G}\cdot\frac{D_{rr}}{D_{rr}+D_{vv}}$$
 = (Wiener que estima $r$ desde $x$) seguido del **filtro inverso $1/G$**. ⚠️ Solo el inverso puro amplifica el ruido donde $|G|$ es pequeño. Con $D_{vv}\to0$ se recupera $1/G$; con ruido blanco dominante $H\approx\frac{D_{rr}}{G\,\sigma_v^2}$.
- **Desmultiplicación (canal de desvanecimiento):** $r=f\cdot s$ con $f\perp s$ WSS: $C_{rr}=C_{ff}C_{ss}+\mu_f^2C_{ss}+\mu_s^2C_{ff}$ ⇒ $D_{rr}=\tfrac1{2\pi}D_{ff}\circledast D_{ss}+\mu_f^2D_{ss}+\mu_s^2D_{ff}$ (convolución periódica), $C_{sr}=\mu_fC_{ss}$ ⇒ $H=\dfrac{D_{ss}\mu_f}{D_{rr}}$. Si $f$ fijo en $\mu_f$ ⇒ $H=1/\mu_f$ ✓.

## Filtro de Wiener causal
Restricción $h[j]=0$ para $j<0$. Las igualdades de ortogonalidad valen **solo para $m\ge0$** ⇒ no se puede pasar directo a frecuencia. 
- Caso fácil: $x$ **blanco** ($C_{xx}=\sigma_x^2\delta$): $h[m]=\frac1{\sigma_x^2}C_{yx}[m]$ para $m\ge0$, 0 si no.
- Caso general: **blanquear primero** con factor espectral de fase mínima (Paley–Wiener garantiza existencia si $\int|\log D_{xx}|<\infty$):
$$D_{xx}(z)=F(z)F(z^{-1}),\quad F\text{ estable, causal, con inverso estable y causal (polos y ceros en }|z|<1)$$
Convolucionando con el inverso anticausal $g$ de $f^*$ y quedándose con $m\ge0$:
$$\boxed{H(z)=\frac1{F(z)}\left[\frac{D_{yx}(z)}{F(z^{-1})}\right]_+}$$
donde $[\cdot]_+$ = parte **causal** (inc. $n=0$).
- **MMSE** $=\frac1{2\pi}\int\big(D_{yy}-HD_{xy}-H^*D_{yx}+|H|^2D_{xx}\big)d\Omega$; excede al no restringido en 
$$\Delta\mathrm{MMSE}=\frac1{2\pi}\int_{-\pi}^{\pi}\left|\left[\frac{D_{yx}}{F(e^{-j\Omega})}\right]_-\right|^2d\Omega\quad(\text{"precio de la causalidad"})$$
con $[\cdot]_-$ = parte estrictamente anticausal.

### Predictor de Wiener causal de un paso
$x[n]$ = salida de $F(z)=\alpha_0+\alpha_1z^{-1}$ con blanco unitario, $y[n]=x[n+1]$. Con $|\alpha_1|<|\alpha_0|$ ($F$ de fase mínima): $D_{yx}=zF(z)F(z^{-1})$ ⇒ $[\,zF(z)\,]_+=\alpha_1$ y
$$H(z)=\frac{\alpha_1}{\alpha_0+\alpha_1z^{-1}},\qquad \mathrm{MMSE}=\alpha_0^2$$
Comparación (con $|\alpha_1|\approx|\alpha_0|=\alpha$): usar solo la media: $2\alpha^2$; una medición: $1.5\alpha^2$; **predictor causal completo: $\alpha^2$** (−⅓). La $H$ ideal en $\rho=0.5$ tendría un polo en $|z|=1$ (marginalmente estable) → se aproxima con $1/(1+0.99z^{-1})$.
- Si $|\alpha_1|>|\alpha_0|$ el cero está fuera del círculo: se corrige multiplicando por un pasa-todo, $\tilde F=\alpha_1+\alpha_0z^{-1}$ (cero reflejado a su recíproco).

> [!tip] Interpretación del predictor
> Con $x=f*w$ ($w$ blanco unitario) y $F(\infty)=f_0$: $x[n+1]=f_0w[n+1]+\sum_{j\le n}f_{n-j+1}w[j]$. Las $w[j]$, $j\le n$, son **conocidas** (por la invertibilidad causal) y no correlacionadas con $w[n+1]$ ⇒
> $$\hat x[n+1]=\sum_{j\le n}f_{n-j+1}w[j],\qquad \mathrm{MMSE}=f_0^2=[F(\infty)]^2,\qquad H(z)=\frac{[zF(z)]_+}{F(z)}$$

## Observadores óptimos y filtrado de Kalman
Problema: $x[n]=y[n]+v[n]$ con $y=c^Tq$, 
$$q[n+1]=Aq[n]+b\,w[n],\quad y[n]=c^Tq[n],\quad G(z)=c^T(zI-A)^{-1}b=\frac{\eta(z)}{a(z)}$$
($w$ blanco de intensidad $\sigma_w^2$, $v$ blanco de intensidad $\sigma_v^2$, $w\perp v$; $a(z)=\det(zI-A)$ de grado $L$; sistema estable, alcanzable y observable; desde $-\infty$.) Con $r=\sigma_w^2/\sigma_v^2$:

1. **Factorización espectral:** $\nu(z)\nu(z^{-1})=r\,\eta(z)\eta(z^{-1})+a(z)a(z^{-1})$, con $\nu$ mónico de grado $L$ y raíces en $|z|<1$. Sin raíces en la circunferencia unidad por no haber factores comunes entre $\eta$ y $a$.
2. $D_{xx}=\sigma_v^2\frac{\nu(z)\nu(z^{-1})}{a(z)a(z^{-1})}$ ⇒ $F=\sigma_v\frac{\nu}{a}$ y $D_{yx}=D_{yy}$.
3. **Filtro de Wiener causal:**
$$\boxed{H(z)=1-\frac{a(z)}{\nu(z)}=\frac{\nu(z)-a(z)}{\nu(z)}}$$
4. **Implementación como observador:** $\hat q[n+1]=(A+\ell c^T)\hat q[n]-\ell x[n]$, $\hat y=c^T\hat q$. Elegir la ganancia $\boldsymbol\ell$ para que $\det(zI-A-\ell c^T)=\nu(z)$ (posible por observabilidad). El numerador resulta $\nu-a$ (argumento: realimentar con ganancia unitaria $x=\hat y+p$ cambia el denominador a $\nu-(\text{num})=a$).
5. Resultado: $\hat y$ es el **estimado LMMSE causal**. Además $\hat q$ es el estimado LMMSE causal del **estado** (el estado está completamente excitado y reflejado en la salida).

**Kalman:** modelo general (variante en el tiempo, incluso inestable, múltiples entradas/salidas, sin WSS). La factorización espectral se reemplaza por una **ecuación de Riccati** que propaga la covarianza del error de estimación (con ruido gaussiano). El observador con ganancia constante es el caso estacionario.

## Resumen CT
$$H(j\omega)=\frac{D_{yx}}{D_{xx}}\ \ (\text{no restr.}),\quad \mathrm{MMSE}=\tfrac1{2\pi}\!\int\!\Big(D_{yy}-\tfrac{|D_{yx}|^2}{D_{xx}}\Big)d\omega;\quad H(j\omega)=\frac1{F}\Big[\frac{D_{yx}}{F(-j\omega)}\Big]_+\ (\text{causal});\quad H(s)=\frac1{F(s)}\big[e^{sT}F(s)\big]_+\ (\text{predicción a }T)$$

Aplicación a **detección** (misma idea de blanquear + filtro adaptado): [[04 Detección de Señales#Ruido de color]].
