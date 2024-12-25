package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.icu.text.UnicodeSet;
import org.junit.Assert;
import pages.SearchResultPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import static stepdefinitions.SharedSD.getDriver;

public class SearchResultSD {

    SearchResultPage searchResultPage = new SearchResultPage();

    @Given("I am on default locations search result screen")
    public void searchResult() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        try {
            searchResultPage.clickCrossPopUP();
        } catch (Exception e) {

        }
    }

    @Then("I verify {string} is within the search result")
    public void iVerifyIsWithinTheSearchResult(String expectedHotelName) {
        ArrayList<String> hotelList = searchResultPage.getHotelsList();

        boolean result = false;
        for (String hotel : hotelList) {
            System.out.println(hotel);

            if (hotel.contains(expectedHotelName))
                result = true;

        }
        Assert.assertTrue("Given hotel is not present", result);
    }

    @Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String expectedPriceStr) {

        ArrayList<Integer> priceList = searchResultPage.getPriceList();
        System.out.println(priceList);

        int expectedPrice = Integer.parseInt(expectedPriceStr);
        ArrayList<Integer> greaterPriceList = new ArrayList<>();
        boolean result = true;
        for (int price : priceList) {
            if (price > expectedPrice)
                greaterPriceList.add(price);
            result = false;
        }

        Assert.assertTrue("some prices are greater than the expected price" + expectedPrice +
                        "\n below is the list of greater price\n" + greaterPriceList
                , result);
    }

    @When("I select option for stars as {}")
    public void iSelectOptionForStarsAs(String starsRating) {
        searchResultPage.clickRating(starsRating.substring(0, 1));
    }

    @Then("I verify system displays only {} hotels on search result")
    public void iVerifySystemDisplaysOnlyHotelsOnSearchResult(String starRatingStr) {

        String expectedRating = starRatingStr.substring(0,1);
        ArrayList<Integer> ratingList = searchResultPage.getAllRatings();
        System.out.println(ratingList);

        int size = ratingList.size();
        int frequency = Collections.frequency(ratingList, Integer.parseInt(expectedRating));

        System.out.println("size="+size);
        System.out.println("frequency="+frequency);

        boolean result = (size==frequency);
        Assert.assertTrue("all hotels rating are not same",result);
    }
}
