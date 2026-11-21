package AbstractClassInterface;
public abstract class Hewan {
    protected String nama;
    protected int jumKaki;

    public Hewan(String nama, int jumKaki) {
        this.nama = nama;
        this.jumKaki = jumKaki;
    }

    public abstract void bersuara();

    public static void makan() {
        System.out.println("nyam, nyam, nyam");
    }

    public void isHewan() {
        System.out.println("nama : " + nama);
        System.out.println("jumlah kaki : " + jumKaki);
    }
}
