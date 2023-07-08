package runner;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    public WebDriver driver;
    public WebDriverWait wait;

    public Helpers(WebDriver driver)
    {
        this.driver = driver;
    }

    public Helpers()
    {

    }


    public void click(By ElementToWaitAndClick) {

            driver.findElement(ElementToWaitAndClick).click();
            System.out.println("INFO: Click On: "+ElementToWaitAndClick.toString());
    }


    public void sendText(By ElementToWaitAndSendKeys, String text) {
            driver.findElement(ElementToWaitAndSendKeys).clear();
            driver.findElement(ElementToWaitAndSendKeys).sendKeys(text);
    }


    public String getText(By ElementToWaitAndGetText) {
        return driver.findElement(ElementToWaitAndGetText).getText();
    }

    public void sleepSeconds(int seconds)
    {
        try {
            System.out.println("INFO: Espera de: "+ seconds+" Segundos");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
