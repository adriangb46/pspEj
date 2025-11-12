package carreraAmpliada;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;
public abstract class Animal extends Thread{
    String name;
    private Semaphore s;
    private Wind w;
    private int distance;
    public Logger out;
    private boolean enTunel = false;

    public Animal(String name, Semaphore s, Wind w, Logger out) {
        this.name = name;
        this.s = s;
        this.w = w;
        distance = 0;
        this.out = out;
    }

    public  abstract int getVelocity(boolean wind,boolean tunel);

    @Override
    public void run() {
        while (getDistance() < Carrera.INICIO_TUNEL + Carrera.TUNEL_FIN_TUNEL) {
            try {
                int recorrido = getVelocidadParaEsteCiclo();

                avanzar(recorrido);

                imprimirEstado(recorrido);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        out.printTuneln("El animal " + name + " ha terminado!!");
    }

    private int getVelocidadParaEsteCiclo() throws InterruptedException {
        int velocidad = getVelocity(getWind().isWindy(), enTunel);

        if (!enTunel && getDistance() + velocidad >= Carrera.INICIO_TUNEL) {
            setDistance(Carrera.INICIO_TUNEL);
            entrarTunel();
            return 0;
        }

        if (enTunel && getDistance() + velocidad >= Carrera.INICIO_TUNEL + Carrera.TUNEL_FIN_TUNEL) {
            salirTunel();
        }

        return velocidad;
    }

    private void entrarTunel() throws InterruptedException {
        getSemafore().acquire();
        enTunel = true;
        out.printTuneln("El animal " + name + " de tipo " + getClass().getSimpleName() + " ha entrado al túnel");
    }

    private void salirTunel() {
        enTunel = false;
        getSemafore().release();
        out.println("El animal " + name + " ha salido del túnel");
    }

    private void avanzar(int distancia) {
        addDistance(distancia);
    }

    private void imprimirEstado(int recorrido) {
        out.println("El animal " + name + " de tipo " + getClass().getSimpleName() +
                " ha recorrido " + recorrido + " m y ahora está en: " + distance + " m");
    }

    /*

    codigo largo

    @Override
    public void run() {
        while(getDistance() < Carrera.INICIO_TUNEL + Carrera.TUNEL_FIN_TUNEL){
            try {
                int rec = this.getVelocity(getWind().isWindy(),enTunel);
                if(getDistance() + rec < Carrera.INICIO_TUNEL){
                    if(enTunel){//por el pajarito
                        getSemafore().release();
                        enTunel = false;
                        out.println("El animal " + name + " ha salido del tunel");
                    }
                    addDistance(rec);
                }else if(getDistance() < Carrera.INICIO_TUNEL
                        && getDistance() + rec >= Carrera.INICIO_TUNEL){
                    setDistance(Carrera.INICIO_TUNEL);
                    if(!enTunel) {
                        getSemafore().acquire();
                    }
                    enTunel = true;
                    out.printTuneln("El animal " + name + " de tipo "
                            + this.getClass().getName() +  " ha entrado al tunel");
                }else if(getDistance() >= Carrera.INICIO_TUNEL
                        && getDistance()
                        + (rec = this.getVelocity(false, enTunel))
                        < Carrera.TUNEL_FIN_TUNEL + Carrera.INICIO_TUNEL){
                    addDistance(rec);
                } else if (getDistance() + (rec = this.getVelocity(false, enTunel))
                        >= Carrera.TUNEL_FIN_TUNEL + Carrera.INICIO_TUNEL ) {
                    addDistance(rec);
                    enTunel = false;
                    getSemafore().release();
                    out.println("El animal " + name + " ha salido del tunel");
                }
                out.println("El animal " + name + " de tipo " + this.getClass().getName() +
                        " ha recorrido " + rec + "m y ahora esta en : " + distance + " m");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        out.printTuneln("El animal " + name + " ha terminado!!");
    }
     */

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
}
