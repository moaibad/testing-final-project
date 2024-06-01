@UPDATE
Feature: Update User

  Scenario: Mengubah beberapa data seperti firstName, lastName pada id user yang terdaftar
    Given Pengguna sudah menentukan base url untuk update user
    And Pengguna memiliki app-id yang valid untuk update user
    When Pengguna mengirim update request dengan request body "firstname_lastname.json" dan id user "60d0fe4f5311236168a109ca"
    Then Pengguna menerima data user yang telah diubah dengan status code "200" ketika update user

  Scenario: Mengubah semua field pada id user yang terdaftar kecuali email
    Given Pengguna sudah menentukan base url untuk update user
    And Pengguna memiliki app-id yang valid untuk update user
    When Pengguna mengirim update request dengan request body "all_field.json" dan id user "60d0fe4f5311236168a109ca"
    Then Pengguna menerima data user yang telah diubah dengan status code "200" ketika update user

  Scenario: Mengubah field pada firstName dengan mengisikan 2 karakter dan id user yang telah terdaftar
    Given Pengguna sudah menentukan base url untuk update user
    And Pengguna memiliki app-id yang valid untuk update user
    When Pengguna mengirim update request dengan request body "firstname_2_characters.json" dan id user "60d0fe4f5311236168a109ca"
    Then Pengguna menerima data user yang telah diubah dengan status code "200" ketika update user

  Scenario: Mengubah field pada firstName dengan mengisikan 50 karakter dan id user yang telah terdaftar
    Given Pengguna sudah menentukan base url untuk update user
    And Pengguna memiliki app-id yang valid untuk update user
    When Pengguna mengirim update request dengan request body "firstname_50_characters.json" dan id user "60d0fe4f5311236168a109d0"
    Then Pengguna menerima data user yang telah diubah dengan status code "200" ketika update user

  Scenario: Mengubah field pada lastName dengan mengisikan 2 karakter dan id user yang telah terdaftar
    Given Pengguna sudah menentukan base url untuk update user
    And Pengguna memiliki app-id yang valid untuk update user
    When Pengguna mengirim update request dengan request body "lastname_2_characters.json" dan id user "60d0fe4f5311236168a109d2"
    Then Pengguna menerima data user yang telah diubah dengan status code "200" ketika update user