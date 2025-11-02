package CajaRegistradora;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RegisterMachine rm = new RegisterMachine();
        Thread t1 = new Thread(new Employee(rm,"Ana"));
        Thread t2 = new Thread(new Employee(rm,"Luis"));
        Thread t3 = new Thread(new Employee(rm,"Maria"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("TOTAL en la caja: " + new DecimalFormat("#.00").format(rm.getTotal()) + "€");
    }
}
