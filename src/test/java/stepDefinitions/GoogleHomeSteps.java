package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.GoogleHome_Page;
import runner.BasePage;

public class GoogleHomeSteps {


    BasePage basePage;
    WebDriver driver;

    GoogleHome_Page googleHome_page;

    public GoogleHomeSteps(BasePage basePage) {
        this.basePage = basePage;
        this.driver = basePage.getDriver();
        this.googleHome_page = new GoogleHome_Page(basePage.getDriver());
    }


    @Given("^on the google search page$")
    public void navigateToGoogle(){
        googleHome_page.navigateToGoogle("https://www.google.com");
    }


    @When("^enter the search criteria$")
    public void enterSearchCriteria(){
        googleHome_page.enterSearchCriteria("Netflix Argentina");
    }

    @And("^click in the search button$")
    public void clickSearchButton(){
        googleHome_page.clickGoogleSearch();
    }

    @And("^access to Netflix Argentina in Google results$")
    public void enterToNetflixArgentina(){
        googleHome_page.clickOnNetflixArgentinaSearchResult();
    }









}

