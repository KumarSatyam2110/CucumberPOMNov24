package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.SharedSD.getDriver;

public class Base {
    //WebDriver driver;

    public WebElement webAction(By locator)
    {
        return getDriver().findElement(locator);
    }


    public void clickOn(By locator)
    {
        webAction(locator).click();
    }

    public void setValue(By locator, String value)
    {
        webAction(locator).sendKeys(value);
    }


    public String getElementText(By locator)
    {
        return webAction(locator).getText();
    }

    ArrayList<String> getElementTextList(By locator)
    {
        ArrayList<String> txtList = new ArrayList<>();

       List<WebElement> wbList = getDriver().findElements(locator);

       for (WebElement wb : wbList)
           txtList.add(wb.getText());

        return txtList;
    }
}
