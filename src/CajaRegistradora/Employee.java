package CajaRegistradora;

import java.text.DecimalFormat;
import java.util.Random;

public class Employee implements Runnable{
    private RegisterMachine rm;
    private String name;

    public Employee(RegisterMachine rm, String name){
        this.rm=rm;
        this.name=name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            double amount = new Random().nextDouble(5,100);
            rm.charge(amount);
            System.out.println("El empleado: " + this.name + " ha cobrado: "
                    + new DecimalFormat("#.00").format(amount) + "€ total en la caja: "
                    + new DecimalFormat("#.00").format(rm.getTotal()) + "€");
            try {
                Thread.sleep(new Random().nextInt(5,1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
