public class Main {
    public static void main(String[] args) {
        System.out.println("\n" + "--- Bentuk! BeNtUk! BENTUK! ---" + "\n");
        
        Bentuk bentuk = new Bentuk ("Hijau");
        bentuk.printInfo(); 
    
        BujurSangkar busang = new BujurSangkar(7.0, "Merah Muda");
        busang.printInfo();

        Lingkaran karan = new Lingkaran(9.0, "Biru Dongker");
        karan.printInfo();

        Silinder nder = new Silinder(12.0, 6.0, "Kuning");
        nder.printInfo();
    }
}
