@GET
Feature: Get

  Scenario: Melakukan request get user tanpa header app-id
    Given Pengguna sudah menentukan base url
    And Pengguna tidak memiliki app-id
    When Pengguna mengirim get request
    Then Pengguna menerima pesan error "APP_ID_MISSING" dengan status code "403"