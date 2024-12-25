package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.SharedSD.getDriver;

public class SearchResultPage extends Base {
    By hotel = By.xpath("//div[@data-testid='title']");

    public ArrayList<String> getHotelsList() {
        return getElementTextList(hotel);
    }

    By crossPopUp = By.xpath("//button[@aria-label='Dismiss sign in information.']");

    public void clickCrossPopUP() {
        clickOn(crossPopUp);
    }

    By priceElements = By.xpath("//span[@data-testid='price-and-discounted-price']");

    public ArrayList<Integer> getPriceList() {
        ArrayList<String> txtList = getElementTextList(priceElements);
        ArrayList<Integer> priceList = new ArrayList<>(); //₹ 12,580
        for (String rawPrice : txtList) {
            String priceWithComma = rawPrice.substring(2);
            String priceStr = priceWithComma.replace(",", ""); //₹ 12580
            int price = Integer.parseInt(priceStr);
            priceList.add(price);

        }
        return priceList;

    }

    public void clickRating(String stars)
    {
        By rating =By.xpath("//input[@name='class="+stars+"']");
       // clickOn(rating);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",webAction(rating));
    }
    By allRatingElements = By.xpath("//div[contains(@aria-label,'out of 5')]");

    public ArrayList<Integer> getAllRatings()
    {
        ArrayList<Integer> ratingList = new ArrayList<>();
        List<WebElement> wbList = getDriver().findElements(allRatingElements);

        for (WebElement wb: wbList)
        {
           String ratingStr = wb.getAttribute("aria-label").substring(0,1);
           ratingList.add(Integer.parseInt(ratingStr));
        }
        return ratingList;
    }
}
