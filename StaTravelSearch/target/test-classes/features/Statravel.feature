Feature: STATravel Tour Finder 

  Scenario: User is in STATravel website and searching tours based on country 
    Given User is in STATravel website "http://www.statravel.co.uk/tours-worldwide.htm"
    When  User select country "India"
    And   User clicks on Find a Tour button 
    Then  User lands on results page 
    
   
    
  Scenario: Verify the total matches found is equal to the actual number of results displayed
    Given User is in results page 
    When User change the sort order to "Price (Low-High)"
    And User clicks on View More button to display more/all results
    Then Verify if "65" matches found text is equal to the actual number of results displayed    
