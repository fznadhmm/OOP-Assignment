public class Lingkaran extends Bentuk {
    private double radius;
    private static final double PHI = 3.14159; 

    public Lingkaran(double radius, String warna) {
        super(warna);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        this.radius = r; 
    }

    public double hitungLuas() {
        return PHI * radius * radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Lingkaran " + "\n" + "Warna: " + getWarna());
        System.out.println("luas = " + hitungLuas()+ "\n");
    }
}
