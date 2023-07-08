@Test
Feature: Test Basic for Netflix Home Page

  @Smoke
  Scenario: As a user go to Netflix website and validate the site's title and url
    Given on the google search page
    When enter the search criteria
    And click in the search button
    And access to Netflix Argentina in Google results
    Then validate url: "https://www.netflix.com"
    Then validate the page Title: "Películas y series ilimitadas y mucho más"


  @Smoke
  Scenario: As a user go to Netflix website and login with invalid credentials
    Given on the google search page
    When enter the search criteria
    And click in the search button
    And access to Netflix Argentina in Google results
    And login with user "FakeUser123" and pass "FakePass123"
    Then user can't log in and see a descriptive message


