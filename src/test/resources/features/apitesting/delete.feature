@DELETE
Feature: Delete User

  Scenario: Melakukan request delete user tanpa header app-id
    Given Pengguna sudah menentukan base url untuk delete user
    And Pengguna tidak memiliki app-id untuk delete user
    When Pengguna mengirim delete request dengan user id "60d0fe4f5311236168a109de"
    Then Pengguna menerima pesan error "APP_ID_MISSING" dengan status code "403" ketika delete user

  Scenario: Melakukan request delete user dengan header app-id yang invalid
    Given Pengguna sudah menentukan base url untuk delete user
    And Pengguna memiliki app-id yang invalid untuk delete user
    When Pengguna mengirim delete request dengan user id "60d0fe4f5311236168a109de"
    Then Pengguna menerima pesan error "APP_ID_NOT_EXIST" dengan status code "403" ketika delete user

  Scenario: Melakukan request delete user dengan header app-id yang valid
    Given Pengguna sudah menentukan base url untuk delete user
    And Pengguna memiliki app-id yang valid untuk delete user
    When Pengguna mengirim delete request dengan user id "60d0fe4f5311236168a109de"
    Then Pengguna menerima id user yang di hapus dengan status code "200"

  Scenario: Menghapus data user berdasarkan "id" yang terdaftar
    Given Pengguna sudah menentukan base url untuk delete user
    And Pengguna memiliki app-id yang valid untuk delete user
    When Pengguna mengirim delete request dengan user id "60d0fe4f5311236168a109df"
    Then Pengguna menerima id user yang di hapus dengan status code "200"

  Scenario: Menghapus data user berdasarkan "id" yang tidak terdaftar
    Given Pengguna sudah menentukan base url untuk delete user
    And Pengguna memiliki app-id yang valid untuk delete user
    When Pengguna mengirim delete request dengan user id "60d0fe4f5311236168a109df"
    Then Pengguna menerima pesan error "RESOURCE_NOT_FOUND" dengan status code "404" ketika delete user