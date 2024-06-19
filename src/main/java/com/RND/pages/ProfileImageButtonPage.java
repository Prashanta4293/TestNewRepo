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

public class ProfileImageButtonPage {
	
	public AppiumDriver driver;
	public GenericFunctions gf;
	    
//	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Select Aanganwadi\")")
//	private WebElement selectAanganwadiDropdown;
//	
//		@AndroidFindBy(accessibility = "Show Beneficiary") 
//	    private WebElement showBeneficiaryButton ;
//		
		@AndroidFindBy(accessibility = "Logout") 
	    private WebElement logoutButton ;
//		
//		@FindBy(xpath = "//android.widget.Button[@bounds='[939,169][1052,281]']")
//		//@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").index(1)")
//	    private WebElement clickProfileImageButton ;
		
		@AndroidFindBy(accessibility = "Choose Sector") 
	    private WebElement clickChooseSectorButton ;
	    
		 public ProfileImageButtonPage(AppiumDriver appiumDriver) {
		        this.driver = appiumDriver;
		        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		        gf=new GenericFunctions(driver);
		    }
	
	 public void chooseSectorButtonValidation() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(clickChooseSectorButton)).click();
	}
	

}
