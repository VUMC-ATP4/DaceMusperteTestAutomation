Feature: Sauce demo login feature

  Scenario: User can see correct title Google
#  User can login with correct username/password
    Given User navigates to 'http://google.lv'
    Then user sees page title 'Google'
#    When user enters 'standard_user' and 'secret_sauce'
#    And user clicks login button
#    Then user sees inventory page

    # aizkomentē ciet

  Scenario: User can see correct title LU
    Given User navigates to 'http://www.lu.lv'
    Then user sees page title 'Latvijas Universitāte'

  Scenario: User can see correct title RTU
    Given User navigates to 'http://www.rtu.lv'
    Then user sees page title 'Rīgas Tehniskā universitāte | Inženierzinātņu centrs Baltijā'
