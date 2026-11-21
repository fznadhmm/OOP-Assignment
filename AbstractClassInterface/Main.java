package AbstractClassInterface;
public class Main {
    public static void main(String[] args) {
        // Hewan h = new Hewan("hewan", 4);   // error, abstract class tidak bisa dibuat objek

        Sapi s = new Sapi();
        s.isHewan();
        s.bersuara();

        System.out.println();

        Bebek b = new Bebek();
        b.isHewan();
        b.bersuara();
        b.terbang();
        b.berenang();

        System.out.println();

        Hewan[] kandang = { new Sapi(), new Bebek() };
        for (Hewan h : kandang) {
            h.bersuara();
        }

        Terbang t = new Bebek();
        t.terbang();

        Hewan.makan();
    }
}
