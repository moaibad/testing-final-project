@EndToEnd
Feature: End to end Test

  Scenario: Melakukan checkout barang para aplikasi Swag Labs
    Given Pengguna berada pada halaman login
    When Pengguna mengisikan username "standard_user"
    And Pengguna mengisikan password "secret_sauce"
    And Pengguna menekan login
    And Pengguna menekan Add to Cart pada barang "Sauce Labs Backpack"
    And Pengguna menekan logo cart
    And Pengguna menekan tombol checkout
    And Pengguna mengisikan field first name dengan "John"
    And Pengguna mengisikan field last name dengan "Doe"
    And Pengguna mengisikan field postal code dengan "54321"
    And Pengguna menekan continue
    And Pengguna menekan finish
    Then Aplikasi menampilkan pembelian berhasil