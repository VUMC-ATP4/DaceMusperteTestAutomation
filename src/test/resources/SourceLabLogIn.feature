Feature: Test all functionality of sauce labs login page

  Scenario: Successful login
    Given User navigates to 'https://www.saucedemo.com'
    And user sees page title 'Swag Labs'
    When user enters 'standard_user' and 'secret_sauce'
    And user clicks login button
    Then user sees inventory page

  Scenario: User sees error message if username empty
    Given User navigates to 'https://www.saucedemo.com'
    And user sees page title 'Swag Labs'
    When user enters '' and 'secret_sauce'
    And user clicks login button
    Then user sees error message 'Epic sadface: Username is required'

  Scenario: User sees error message if password empty
    Given User navigates to 'https://www.saucedemo.com'
    And user sees page title 'Swag Labs'
    When user enters 'standard_user' and ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Password is required'

  Scenario: User sees error message if username & password empty
    Given User navigates to 'https://www.saucedemo.com'
    And user sees page title 'Swag Labs'
    When user enters '' and ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Username is required'

  Scenario: User sees error message if wrong credentials are provided
    Given User navigates to 'https://www.saucedemo.com'
    And user sees page title 'Swag Labs'
    When user enters 'testjuris' and 'testpassword'
    And user clicks login button
    Then user sees error message 'Epic sadface: Username and password do not match any user in this service'

  Scenario Outline: User sees correct error message
    Given User navigates to 'https://www.saucedemo.com'
    And user sees page title 'Swag Labs'
    When user enters '<username>' and '<password>'
    And user clicks login button
    Then user sees error message '<error_message>'
    Examples:
      | username | password | error_message |
      |  | manaParole | Epic sadface: Username is required |
      | Juris123 |  | Epic sadface: Password is required |
      |  | | Epic sadface: Username is required |
      | Juris123 | MansParolis | Epic sadface: Username and password do not match any user in this service |