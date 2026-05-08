package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicPage {

    WebDriver driver;

    public DynamicPage(WebDriver driver) {

        this.driver = driver;

    }

    By dynamicLoadingLink =
            By.linkText("Dynamic Loading");

    By example2Link =
            By.partialLinkText("Example 2");

    By startButton =
            By.xpath("//button[text()='Start']");

    By helloText =
            By.xpath("//h4[text()='Hello World!']");

    By disappearingElementsLink =
            By.linkText("Disappearing Elements");

    By galleryLink =
            By.linkText("Gallery");

    public void openDynamicLoadingPage() {

        driver.findElement(dynamicLoadingLink)
                .click();

    }

    public void openExample2() {

        driver.findElement(example2Link)
                .click();

    }

    public void clickStartButton() {

        driver.findElement(startButton)
                .click();

    }

    public String getHelloText() {

        return driver.findElement(helloText)
                .getText();

    }

    public void openDisappearingElementsPage() {

        driver.findElement(disappearingElementsLink)
                .click();

    }
    public boolean isGalleryDisplayed() {

        return driver.findElements(
                        By.linkText("Gallery"))
                .size() > 0;
    }

}