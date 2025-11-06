package carreraDeTortugas;

import java.util.concurrent.Semaphore;

public class Tortuga extends Thread{

    private String name;
    private Semaphore s;
    private int distance;

    public Tortuga(String name,Semaphore s){
        this.name = name;
        this.s = s;
    }

    public void avanzar() throws InterruptedException {
        distance += 1;
        System.out.println("La trotuga " + name + "ha avanzado y esta a " + distance);
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try {
            while (distance <= Carrera.INICIO_TUNEL + Carrera.DISTANCIA_TUNEL + Carrera.TUNEL_FIN) {
                if (distance <= Carrera.INICIO_TUNEL) {
                    avanzar();
                }else if(distance < Carrera.INICIO_TUNEL + Carrera.DISTANCIA_TUNEL){

                    try {
                        s.acquire(); // espera si ya hay otra tortuga adentro
                        System.out.println(name + " quiere entrar al túnel...");
                        while (distance < Carrera.INICIO_TUNEL + Carrera.DISTANCIA_TUNEL) {
                            System.out.println(name + " está pasando por el túnel...");
                            avanzar();
                        }
                        System.out.println(name + " ha salido del túnel.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        s.release(); // libera el túnel
                    }
                }else{
                    avanzar();
                }

            }
            System.out.println("Tortuga " + name + " ha terminado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
