---
tags: [conexiones, repaso]
---
# 06 · Conexiones entre temas
← [[00 Índice]]

## Un solo truco, muchos capítulos: **blanquear**
Casi todos los problemas difíciles se resuelven llevándolos al caso de **ruido blanco**, donde las cuentas son simples.

| Dónde | Qué se blanquea | Resultado |
|---|---|---|
| [[02 Densidad Espectral de Potencia#Filtros de modelado y de blanqueo]] | proceso coloreado $x$ | $\lvert H\rvert^2=\sigma_w^2/S_{xx}$ |
| [[03 Estimación de Señales#Filtro de Wiener causal]] | las mediciones, con $1/F$ | $H=\frac1F[\cdot]_+$ |
| [[04 Detección de Señales#Ruido de color]] | el ruido coloreado, con $1/M$ | $H=S(e^{-j\Omega})/(D_{vv}/\sigma^2)$ |

## Tabla de paralelos
| Idea | Variables aleatorias | Procesos WSS (en frecuencia) |
|---|---|---|
| Cota de correlación | $\sigma_{XY}^2\le\sigma_X^2\sigma_Y^2$ | $\lvert D_{yx}\rvert^2\le D_{xx}D_{yy}$ ([[02 Densidad Espectral de Potencia]]) |
| LMMSE | $\sigma_Y^2(1-\rho^2)$ | $D_{yy}(1-\lvert\rho_{yx}\rvert^2)$ ([[03 Estimación de Señales]]) |
| Desigualdad de Cauchy–Schwarz | $E[XY]^2\le E[X^2]E[Y^2]$ | SNR máxima del filtro adaptado ([[04 Detección de Señales]]) |
| Estimación vs detección | estimar valor continuo | decidir entre hipótesis discretas |
| Filtro de modelado | genera coloreado desde blanco | inverso del filtro de blanqueo |

## Estimación ↔ detección
- **Estimación (Cap. 12):** minimiza ECM; la solución usa solo 1.º y 2.º momentos; el análisis natural es $H=D_{yx}/D_{xx}$.
- **Detección (Cap. 13):** minimiza $P_e$; el caso gaussiano da soluciones exactas; si solo hay 1.º y 2.º momentos se maximiza la SNR.
- **Filtro adaptado** y **Wiener** son ambos "filtros que usan la forma de $S$ y del ruido": el adaptado usa $\lvert S\rvert/D_{vv}$, el Wiener usa $D_{yx}/D_{xx}$.

## Errores típicos
> [!warning] Cosas que se confunden
> 1. **Incorrelacionado ≠ correlación cero.** Incorrelacionado = covarianza cero. ([[01 Procesos Aleatorios]])
> 2. **SSS ⇒ WSS**, pero WSS ⇒ SSS solo en procesos gaussianos.
> 3. **Media cero** no implica "sin impulso en la PSD": $y=A+x$ con $A$ aleatoria de media cero tiene impulso en $\Omega=0$ y **no es ergódico en la media**.
> 4. $S_{xx}$ vs $D_{xx}$: difieren en $2\pi\mu^2\delta(\Omega)$. La **FSD** ($D$) es la que aparece en Wiener y ergodicidad de la media.
> 5. **Convención de $R_{xy}$**: aquí $R_{xy}(\tau)=E[x(t+\tau)y(t)]$ (otros textos lo invierten).
> 6. **Periodograma ≠ PSD**: un solo periodograma es muy ruidoso (varianza no baja con $T$); hay que promediar. Y su esperanza es la PSD *suavizada*.
> 7. En detección con ruido blanco **solo importa la energía** de $s$; con ruido de color **también la forma**.
> 8. Antipodal vs on‑off: misma amplitud pico, pero antipodal duplica el argumento de $Q$ (a costo de energía media doble).
> 9. Un filtro de blanqueo/modelado **no es único**: se puede multiplicar por cualquier pasa-todo; se elige el de **fase mínima** cuando se necesita causalidad e inverso causal.
> 10. Wiener causal: la igualdad $h*C_{xx}=C_{yx}$ vale **solo para $m\ge0$**; no se puede dividir directamente en frecuencia.
