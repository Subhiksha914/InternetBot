package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxPage;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkboxTest() {

        CheckboxPage checkboxPage =
                new CheckboxPage(driver);

        checkboxPage.openCheckboxPage();

        checkboxPage.clickCheckbox1();

        Assert.assertTrue(
                checkboxPage.isCheckbox1Selected()
        );

        checkboxPage.clickCheckbox2();

        Assert.assertFalse(
                checkboxPage.isCheckbox2Selected()
        );

    }

    @Test
    public void dropdownTest() {

        CheckboxPage checkboxPage =
                new CheckboxPage(driver);

        checkboxPage.openDropdownPage();

        checkboxPage.selectDropdownOption("Option 1");

        Assert.assertEquals(
                checkboxPage.getSelectedOption(),
                "Option 1"
        );

        checkboxPage.selectDropdownOption("Option 2");

        Assert.assertEquals(
                checkboxPage.getSelectedOption(),
                "Option 2"
        );

        Assert.assertEquals(
                checkboxPage.getDropdownOptionsCount(),
                3
        );

    }

}
