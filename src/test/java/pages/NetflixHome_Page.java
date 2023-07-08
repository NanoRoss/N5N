package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import runner.Helpers;
public class NetflixHome_Page {

    WebDriver driver;
    Helpers helpers;

    public NetflixHome_Page(WebDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers(driver);
    }

    public By webTitle = By.cssSelector("h1[data-uia='nmhp-card-hero-text-title']");

    public By EnterBtn = By.cssSelector("a[href='/ar/login']");
    public By userField = By.xpath("//input[@id='id_userLoginId']");
    public By passwordField = By.xpath("//input[@id='id_password']");
    public By loginBtn = By.xpath("//button[contains(text(),'Iniciar sesión')]");
    public By loginMje = By.cssSelector("div[class=\"ui-message-contents\"]");

    public String obtainWebTitle() {
        return helpers.getText(webTitle);
    }
    public void changueLanguageToSpanish() {
        WebElement selectElement = driver.findElement(By.xpath("(//select[@name='LanguageSelect'])[1]"));
        Select select = new Select(selectElement);
        if (select.getFirstSelectedOption().getAttribute("lang").equals("en")) {
            select.selectByVisibleText("Español");
        }
        helpers.sleepSeconds(10);
    }
    public void loginIntoNetflix(String user, String pass) {
        changueLanguageToSpanish();
        helpers.click(EnterBtn);
        helpers.sendText(userField,user);
        helpers.sendText(passwordField,pass);
        helpers.click(loginBtn);
    }

    public String returnLoginResultMje() {
        return helpers.getText(loginMje);
    }


}