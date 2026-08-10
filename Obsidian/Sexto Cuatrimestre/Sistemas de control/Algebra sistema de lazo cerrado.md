![[Pasted image 20260630040745.png]]

Pasos:
1. Escribir B(s) 
	sabemos que B(s) surge de aplicarle una función de transferencia
	a C(s) la funcion de transferencia es H(s) entonces
	B(s)=C(s)H(s)
2. Escribir C(s) 
	sabemos que C(s) también es una función de transferencia G(s) aplicada a a E(s) es decir
	C(s)=E(s)G(s)
3. Reemplazar 2 en 1
	haciendo un pequeño despeje C(s) = B(s) / H(s)
	llegamos a que B(s)/H(s) = E(s)G(s)
	o tambien  
	
	- función de trasferencia en Zuzo abierto
		B(s)/E(s) = G(s)H(s)
	- El coeficiente entre entre la salida C(s) y la señal de error se denomina function de trayectoria directa por lo que:
		C(S) / E(S) = G(s)
	- Si la función de transferencia de la trayectoria de re-alimentacion H(s) es la unidad la funcion de transferencia de lazo abierto y la función de trasferencia de trayectoria 

Después de obtener todo esto sabemos también que:
	C(s) = G(s)E(s)
	E(s) = R(s) - B(s)
- en la ecuación 2 sabemos que B(s)=H(s)C(s)
	por lo que la nueva ecuación 2 queda
	E(s) = R(s) - H(s)C(s)
- reemplazando la ecuación E(s) en 1:
	C(s)=G(s)(R(s)-H(s)C(s))

Finalmente nos queda:
C(s) = G(s)(R(s) - H(s)C(s))

Ahora podemos seguir simplificándolo 
- distribuimos el parenthesis:
	C(s) = G(s)R(s) - G(s)H(s)C(s)
	C(s) + G(s)H(s)C(s) = G(s)R(s)
-  factorizando
	C(s)(1+H(s)G(s)) = G(s)R(s)
- finalmente
	C(S) / R(s) = G(s) / (1 + H(s)G(s))