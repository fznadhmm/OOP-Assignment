package AbstractClassInterface;
public class Sapi extends Hewan {
    public Sapi() {
        super("sapi", 4);
    }

    @Override
    public void bersuara() {
        System.out.println("Mooo, Mooo..");
    }
}
