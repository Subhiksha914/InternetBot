package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage {

    WebDriver driver;

    public UploadPage(WebDriver driver) {

        this.driver = driver;

    }

    By fileUploadLink =
            By.linkText("File Upload");

    By chooseFile =
            By.id("file-upload");

    By uploadButton =
            By.id("file-submit");

    By uploadedFileName =
            By.id("uploaded-files");

    By pageTitle =
            By.tagName("h3");

    public void openUploadPage() {

        driver.findElement(fileUploadLink).click();

    }

    public void uploadFile(String filePath) {

        driver.findElement(chooseFile)
                .sendKeys(filePath);

    }

    public void clickUploadButton() {

        driver.findElement(uploadButton).click();

    }

    public String getUploadedFileName() {

        return driver.findElement(uploadedFileName)
                .getText();

    }

    public String getPageTitle() {

        return driver.findElement(pageTitle)
                .getText();

    }

}