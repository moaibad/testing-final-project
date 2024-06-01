@Dashboard
Feature: Dashboard Feature

  Background:
    Given Pengguna sudah berhasil login ke aplikasi
    Given Pengguna berada pada halaman dashboard

  Scenario: Menambah 1 barang ke cart
    When Pengguna menekan tombol Add to Cart pada barang "Sauce Labs Backpack"
    And Tombol Add to Cart pada produk "Sauce Labs Backpack" berubah menjadi tombol Remove
    Then Sistem menampilkan nilai pada logo cart sebesar "1"

  Scenario: Menambah 6 barang ke cart
    When Pengguna menekan tombol Add to Cart pada semua barang
    And Tombol Add to Cart pada semua barang berubah menjadi tombol Remove
    Then Sistem menampilkan nilai pada logo cart sebesar "6"

  Scenario: Menghapus 1 barang dari cart
    When Pengguna menekan tombol Add to Cart pada semua barang
    And Tombol Add to Cart pada semua barang berubah menjadi tombol Remove
    Then Sistem menampilkan nilai pada logo cart sebesar "6"
    When Pengguna menekan tombol Remove pada barang "Sauce Labs Backpack"
    Then Sistem menampilkan nilai pada logo cart sebesar "5"
