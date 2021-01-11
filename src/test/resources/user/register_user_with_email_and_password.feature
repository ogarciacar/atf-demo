Feature: Register user with email and password
  The user is able to register using email and password

  Scenario Outline: Valid registration responses
    Given the user types email "<email>" and password "<password>"
    When the user tries to register into the system
    Then the system responds "<status>" and the error message is "<error>"

    Examples:
      | email | password | status | error |
      | janet.weaver@reqres.in  | password  | 200 ||
      | george.bluth@reqres.in  | secret    | 200 ||
      | emma.wong@reqres.in     | my_pass   | 200 ||
      | user@email              | pass      | 400 | Note: Only defined users succeed registration |
      | user@email              |           | 400 | Missing password |
      | emma.wong@reqres.in     |           | 400 | Missing password |
      |                         | pass      | 400 | Missing email or username |
