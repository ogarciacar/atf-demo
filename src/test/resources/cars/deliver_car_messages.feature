Feature: Deliver car messages
  The pipeline delivers correctly all car messages sent

  Scenario: Delivers up to 10 cars messages successfully
    When the producer sends 10 cars
    Then the consumer receives the same amount of cars

  Scenario: Delivers up to 100 cars messages successfully
    When the producer sends 100 cars
    Then the consumer receives the same amount of cars

  Scenario: Delivers up to 1000 cars messages successfully
    When the producer sends 1000 cars
    Then the consumer receives the same amount of cars

  Scenario: Delivers up to 10K cars messages successfully
    When the producer sends 10000 cars
    Then the consumer receives the same amount of cars

  Scenario: Delivers up to 100K cars messages successfully
    When the producer sends 100000 cars
    Then the consumer receives the same amount of cars

  Scenario: Delivers up to 1M cars messages successfully
    When the producer sends 1000000 cars
    Then the consumer receives the same amount of cars