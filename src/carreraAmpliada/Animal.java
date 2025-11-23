package carreraAmpliada;

import java.util.concurrent.Semaphore;

/**
 * Clase inicial de Animal
 *
 * @author Adrián González Blanco
 * @version 2.0
 */
public abstract class Animal implements Runnable{
    String name;
    private final Semaphore s;
    private final Wind w;
    private int distance;
    public final Logger out;
    private boolean enTunel = false;

    public Animal(String name, Semaphore s, Wind w, Logger out) {
        this.name = name;
        this.s = s;
        this.w = w;
        distance = 0;
        this.out = out;
    }

    public  abstract int getVelocity(boolean wind,boolean tunel);

    public int getDistance() {
        return distance;
    }

    public void addDistance(int distance) {
        this.distance += distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Wind getWind() {
        return w;
    }

    public Semaphore getSemafore() {
        return s;
    }

    public String getNombre() {
        return name;
    }


    public void avanzarFueraTunel(int rec){
        if (enTunel) {//por el pajarito
            getSemafore().release();
            enTunel = false;
            out.println("El animal " + name + " ha salido del tunel");
        }
        addDistance(rec);
    }

    public void avanzarHastaEntradaOMas(int rec) throws InterruptedException {
        setDistance(Carrera.INICIO_TUNEL);
        if (!enTunel) {
            getSemafore().acquire();
        }
        enTunel = true;
        out.printTuneln("El animal " + name + " de tipo "
                + this.getClass().getName() + " ha entrado al tunel");
    }

    public void avanzarDentroTunel(int rec){
        addDistance(rec);
    }

    public void finalTunel(int rec){
        addDistance(rec);
        enTunel = false;
        getSemafore().release();
        out.println("El animal " + name + " ha salido del tunel");
    }

    @Override
    public void run() {
        while (getDistance() < Carrera.INICIO_TUNEL + Carrera.TUNEL_FIN_TUNEL) {
            try {
                int rec = this.getVelocity(getWind().isWindy(), enTunel);


                if (getDistance() + rec < Carrera.INICIO_TUNEL) {
                    avanzarFueraTunel(rec);
                } else if (getDistance() < Carrera.INICIO_TUNEL
                        && getDistance() + rec >= Carrera.INICIO_TUNEL) {
                    avanzarHastaEntradaOMas(rec);
                } else if (getDistance() >= Carrera.INICIO_TUNEL
                        && getDistance()
                        + rec < Carrera.TUNEL_FIN_TUNEL + Carrera.INICIO_TUNEL) {
                    avanzarDentroTunel(rec);
                } else if (getDistance() + rec
                        >= Carrera.TUNEL_FIN_TUNEL + Carrera.INICIO_TUNEL) {
                    finalTunel(rec);
                    Carrera.terminarCarrera(this);
                }

                out.printTuneln("El animal " + name + " de tipo " + this.getClass().getSimpleName() +
                        " ha recorrido " + rec + "m y ahora esta en : " + distance + " m");

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                break;
            }
        }
    }

    /*

    codigo refactorizado por implementacion modular
    deprecado

    @Override
    public void run() {
        while (getDistance() < Carrera.INICIO_TUNEL + Carrera.TUNEL_FIN_TUNEL) {
            try {
                int rec = this.getVelocity(getWind().isWindy(), enTunel);
                if (getDistance() + rec < Carrera.INICIO_TUNEL) {
                    if (enTunel) {//por el pajarito
                        getSemafore().release();
                        enTunel = false;
                        out.println("El animal " + name + " ha salido del tunel");
                    }
                    addDistance(rec);
                } else if (getDistance() < Carrera.INICIO_TUNEL
                        && getDistance() + rec >= Carrera.INICIO_TUNEL) {
                    setDistance(Carrera.INICIO_TUNEL);
                    if (!enTunel) {
                        getSemafore().acquire();
                    }
                    enTunel = true;
                    out.printTuneln("El animal " + name + " de tipo "
                            + this.getClass().getName() + " ha entrado al tunel");
                } else if (getDistance() >= Carrera.INICIO_TUNEL
                        && getDistance()
                        + (rec = this.getVelocity(false, enTunel))
                        < Carrera.TUNEL_FIN_TUNEL + Carrera.INICIO_TUNEL) {
                    addDistance(rec);
                } else if (getDistance() + rec >= Carrera.TUNEL_FIN_TUNEL + Carrera.INICIO_TUNEL) {
                    addDistance(rec);
                    enTunel = false;
                    getSemafore().release();
                    out.println("El animal " + name + " ha salido del tunel");
                }
                out.printTuneln("El animal " + name + " de tipo " + this.getClass().getName() +
                        " ha recorrido " + rec + "m y ahora esta en : " + distance + " m");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        out.printTuneln("El animal " + name + " de clase " +  this.getClass().getSimpleName()
                + " ha terminado!! y por lo tanto ha ganado");
        System.exit(0);
    }

     */
}
