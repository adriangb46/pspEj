package carreraAmpliada;

import java.util.Random;

public class Wind extends Thread{
    public boolean wind;
    public boolean active;
    private Logger out;

    public Wind(Logger out){
        this.out = out;
        active = true;
    }

    public boolean isWindy() {
        return wind;
    }

    @Override
    public void run() {
        while(active){
            try {
                wind = new Random().nextBoolean();
                out.printWindln(wind?"Hay viento":"No hay viento");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
