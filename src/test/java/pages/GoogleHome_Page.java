package pages;

import runner.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GoogleHome_Page {


     WebDriver driver;
     Helpers helpers;


    public GoogleHome_Page(WebDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers(driver);
    }

    public By searchButton = By.xpath("(//*[@class=\"gNO89b\"])[1]");
    public By searchTextField = By.xpath("//*[@name=\"q\"]");
    public By netflixArgentinaResult = By.xpath("//a[@href='https://www.netflix.com/ar-en/']");



    public void navigateToGoogle(String URL){driver.get(URL); }

    public void clickGoogleSearch(){
        helpers.click(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        System.out.println("ingresando " +criteria);
        helpers.sendText(searchTextField,criteria);
    }
    public void clickOnNetflixArgentinaSearchResult(){
        helpers.click(netflixArgentinaResult);
    }


}
