package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {

    WebDriver driver;

    public AlertPage(WebDriver driver) {

        this.driver = driver;

    }

    By jsAlertLink =
            By.linkText("JavaScript Alerts");

    By alertButton =
            By.xpath("//button[text()='Click for JS Alert']");

    By confirmButton =
            By.xpath("//button[text()='Click for JS Confirm']");

    By promptButton =
            By.xpath("//button[text()='Click for JS Prompt']");

    By resultText =
            By.id("result");

    public void openAlertPage() {

        driver.findElement(jsAlertLink).click();

    }

    public void clickJsAlert() {

        driver.findElement(alertButton).click();

    }

    public void clickJsConfirm() {

        driver.findElement(confirmButton).click();

    }

    public void clickJsPrompt() {

        driver.findElement(promptButton).click();

    }

    public String getResultText() {

        return driver.findElement(resultText)
                .getText();

    }

}