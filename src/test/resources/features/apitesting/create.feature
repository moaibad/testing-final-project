@CREATE
Feature: Create User

  Scenario: Melakukan request create user tanpa header app-id
    Given Pengguna sudah menentukan base url untuk create user
    And Pengguna tidak memiliki app-id untuk create user
    When Pengguna mengirim create request dengan request body "authorization_test.json"
    Then Pengguna menerima pesan error "APP_ID_MISSING" dengan status code "403" ketika create user

  Scenario: Melakukan request create user dengan header app-id yang invalid
    Given Pengguna sudah menentukan base url untuk create user
    And Pengguna memiliki app-id yang invalid untuk create user
    When Pengguna mengirim create request dengan request body "authorization_test.json"
    Then Pengguna menerima pesan error "APP_ID_NOT_EXIST" dengan status code "403" ketika create user

  Scenario: Melakukan request create user dengan header app-id yang valid
    Given Pengguna sudah menentukan base url untuk create user
    And Pengguna memiliki app-id yang valid untuk create user
    When Pengguna mengirim create request dengan request body "authorization_test.json"
    Then Pengguna menerima data user yang telah dibuat dengan status code "200" ketika create user

  Scenario: Melakukan request create user dengan email yang belum ada di database
    Given Pengguna sudah menentukan base url untuk create user
    And Pengguna memiliki app-id yang valid untuk create user
    When Pengguna mengirim create request dengan request body "create_user.json"
    Then Pengguna menerima data user yang telah dibuat dengan status code "200" ketika create user

  Scenario: Melakukan request create user dengan email yang sudah ada di database
    Given Pengguna sudah menentukan base url untuk create user
    And Pengguna memiliki app-id yang valid untuk create user
    When Pengguna mengirim create request dengan request body "create_user.json"
    Then Pengguna menerima pesan error "BODY_NOT_VALID" dengan status code "400" ketika create user