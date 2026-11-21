import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class ReadingTracker {

    //Komponen GUI
    private JFrame frame;
    private JTextField judulField;
    private JTextField totalField;
    private JButton simpanButton;
    private JLabel infoLabel;
    private JTextField dariField;
    private JTextField sampaiField;
    private JButton catatButton;
    private JTextArea riwayatArea;
    private JLabel progressLabel;

    //Data buku
    private String judulBuku;
    private int totalHalaman;
    private int halamanTerakhir = 0;
    private int jumlahCatatan = 0;

    //Konstruktor untuk ngebuat semua komponennya
    public ReadingTracker() {
        frame = new JFrame("Reading Tracker");

        judulField = new JTextField(20);
        totalField = new JTextField(20);
        simpanButton = new JButton("Simpan Buku");

        infoLabel = new JLabel("Perlu mengisi data buku terlebih dahulu.");
        dariField = new JTextField(5);
        sampaiField = new JTextField(5);
        catatButton = new JButton("Catat Bacaan");

        riwayatArea = new JTextArea(10, 30);
        riwayatArea.setEditable(false);
        riwayatArea.setText("Belum ada catatan bacaan.\n");

        progressLabel = new JLabel("Belum ada buku yang disimpan.", SwingConstants.CENTER);
    }

    //Nyusun frame sm layout
    public void launchFrame() {
        // ini buat Panel utama, buat ksh jarak 10 pixel di sekeliling isi jendela
        JPanel utama = new JPanel(new BorderLayout(10, 10));
        utama.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        /* bagian data buku
        Kolom kiri isi label, kolom kanan buat isian, biar rapi sejajar*/
        JPanel labelBuku = new JPanel(new GridLayout(2, 1, 10, 10));
        labelBuku.add(new JLabel("Judul Buku:"));
        labelBuku.add(new JLabel("Total Halaman:"));

        JPanel isianBuku = new JPanel(new GridLayout(2, 1, 10, 10));
        isianBuku.add(judulField);
        isianBuku.add(totalField);

        JPanel barisSimpan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        barisSimpan.add(simpanButton);

        JPanel panelBuku = new JPanel(new BorderLayout(10, 10));
        panelBuku.setBorder(buatBorder("Data Buku"));
        panelBuku.add(labelBuku, BorderLayout.WEST);
        panelBuku.add(isianBuku, BorderLayout.CENTER);
        panelBuku.add(barisSimpan, BorderLayout.SOUTH);

        //bagian catatan bacaan
        JPanel barisInput = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        barisInput.add(new JLabel("Dari halaman:"));
        barisInput.add(dariField);
        barisInput.add(new JLabel("Sampai halaman:"));
        barisInput.add(sampaiField);
        barisInput.add(catatButton);

        JPanel panelAtas = new JPanel(new GridLayout(2, 1, 5, 8));
        panelAtas.add(infoLabel);
        panelAtas.add(barisInput);

        JPanel panelCatat = new JPanel(new BorderLayout(10, 10));
        panelCatat.setBorder(buatBorder("Catat Bacaan Hari Ini"));
        panelCatat.add(panelAtas, BorderLayout.NORTH);
        panelCatat.add(new JScrollPane(riwayatArea), BorderLayout.CENTER);

        //ngegabungin semua ke panel utama trs ke frame
        utama.add(panelBuku, BorderLayout.NORTH);
        utama.add(panelCatat, BorderLayout.CENTER);
        utama.add(progressLabel, BorderLayout.SOUTH);
        frame.add(utama);

        //Sebelum buku disimpan, bagian catatan dimatiin dulu
        dariField.setEnabled(false);
        sampaiField.setEnabled(false);
        catatButton.setEnabled(false);

        //Daftarkan listener 
        SimpanHandler simpanHandler = new SimpanHandler();
        simpanButton.addActionListener(simpanHandler);
        totalField.addActionListener(simpanHandler);    //tekan Enter juga bisa

        CatatHandler catatHandler = new CatatHandler();
        catatButton.addActionListener(catatHandler);
        sampaiField.addActionListener(catatHandler);    //tekan Enter juga bisa

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //ngebuat border dgn judul sm jarak di dalamnya
    private Border buatBorder(String judul) {
        Border garis = BorderFactory.createTitledBorder(judul);
        Border jarak = BorderFactory.createEmptyBorder(5, 10, 10, 10);
        return BorderFactory.createCompoundBorder(garis, jarak);
    }

    //Event handling 
    //ini dipanggil pas tombol Simpan Buku dipencey
    private class SimpanHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            simpanBuku();
        }
    }

    //ini dipanggil pas tombol Catat Bacaan dipencet
    private class CatatHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            catatBacaan();
        }
    }

    private void simpanBuku() {
        String judul = judulField.getText().trim();
        int total = ambilAngka(totalField.getText());

        if (judul.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Judul buku belum diisi!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (total <= 0) {
            JOptionPane.showMessageDialog(frame, "Total halaman harus lebih dari 0!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        judulBuku = judul;
        totalHalaman = total;

        // Kunci form buku, trs buka bagian catatan
        judulField.setEditable(false);
        totalField.setEditable(false);
        simpanButton.setEnabled(false);
        dariField.setEnabled(true);
        sampaiField.setEnabled(true);
        catatButton.setEnabled(true);

        dariField.setText("1");
        infoLabel.setText("Buku: " + judulBuku + " (" + totalHalaman + " halaman)");
        riwayatArea.setText("");
        progressLabel.setText("Progress: 0 / " + totalHalaman + " halaman (0%)");
    }

    private void catatBacaan() {
        int dari = ambilAngka(dariField.getText());
        int sampai = ambilAngka(sampaiField.getText());

        if (dari < 1 || sampai < 1) {
            JOptionPane.showMessageDialog(frame, "Halaman harus berupa angka lebih dari 0!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sampai < dari) {
            JOptionPane.showMessageDialog(frame, "Halaman akhir tidak boleh lebih kecil dari halaman awal!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sampai > totalHalaman) {
            JOptionPane.showMessageDialog(frame, "Halaman akhir melebihi total halaman buku!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //nambahin ke riwayat
        jumlahCatatan = jumlahCatatan + 1;
        int jumlah = sampai - dari + 1;
        riwayatArea.append("Catatan " + jumlahCatatan + ": halaman " + dari
                + " - " + sampai + " (" + jumlah + " halaman)\n");

        //Perbarui progress
        if (sampai > halamanTerakhir) {
            halamanTerakhir = sampai;
        }
        int persen = halamanTerakhir * 100 / totalHalaman;
        progressLabel.setText("Progress: " + halamanTerakhir + " / " + totalHalaman
                + " halaman (" + persen + "%)");

        if (halamanTerakhir >= totalHalaman) {
            //Buku sudah selesai dibaca
            dariField.setEnabled(false);
            sampaiField.setEnabled(false);
            catatButton.setEnabled(false);
            JOptionPane.showMessageDialog(frame, "Selamat, buku sudah selesai dibaca!",
                    "Selesai", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //nyiapin input berikutnya
            dariField.setText(String.valueOf(halamanTerakhir + 1));
            sampaiField.setText("");
        }
    }

    //ubah teks jd angka, kalau bukan angka hasilnya -1
    private int ambilAngka(String teks) {
        try {
            return Integer.parseInt(teks.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        ReadingTracker app = new ReadingTracker();
        app.launchFrame();
    }
}