package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends BaseTest implements ITestListener {

    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {

        sparkReporter =
                new ExtentSparkReporter("ExtentReport.html");

        extentReports =
                new ExtentReports();

        extentReports.attachReporter(sparkReporter);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest =
                extentReports.createTest(result.getName());

        extentTest.pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest =
                extentReports.createTest(result.getName());

        extentTest.fail(result.getThrowable());

        String timestamp =
                new SimpleDateFormat("yyyyMMddHHmmss")
                        .format(new Date());

        File directory =
                new File("./screenshots");

        if (!directory.exists()) {

            directory.mkdir();

        }

        File screenshot =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String path =
                "./screenshots/"
                        + result.getName()
                        + timestamp
                        + ".png";

        try {

            FileUtils.copyFile(
                    screenshot,
                    new File(path)
            );

            extentTest.addScreenCaptureFromPath(path);

        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();

    }

}