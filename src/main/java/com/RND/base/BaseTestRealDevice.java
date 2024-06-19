package com.RND.base;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import com.RND.common.GenericFunctions;
import com.RND.common.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.util.Date;

public class BaseTestRealDevice {
    protected AppiumDriverLocalService service;
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected ExtentReports extent;
    protected ExtentTest test;
    protected String testMethodName;
    protected String descriptiveTestName;
    protected Utility util;
    protected GenericFunctions gf;

    @BeforeSuite
    public void initialConfig() {
        ExtentSparkReporter spark = new ExtentSparkReporter("Verification of Login with mobile number.html");
        spark.config().setDocumentTitle("Tathya mobile Integration Test Execution Report");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Automation Test Report");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Test Type ", "Regression");
        extent.setSystemInfo("Environment", "Stage");
        extent.setSystemInfo("Author", "Prashanta Behera");
    }
    
    @BeforeClass
    public AndroidDriver configureAppium() throws MalformedURLException {

        // run appium server automatically

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\prashanta.behera\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        // create capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OnePlus AC2001");
        // options.setDeviceName("samsung SM-E045F ");
        options.setCapability("platformName", "Android");
        // options.setCapability("deviceUDID", "R9ZW705XRKT");
        options.setCapability("deviceUDID", "4e255fc2");
        options.setCapability("appium:appPackage", "com.wcdodisha.tathya");
        options.setCapability("appium:appActivity", "com.wcdodisha.tathya.MainActivity");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:ignoreHiddenApiPolicyError", "true");
        options.setCapability("appium:noReset", "true");
        // Set enforceXPath1 capability to true
        options.setCapability("enforceXPath1", true);

        return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }
    
    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        // Setup Appium driver before each test method
        driver = configureAppium(); // Initialize AppiumDriver
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        util = new Utility(driver);
        gf = new GenericFunctions(driver);

        testMethodName = method.getName();
        descriptiveTestName = method.getAnnotation(Test.class).testName();
        test = extent.createTest(descriptiveTestName);
        test.info("Test '" + descriptiveTestName + "' started at: " + new Date());
    }
    
   

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        }
        long endTime = System.currentTimeMillis();
        test.info("Test '" + descriptiveTestName + "' finished at: " + new Date(endTime));
        long duration = endTime - result.getStartMillis();
        test.info("Duration: " + Duration.ofMillis(duration).toString().substring(2)); // Display duration
    }

    @AfterSuite
    public void flushReport() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("Verification of Login with mobile number.html").toURI());
    }

   

    @AfterTest
    public void serviceClose() {
        if (service.isRunning() == true) {
            service.stop();
            System.out.println("Appium server closed");
        }
    }
}
