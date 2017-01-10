Feature: Login

  Scenario: Pivotal Tracker Login.
    Given I am on the Pivotal Tracker login page
    When I insert my account name Roy.Rodriguez@fundacion-jala.org
    And I press NEXT button
    And I insert my password Sabbath27
    And I press SIGN IN button
    Then I should see the HomePage of Pivotal Tracker https://www.pivotaltracker.com/dashboard