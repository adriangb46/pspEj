package carreraAmpliada;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.Date;

public class Logger extends PrintStream {
    public Logger(OutputStream out) {
        super(out);
    }

    @Override
    public void println(String msg){
        msg = "[ " + Date.from(Instant.now()) + "] " + msg;
        super.println(msg);
    }

    public void printEventln(String msg){
        msg = "\u001B[31m" +  "[ " + Date.from(Instant.now()) + "] " + msg + "\u001B[0m" ;
        super.println(msg);
    }

    public void printTuneln(String msg){
        msg = "\u001B[32m" +  "[ " + Date.from(Instant.now()) + "] " + msg + "\u001B[0m";
        super.println(msg);
    }

    public void printWindln(String msg){
        msg = "\u001B[33m" +  "[ " + Date.from(Instant.now()) + "] " + msg + "\u001B[0m";
        super.println(msg);
    }
}
