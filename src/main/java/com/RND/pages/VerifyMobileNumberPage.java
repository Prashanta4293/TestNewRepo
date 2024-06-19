package com.RND.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RND.common.GenericFunctions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VerifyMobileNumberPage {
public AppiumDriver driver;
GenericFunctions gf=new GenericFunctions(driver);;
	

  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").index(0)")
  private WebElement otpField;
  
  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").index(1)")
  private WebElement otpField1;
  
  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").index(2)")
  private WebElement otpField2;
  
  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").index(3)")
  private WebElement otpField3;



	

	@AndroidFindBy(accessibility = "Verify") 
    private WebElement verifyButton;
    
	public VerifyMobileNumberPage(AppiumDriver appiumdriver) {
		this.driver = appiumdriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void loginOTP() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(otpField)).click();
		//otpField.click();
		Thread.sleep(15000);
//		otpField.sendKeys("1");
//		otpField1.sendKeys("1");
//		otpField2.sendKeys("1");
//		otpField3.sendKeys("1");
		verifyButton.click();
	}

}
