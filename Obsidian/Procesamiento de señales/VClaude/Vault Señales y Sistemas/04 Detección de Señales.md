---
tags: [cap13, deteccion, filtro-adaptado, MAP, comunicaciones]
cap: 13
---
# 04 · Detección de Señales
← [[03 Estimación de Señales]] · [[00 Índice]] · Siguiente: [[05 Formulario]]

**Problema típico (radar, sonar, comunicaciones):** decidir si una forma de onda medida es **solo ruido** o contiene una **señal conocida** (o cuál de varias). Se parte de la regla MAP del Capítulo 9 extendida a **varias mediciones**. Con ruido gaussiano se obtiene mínima probabilidad de error; si solo se conocen 1.º y 2.º momentos, se maximiza una **SNR**.

## Prueba de hipótesis con múltiples mediciones
Vector $\mathbf r=(r_0..r_{L-1})$. Decidir con **mínima $P(\text{error})$** ⇒ elegir la hipótesis de mayor probabilidad a posteriori:
$$p(H_1)f_{R|H}(\mathbf r|H_1)\ \underset{H_0}{\overset{H_1}{\gtrless}}\ p(H_0)f_{R|H}(\mathbf r|H_0)\quad\Longleftrightarrow\quad \frac{f(\mathbf r|H_1)}{f(\mathbf r|H_0)}\gtrless\eta=\frac{p_0}{p_1}$$
(razón de verosimilitud; con otros criterios —Neyman–Pearson, riesgo mínimo— cambia solo el umbral $\eta$). Para $M$ hipótesis: elegir la que maximice $p(H_i)f(\mathbf r|H_i)$. Las regiones de decisión viven ahora en $\mathbb R^L$.

> [!example] Ejemplo 13.1: dos mediciones son mejores que una
> $P(H_0)=\tfrac34$, $P(H_1)=\tfrac14$. $X|H_0\sim U(-2,2)$ (densidad ¼), $X|H_1\sim U(-1,1)$ (densidad ½).
> - Con **una** medición: $\tfrac14\cdot\tfrac12=\tfrac18<\tfrac34\cdot\tfrac14=\tfrac3{16}$ ⇒ se declara siempre $H_0$: $P_{FA}=P_D=0$, $P_e=\tfrac14$.
> - Con **dos** independientes: las densidades conjuntas valen $\tfrac14$ (bajo $H_1$, en $|x_1|,|x_2|<1$) y $\tfrac1{16}$ (bajo $H_0$, en $|x_1|,|x_2|<2$). En el cuadrado chico: $\tfrac14\cdot\tfrac14=\tfrac1{16}>\tfrac34\cdot\tfrac1{16}=\tfrac3{64}$ ⇒ se declara $H_1$; en el resto del cuadrado grande solo $H_0$ tiene densidad ⇒ $H_0$. Resulta $P_{FA}=\tfrac14$, $P_D=1$ ⇒ $P_e=p_0P_{FA}=\tfrac3{16}<\tfrac14$.
> Un uso *no óptimo* (p. ej. promediar $x_1,x_2$) puede dar el mismo mal desempeño que una sola medición.

Relación con falsa alarma / pérdida: $P_{FA}=P(\text{'}H_1\text{'}|H_0)$, $P_M=P(\text{'}H_0\text{'}|H_1)=1-P_D$, $\;P_e=p_0P_{FA}+p_1P_M$.

## Señal conocida en ruido gaussiano i.i.d.
$$H_0:R[n]=W[n],\qquad H_1:R[n]=s[n]+W[n],\qquad n=0..L-1,\ W\sim\mathcal N(0,\sigma^2)\text{ i.i.d.}$$
Tomando logaritmo de la regla MAP (las exponenciales son $e^{-\sum r^2/2\sigma^2}$ y $e^{-\sum(r-s)^2/2\sigma^2}$):
$$\boxed{g=\sum_{n=0}^{L-1}r[n]s[n]\ \underset{H_0}{\overset{H_1}{\gtrless}}\ \gamma=\sigma^2\ln\frac{p_0}{p_1}+\frac{E}{2}},\qquad E=\sum s^2[n]$$
Con $p_0=p_1$: $\gamma=E/2$ (a mitad de camino entre las medias). Si $H_0$ es más probable, $\gamma$ sube. Si $s<0$ en el caso $L=1$, se intercambian $H_0$ y $H_1$ en la desigualdad.

