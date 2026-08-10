Apreciemos el siguiente Diagrama en el sacaremos varias conclusiones para poder simplificarlo
![[Pasted image 20260630034316.png]]
Primero definimos quienes son cada uno
- R(s):esta es la señal que colocamos "cruda" sin modificar nada

- B(s):la señal re-alimentada es la que sale por C(s) aplicada una function de tranferencia B(s)=C(s)H(s) esta señal es la que se le restara a la señal R(s) para dar origen a la señal error

- E(s): es simplemente la resta de la señal R(s) - B(s) a esta señal se le aplicara la función de transferencia G(s) para dar origen a C(s)

- C(s) la señal de salida es también aplicarle la función de transferencia a la señal error es decir C(s)=E(s)G(s)

Formulas de este sistema:


![[Pasted image 20260630084337.png]]

![[Pasted image 20260630084353.png]]

![[Pasted image 20260630084407.png]]

puede ver su deduccion en :

[[Algebra sistema de lazo cerrado]]

Regla en sistema de lazo cerrado

la regla practica es que si tenemos N sistemas acoplados la salida siempre sera la primera entrada de realimentada (G(s) en nuestro caso) por la señal de entrada sobre 1 + el producto de todos los bloques de realimentacion.
C(s) = G(s)R(s) / (1 + G(s)H(s)I(s)J(s)...) 