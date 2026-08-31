## Creacion de un thread

### Hay 2 formas de crear threads en java:

#### Extendiendo la clase Thread y sobreescribiendo el metodo run()

```
public class MyClass extends Thread{
@Override
public void run(){
System.out.println("Im running!");}
}

public class Main{
public static void main(String[] args)
{
MyClass mc = new MyClass();
mc.start();
}}
```

#### Creando una clase que implemente la interfaz runnable. Luego crear un objeto de la clase Thread y pasarle el objeto runnable

```
public class MyClass implements Runnable{
@Override
public void run(){
System.out.println("Im running!");
}}

public class main{
Public static void main(String[] args){
MyClass mc = new MyClass();
Thread t = new Thread(mc);
t.start();
}}

```

---
## Atributos

La clase thread almacena atributos de informacion
 estos son:

#### Id: Este atributo almacena un identificador unico para cada thread

#### Nombre: Nombre del thread

#### Prioridad: almacena su prioridad
##### Va del 1 hasta al 10 1 la mas baja 10 la mas alta, no es recomendable cambiar la prioridad

#### Estado: Almacena sus 7 posibles estados:

### Estados de un thread

#### New:

#### Ready-to-run

#### Running

#### Sleeping

#### Waiting

#### Blocking

#### Dead

## Cambios de estado de un hilo:

### Creacion
- #### Cuando se crea un proceso se crea un hilo para ese proceso, Luego este hilo puede crear otros hilos hilos dentro del mismo proceso
### Bloqueo
- #### Cuando un hilo necesita esprar por un suceso se bloquea (salvando sus reginstros de usuario contador de programa y puntero de pila)
- #### Ahora el processador podra pasar a ejecutar otro hilo que este en la cola de Listos mientras el anterior permanece bloqueado
### Desbloqueo
- #### Cuando el suceso por el que el hilo se bloqueo se produce, el ,mismo pasa a la cola de listos
### Terminacion
- #### Cuando un hilo finaliza se liberan tanto su contexto como sus pilas


## Estados de un hilo en JAVA


![[Pasted image 20260831171140.png]]