### Rendimiento
$G=\sum W[n]s[n]$ es gaussiana (combinación lineal de gaussianas independientes):
- Bajo $H_0$: $G\sim\mathcal N(0,\sigma^2E)$. Bajo $H_1$: $G\sim\mathcal N(E,\sigma^2E)$. **Misma varianza**, medias separadas por $E$.
- $Q(x)=\frac1{\sqrt{2\pi}}\int_x^\infty e^{-v^2/2}dv$, $Q(-x)=1-Q(x)$; cotas $\frac{1}{\sqrt{2\pi}}\frac{x}{1+x^2}e^{-x^2/2}<Q(x)<\frac1{\sqrt{2\pi}\,x}e^{-x^2/2}$.
$$P_{FA}=Q\!\left(\frac{\gamma}{\sigma\sqrt E}\right)=Q\!\left(\frac{\sigma\ln(p_0/p_1)}{\sqrt E}+\frac{\sqrt E}{2\sigma}\right),\qquad P_M=Q\!\left(\frac{\sqrt E}{2\sigma}-\frac{\sigma\ln(p_0/p_1)}{\sqrt E}\right)$$
$$P_e=p_0P_{FA}+p_1P_M;\qquad p_0=p_1:\ \ P_{FA}=P_M=P_e=Q\!\left(\frac{\sqrt E}{2\sigma}\right)<\frac{1}{\sqrt{2\pi}}\frac{e^{-E/(8\sigma^2)}}{\sqrt E/(2\sigma)}$$
> [!important] Solo importan la **energía** $E$ y los a priori
> $P_e$ depende de la SNR $E/\sigma^2$ y de $p_0/p_1$, **no de la forma** de $s[n]$ (en ruido blanco). Decae algo más rápido que exponencialmente con la SNR. Esto cambia en ruido de color.

## Filtro adaptado
$g=\sum r[k]s[k]=\big(r*h\big)[0]$ si $h[-k]=s[k]$, es decir
$$h[n]=s[-n]\qquad\Longleftrightarrow\qquad H(e^{j\Omega})=S(e^{-j\Omega})=|S(e^{j\Omega})|e^{-j\angle S(e^{j\Omega})}$$
- Detector óptimo: $r[n]\to h\to$ muestrear en $n=0\to$ comparar con $\gamma$.
- Para hacerlo **causal**: $h[n]=s[D-n]$ (retardo) y muestrear en $n=D$.
- **Escalar** $h$ por $K>0$ ⇒ escalar $\gamma$ por $K$; el desempeño no cambia.
- **Propiedades:** 
  - Con entrada $s[n]$ (sin ruido) la salida es la autocorrelación determinista $R_{ss}[n]$ con pico $R_{ss}[0]=E$ ⇒ **el mejor instante de muestreo es $n=0$** (la contribución del ruido no depende del instante).
  - En frecuencia: $|H|=|S|$ (acentúa donde la señal tiene energía; el ruido blanco es plano) y la **fase $-\angle S$ alinea** todos los componentes para sumarlos constructivamente en $n=0$.

## Extensiones del filtro adaptado
### Señales de duración infinita y energía finita
Si $s\in\ell^2$ la solución sigue siendo el filtro adaptado (puede no admitir implementación causal con retardo finito).

### Ruido blanco no gaussiano: maximizar la SNR
Si el ruido solo se sabe blanco (media 0, intensidad $\sigma^2$) no hay MAP, pero conservando la estructura "filtro LTI → muestreo → umbral": $g[0]=\sum r[n]h[-n]$ tiene media $0$ bajo $H_0$, $\mu=\sum s[n]h[-n]$ bajo $H_1$ y varianza $\sigma^2\sum h^2[-n]$:
$$\mathrm{SNR}_{out}=\frac{\mu^2}{\sigma_g^2}=\frac{\big(\sum s[n]h[-n]\big)^2}{\sigma^2\sum h^2[-n]}\ \overset{\text{Cauchy–Schwarz}}{\le}\ \frac{E}{\sigma^2}=\mathrm{SNR}_{in}$$
Igualdad ⇔ $h[-n]=Ks[n]$: **el filtro adaptado maximiza la SNR** de la muestra. (Solo en el caso gaussiano además minimiza $P_e$.) Umbral razonable: $\mu/2$.

