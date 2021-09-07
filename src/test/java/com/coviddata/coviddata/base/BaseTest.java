package com.coviddata.coviddata.base;
import com.coviddata.coviddata.pages.HomePage;
import com.coviddata.coviddata.utils.EventReporter;
import com.coviddata.coviddata.utils.WindowsManager;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Todo Create setup to initialize common funtions to all tests
    //Todo Create teadoown

    private EventFiringWebDriver driver;
    protected HomePage homePage;
    public static final String pass_screen_shot_path = "/Volumes/Projects/microservice-apps/covid-data/src/main/resources/testresults/pass/";
    public static final String driver_path = "/Volumes/Projects/microservice-apps/covid-data/src/main/resources/drivers/geckodriver";
    private static final String url = "https://the-internet.herokuapp.com";
    public static final String fail_screen_shot_path = "/Volumes/Projects/microservice-apps/covid-data/src/main/resources/testresults/fails/";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver",driver_path);
        driver = new EventFiringWebDriver(new FirefoxDriver());
        driver.register(new EventReporter());
       launchUrl();
        driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void launchUrl(){
        driver.get(url);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.close();
        Thread.sleep(1000);
    }

    @AfterMethod
    public void recordFailure(ITestResult result ) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()){

            var camera =  (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            //System.out.println("Screenshot Taken: " + screenshot.getAbsolutePath());
            Files.move(screenshot,new File(pass_screen_shot_path +result.getName()+ ".png"));

        }}

        @AfterMethod
        public void recordSuccess(ITestResult result ) throws IOException {
            if(ITestResult.SUCCESS == result.getStatus()){

                var camera =  (TakesScreenshot)driver;
                File screenshot = camera.getScreenshotAs(OutputType.FILE);
               // System.out.println("Screenshot Taken: " + screenshot.getAbsolutePath());
                Files.move(screenshot,new File(fail_screen_shot_path+ result.getName()+ ".png"));

            }
    }

    public WindowsManager getWindowsManager(){
        return new WindowsManager(driver);
    }

}

