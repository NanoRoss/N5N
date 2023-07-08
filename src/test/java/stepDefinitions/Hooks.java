package stepDefinitions;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import runner.BasePage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {


    BasePage basePage;

    public Hooks(BasePage basePage){
        this.basePage = basePage;
    }

    @Before
    public void Before()   {
        basePage.setUp();
    }



    @After
    public void After(Scenario scenario) throws IOException, InterruptedException  {
        byte[] source = ((TakesScreenshot) basePage.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShotByte(), "image/jpg", scenario.getName());
        if(scenario.isFailed()) {
            takeScreenshot("Error: "+scenario.getName()+" ");
        }
        basePage.tearDown();
    }

    public byte[] screenShotByte()
    {
        return ((TakesScreenshot) basePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public String getDate() {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH.mm.ss dd-MM-yyyy");
        return hourdateFormat.format(date);
    }

    public void takeScreenshot(String nombre) {
        String Fecha = getDate();
        File MyScreenshot = ((TakesScreenshot) basePage.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(MyScreenshot, new File("src/test/resources/Screenshots/" + nombre + Fecha + ".png"));
            System.out.println("INFO: Tomando Screenshot: " + nombre + " Fecha: " + Fecha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
