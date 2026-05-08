package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadPage;

public class UploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {

        UploadPage uploadPage =
                new UploadPage(driver);

        uploadPage.openUploadPage();

        Assert.assertEquals(
                uploadPage.getPageTitle(),
                "File Uploader"
        );

        String filePath =
                System.getProperty("user.dir")
                        + "/testfile.txt";

        uploadPage.uploadFile(filePath);

        uploadPage.clickUploadButton();

        Assert.assertEquals(
                uploadPage.getUploadedFileName(),
                "testfile.txt"
        );

    }

}
