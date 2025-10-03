package zoologico;

public class Gato extends Animal {
    public int longuitudBigotes;

    public Gato(String name, int age, int longuitudBigotes){
        super(name,age);
        this.longuitudBigotes = longuitudBigotes;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println(" , longitud de los bigotes:  " + longuitudBigotes);
    }
}
