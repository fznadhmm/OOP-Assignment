package AbstractClassInterface;
public class Bebek extends Hewan implements Terbang, Berenang {
    public Bebek() {
        super("bebek", 2);
    }

    @Override
    public void bersuara() {
        System.out.println("kwek, kwek, kwek");
    }

    @Override
    public void terbang() {
        System.out.println("Bebek terbang rendah");
    }

    @Override
    public void berenang() {
        System.out.println("Bebek berenang di kolam");
    }
}
