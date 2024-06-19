package com.RND.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RND.common.GenericFunctions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	public AppiumDriver driver; 
	public GenericFunctions gf;

    @FindBy(xpath = "//android.widget.EditText[@hint='Mobile number']")
    private WebElement mobileNumber;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"SEND OTP\"]")
    private WebElement sendOTP;

    public LoginPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        gf=new GenericFunctions(driver);
    }

    public void login() {
        System.out.println("Entering login method");
        //gf.highlightMobileElement(driver,mobileNumber);
        mobileNumber.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(mobileNumber)).sendKeys("8329422716");;
        //mobileNumber.sendKeys("8329422716");
        sendOTP.click();
        System.out.println("Exiting login method");
    }
}
