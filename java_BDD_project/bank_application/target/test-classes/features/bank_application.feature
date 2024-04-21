Feature: Bank Credit Offers Management
#task2
  Scenario: Adding usual customer to economy offer
    Given an economy credit offer with ID "1"
    And a usual customer named "John"
    When the usual customer is added to the economy offer
    Then the usual customer should be added successfully

  Scenario: Removing usual customer from economy offer
    Given an economy credit offer with ID "2"
    And a usual customer named "John" added to the economy offer
    When the usual customer is removed from the economy offer
    Then the usual customer should be removed successfully

  Scenario: Adding VIP customer to economy offer
    Given an economy credit offer with ID "3"
    And a VIP customer named "Alice"
    When the VIP customer is added to the economy offer
    Then the VIP customer should be added successfully

  Scenario: Removing VIP customer from economy offer
    Given an economy credit offer with ID "4"
    And a VIP customer named "Emma" added to the economy offer
    When the VIP customer is removed from the economy offer
    Then the VIP customer should not be removed

  Scenario: Not adding usual customer to business offer
    Given a business credit offer with ID "5"
    And a usual customer named "Mike"
    When the usual customer is added to the business offer
    Then the usual customer should not be added

  Scenario: Not removing usual customer from any offer
    Given a business credit offer with ID "6"
    And a usual customer named "Kate"
    When the usual customer is removed from any offer
    Then the usual customer should not be removed

  Scenario: Adding VIP customer to business offer
    Given a business credit offer with ID "7"
    And a VIP customer named "Tom"
    When the VIP customer is added to the business offer
    Then the VIP customer should be added successfully

  Scenario: Not removing VIP customer from any offer
    Given a business credit offer with ID "8"
    And a VIP customer named "Emma"
    When the VIP customer is removed from any offer
    Then the VIP customer should not be removed

    #task3
  Scenario: Adding usual customer to premium offer
    Given a premium credit offer with ID "9"
    And a usual customer named "David"
    When the usual customer is added to the premium offer
    Then the usual customer should not be added

  Scenario: Adding VIP customer to premium offer
    Given a premium credit offer with ID "10"
    And a VIP customer named "Sophia"
    When the VIP customer is added to the premium offer
    Then the VIP customer should be added successfully

  Scenario: Removing customer from premium offer
    Given a premium credit offer with ID "11"
    And a customer named "Anna" added to the premium offer
    When the customer is removed from the premium offer
    Then the customer should be removed successfully

    #task4

  Scenario: Adding the same customer to an offer again
    Given a "economy" credit offer with ID "12"
    And a customer named "Maria" added to the credit offer
    When the same customer is added to the credit offer again
    Then the customer should not be added again

    #task5

  Scenario Outline: Calculate bonus points for customers applying for an economy credit offer
    Given an economy credit offer with ID <offer_id> and credit amount <credit_amount>
    And A <customer_type> named <customer_name>
    When the bonus points are calculated for the customer
    Then the bonus points should be <expected_bonus_points>

    Examples:
      | offer_id | credit_amount | customer_type | customer_name | expected_bonus_points |
      | "1"      | 1000.0        | "VIP"         | "Alice"       | 100                   |
      | "2"      | 2000.0        | "usual"       | "John"        | 100                   |
      | "3"      | 500.0         | "VIP"         | "Bob"         | 50                    |
      | "4"      | 3000.0        | "usual"       | "Emma"        | 150                   |


  Scenario Outline: Calculate bonus points for customers applying for a business credit offer
    Given a business credit offer with ID <offer_id> and credit amount <credit_amount>
    And A <customer_type> named <customer_name>
    When the bonus points are calculated for the customer for business offer
    Then the bonus points for business offer should be <expected_bonus_points>

    Examples:
      | offer_id | credit_amount | customer_type | customer_name | expected_bonus_points |
      | "1"      | 1000.0        | "VIP"         | "Alice"       | 150                   |
      | "2"      | 2000.0        | "usual"       | "John"        | 140                   |
      | "3"      | 500.0         | "VIP"         | "Bob"         | 75                    |
      | "4"      | 3000.0        | "usual"       | "Emma"        | 210                   |

  Scenario Outline: Calculate bonus points for customers applying for a premium credit offer
    Given a premium credit offer with ID <offer_id> and credit amount <credit_amount>
    And A <customer_type> named <customer_name>
    When the bonus points are calculated for the customer for premium offer
    Then the bonus points for premium offer should be <expected_bonus_points>

    Examples:
      | offer_id | credit_amount | customer_type | customer_name | expected_bonus_points |
      | "1"      | 1000.0        | "VIP"         | "Alice"       | 200                   |
      | "2"      | 2000.0        | "usual"       | "John"        | 200                   |
      | "3"      | 500.0         | "VIP"         | "Bob"         | 100                   |
      | "4"      | 3000.0        | "usual"       | "Emma"        | 300                   |
