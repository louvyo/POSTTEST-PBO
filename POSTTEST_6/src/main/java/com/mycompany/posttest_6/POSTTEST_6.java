/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.posttest_6;

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

    public void setStok(int stok) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStok'");
    }
}

interface BarangInterface {
    void tambahStok(int jumlah);

    void kurangiStok(int jumlah);

    int getStok();

    static void printHeader() {
        System.out.println("Kode   | Nama                | Harga  | Stok | Detail");
        System.out.println("-------------------------------------------------------");
    }
}

class BarangElektronik extends Barang implements BarangInterface {
    private String jenis;
    private int masaGaransi;
    private int stok;

    public BarangElektronik(String kode, String nama, int harga, String jenis, int masaGaransi, int stok) {
        super(kode, nama, harga);
        this.jenis = jenis;
        this.masaGaransi = masaGaransi;
        this.stok = stok;
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

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return super.toString() + " Jenis: " + jenis + " Garansi: " + masaGaransi + " bulan" + " Stok: " + stok;
    }

    @Override
    public void tambahStok(int jumlah) {
        try {
            if (jumlah < 0) {
                throw new IllegalArgumentException("Jumlah stok tidak boleh negatif");
            }
            // Implementasi logika penambahan stok barang elektronik
            System.out.println("Masukkan jumlah stok barang elektronik " + getNama() + " yang ditambahkan: " + jumlah);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void kurangiStok(int jumlah) {
        try {
            if (jumlah < 0) {
                throw new IllegalArgumentException("Jumlah stok tidak boleh negatif");
            }
            // Implementasi logika pengurangan stok barang elektronik
            System.out.println("Masukkan jumlah stok barang elektronik " + getNama() + " yang dikurangi: " + jumlah);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class BarangNonElektronik extends Barang implements BarangInterface {
    private String bahan;
    private String ukuran;
    private String warna;
    private int stok;

    public BarangNonElektronik(String kode, String nama, int harga, String bahan, String ukuran, String warna,
            int stok) {
        super(kode, nama, harga);
        this.bahan = bahan;
        this.ukuran = ukuran;
        this.warna = warna;
        this.stok = stok;
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

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return super.toString() + " Bahan: " + bahan + " Ukuran: " + ukuran + " Warna: " + warna + " Stok: " + stok;
    }

    @Override
    public void tambahStok(int jumlah) {
        try {
            if (jumlah < 0) {
                throw new IllegalArgumentException("Jumlah stok tidak boleh negatif");
            }
            // Implementasi logika penambahan stok barang non-elektronik
            System.out.println(
                    "Masukkan jumlah stok barang non-elektronik " + getNama() + " yang ditambahkan: " + jumlah);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void kurangiStok(int jumlah) {
        try {
            if (jumlah < 0) {
                throw new IllegalArgumentException("Jumlah stok tidak boleh negatif");
            }
            // Implementasi logika pengurangan stok barang non-elektronik
            System.out
                    .println("Masukkan jumlah stok barang non-elektronik " + getNama() + " yang dikurangi: " + jumlah);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class POSTTEST_6 {
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
        int harga, stok; // tambahkan variabel stok

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

        do {
            try {
                System.out.print("Masukkan stok barang: ");
                stok = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Stok harus berupa angka.");
            }
        } while (true);

        Barang barang;
        if (jenis.equals("elektronik")) {
            System.out.print("Masukkan masa garansi barang elektronik (bulan): ");
            int masaGaransi = Integer.parseInt(scanner.nextLine());
            barang = new BarangElektronik(kode, nama, harga, jenis, masaGaransi, stok); // Menambahkan stok pada
                                                                                        // konstruktor BarangElektronik
        } else {
            System.out.print("Masukkan bahan barang non-elektronik: ");
            String bahanNonElektronik = scanner.nextLine();
            System.out.print("Masukkan ukuran barang non-elektronik: ");
            String ukuranNonElektronik = scanner.nextLine();
            System.out.print("Masukkan warna barang non-elektronik: ");
            String warnaNonElektronik = scanner.nextLine();
            barang = new BarangNonElektronik(kode, nama, harga, bahanNonElektronik, ukuranNonElektronik,
                    warnaNonElektronik, stok); // Menambahkan stok pada konstruktor BarangNonElektronik
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
            BarangInterface.printHeader();
            System.out.println("----------------------------------------------------------------------");
            for (Barang barang : daftarBarang) {
                if (barang instanceof BarangElektronik) {
                    BarangElektronik barangElektronik = (BarangElektronik) barang;
                    System.out.println(String.format("%-10s %-20s %-10s %-10s %s", barang.getKode(), barang.getNama(),
                            barang.getHarga(), barangElektronik.getStok(), barangElektronik.getJenis()));
                } else if (barang instanceof BarangNonElektronik) {
                    BarangNonElektronik barangNonElektronik = (BarangNonElektronik) barang;
                    System.out.println(String.format("%-10s %-20s %-10s %-10s %s", barang.getKode(), barang.getNama(),
                            barang.getHarga(), barangNonElektronik.getStok(),
                            "Bahan: " + barangNonElektronik.getBahan() +
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
        System.out.print("Masukkan kode barang yang akan diedit: ");
        String kode = scanner.nextLine();

        for (Barang barang : daftarBarang) {
            if (barang.getKode().equals(kode)) {
                System.out.print("Masukkan nama barang baru: ");
                String nama = scanner.nextLine();
                int harga;
                do {
                    try {
                        System.out.print("Masukkan harga barang baru: ");
                        harga = Integer.parseInt(scanner.nextLine());
                        if (harga < 0) {
                            throw new IllegalArgumentException("Harga tidak boleh negatif.");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Harga harus berupa angka.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } while (true);

                int stok;
                do {
                    try {
                        System.out.print("Masukkan stok barang baru: ");
                        stok = Integer.parseInt(scanner.nextLine());
                        if (stok < 0) {
                            throw new IllegalArgumentException("Stok tidak boleh negatif.");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Stok harus berupa angka.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } while (true);

                if (barang instanceof BarangElektronik) {
                    BarangElektronik barangElektronik = (BarangElektronik) barang;
                    String jenis;
                    do {
                        System.out.print("Masukkan jenis barang elektronik baru (elektronik/non-elektronik): ");
                        jenis = scanner.nextLine().toLowerCase();
                        if (!jenis.equals("elektronik") && !jenis.equals("non-elektronik")) {
                            System.out.println("Jenis barang tidak valid. Masukkan jenis barang yang benar.");
                        }
                    } while (!jenis.equals("elektronik") && !jenis.equals("non-elektronik"));

                    int masaGaransi;
                    do {
                        try {
                            System.out.print("Masukkan masa garansi barang elektronik baru (bulan): ");
                            masaGaransi = Integer.parseInt(scanner.nextLine());
                            if (masaGaransi < 0) {
                                throw new IllegalArgumentException("Masa garansi tidak boleh negatif.");
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Masa garansi harus berupa angka.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } while (true);

                    barangElektronik.setNama(nama);
                    barangElektronik.setHarga(harga);
                    barangElektronik.setJenis(jenis);
                    barangElektronik.setMasaGaransi(masaGaransi);
                    barangElektronik.setStok(stok);
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
                    barangNonElektronik.setStok(stok);
                } else {
                    barang.setNama(nama);
                    barang.setHarga(harga);
                    barang.setStok(stok);
                }

                System.out.println("Barang berhasil diedit.");
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

        boolean found = false;
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            if (barang.getKode().equals(kode)) {
                daftarBarang.remove(i);
                found = true;
                System.out.println("Barang berhasil dihapus.");
                break;
            }
        }

        if (!found) {
            System.out.println("Barang tidak ditemukan.");
        }
        waitEnter();
    }

    static void waitEnter() {
        System.out.println("Tekan Enter untuk kembali ke menu...");
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
