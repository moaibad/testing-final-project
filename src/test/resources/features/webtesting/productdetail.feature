@ProductDetail
Feature: Product Detail Feature

  Background:
    Given Pengguna sudah login ke dalam aplikasi
    And Pengguna sudah memilih barang yang ingin dilihat detailnya
    And Pengguna berada pada halaman detail produk

  Scenario: Verifikasi halaman detail produk
    Then Aplikasi menampilkan nama produk
    And Aplikasi menampilkan deskripsi produk
    And Aplikasi menampilkan harga produk
    And Aplikasi menampilkan gambar produk

  Scenario: Menambah barang ke cart
    When Pengguna menekan tombol Add to Cart
    Then Tombol Add to Cart pada barang berubah menjadi tombol Remove
    And Sistem menampilkan angka pada logo cart

  Scenario: Menghapus barang dari cart
    When Pengguna menekan tombol Add to Cart
    And Tombol Add to Cart pada barang berubah menjadi tombol Remove
    And Sistem menampilkan angka pada logo cart
    And Pengguna menekan tombol Remove
    Then Tombol Remove pada barang berubah menjadi tombol Add to Cart
    And Sistem menyembunyikan angka pada logo cart
