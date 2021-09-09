package automation.tests;


import automation.base.BaseTest;
import com.pages.LoginPage;
import com.pages.SecureAreaPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends BaseTest {

    LoginPage loginPage;
    SecureAreaPage secureAreaPage;
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void negloginTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith","SuperSecretPassword!");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }
    @Test
    public void psvloginTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith1","SuperSecretPassword!");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }

    @Test
    public void failedloginTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith","SuperSecretPassword!");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }



    @Test
    public void positiveTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith","SuperSecretPassword!");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }

    @Test
    public void negativeTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith","SuperSecretPassword!");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }

    @Test
    public void covidDataTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith","SuperSecretPassword!");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }

    @Test
    public void alertFirstTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith","SuperSecretPassword!1");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }

    @Test
    public void positiveFailedTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith1","SuperSecretPassword!");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }


}
