@Menu
Feature: Menu Feature

  Background:
    Given Pengguna telah login ke aplikasi
    And Pengguna telah berada pada halaman dashboard

  Scenario: Menekan icon Menu
    When Pengguna menekan tombol menu
    Then Sistem menampilkan opsi berikut:
      | All Items       |
      | About           |
      | Logout          |
      | Reset App State |

  Scenario: Memilih opsi "About"
    When Pengguna menekan tombol menu
    And Pengguna menekan tombol About
    Then Sistem menampilkan halaman About

  Scenario: Menutup menu
    When Pengguna menekan tombol menu
    And Pengguna menekan tombol close
    Then Sistem menyembunyikan opsi berikut:
      | All Items       |
      | About           |
      | Logout          |
      | Reset App State |
