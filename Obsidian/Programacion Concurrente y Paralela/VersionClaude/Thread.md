## Creacion de un thread

### Hay 2 formas de crear threads en java:

#### Extendiendo la clase Thread y sobreescribiendo el metodo run()

```java
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

```java
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

> **Ojo**: siempre se llama al método `start()`, nunca directamente a `run()`. Si se llama a `run()` directamente, el código se ejecuta en el hilo actual (como un método normal), sin crear un hilo nuevo.

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

---

## <font color="#ff0000">Ventajas de usar hilos frente a procesos</font>

- Se tarda **menos tiempo** en crear un nuevo hilo dentro de un proceso existente que en crear un proceso nuevo.
- Se tarda **menos tiempo** en terminar un hilo que en terminar un proceso.
- Se tarda **menos tiempo** en cambiar de contexto entre dos hilos del mismo proceso que entre procesos distintos.
- La **comunicación entre hilos** de un mismo proceso es más eficiente que la comunicación entre procesos, porque comparten el mismo espacio de memoria (no hace falta pasar por el SO).

---

## <font color="#ff0000">Hilos Daemon</font>

- Un hilo **daemon** es un hilo de **mínima prioridad** que corre en segundo plano, típicamente para tareas de soporte (recolección de basura, limpieza, monitoreo).
- **En Java, un programa finaliza cuando todos sus hilos NO-daemon terminan.** Los hilos daemon **no impiden** que el programa termine: la JVM los da por terminados automáticamente cuando ya no quedan hilos no-daemon corriendo.
- Ejemplo: en un programa con un hilo Main, múltiples hilos productores, y dos hilos daemon, el programa finaliza cuando terminan Main y los productores (todos los no-daemon), sin importar si los daemon siguen corriendo.

### Ver también
- [[Proceso]]
- [[Semaforo]]
- [[Clase 4]] — interrupción de un hilo
