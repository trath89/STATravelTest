$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Statravel.feature");
formatter.feature({
  "line": 1,
  "name": "STATravel Tour Finder",
  "description": "",
  "id": "statravel-tour-finder",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "User is in STATravel website and searching tours based on country",
  "description": "",
  "id": "statravel-tour-finder;user-is-in-statravel-website-and-searching-tours-based-on-country",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is in STATravel website \"http://www.statravel.co.uk/tours-worldwide.htm\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User select country \"India\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User clicks on Find a Tour button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User lands on results page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.statravel.co.uk/tours-worldwide.htm",
      "offset": 30
    }
  ],
  "location": "SearchTourStepDefinition.user_is_in_STATravel_website(String)"
});
formatter.result({
  "duration": 11005411183,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "India",
      "offset": 21
    }
  ],
  "location": "SearchTourStepDefinition.user_select_country(String)"
});
formatter.result({
  "duration": 21708961075,
  "status": "passed"
});
formatter.match({
  "location": "SearchTourStepDefinition.user_clicks_on_Find_a_Tour_button()"
});
formatter.result({
  "duration": 3485146084,
  "status": "passed"
});
formatter.match({
  "location": "SearchTourStepDefinition.user_lands_on_results_page()"
});
formatter.result({
  "duration": 124440867,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Verify the total matches found is equal to the actual number of results displayed",
  "description": "",
  "id": "statravel-tour-finder;verify-the-total-matches-found-is-equal-to-the-actual-number-of-results-displayed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "User is in results page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "User change the sort order to \"Price (Low-High)\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User clicks on View More button to display more/all results",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Verify if \"65\" matches found text is equal to the actual number of results displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchTourStepDefinition.user_is_in_results_page()"
});
formatter.result({
  "duration": 364541678,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Price (Low-High)",
      "offset": 31
    }
  ],
  "location": "SearchTourStepDefinition.user_change_the_sort_order_to(String)"
});
formatter.result({
  "duration": 1032539905,
  "status": "passed"
});
formatter.match({
  "location": "SearchTourStepDefinition.user_clicks_on_View_More_button_to_display_more_all_results()"
});
formatter.result({
  "duration": 690459255,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "65",
      "offset": 11
    }
  ],
  "location": "SearchTourStepDefinition.verify_if_matches_found_text_is_equal_to_the_actual_number_of_results_displayed(int)"
});
formatter.result({
  "duration": 737378886,
  "status": "passed"
});
});