package hilosAlumnos;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce el nombre del primer alumno");
        String n1 = leer.next();
        System.out.println("Introduce el nombre del segundo alumno");
        String n2 = leer.next();
        System.out.println("Introduce el nombre del tercer alumno");
        String n3 = leer.next();

        Thread t1 = new Thread(new Student(n1));
        t1.start();
        t1.join();

        Thread t2 = new Thread(new Student(n2));
        t2.start();
        t2.join();

        Thread t3 = new Thread(new Student(n3));
        t3.start();
        t3.join();
    }
}
