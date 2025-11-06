package carreraDeTortugas;

import java.util.concurrent.Semaphore;

public class Carrera {
    public static final int INICIO_TUNEL = 3;
    public static final int DISTANCIA_TUNEL = 5;
    public static final int TUNEL_FIN = 2;


    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);

        Tortuga t1 = new Tortuga("tortuga 1",s);
        Tortuga t2 = new Tortuga("tortuga 2",s);
        Tortuga t3 = new Tortuga("tortuga 3",s);

        t1.start();
        t2.start();
        t3.start();
    }
}
