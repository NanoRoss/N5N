package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.NetflixHome_Page;
import runner.BasePage;
import runner.Helpers;

public class NetflixHomeSteps {

    BasePage basePage;

    Helpers helpers;
    WebDriver driver;

    NetflixHome_Page netflixHomePage;

    public NetflixHomeSteps(BasePage basePage) {
        this.basePage = basePage;
        this.driver = basePage.getDriver();
        this.netflixHomePage = new NetflixHome_Page(basePage.getDriver());
    }


    @Then("validate url: {string}")
    public void validateNetflixUrl(String urlTarget){
        String url = driver.getCurrentUrl();
        System.out.println("--- INFO: la url es: " + url);
        Assert.assertTrue(url.contains(urlTarget));
    }

    @Then("validate the page Title: {string}")
    public void validateSiteTitle(String titleTarget){
        netflixHomePage.changueLanguageToSpanish();

        String title = netflixHomePage.obtainWebTitle();
        System.out.println("INFO: El titulo de la pagina es: " + title);
        Assert.assertTrue(title.contains(titleTarget));
    }

    @And("login with user {string} and pass {string}")
    public void loginInToNetflix(String user, String pass){
        netflixHomePage.loginIntoNetflix(user,pass);
    }

    @Then("^user can't log in and see a descriptive message$")
    public void userCantLoginDescriptiveMessage(){
        Assert.assertTrue(netflixHomePage.returnLoginResultMje().contains("No podemos encontrar una cuenta"));
    }

}
