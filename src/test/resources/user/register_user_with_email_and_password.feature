Feature: Register user with email and password
  The user is able to register using email and password

  Scenario: Unsuccessful registration
    Given the user types only its email "user@email.com"
    When the user tries to register into the system
    Then the user gets an error 400 and the message "Missing password"

  Scenario: Successful registration
    Given the user types email "user@email.com" and password "secret"
    When the user tries to register into the system
    Then the user gets a successful registration along with a token