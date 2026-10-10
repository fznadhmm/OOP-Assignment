# Tugas PBO: Bentuk & Bangun Ruang

Proyek ini adalah implementasi konsep *Object-Oriented Programming* (OOP) dalam Java untuk memodelkan berbagai bentuk geometri dua dimensi dan tiga dimensi.

## 📂 Struktur Kode

* **`Bentuk.java`**: Merupakan kelas induk (*super class*) yang memiliki atribut dasar berupa warna.

* **`BujurSangkar.java`**: Merupakan kelas turunan dari `Bentuk` yang mewakili bangun datar persegi dengan atribut tambahan berupa `sisi`.

* **`Lingkaran.java`**: Merupakan kelas turunan dari `Bentuk` yang mewakili bangun datar lingkaran dengan atribut tambahan berupa `radius` (jari-jari).

* **`Silinder.java`**: Merupakan kelas turunan dari `Lingkaran` (pewarisan bertingkat) yang mewakili bangun ruang silinder dengan atribut tambahan berupa `tinggi`.

* **`Main.java`**: Kelas utama untuk mengeksekusi program dan membuat objek dari setiap bentuk.

## 💻 Penerapan Konsep OOP

### 1. Encapsulation (Enkapsulasi)

Enkapsulasi adalah pembungkusan data (atribut) dan metode (fungsi) di dalam sebuah kelas untuk menyembunyikan detail implementasi dari luar. Pada kode ini, enkapsulasi terlihat dari penggunaan *access modifier* `private` pada atribut-atribut kelas:

* `private String warna;` pada `Bentuk`

* `private double sisi;` pada `BujurSangkar`

* `private double radius;` pada `Lingkaran`

* `private double tinggi;` pada `Silinder`

Untuk mengakses atau memodifikasi atribut-atribut tersebut dari luar, program menggunakan metode *getter* dan *setter* publik (contoh: `getWarna()`, `setWarna()`, `getSisi()`). Hal ini menjaga keamanan data agar tidak diubah sembarangan dari luar kelas.

### 2. Inheritance (Pewarisan)

Inheritance adalah mekanisme di mana sebuah kelas (kelas anak) mewarisi atribut dan metode dari kelas lain (kelas induk). Tujuannya agar tidak perlu menulis ulang kode yang sama. Dalam proyek ini, pewarisan ditandai dengan kata kunci `extends`:

* `class BujurSangkar extends Bentuk`: `BujurSangkar` mewarisi atribut warna dari `Bentuk`.

* `class Lingkaran extends Bentuk`: `Lingkaran` mewarisi atribut warna dari `Bentuk`.

* `class Silinder extends Lingkaran`: Ini adalah pewarisan bertingkat (*Multilevel Inheritance*). Karena `Silinder` adalah turunan dari `Lingkaran`, ia mewarisi `radius` dari `Lingkaran`, sekaligus mendapatkan `warna` dari `Bentuk`.
  Pada setiap konstruktor kelas anak, pemanggilan `super(...)` digunakan untuk mengirimkan nilai atribut ke kelas induknya.

### 3. Polymorphism (Polimorfisme)

Polimorfisme memungkinkan sebuah metode memiliki nama yang sama tetapi perilaku yang berbeda tergantung pada objek yang memanggilnya. Pada kode ini, polimorfisme terlihat sangat jelas dari penerapan **Method Overriding**.
Kelas `Bentuk` memiliki metode `printInfo()` yang mencetak warna. Metode ini kemudian "ditimpa" (di-*override*) di kelas `BujurSangkar`, `Lingkaran`, dan `Silinder` menggunakan anotasi `@Override`. Berkat ini, saat metode `printInfo()` dipanggil, setiap objek akan mencetak informasi yang spesifik dengan bentuknya (seperti luas untuk bangun datar dan volume untuk bangun ruang) beserta warnanya.

## 🚀 Cara Menjalankan Program

1. Buka terminal atau *command prompt*.

2. Arahkan direktori ke folder tempat file-file Java ini disimpan.

3. Kompilasi seluruh program dengan perintah:

   ```
   javac *.java
   
   ```

4. Jalankan program melalui Main Class dengan perintah:

   ```
   java Main
   
   ```

## 📸 Screenshot Output

*(Silakan letakkan file gambar di folder yang sama dan ubah `screenshot.png` di bawah ini sesuai dengan nama file screenshot Anda).*