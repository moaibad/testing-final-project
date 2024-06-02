@Login
Feature: Login Feature

  Scenario: Login menggunakan username dan password yang terdaftar pada sistem
    Given Pengguna membuka halaman saucedemo pada browser
    And Pengguna berada pada halaman login yang berisikan form username dan password
    When Pengguna mengisi username "standard_user"
    And Pengguna mengisi password "secret_sauce"
    And Pengguna menekan tombol login
    Then Pengguna berhasil melakukan login dan menampilkan halaman Dashboard

  Scenario: Login menggunakan username yang terdaftar pada sistem dan password yang tidak terdaftar pada sistem
    Given Pengguna membuka halaman saucedemo pada browser
    And Pengguna berada pada halaman login yang berisikan form username dan password
    When Pengguna mengisi username "standard_user"
    And Pengguna mengisi password "boo"
    And Pengguna menekan tombol login
    Then Pengguna gagal melakukan login dan terdapat error message "Username and password do not match any user in this service !"

  Scenario: Login menggunakan password yang terdaftar pada sistem dan username yang tidak terdaftar pada sistem
    Given Pengguna membuka halaman saucedemo pada browser
    And Pengguna berada pada halaman login yang berisikan form username dan password
    When Pengguna mengisi username "cinderella"
    And Pengguna mengisi password "secret_sauce"
    And Pengguna menekan tombol login
    Then Pengguna gagal melakukan login dan terdapat error message "Username and password do not match any user in this service !"