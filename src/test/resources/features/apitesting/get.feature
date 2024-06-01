@GET
Feature: Get User

  Scenario: Melakukan request get user tanpa header app-id
    Given Pengguna sudah menentukan base url untuk get user
    And Pengguna tidak memiliki app-id untuk get user
    When Pengguna mengirim get request
    Then Pengguna menerima pesan error "APP_ID_MISSING" dengan status code "403" ketika get user

  Scenario: Melakukan request get user dengan header app-id yang invalid
    Given Pengguna sudah menentukan base url untuk get user
    And Pengguna memiliki app-id yang invalid untuk get user
    When Pengguna mengirim get request
    Then Pengguna menerima pesan error "APP_ID_NOT_EXIST" dengan status code "403" ketika get user

  Scenario: Melakukan request get user dengan header app-id yang valid
    Given Pengguna sudah menentukan base url untuk get user
    And Pengguna memiliki app-id yang valid untuk get user
    When Pengguna mengirim get request
    Then Pengguna menerima user information dengan status code "200"

  Scenario: Mengambil data user berdasarkan "id" yang terdaftar
    Given Pengguna sudah menentukan base url untuk get user
    And Pengguna memiliki app-id yang valid untuk get user
    When Pengguna mengirim get request dengan id "60d0fe4f5311236168a109cc"
    Then Pengguna menerima user information berdasarkan id dengan status code "200"

  Scenario: Mengambil data user berdasarkan "id" yang tidak terdaftar
    Given Pengguna sudah menentukan base url untuk get user
    And Pengguna memiliki app-id yang valid untuk get user
    When Pengguna mengirim get request dengan id "662e6015bb70a73efe2595f9"
    Then Pengguna menerima pesan error "RESOURCE_NOT_FOUND" dengan status code "404" ketika get user