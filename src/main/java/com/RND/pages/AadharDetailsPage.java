package com.RND.pages;


import java.time.Duration;

import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.RND.common.GenericFunctions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

	public class AadharDetailsPage {
	public AppiumDriver driver;
	public GenericFunctions gf;
	
	
	@FindBy(xpath = "//android.view.View/android.widget.RadioButton[1]")
	private WebElement beneficiaryAadharRadioButton;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"SAVE\"]")
    private WebElement saveButton;
	
	@FindBy(xpath = "//android.widget.EditText[@hint='Guardian Relation']")
    private WebElement guardianRelationText;
	
	@FindBy(xpath = "//android.view.View[@bounds='[60,416][360,484]']")
    private WebElement uploadGuardianAadhar;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Gallery\"]")
    private WebElement chooseGallery;
	
	@FindBy(xpath = "//android.widget.ImageView[@bounds='[0,412][236,648]']")
	private WebElement chooseImageFromGallery;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"Crop\"]")
    private WebElement cropImageOk;
	
		
		
	    
		 public AadharDetailsPage(AppiumDriver appiumDriver) {
		        this.driver = appiumDriver;
		        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		        gf=new GenericFunctions(driver);
		    }
		
		public void addGuardianAadharDetatilsButton() {
			//gf.clickByJS(beneficiaryAadharRadioButton, driver);
			beneficiaryAadharRadioButton.click();
			guardianRelationText.click();
			guardianRelationText.sendKeys("Test Relation");
			driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
			        + ".scrollIntoView(new UiSelector()" + ".description(\"" + "SAVE" + "\").instance(0))"));
			uploadGuardianAadhar.click();
			chooseGallery.click();
			chooseImageFromGallery.click();
			cropImageOk.click();
			saveButton.click();
			
		}
		
		

	}