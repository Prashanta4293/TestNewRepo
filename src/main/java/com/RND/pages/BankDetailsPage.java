package com.RND.pages;

	import org.openqa.selenium.WebElement;
		import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.RND.common.GenericFunctions;

import io.appium.java_client.AppiumBy;
	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.pagefactory.AppiumFieldDecorator;

		public class BankDetailsPage {
		public AppiumDriver driver;
		public GenericFunctions gf;
		
		@FindBy(xpath = "//android.view.View[@content-desc=\"Bank Name\"]")
		private WebElement bankNameDropDown;
		
		@FindBy(xpath = "//android.view.View[@content-desc=\"ABHYUDAYA COOPERATIVE BANK LIMITED\"]")
		private WebElement bankName;
		
		@FindBy(xpath = "//android.view.View[@content-desc=\"IFSC Code\"]")
		private WebElement IFSCDropdown;
		
		@FindBy(xpath = "//android.view.View[@content-desc=\"ABHY0065002\"]")
		private WebElement IFSC;
		
		@FindBy(xpath = "//android.widget.EditText[@hint='Account Number']")
	    private WebElement accountNumberText;
		
		@FindBy(xpath = "//android.view.View[@content-desc=\"ABHY0065002\"]")
		private WebElement accountHolderNameText;
		
		@FindBy(xpath = "//android.widget.Button[@content-desc=\"SAVE\"]")
	    private WebElement saveButton;
		
			 public BankDetailsPage(AppiumDriver appiumDriver) {
			        this.driver = appiumDriver;
			        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			        gf=new GenericFunctions(driver);
			    }
			
			public void addGuardianBankDetailsButton() {
				bankNameDropDown.click();
				bankName.click();
				IFSCDropdown.click();
				IFSC.click();
				accountNumberText.sendKeys("12345678901");
				driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				        + ".scrollIntoView(new UiSelector()" + ".description(\"" + "SAVE" + "\").instance(0))"));
				accountHolderNameText.sendKeys("Test Acnt Holder");
				
				saveButton.click();
				
			}
			
			

		}