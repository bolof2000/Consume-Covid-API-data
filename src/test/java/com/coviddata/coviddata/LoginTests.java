package com.coviddata.coviddata;


import com.coviddata.coviddata.base.BaseTest;
import com.coviddata.coviddata.pages.LoginPage;
import com.coviddata.coviddata.pages.SecureAreaPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends BaseTest {

    LoginPage loginPage;
    SecureAreaPage secureAreaPage;
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void positiveloginTest(){

        loginPage = homePage.clickFormAuthentication();
        secureAreaPage = loginPage.setLoginCredentials("tomsmith","SuperSecretPassword!!");
        String msg = secureAreaPage.secureAreaText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));

    }


}
