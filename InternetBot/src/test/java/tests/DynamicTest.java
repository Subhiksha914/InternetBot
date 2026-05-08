package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicPage;

import java.time.Duration;

public class DynamicTest extends BaseTest {

    @Test
    public void dynamicLoadingTest() {

        DynamicPage dynamicPage =
                new DynamicPage(driver);

        dynamicPage.openDynamicLoadingPage();

        dynamicPage.openExample2();

        dynamicPage.clickStartButton();

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        org.openqa.selenium.By.xpath
                                ("//h4[text()='Hello World!']")
                )
        );

        Assert.assertEquals(
                dynamicPage.getHelloText(),
                "Hello World!"
        );

    }

    @Test
    public void disappearingElementsTest() {

        DynamicPage dynamicPage =
                new DynamicPage(driver);

        dynamicPage.openDisappearingElementsPage();

        driver.navigate().refresh();

        Assert.assertTrue(
                dynamicPage.isGalleryDisplayed()
        );

    }

}