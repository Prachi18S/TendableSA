Feature: Tendable

  Background: 
    Given user navigates to Tendable URL

  Scenario: Verify that user can access top-level menus
    Then user can access top--level menus: Home, Our Story, Our Solution, and Why Tendable

  Scenario Outline: Verify that the "Request a Demo" button is present and active on each of the aforementioned top-level menu pages
    Given user clicks "<menu>"
    Then user can see Request a Demo button is present and active

    Examples: 
      | menu          |
      | Our Story     |
      | Our Solution  |
      | Why Tendable? |

  Scenario: Verify on submitting all the fields excluding the "Message" field in Marketing section, an error should be displayed
    Given user clicks "Contact Us"
    When user navigates to "Marketing" section
    And user submits fullName, organisationName, Phone Number, email, jobRole
    And user clicks "Agree"  button
    And user clicks "submit" button
    Then "Sorry, there was an error submitting the form. Please try again." error should be displayed
