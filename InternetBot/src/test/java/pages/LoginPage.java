package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    By formAuthLink =
            By.linkText("Form Authentication");

    By usernameField =
            By.id("username");

    By passwordField =
            By.id("password");

    By loginButton =
            By.cssSelector("button[type='submit']");

    By successMessage =
            By.id("flash");

    public void openLoginPage() {

        driver.findElement(formAuthLink).click();

    }

    public void enterUsername(String username) {

        driver.findElement(usernameField)
                .sendKeys(username);

    }

    public void enterPassword(String password) {

        driver.findElement(passwordField)
                .sendKeys(password);

    }

    public void clickLogin() {

        driver.findElement(loginButton).click();

    }

    public String getSuccessMessage() {

        return driver.findElement(successMessage)
                .getText();

    }

}