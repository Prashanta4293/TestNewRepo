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

	public class SupervisorHomePage {
	public AppiumDriver driver;
	public GenericFunctions gf;
	    
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Select Aanganwadi\")")
	private WebElement selectAanganwadiDropdown;
	
	    @AndroidFindBy(accessibility = "Khinda-A") 
        private WebElement khindaA ;
	    
	    @AndroidFindBy(accessibility = "Khinda-B") 
        private WebElement khindaB ;
	    
	    @AndroidFindBy(accessibility = "Talapada") 
        private WebElement Talapada ;
	    
	    @AndroidFindBy(accessibility = "Maranda") 
        private WebElement Maranda ;
	    
	    @AndroidFindBy(accessibility = "Banamira") 
        private WebElement Banamira ;
	    
		@AndroidFindBy(accessibility = "Show Beneficiary") 
	    private WebElement showBeneficiaryButton ;
		
		@AndroidFindBy(accessibility = "Add New Beneficiary") 
	    private WebElement addNewBeneficiaryButton ;
		
		@FindBy(xpath = "//android.widget.Button[@bounds='[939,169][1052,281]']")
		//@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").index(1)")
	    private WebElement clickProfileImageButton ;
		
		@AndroidFindBy(accessibility = "Choose Sector") 
	    private WebElement clickChooseSectorButton ;
	    
		 public SupervisorHomePage(AppiumDriver appiumDriver) {
		        this.driver = appiumDriver;
		        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		        gf=new GenericFunctions(driver);
		    }
		 
		 public void checkForChangeSectorTwo() throws InterruptedException {
			 clickProfileImageButton.click();
			 //Thread.sleep(5000);
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(clickChooseSectorButton)).click();
			 //clickChooseSectorButton.click();
		}
		
		public void showBeneficiary() {
			
			selectAanganwadiDropdown.click();
			khindaA.click();
			showBeneficiaryButton.click();
		}
		
		public void addNewBeneficiary() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(selectAanganwadiDropdown)).click();
			//selectAanganwadiDropdown.click();
			khindaA.click();
			addNewBeneficiaryButton.click();
		}

	}
