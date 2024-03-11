/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.posttest_1;

/**
 *
 * @author Louvy
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Barang {
    String kode;
    String nama;
    int harga;

    public Barang(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %s", kode, nama, harga);
    }

}

public class POSTTEST_1 {

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
        String kode, nama;
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
            try {
                System.out.print("Masukkan harga barang: ");
                harga = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Harga harus berupa angka.");
            }
        } while (true);

        Barang barang = new Barang(kode, nama, harga);
        daftarBarang.add(barang);

        System.out.println("Barang berhasil ditambahkan.");
        waitEnter();
    }

    static boolean isKodeBarangExists(String kode) {
        for (Barang barang : daftarBarang) {
            if (barang.kode.equals(kode)) {
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
            System.out.println(String.format("%-10s %-20s %s", "Kode", "Nama", "Harga"));
            System.out.println("----------------------------------------------------------------------");
            for (Barang barang : daftarBarang) {
                System.out.println(barang);
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
            if (barang.kode.equals(kode)) {
                System.out.print("Masukkan nama barang baru: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan harga barang baru: ");
                int harga = scanner.nextInt();
                scanner.nextLine();

                barang.nama = nama;
                barang.harga = harga;

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
            if (barang.kode.equals(kode)) {
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