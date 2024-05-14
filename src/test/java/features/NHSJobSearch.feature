Feature: NHS Job Search Functionality

  Scenario: Search for jobs with preferences
    Given I am a jobseeker on NHS Jobs website
    When I put my preferences into the Search functionality
    Then I should get a list of jobs which matches my preferences
    And my search results should be sorted by the newest Date Posted