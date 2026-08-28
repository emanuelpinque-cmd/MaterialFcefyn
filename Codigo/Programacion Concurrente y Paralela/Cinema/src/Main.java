public class Main {

    public static void main(String[] args) {
    Function theLordOfTheRings = new Function("The lord of the rings",200);
    Customer juan = new Customer("Juan Perez",10,10,theLordOfTheRings);
    Customer pedro = new Customer("Pedro Silva",12,12,theLordOfTheRings);
    Customer pablo = new Customer("Pablo Flores",4,20,theLordOfTheRings);

    Thread t1 = new Thread(juan);
    Thread t2 = new Thread(pedro);
    Thread t3 = new Thread(pablo);

    t1.start();
    t2.start();
    t3.start();

    try{
        t1.join();
        t2.join();
        t3.join();
    }
    catch(InterruptedException e){}



    theLordOfTheRings.showCash();
    theLordOfTheRings.showSeats();
    }


}