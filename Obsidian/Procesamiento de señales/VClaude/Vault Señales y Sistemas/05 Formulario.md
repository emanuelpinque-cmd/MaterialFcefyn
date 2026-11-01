---
tags: [formulario, repaso]
---
# 05 · Formulario
← [[00 Índice]]

## Momentos y estacionariedad → [[01 Procesos Aleatorios]]
| Concepto | Fórmula |
|---|---|
| Covarianza | $C_{XX}(t_1,t_2)=R_{XX}(t_1,t_2)-\mu_X(t_1)\mu_X(t_2)$ |
| WSS | $\mu_X$ constante; $R_{XX}(t_1,t_2)=R_{XX}(t_1-t_2)$ |
| Simetrías | $R_{xx}(\tau)=R_{xx}(-\tau)$; $R_{xy}(\tau)=R_{yx}(-\tau)$ |
| Cota | $\lvert C_{xx}(\tau)\rvert\le C_{xx}(0)$ |
| Bernoulli ±1 | $\mu=2p-1$, $C[m]=4p(1-p)\delta[m]$ |
| Telegráfica | $R(\tau)=e^{-2\lambda\lvert\tau\rvert}$ |
| Sinusoide fase unif. | $R(\tau)=\tfrac{E[A^2]}2\cos\omega_0\tau$ |
| Ergodicidad media | $C_{xx}(\tau)\to0$ (suficiente); FSD sin impulso en 0 (nec. y suf.) |

## Sistemas LTI con entrada WSS
| | |
|---|---|
| $\mu_y$ | $H(j0)\mu_x$ |
| $R_{yx}$ | $h*R_{xx}$ |
| $R_{yy}$ | $R_{hh}*R_{xx}$, $R_{hh}=h(-\tau)*h(\tau)$ |
| $S_{yy}$ | $\lvert H\rvert^2S_{xx}$ ; $S_{yy}(z)=H(z)H(1/z)S_{xx}(z)$ |
| $S_{yx}$ | $H\,S_{xx}$ |

## Espectros → [[02 Densidad Espectral de Potencia]]
| | |
|---|---|
| PSD | $S_{xx}=\mathcal F\{R_{xx}\}\ge0$, $E[x^2]=\tfrac1{2\pi}\int S_{xx}$ |
| FSD | $D_{xx}=\mathcal F\{C_{xx}\}$; $S=D+2\pi\mu^2\delta$ |
| Exponencial | $e^{-\alpha\lvert\tau\rvert}\leftrightarrow\frac{2\alpha}{\omega^2+\alpha^2}$ |
| Un paso | $\sigma^2(1+2\rho\cos\Omega)$, $\lvert\rho\rvert\le\tfrac12$ |
| Cruzada | $\lvert D_{yx}\rvert^2\le D_{xx}D_{yy}$ |
| EWK | $S_{xx}=\lim E[\tfrac1{2T}\lvert X_T\rvert^2]$ |
| Resolución periodograma | $\approx\pi/T$; varianza ÷ $M$ al promediar |
| Modelado | $D_{xx}=\lvert H\rvert^2$ (factor espectral × pasa-todo) |
| Blanqueo | $\lvert H\rvert^2=\sigma_w^2/S_{xx}$ |
| Johnson–Nyquist | $S=2kTR$ |

## Estimación → [[03 Estimación de Señales]]
| | |
|---|---|
| LMMSE VA | $\hat Y=\mu_Y+\mathbf c_{XY}^TC_{XX}^{-1}(\mathbf X-\boldsymbol\mu_X)$ |
| MMSE | $\sigma_Y^2(1-\rho_{XY}^2)$ |
| Predicción 1 medición | $a=C_{xx}[m]/C_{xx}[0]$, $b=\mu_x(1-a)$ |
| Wiener FIR | $\sum_k h[k]C_{xx}[m-k]=C_{yx}[m]$ |
| Wiener no restringido | $H=D_{yx}/D_{xx}$, MMSE $=\tfrac1{2\pi}\int D_{yy}(1-\lvert\rho_{yx}\rvert^2)$ |
| Wiener causal | $H=\frac1F\big[\frac{D_{yx}}{F(z^{-1})}\big]_+$, $D_{xx}=F(z)F(z^{-1})$ |
| Precio causalidad | $\tfrac1{2\pi}\int\lvert[D_{yx}/F^*]_-\rvert^2$ |
| Predictor 1 paso | $H=[zF]_+/F$, MMSE $=f_0^2$ |
| Señal+ruido blanco, estado | $H=1-a/\nu$, $\nu\tilde\nu=r\eta\tilde\eta+a\tilde a$, $r=\sigma_w^2/\sigma_v^2$ |

## Detección → [[04 Detección de Señales]]
| | |
|---|---|
| MAP binaria | $\frac{f(r\mid H_1)}{f(r\mid H_0)}\gtrless\frac{p_0}{p_1}$ |
| Señal conocida, gauss. iid | $g=\sum rs\gtrless\sigma^2\ln\frac{p_0}{p_1}+\frac E2$ |
| Medias / varianza de $G$ | $0$ y $E$ ; $\sigma^2E$ |
| $P_{FA}$, $P_M$ | $Q\!\big(\frac{\gamma}{\sigma\sqrt E}\big)$ ; $Q\!\big(\frac{E-\gamma}{\sigma\sqrt E}\big)$ |
| $p_0=p_1$ | $P_e=Q\!\big(\frac{\sqrt E}{2\sigma}\big)$ |
| Filtro adaptado | $h[n]=s[-n]$, $H=S(e^{-j\Omega})$, salida $=R_{ss}$ |
| SNR máx. | $E/\sigma^2$ (Cauchy–Schwarz) |
| Ruido de color | $H=S(e^{-j\Omega})\big/\big(D_{vv}/\sigma^2\big)$, SNR $=\tfrac1{2\pi}\int\lvert S\rvert^2/D_{vv}$ |
| Discriminación | maximizar $\sum rs_i+\sigma^2\ln P(H_i)-E_i/2$ |
| On‑off / antipodal | $Q(\tfrac{\sqrt E}{2\sigma})$ / $Q(\tfrac{\sqrt E}{\sigma})$ |
