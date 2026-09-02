### Forma 1

```
close all;
clear all;
clc
%Defino las constantes
syms s R L J B Ki Ka Kb W V I real
%Defino las ecuaciones
eq1 = V == R*I + L*s*I + Kb*W
eq2 = J*s*W == Ki*I - B*W
%Resolver las ecuaciones
S = solve(eq1,eq2,W,V)
G = S.W/S.V
G = simplify(G)
````
### Forma 2

```
close all;
clear all;
clc
%Defino las constantes
syms s R L J B Ki Ka Kb W V I real
%Defino las ecuaciones
I = (J*s*W+B*W)/Ki
V = collect(R*I+L*s*I+Kb*W,W)
G = simplify(W/V)
````

### Forma de mason
```` 
close all;
clear all;
clc
%Defino las constantes
syms s R L J B Kb Ki W V I real
%Parametros mason
M1 = 1/L * 1/s * Ki/J * 1/s;
L1 = -1/s * R/L;
L2 = -1/s*B/J;
L3 = -1/s * Ki/J * 1/s * Kb/L;
Det = 1 -(L1+L2+L3) + (L1*L2)
Det1 = 1;
Gmason = M1*Det1 / Det;
Gmason = simplify(Gmason)

````

