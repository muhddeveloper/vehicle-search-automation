Feature: Car Search using registration number


  Scenario Outline: Search for Valid Car
    Given I have valid car registration number
    When Car registration number is "<regNumber>"
    Then The result should have Car Color "<carColor>" and Car Make "<carMake>"
    Then Close the browser

    Examples:
      | regNumber | carColor   | carMake  |
      | SK63CKC   | WHITE      | TOYOTA  |
      | PX13PXV   | WHITE       | SUZUKI |