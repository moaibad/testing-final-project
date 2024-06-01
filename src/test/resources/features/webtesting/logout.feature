@Logout
Feature: Logout

  Scenario: Pengguna logout dari aplikasi
    Given Pengguna telah berhasil login ke aplikasi
    When Pengguna membuka sidebar menu
    And Pengguna menekan tombol logout
    Then Aplikasi menampilkan halaman login