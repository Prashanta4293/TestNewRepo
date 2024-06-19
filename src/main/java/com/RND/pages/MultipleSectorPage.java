package com.RND.pages;

	import java.time.Duration;

import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RND.common.GenericFunctions;

import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

	public class MultipleSectorPage {
	public AppiumDriver driver;
	public GenericFunctions gf;
	    
	
	@FindBy(xpath = "//android.view.View[@bounds='[62,661][1018,841]']")
	private WebElement chooseFuladi;
	
	@AndroidFindBy(accessibility = "Khinda") 
	private WebElement chooseKhinda;
	    
    public MultipleSectorPage(AppiumDriver appiumDriver) {
		    this.driver = appiumDriver;
		    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		    gf=new GenericFunctions(driver);
	}
		
    public void checkForChangeSectorOne() {
			
			chooseFuladi.click();
			
	}
		
    public void checkForSupervisorAllValidation() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(chooseKhinda)).click();
	}
		
	}