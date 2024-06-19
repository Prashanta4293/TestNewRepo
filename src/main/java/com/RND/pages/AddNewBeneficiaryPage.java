package com.RND.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.RND.common.GenericFunctions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

	public class AddNewBeneficiaryPage {
	public AppiumDriver driver;
	public GenericFunctions gf;
		
	@FindBy(xpath = "//android.widget.EditText[@index='0']")
    private WebElement beneficiaryNameTextField;
	
	@FindBy(xpath = "//android.view.View[@bounds='[385,1224][1004,1365]']")
	private WebElement dateOfBirthField;
	
	@AndroidFindBy(accessibility = "Select year") 
    private WebElement chooseYearButton ;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"2010\"]")
	private WebElement chooseYear2010;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"10, Wednesday, March 10, 2010\"]")
	private WebElement chooseDate;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
	private WebElement calenderOKButton;
	
	@FindBy(xpath = "//android.widget.RadioButton[@index='3']")
	private WebElement femaleRadioButton;
	
	@FindBy(xpath = "//android.widget.RadioButton[@bounds='[257,535][347,625]']")
	private WebElement maleRadioButton;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Select Type\"]")
	private WebElement beneficiaryTypeDropDown;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Kishori\")")
	private WebElement kishoriTypeDropDownOption;
	
	@FindBy(xpath = "//android.widget.Button[@bounds='[385,1682][1004,1823]']")
	private WebElement categoryTypeDropDown;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"OBC\"]")
	private WebElement OBCTypeDropDownOption;
	
	@FindBy(xpath = "//android.widget.EditText[@index='6']")
	private WebElement mothersNameTextField;
	
	@FindBy(xpath = "//android.widget.EditText[@bounds='[257,775][669,868]']")
    private WebElement mothersNameTextFieldEdit;
	
	@FindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement fathersNameTextField;
	
	@FindBy(xpath = "//android.widget.EditText[@bounds='[257,774][669,868]']")
	private WebElement fathersNameTextFieldEdit;
	
	@FindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement addressTextField;
	
	@FindBy(xpath = "//android.widget.EditText[@bounds='[385,1407][1004,1548]']")
	private WebElement addressTextFieldEdit;
	
	@FindBy(xpath = "//android.widget.EditText[@index='8']")
	private WebElement mobileNumberTextField;
	
	@FindBy(xpath = "//android.widget.EditText[@bounds='[385,1405][1004,1602]']")
	private WebElement mobileNumberTextFieldEdit;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"SAVE\"]")
    private WebElement saveButton;		
	
	    
	    
		public AddNewBeneficiaryPage(AppiumDriver appiumdriver) {
			this.driver= appiumdriver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			gf=new GenericFunctions(driver);
		}
		
		public void addProfileData() throws InterruptedException {
			beneficiaryNameTextField.click();
			beneficiaryNameTextField.sendKeys("TestGirl");
			dateOfBirthField.click();
			chooseYearButton.click();
			chooseYear2010.click();
			chooseDate.click();
			calenderOKButton.click();
			driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
			        + ".scrollIntoView(new UiSelector()" + ".description(\"" + "Select Type" + "\").instance(0))"));
			femaleRadioButton.click();
			gf.Wait(3000);
			beneficiaryTypeDropDown.click();
			kishoriTypeDropDownOption.click();
			categoryTypeDropDown.click();
			OBCTypeDropDownOption.click();
			mothersNameTextField.click();
			mothersNameTextField.sendKeys("Test mother");
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//wait.until(ExpectedConditions.elementToBeClickable(mothersNameTextFieldEdit)).sendKeys("Test mother");
			//mothersNameTextField.sendKeys("Test mother");
			fathersNameTextField.click();
			fathersNameTextField.sendKeys("Test Father");
			addressTextField.click();
			addressTextFieldEdit.sendKeys("Test address");
			mobileNumberTextField.click();
			mobileNumberTextFieldEdit.sendKeys("1234567890");
			driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
			        + ".scrollIntoView(new UiSelector()" + ".description(\"" + "SAVE" + "\").instance(0))"));
			saveButton.click();
			
		}

	}