> [!note] Cauchy–Schwarz (en $\ell^2$)
> $\big(\sum xy\big)^2\le\big(\sum x^2\big)\big(\sum y^2\big)$, con igualdad ⇔ $y=Kx$. Prueba: $\sum(\alpha x-y)^2\ge0\ \forall\alpha$ ⇒ discriminante $b^2\le4ac$.

### Ruido de color
Ruido $v[n]$ WSS media cero con FSD $D_{vv}=\sigma^2M(e^{j\Omega})M(e^{-j\Omega})$ ([[02 Densidad Espectral de Potencia#Filtros de modelado y de blanqueo|filtro de modelado]]; $D_{vv}\ne0$ en todo $\Omega$). Transformación **reversible** al caso blanco: $r=s+v$ equivale a $q=p+w$ con $w$ blanco y $p=s*(1/M)$ (señal **preblanqueada**). El filtro adaptado a $p$ aplicado a $q$ es la cascada $M\cdot H$ ⇒
$$\boxed{H(e^{j\Omega})=\frac{S(e^{-j\Omega})}{M(e^{j\Omega})M(e^{-j\Omega})}=\frac{S(e^{-j\Omega})}{D_{vv}(e^{j\Omega})/\sigma^2}}$$
- Gaussiano ⇒ mínima $P_e$; solo blanco ⇒ máxima SNR.
- **Desempeño**: razón energía/ruido de la señal preblanqueada
$$\frac{E_p}{\sigma^2}=\frac1{2\pi}\int_{-\pi}^{\pi}\frac{|S(e^{j\Omega})|^2}{D_{vv}(e^{j\Omega})}\,d\Omega\qquad(=E/\sigma^2\text{ si }D_{vv}=\sigma^2)$$
 ⇒ **la forma de $s[n]$ ahora sí importa**: conviene concentrar su energía donde el ruido es débil (sujeto a restricciones de amplitud pico y duración).

### Filtros adaptados en tiempo continuo
Con $D_{vv}(j\omega)$ y energía finita $s(t)$: media bajo $H_1$ $\frac1{2\pi}\int SH\,d\omega$, varianza $\frac1{2\pi}\int|H|^2D_{vv}\,d\omega$,
$$H(j\omega)=\frac{S(-j\omega)}{D_{vv}(j\omega)/\sigma^2},\qquad \mathrm{SNR}_{out}=\frac1{2\pi}\int\frac{|S(j\omega)|^2}{D_{vv}(j\omega)}\,d\omega$$
($\sigma^2$ es un parámetro arbitrario que se tiene en cuenta al fijar $\gamma$.) El ruido blanco CT es una idealización difícil; por eso el desarrollo se hizo en DT.

### Filtro adaptado y pulsos de Nyquist
Con ruido blanco aditivo y pulso transmitido $P(j\omega)$ por canal $H_c$: el receptor óptimo es $H_c(-j\omega)P(-j\omega)$ y la respuesta total es $|P|^2|H_c|^2$. Para **ISI cero** esto debe cumplir Nyquist ⇒ si $|H_c|$ es constante en la banda, $|P(j\omega)|^2$ debe satisfacer Nyquist (réplicas a $2\pi/T$ suman constante). La **conformación del pulso se reparte por igual** entre transmisor y receptor.

### Tiempo de llegada desconocido y compresión de pulsos (radar/sonar)
Con eco $\alpha\,s[n-D]$: la salida del adaptado es $\alpha R_{ss}[k-D]$, con **pico en $k=D$** ⇒ el instante del máximo estima el retardo (distancia = retardo × velocidad / 2). Dificultades: $D$ y $\alpha$ desconocidos (⇒ tiempo de muestreo y umbral desconocidos), y con potencia pico limitada solo se gana energía alargando el pulso (peor resolución entre dos ecos próximos).
- **Compresión de pulsos:** diseñar $s[n]$ largo con $R_{ss}[k]\ll E$ para $k\ne0$ ⇒ autocorrelación casi un impulso: buena detección + buena resolución.
- **Barker‑13:** $+A,+A,+A,+A,+A,-A,-A,+A,+A,-A,+A,-A,+A$ (extendida con ceros a ambos lados): la autocorrelación determinista vale $13A^2$ en el retardo 0 y en los demás retardos su magnitud es mínima (el texto la da como $A$ o $0$, frente a $13A^2$ en el pico).
- **Chirp:** frecuencia barrida linealmente; segmentos de distinta frecuencia ⇒ autocorrelación pequeña fuera de un segmento.

## Discriminación de señales en ruido gaussiano i.i.d.
$H_i:R[n]=s_i[n]+W[n]$, $i=0..M-1$ (ej.: símbolos digitales mapeados a señales distintas). MAP ⇒ elegir el $i$ que maximice
$$\sum_n r[n]s_i[n]+\sigma^2\ln P(H_i)-\frac{E_i}{2}\qquad\Big(\text{con energías y a priori iguales: } g_i=\sum_n r[n]s_i[n]\Big)$$
Se implementa con **un banco de filtros adaptados**, uno por señal, muestreados en el instante apropiado.

### Caso binario
$$g=\sum r[n]\,(s_1[n]-s_0[n])\ \gtrless\ \sigma^2\ln\frac{p_0}{p_1}+\frac{E_1-E_0}{2}=\gamma$$
= detección de la **señal diferencia** (filtro adaptado a $s_1-s_0$). Sea $X=\sum s_0s_1$, $-\sqrt{E_0E_1}\le X\le\sqrt{E_0E_1}$. Bajo $H_0$, $G\sim\mathcal N(-E_0+X,\sigma^2E_d)$; bajo $H_1$, $G\sim\mathcal N(E_1-X,\sigma^2E_d)$, con $E_d=E_1+E_0-2X$.
- **Energías iguales ($E$) y $p_0=p_1$**: $\gamma=0$, 
$$P_e=Q\!\left(\frac{E-X}{\sigma\sqrt{E_d}}\right)=Q\!\left(\frac{\sqrt{E-X}}{\sigma\sqrt2}\right)$$ 
 Se minimiza con $X=-E$, es decir $s_1=-s_0$ (**antipodal**).

| Señalización | Señales | Prob. de error ($p_0=p_1$) |
|---|---|---|
| **On‑off** | $s_0=0,\ s_1=s$ | $Q\!\left(\dfrac{\sqrt E}{2\sigma}\right)$ |
| **Antipodal** | $s_1=-s_0$, energía $E$ cada una | $Q\!\left(\dfrac{\sqrt E}{\sigma}\right)$ |

La antipodal **duplica la distancia entre medias** ⇒ el argumento de $Q$ se duplica (SNR efectiva ×4). Misma potencia *pico* que on‑off, pero energía promedio por bit duplicada (con $p_0=p_1=\tfrac12$).

> [!example] Ejemplo 13.3: PAM on‑off vs. antipodal con filtro adaptado
> $x(t)=\sum a[n]p(t-nT)$, $p$ rectangular de amplitud $A$ y ancho $T/2$; $\sigma=3.5$; 13 bits; pulso de 50 muestras (energía $=50A^2$ con $A=1$). El filtro adaptado es una **integración "boxcar"** de ventana $T/2$ muestreada cada $T$.
>
> | | Sin filtro adaptado | Con filtro adaptado |
> |---|---|---|
> | On‑off | $Q(A/2\sigma)=0.443$ | $Q(\sqrt{50}/(2\cdot3.5))=0.156$ |
> | Antipodal | $Q(A/\sigma)=0.388$ | $Q(\sqrt{50}/3.5)=0.022$ |
>
> Errores esperados en 13 bits (binomial): 5.76 (±1.79), 5.03 (±1.76), **2.03 (±1.31)** (observado: 2), **0.28 (±0.53)** (observado: 0). Se ven las dos mejoras: *filtro adaptado* (promedia el ruido) y *señalización antipodal*.

Conexión con los capítulos anteriores: el filtro adaptado en ruido de color usa **el mismo blanqueo** que el Wiener causal ([[03 Estimación de Señales#Filtro de Wiener causal]]); ver [[06 Conexiones entre temas]].
