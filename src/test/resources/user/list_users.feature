Feature: Get user list
  The user is able to get all the user list

  Scenario: Successful user list retrieval
    When the user tries to get users from the page 1
    Then the user list is not empty
    When the user tries to get users from the page 2
    Then the user list is not empty
    When the user tries to get users from the page 2000
    Then the user list is empty