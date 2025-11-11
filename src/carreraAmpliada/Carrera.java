package carreraAmpliada;

import carreraAmpliada.animales.Liebre;
import carreraAmpliada.animales.Pajaro;
import carreraAmpliada.animales.Tortuga;

import java.util.concurrent.Semaphore;

public class Carrera {

    public static final int INICIO_TUNEL = 50;
    public static final int TUNEL_FIN_TUNEL = 100;

    Semaphore s = new Semaphore(1);

    public Animal t1 = new Tortuga("manolita",s);
    public Animal p1 = new Pajaro("juanito",s);
    public Animal l1 = new Liebre("saltarina",s);



    t1.start();
    p1.start();
    l1.start();

}
