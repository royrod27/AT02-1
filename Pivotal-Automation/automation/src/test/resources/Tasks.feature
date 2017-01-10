Feature: Task
  Scenario: Delete Task
    Given I am logged on the pivotal tracker web page with e-mail Roy.Rodriguez@fundacion-jala.org and password Sabbath27
    And I have a projectTest project created
    And I have a testStory Story created
    And I have a task taskOne created
    When I delete taskOne
    Then taskOne should be deleted