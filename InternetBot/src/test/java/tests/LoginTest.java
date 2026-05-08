package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password,
                          boolean expectedResult) {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.openLoginPage();

        loginPage.enterUsername(username);

        loginPage.enterPassword(password);

        loginPage.clickLogin();

        String message =
                loginPage.getSuccessMessage();

        if(expectedResult) {

            Assert.assertTrue(
                    message.contains
                            ("You logged into a secure area!")
            );

        }

        else {

            Assert.assertTrue(
                    message.contains
                            ("Your username is invalid!")
                            ||
                            message.contains
                                    ("Your password is invalid!")
            );

        }

    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {

                {"tomsmith",
                        "SuperSecretPassword!",
                        true},

                {"wronguser",
                        "SuperSecretPassword!",
                        false},

                {"tomsmith",
                        "wrongpassword",
                        false}

        };

    }

}