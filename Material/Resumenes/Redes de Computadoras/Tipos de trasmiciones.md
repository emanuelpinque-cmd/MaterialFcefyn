Redes de Computadoras

- Segunda clase teorico

Trasmicion de datos analogicos y digitales

- Recordemos las funciones continuas, la naturaleza responde a funciones continuas y segundas derivadas tambien continuas es decir que no hay señales puntiagudas ni con saltos bruscos

- En cambio las señales digitales si se presentan esos saltos bruscos  

- Por ejemplo en una onda cuadrada para enviar un tren de 8 bits

En un cable UTP las señales no salen de esa forma como vemos cuadrada esos unos y ceros cuando sale a la red en realidad esto puede salir señaliado en 2 sañeles que van de mas a menos por que a si va a ser mas facil de leer en el destino

"En resumen no irian de 0 a 1 de forma literal" podria ir de -5 a 5 v""

otro ejemplo es el codigo manchester hay reglas de variaciones para representar un 1 o 0 

# Tipos de trasmiciones

Existen 2 tipos de tramiciones:

- Asincrona:la señal no depende del tiempo el mesaje no esta sincronizado entre emisor y receptor estos mensajes. estos mensajes obligatoriamente debe llevar un preambulo para avisar de la comunicacion. lleva por ejemplo una onda cuadrada que le avisa al receptor que debe sincronizarse
  
    Esto es necesario en por ejemplo aplicaciones de grandes distacias ya que el 
    tiempo puede no ser el mismo

Cuando el paquete llega al destino el preambulo indica todos los aspectos de la sincronizacion

- Sincronica el sincronismo esta forzado, tiene un clock previo o un clock comun dentro de la misma placa donde todo se maneja al mismo ritmo, tembien tiene otras caracteristicas permiten mandar mensajes esporadicos es decir que no necesariamente un mensaje va detras de otro

# Tecnicas de trasmicion de datos

- Banda Base:utilizan una señal digital de una unica frecuencia, la señal fluye en formas de pulsos discretos, una señal en banda base si no fue modulada previamente, un ejemplo una serie de 0s y 1s salen del cable se hizo una codificacion digital de datos digital de datos digitales.

- Banda ancha:

Si por ejemplo quiero trasmitir la señal de voz a travez de una antena no puedo trasmitirla en banda base por lo que llevo la banda base a una banda mas alta para modular la señal por ejemplo a los 10Mhz

El proceso de llevar de banda base a banda ancha se lo llama modulacion

Se multiplican las señales la señal portadora con otra señal de modulacion AM

# Perturbaciones en la trasmicion

- Atenuacion:La energia de una señal edcae con la distancia por lo que hay que asegurarse que la señal llegue con suficiente energia para ser captada

por ejemplo en un cable existe estar perdidas por la resistencia electrica

- Distorcion de retardo:Esto ocurre por que la atenuacion es mayor en altas frecuencias, hay frecuencias que llegan antes que otras,

- Ruido:toda aquella señal que se inserta entre el emisor y receptor de una señal dad 
