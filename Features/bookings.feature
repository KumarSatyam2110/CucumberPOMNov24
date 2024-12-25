Feature: All bookings.com scenarios


  https://www.booking.com/searchresults.en-gb.html?ss=Pune&ssne=Pune&ssne_untouched=Pune&efdco=1&label=gen173nr-1BCAEoggI46AdIM1gEaGyIAQGYAQm4ARfIAQzYAQHoAQGIAgGoAgO4AtrD_LYGwAIB0gIkNDJjZjU3MzQtNzM1NS00NWU3LWJjNGItNWFmNDdhZWM4OGI52AIF4AIB&sid=8918bb74d902fb87b582710b0a1c8fc6&aid=356980&lang=en-gb&sb=1&src_elem=sb&src=searchresults&dest_id=-2108361&dest_type=city&checkin=2025-01-15&checkout=2025-01-17&group_adults=2&no_rooms=1&group_children=0


# 1
  @starverify
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select option for stars as <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |
      | 4 stars |
      | 3 stars |






  @maxAmount
  Scenario: check the hotel prices are below a certain amount
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "10000" amount



#3
  @HotelSearch
  Scenario: verify given hotel is present in the list
    Given I am on default locations search result screen
    Then I verify "Shantai Hotel" is within the search result