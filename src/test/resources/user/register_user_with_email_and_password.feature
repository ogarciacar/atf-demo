Feature: Register user with email and password
  The user is able to register using email and password

  Scenario: Unsuccessful registration
    Given the user types only its email "user@email.com"
    When the user tries to register into the system
    Then the user gets an error 400 and the message "Missing password"

  Scenario Outline: Successful registration
    Given the user types email "<email>" and password "<password>"
    When the user tries to register into the system
    Then the user gets a successful registration along with a token

    Examples:
      | email | password |
      | george.bluth@reqres.in | secret |
      | janet.weaver@reqres.in | password |
      | emma.wong@reqres.in | my_pass |