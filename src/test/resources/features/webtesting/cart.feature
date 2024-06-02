@Cart
Feature: Cart Feature

  Background:
    Given Pengguna sudah melakukan login
    And Pengguna sudah berada pada halaman dashboard

  Scenario: Verifikasi halaman Cart tidak kosong dengan terdapat 1 barang
    When Pengguna menambah barang "Sauce Labs Backpack" ke cart
    And Pengguna menekan icon cart
    Then Pengguna berada pada halaman cart
    And Pengguna melihat "1" produk di dalam cart

  Scenario: Menekan Tombol "Continue shoppIng" ketika berada dalam halaman cart
    When Pengguna menekan icon cart
    And Pengguna menekan tombol Continue Shopping
    Then Pengguna dialihkan ke halaman dashboard

  Scenario: Menekan Tombol checkout ketika terdapat total 1 barang dalam cart
    When Pengguna menambah barang "Sauce Labs Onesie" ke cart
    And Pengguna menekan icon cart
    And Pengguna berada pada halaman cart
    And Pengguna menekan tombol Checkout
    Then Pengguna dialihkan ke halaman checkout