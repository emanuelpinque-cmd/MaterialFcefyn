# Expresiones Regulares

## Definición
### Una expresión regular es una notación compacta para describir un **lenguaje de tipo 3 (regular)**, usando operaciones sobre símbolos del alfabeto.
- Todo lenguaje regular puede describirse con una expresión regular y, recíprocamente, toda expresión regular describe un lenguaje regular (reconocible por un [[Automatas Finitos|autómata finito]]).

---

## Operaciones básicas

| Operación | Notación | Significado |
|---|---|---|
| Concatenación | $\alpha\beta$ | Una cadena de $\alpha$ seguida de una cadena de $\beta$ |
| Unión (alternancia) | $\alpha \vert \beta$  ó  $\alpha + \beta$ | Una cadena de $\alpha$ **o** una cadena de $\beta$ |
| Clausura de Kleene | $\alpha^*$ | Cero o más repeticiones de $\alpha$ (incluye $\lambda$) |
| Clausura positiva | $\alpha^+$ | Una o más repeticiones de $\alpha$ (no incluye $\lambda$ salvo que $\alpha$ ya la contenga) |

- Se cumple: $\alpha^* = \alpha^+ \cup \{\lambda\}$

## Precedencia de operadores
De mayor a menor precedencia:
1. Clausura ($*$, $+$)
2. Concatenación
3. Unión ($\vert$)

## Ejemplo
$$aa^*bb^* \quad \text{describe cadenas con una o más "a" seguidas de una o más "b"}$$

Este es justamente el ejemplo de una regla de derivación de tipo 3: $A \rightarrow aB$ o $A \rightarrow a$.

### Ver también
- [[Gramatica]]
- [[Automatas Finitos]]
