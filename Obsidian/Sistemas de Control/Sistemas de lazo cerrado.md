se mantiene una relacion pre-establecida entre la entrada y salida comparandolas y utilizando la diferencia como paramentro de control.

se ven de la siguente forma:

![[Pasted image 20260804090502.png]]

un ejemplo de esto imaginemos en un control de temperatura, la señal es el voltaje se compara con un op-amp luego este op-amp activa un transistor para encender una resistencia esta misma resistencia se convierte un voltaje con por ejemplo un lm35 para volver a ser realimentada.

en nuestra analogia:
señales
- R(s) señal de voltaje
- B(s) señal convertida de la salida en temperatura al voltaje
- E(s) la señal error que sale del opamp
- C(s) la señal de temperatura

componentes:
- restador:op-amp
- bloque G(s) seria el dispositivo que convierte tension en temperatura es decir el transistor y resistencia
- bloque H(s) el lm35

atravez del control alimentado se busca reducir [[Perturbaciones]] de un sistema.

