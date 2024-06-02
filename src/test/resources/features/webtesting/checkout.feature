@Checkout
Feature: Checkout Feature

  Background:
    Given Pengguna berhasil melakukan login
    And Pengguna berada di halaman dashboard
    And Pengguna menambah barang "Sauce Labs Backpack" ke dalam cart
    And Pengguna menekan cart
    And Pengguna diarahkan ke halaman cart
    And Pengguna memilih opsi Checkout
    And Pengguna dialihkan ke halaman checkout information

  Scenario: Melanjutkan proses checkout dengan menekan tombol "Continue"
    When Pengguna mengisikan field first name dengan value "John"
    And Pengguna mengisikan field last name dengan value "Doe"
    And Pengguna mengisikan field postal code dengan value "54321"
    And Pengguna menekan tombol continue
    Then Pengguna dialihkan ke halaman checkout overview

  Scenario: Membatalkan proses pembelian dengan menekan tombol "Cancel"
    When Pengguna mengisikan field first name dengan value "John"
    And Pengguna mengisikan field last name dengan value "Doe"
    And Pengguna mengisikan field postal code dengan value "54321"
    And Pengguna menekan tombol continue
    And Pengguna dialihkan ke halaman checkout overview
    And Pengguna menekan tombol cancel
    Then Pengguna diarahkan ke halaman cart

  Scenario: Melanjutkan proses pembelian dengan menekan tombol "Finish"
    When Pengguna mengisikan field first name dengan value "John"
    And Pengguna mengisikan field last name dengan value "Doe"
    And Pengguna mengisikan field postal code dengan value "54321"
    And Pengguna menekan tombol continue
    And Pengguna dialihkan ke halaman checkout overview
    And Pengguna menekan tombol finish
    Then Sistem menampilkan checkout complete