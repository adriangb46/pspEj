package carreraAmpliada;

import carreraAmpliada.animales.Liebre;
import carreraAmpliada.animales.Pajaro;
import carreraAmpliada.animales.Tortuga;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;

public class Carrera {

    public static final int INICIO_TUNEL = 50;
    public static final int TUNEL_FIN_TUNEL = 100;

    static Semaphore s = new Semaphore(1);
    static Logger out = new Logger(System.out);
    static Wind w = new Wind(out);

    static Animal t1 = new Tortuga("manolita",s,w,out);
    static Animal p1 = new Pajaro("juanito",s,w,out);
    static Animal l1 = new Liebre("saltarina",s,w,out);

    public static void main(String[] args) throws InterruptedException {
        w.start();
        t1.start();
        p1.start();
        l1.start();
        t1.join();
        l1.join();
        p1.join();
        w.active = false;
    }




}
