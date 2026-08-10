###### Procesamiento de señales

![](/home/emanuelp/.config/marktext/images/2026-08-09-14-51-25-image.png)

De este grafico sabemos que el perido son 60mm.

ademas sabemos que la velocidad se puede expresar en terminos de desplazamiento y tiempo, es decir:

$$
v=\frac{\Delta x}{\Delta t} 
$$

despejando tenemos que:

$$
T = \frac{\lambda}{C}=\frac{60mm}{299792458 \frac{m}{s}} =\frac{0.06m}{299792458 \frac{m}{s}} =0.2ns
$$

siendo T el periodo en segundos, lamda la longitud de onda y C la velocidad de la luz

$$
f=\frac{1}{T}=\frac{1}{0.2ns}=5Ghz
$$

llegamos a la conclusion que su periodo son 0.2ns de forma analoga su frecuencia es aproximadamente de 5Ghz ya que es su reciproco

c)

![The Electromagnetic Spectrum](https://www.columbia.edu/~vjd1/electromag_spectrum.gif)Aqui tenemos una imagen del espectro electromagnetico, nuetra longitud de onda es de 60mm es decir 0.06m en notacion exponencial 60 10⁻3 si queremos ubicarlo en la escala claramente esta en el espectro de microondas

![The ITU frequency bands VLF, LF, MF, HF, VHF, UHF,  EHF  . . .](https://www.electronics-notes.com/images/radio-spectrum-vlf-lf-hf-vhf-uhf.gif)

 Se aprecia claramente que pertence a la banda SHF de los 3GHz hasta 30Ghz

d) la frecuencia 5GHz en particular es una frecuencia extremadamente util su principal uso es en el WI-FI para reemplazar la antigua 2.4GHz aumentando su velocidad pero su costo es de menor alcance y problemas al atravezar estos dispositivos.

por eso se sigue utilizando la antigua 2.4Ghz esto es un trade off conocido de la fisica

- Mayor frecuencia:Se puede trasmitir mayor densidad de informacion, pero el costo es una mayor energia (despreciable en este caso) pero otro es la menor penetracion de la onda electromagnetica puesto que las moleculas ya empiezan a interferir entre ellas por su menor longitud de onda, un ejemplo es la luz visible pudiendo trasmitir gran cantidad de informacion con la fibra optica pero es pesima para trasmitirse en el aire puesto que interfiere con casi cualquier objeto

- Menor frecuencia:mucha mayor capacidad de penetracion y alcance las moleculas de los objetos casi no intervienen debido a su gran tamaño son atravezas e ignoradas completamente,el costo menor densidad de informacion menor, un ejemplo son las ondas de radio pudiendo trasmitirse por distacias extremas pero limitadas por su ancho de banda

e) El fenome representado es la atenuacion, su explicacion es bastantea intuitiva la OEM transporta energia y al interactuar con las moleculas estas la absorven (como por ejemplo un microondas haciendo vibrar los dipolos de las moleculas de agua) esta energia se va perdiendo a medida que la onda avanza con un decaimiento exponencial similar a la friccion de un objeto en movimiento, lo que causa una reduccion de la amplitud si esto no se trata la onda se vuelve indistinguible del ruido electrico

f) este fenomeno es muy comun cuando un telefono celular se aleja lo suficiente del router de WI-FI ademas que la analogia es acertada puesto que operan en el mismo rango de frecuencia 5Ghz

g)hay que aclarar que este es un fenomeno universal puesto que en el universo real siempre existen perdidas de energias pero una menos que otra.

- En las tramisciones de telefonia de celular es donde mas afecta el aire y los objetos fisicos puede robar gran cantidad de energia de la onda.

Por este motivo es que estas comunicaciones tienen problemas con la lluvia principalmente por el momento dipolar electrico de esta molecula cuando una OEM la atraviesa por la diferencias del campo electrico gana energia cinetica "rotando" aumentando aun mas la perdida de la onda

- El cable coaxial utiliza electricidad para la trasmicion de sus datos pero este fenomeno esta presente por que todos los objetos por mas conductores que sean (a excepcion de los superconductores pero ese es otro caso) tienen algun tipo de resistencia, por el efecto joule cuando existe una corriente a travez de esa resistencia el cable libera energia al ambiente perdiendo amplitud de la señal.

- La fibra optica es increiblemente eficiente pero como dicta la fisica no existe ninguna fuente sin perdidas, la principal son por que los fotones de luz chocan con imperfecciones microscopicas del cable redireccionandolos tambien hay que tener en cuenta que no existe un material con reflectividad perfecta asi que tambien el cable absorve parte de la energia calentandolo aunque es muy pequeño existe
