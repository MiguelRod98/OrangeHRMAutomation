#language: en
#Project: orangeHRM - Choucair
#Date: 18/12/2024
#Autor: Amazon Q

@PIM
Feature: Employee Management in PIM

  As an HR administrator,
  I want to create a new employee in PIM with login details,
  To manage employee information and validate the employee exists in the system.

  Scenario Outline: Successfully creating a new employee with login details
    Given the HR administrator is on the login page
    When he logs in with admin credentials
      | username   | password   |
      | <username> | <password> |
    And he navigates to the PIM module
    And he adds a new employee with login details
      | firstName   | middleName   | lastName   | createLoginDetails   | userPassword   | confirmPassword   | status   |
      | <firstName> | <middleName> | <lastName> | <createLoginDetails> | <userPassword> | <confirmPassword> | <status> |
    And he navigates to employee list
    And he searches for the created employee
    Then he should see the employee exists in the list
      | firstName   |
      | <firstName> |

    Examples:
      | username | password | firstName | middleName | lastName | createLoginDetails | userPassword | confirmPassword | status  |
      | Admin    | admin123 | Juan      | Carlos     | Perez    | Yes                | Pass123!     | Pass123!        | Enabled |