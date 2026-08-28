//This calculator calculate numbers :]
public class Calculator implements Runnable {
    private int num;
    private Boolean primeMode = false;
    public Calculator(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (!primeMode) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("num= "+this.num+" Number = " + i * num + " Thread = " + Thread.currentThread().getName());
            }
        }
    }

}


