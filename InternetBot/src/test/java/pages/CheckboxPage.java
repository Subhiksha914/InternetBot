package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckboxPage {

    WebDriver driver;

    public CheckboxPage(WebDriver driver) {

        this.driver = driver;

    }

    By checkboxLink =
            By.linkText("Checkboxes");

    By checkbox1 =
            By.xpath("(//input[@type='checkbox'])[1]");

    By checkbox2 =
            By.xpath("(//input[@type='checkbox'])[2]");

    By dropdownLink =
            By.linkText("Dropdown");

    By dropdown =
            By.id("dropdown");

    public void openCheckboxPage() {

        driver.findElement(checkboxLink).click();

    }

    public void clickCheckbox1() {

        driver.findElement(checkbox1).click();

    }

    public void clickCheckbox2() {

        driver.findElement(checkbox2).click();

    }

    public boolean isCheckbox1Selected() {

        return driver.findElement(checkbox1)
                .isSelected();

    }

    public boolean isCheckbox2Selected() {

        return driver.findElement(checkbox2)
                .isSelected();

    }

    public void openDropdownPage() {

        driver.findElement(dropdownLink).click();

    }

    public void selectDropdownOption(String text) {

        WebElement element =
                driver.findElement(dropdown);

        Select select =
                new Select(element);

        select.selectByVisibleText(text);

    }

    public String getSelectedOption() {

        WebElement element =
                driver.findElement(dropdown);

        Select select =
                new Select(element);

        return select.getFirstSelectedOption()
                .getText();

    }

    public int getDropdownOptionsCount() {

        WebElement element =
                driver.findElement(dropdown);

        Select select =
                new Select(element);

        return select.getOptions().size();

    }

}