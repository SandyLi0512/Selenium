# new feature
# Tags: optional

Feature: Login yandex web

  Scenario: Login yandex website
    Given I navigate to yandex website
    When I click Log in button
    And I input account, password and click sing in
      | email               | password             |
      | sandy.l1@yandex.com |7WA2yKFbyQTw5va          |
    Then I see the organization home page

  Scenario: Create new email
    Given I click Compose button
    When I give email address
      | emailAddress             |
      | sandy029@yandex.com        |
    And I give email subject
      | emailSubject             |
      | testing        |
    And I give email detail text
      | emailText             |
      | testing testing       |
    Then I click close button

  Scenario: Verify the email in Draft
    Given I click Draft link
    When I get the email title in Draft
    And I click send button
    Then Check the email deleted from draft

  Scenario: Send the email
    Given I check the sent email in inbox
    When Checked the email title in sent box
    Then Logout account