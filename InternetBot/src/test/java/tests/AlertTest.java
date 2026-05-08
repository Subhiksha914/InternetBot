package tests;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void jsAlertTest() {

        AlertPage alertPage =
                new AlertPage(driver);

        alertPage.openAlertPage();

        alertPage.clickJsAlert();

        Alert alert =
                driver.switchTo().alert();

        alert.accept();

        String result =
                alertPage.getResultText();

        Assert.assertTrue(
                result.contains
                        ("You successfully clicked an alert")
        );

    }

    @Test
    public void jsConfirmTest() {

        AlertPage alertPage =
                new AlertPage(driver);

        alertPage.openAlertPage();

        alertPage.clickJsConfirm();

        Alert alert =
                driver.switchTo().alert();

        alert.dismiss();

        String result =
                alertPage.getResultText();

        Assert.assertTrue(
                result.contains("Cancel")
        );

    }

    @Test
    public void jsPromptTest() {

        AlertPage alertPage =
                new AlertPage(driver);

        alertPage.openAlertPage();

        alertPage.clickJsPrompt();

        Alert alert =
                driver.switchTo().alert();

        alert.sendKeys("InternetBot");

        alert.accept();

        String result =
                alertPage.getResultText();

        Assert.assertTrue(
                result.contains("InternetBot")
        );

    }

}