package carreraDeTortugas;

import java.util.concurrent.Semaphore;

public class Tunel{
    private Semaphore s = new Semaphore(1);
    public void entrar(String nombreTortuga) {
        try {
            System.out.println(nombreTortuga + " quiere entrar al túnel...");
            s.acquire(); // espera si ya hay otra tortuga adentro
            System.out.println(nombreTortuga + " está pasando por el túnel...");
            Thread.sleep(2000); // simula el tiempo dentro del túnel
            System.out.println(nombreTortuga + " ha salido del túnel.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            s.release(); // libera el túnel
        }
    }
}
