/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/

package com.mycompany.posttest_5;

/**
 *
 * @author Louvy
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Barang {
    private String kode;
    private String nama;
    private int harga;

    public Barang(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    // getter dan setter

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %s", kode, nama, harga);
    }
}

class BarangElektronik extends Barang {
    private String jenis;
    private int masaGaransi;

    public BarangElektronik(String kode, String nama, int harga, String jenis, int masaGaransi) {
        super(kode, nama, harga);
        this.jenis = jenis;
        this.masaGaransi = masaGaransi;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getMasaGaransi() {
        return masaGaransi;
    }

    public void setMasaGaransi(int masaGaransi) {
        this.masaGaransi = masaGaransi;
    }

    public void cekGaransi() {
        System.out.println("Masa garansi untuk " + getNama() + " adalah " + masaGaransi + " bulan.");
    }

    @Override
    public String toString() {
        return super.toString() + " Jenis: " + jenis + " Garansi: " + masaGaransi + " bulan";
    }
}

class BarangNonElektronik extends Barang {
    private String bahan;
    private String ukuran;
    private String warna;

    public BarangNonElektronik(String kode, String nama, int harga, String bahan, String ukuran, String warna) {
        super(kode, nama, harga);
        this.bahan = bahan;
        this.ukuran = ukuran;
        this.warna = warna;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    @Override
    public String toString() {
        return super.toString() + " Bahan: " + bahan + " Ukuran: " + ukuran + " Warna: " + warna;
    }
}

public class POSTTEST_5 {
    static ArrayList<Barang> daftarBarang = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("=== Sistem Pendataan Toko Alat Olahraga Louvy Store ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Daftar Barang");
            System.out.println("3. Edit Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");

            int pilihan = 0;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine();
                waitEnter();
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    lihatDaftarBarang();
                    break;
                case 3:
                    editBarang();
                    break;
                case 4:
                    hapusBarang();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    waitEnter();
                    break;
            }
        }
    }

    static void tambahBarang() {
        String kode, nama, jenis;
        int harga;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        do {
            System.out.print("Masukkan kode barang: ");
            kode = scanner.nextLine();
            if (kode.trim().isEmpty()) {
                System.out.println("Kode barang tidak boleh kosong.");
            } else if (isKodeBarangExists(kode)) {
                System.out.println("Kode barang sudah digunakan. Masukkan kode barang lain.");
            }
        } while (kode.trim().isEmpty() || isKodeBarangExists(kode));

        do {
            System.out.print("Masukkan nama barang: ");
            nama = scanner.nextLine();
        } while (nama.trim().isEmpty());

        do {
            System.out.print("Masukkan jenis barang (Elektronik/Non-elektronik): ");
            jenis = scanner.nextLine().toLowerCase();
            if (!jenis.equals("elektronik") && !jenis.equals("non-elektronik")) {
                System.out.println("Jenis barang tidak valid. Masukkan jenis barang yang benar.");
            }
        } while (!jenis.equals("elektronik") && !jenis.equals("non-elektronik"));

        do {
            try {
                System.out.print("Masukkan harga barang: ");
                harga = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Harga harus berupa angka.");
            }
        } while (true);

        Barang barang;
        if (jenis.equals("elektronik")) {
            System.out.print("Masukkan masa garansi barang elektronik (bulan): ");
            int masaGaransi = Integer.parseInt(scanner.nextLine());
            barang = new BarangElektronik(kode, nama, harga, jenis, masaGaransi);
        } else {
            System.out.print("Masukkan bahan barang non-elektronik: ");
            String bahanNonElektronik = scanner.nextLine();
            System.out.print("Masukkan ukuran barang non-elektronik: ");
            String ukuranNonElektronik = scanner.nextLine();
            System.out.print("Masukkan warna barang non-elektronik: ");
            String warnaNonElektronik = scanner.nextLine();
            barang = new BarangNonElektronik(kode, nama, harga, bahanNonElektronik, ukuranNonElektronik,
                    warnaNonElektronik); // Menambahkan parameter ukuran dan warna
        }

        daftarBarang.add(barang);

        System.out.println("Barang berhasil ditambahkan.");
        waitEnter();
    }

    static boolean isKodeBarangExists(String kode) {
        for (Barang barang : daftarBarang) {
            if (barang.getKode().equals(kode)) {
                return true;
            }
        }
        return false;
    }

    static void lihatDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Daftar barang kosong.");
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("======================================================================");
            System.out.println(String.format("%-10s %-20s %-10s %s", "Kode", "Nama", "Harga", "Detail"));
            System.out.println("----------------------------------------------------------------------");
            for (Barang barang : daftarBarang) {
                if (barang instanceof BarangElektronik) {
                    BarangElektronik barangElektronik = (BarangElektronik) barang;
                    System.out.println(String.format("%-10s %-20s %-10s %s", barang.getKode(), barang.getNama(),
                            barang.getHarga(), barangElektronik.getJenis()));
                } else if (barang instanceof BarangNonElektronik) {
                    BarangNonElektronik barangNonElektronik = (BarangNonElektronik) barang;
                    System.out.println(String.format("%-10s %-20s %-10s %s", barang.getKode(), barang.getNama(),
                            barang.getHarga(), "Bahan: " + barangNonElektronik.getBahan() +
                                    ", Ukuran: " + barangNonElektronik.getUkuran() +
                                    ", Warna: " + barangNonElektronik.getWarna()));
                } else {
                    System.out.println(barang);
                }
            }
            System.out.println("======================================================================");
        }
        waitEnter();
    }

    static void editBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Daftar barang kosong.");
            waitEnter();
            return;
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Masukkan kode barang yang akan di edit: ");
        String kode = scanner.nextLine();

        for (Barang barang : daftarBarang) {
            if (barang.getKode().equals(kode)) {
                System.out.print("Masukkan nama barang baru: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan harga barang baru: ");
                int harga = Integer.parseInt(scanner.nextLine());

                if (barang instanceof BarangElektronik) {
                    BarangElektronik barangElektronik = (BarangElektronik) barang;
                    System.out.print("Masukkan jenis barang elektronik baru: ");
                    String jenis = scanner.nextLine();
                    System.out.print("Masukkan masa garansi barang elektronik baru (bulan): ");
                    int masaGaransi = Integer.parseInt(scanner.nextLine());

                    barangElektronik.setNama(nama);
                    barangElektronik.setHarga(harga);
                    barangElektronik.setJenis(jenis);
                    barangElektronik.setMasaGaransi(masaGaransi);
                } else if (barang instanceof BarangNonElektronik) {
                    BarangNonElektronik barangNonElektronik = (BarangNonElektronik) barang;
                    System.out.print("Masukkan bahan barang non-elektronik baru: ");
                    String bahan = scanner.nextLine();
                    System.out.print("Masukkan ukuran barang non-elektronik baru: ");
                    String ukuran = scanner.nextLine();
                    System.out.print("Masukkan warna barang non-elektronik baru: ");
                    String warna = scanner.nextLine();

                    barangNonElektronik.setNama(nama);
                    barangNonElektronik.setHarga(harga);
                    barangNonElektronik.setBahan(bahan);
                    barangNonElektronik.setUkuran(ukuran);
                    barangNonElektronik.setWarna(warna);
                } else {
                    barang.setNama(nama);
                    barang.setHarga(harga);
                }

                System.out.println("Barang berhasil di edit.");
                waitEnter();
                return;
            }
        }

        System.out.println("Barang tidak ditemukan.");
        waitEnter();
    }

    static void hapusBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Daftar barang kosong.");
            waitEnter();
            return;
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Masukkan kode barang yang akan dihapus: ");
        String kode = scanner.nextLine();

        for (Barang barang : daftarBarang) {
            if (barang.getKode().equals(kode)) {
                daftarBarang.remove(barang);
                System.out.println("Barang berhasil dihapus.");
                waitEnter();
                return;
            }
        }

        System.out.println("Barang tidak ditemukan.");
        waitEnter();
    }

    static void waitEnter() {
        System.out.println("Tekan Enter untuk kembali ke menu...");
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
