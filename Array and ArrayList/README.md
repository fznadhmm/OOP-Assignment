# Array and Array List Assignment

# My Bank Gwe 🏦

Program ini adalah aplikasi konsol berbasis Java sederhana untuk mensimulasikan sistem manajemen bank. Program ini memungkinkan penambahan nasabah (Customer), pembuatan rekening (Account) untuk masing-masing nasabah, serta melakukan transaksi dasar seperti setor tunai (Deposit) dan tarik tunai (Withdraw).

## 📂 Struktur File

Proyek ini terdiri dari 4 file Java utama:

1. **`Account.java`**: Mengelola data saldo nasabah dan logika transaksi (deposit/withdraw) serta mencatat total transaksi yang terjadi dalam bank menggunakan *static variable*.

2. **`Customer.java`**: Merepresentasikan nasabah bank. Menyimpan data nama nasabah dan daftar rekening (menggunakan Array) yang dimiliki oleh nasabah tersebut.

3. **`Bank_Blueprint.java`**: Berfungsi sebagai sistem inti bank yang menyimpan daftar semua nasabah menggunakan `ArrayList`.

4. **`Bank_Main2.java`**: Merupakan *Main class* yang berisi antarmuka interaktif (menu konsol) untuk pengguna agar dapat berinteraksi dengan sistem bank.

## 💻 Penerapan Konsep OOP

Proyek ini dirancang menggunakan paradigma Pemrograman Berorientasi Objek (OOP). Berikut adalah analisis penerapannya dalam kode:

### 1. Encapsulation (Enkapsulasi)

Enkapsulasi adalah konsep menyembunyikan detail implementasi internal dan melindungi data dari akses langsung yang tidak sah.

* **Bukti dalam kode:** Hampir seluruh variabel atau atribut di dalam program ini di-set dengan *access modifier* `private`.

  * Contoh di `Account.java`: `private double balance;`

  * Contoh di `Customer.java`: `private String firstName;` dan `private Account[] accounts;`

* Data-data ini hanya bisa diakses atau diubah secara aman dari luar melalui metode *Getter* dan *Setter* publik, seperti `getBalance()`, `deposit()`, atau `getFirstName()`. Hal ini mencegah saldo nasabah diubah secara sembarangan dari luar kelas.

### 2. Inheritance (Pewarisan)

*Catatan: Pada versi kode saat ini, pewarisan secara eksplisit (menggunakan keyword `extends`) belum diimplementasikan.*
Namun, rancangan kode ini sangat terbuka untuk *Inheritance*.

* **Contoh Penerapan (Rencana Pengembangan):** Kita bisa membuat kelas baru seperti `class SavingsAccount extends Account` (Rekening Tabungan) atau `class CreditAccount extends Account` (Rekening Kredit) yang akan mewarisi atribut `balance` dan metode dasar dari `Account`, namun memiliki aturan bunganya masing-masing.

### 3. Polymorphism (Polimorfisme)

*Catatan: Sama seperti Inheritance, polimorfisme belum terlihat secara menonjol di kode versi dasar ini.*
Polimorfisme adalah kemampuan objek untuk memiliki berbagai bentuk atau perilaku.

* **Contoh Penerapan (Rencana Pengembangan):** Jika kita mengimplementasikan `SavingsAccount` dan `CreditAccount` (seperti poin di atas), kita bisa melakukan metode *Overriding* pada method `withdraw()`. Misalnya, `CreditAccount` mengizinkan `withdraw` melebihi saldo (menjadi minus) yang tidak diizinkan di metode `withdraw()` kelas `Account` biasa.

## 🚀 Cara Menjalankan Program

1. Pastikan Anda telah menginstal Java (JDK) di komputer Anda.

2. Buka terminal atau *command prompt*.

3. Arahkan direktori ke folder tempat file-file Java ini disimpan.

4. Kompilasi semua file Java dengan perintah:

   ```
   javac *.java
   
   ```

5. Jalankan program melalui Main Class:

   ```
   java Bank_Main2
   
   ```

## 📸 Screenshot Output
<img width="363" height="196" alt="Page0" src="https://github.com/user-attachments/assets/62eb4778-b3f4-4d94-8b04-78a40b92b0e1" />
