Feature: Deliver car messages
  The pipeline delivers correctly all sent messages

  Scenario: Send a Receive cars successfully
    Given the pipeline is up and running
    When the producer sends 100 cars
    Then the consumer receives 100 cars