package carreraAmpliada;

import carreraAmpliada.animales.Liebre;
import carreraAmpliada.animales.Pajaro;
import carreraAmpliada.animales.Tortuga;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;

public class Carrera {

    public static final int INICIO_TUNEL = 50;
    public static final int TUNEL_FIN_TUNEL = 100;
    public static volatile boolean hayGanador = false;
    public static volatile Animal ganadorCarrera = null;

    static Semaphore s = new Semaphore(1);
    static Logger out = new Logger(System.out);
    static Wind w = new Wind(out);

    static Thread t1 = new Thread(new  Tortuga("manolita",s,w,out));
    static Thread p1 = new Thread(new Pajaro("juanito",s,w,out));
    static Thread l1 = new Thread(new Liebre("saltarina",s,w,out));
    static Thread [] threads = new Thread[]{w,t1,p1,l1};



    public static void main(String[] args) throws InterruptedException {
        for(Thread t : threads){
            t.start();
        }
    }

    public static void terminarCarrera(Animal animal){
        hayGanador = true;
        ganadorCarrera = animal;

        for(Thread t : threads){
            t.interrupt();
        }

        out.printTuneln("El animal " + ganadorCarrera.getNombre() + " de clase "
                +  ganadorCarrera.getClass().getSimpleName() + " ha terminado!! y por lo tanto ha ganado");
    }




}
