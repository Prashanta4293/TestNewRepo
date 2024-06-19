package com.RND.tests;

import java.io.IOException;
import java.time.Duration;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.RND.base.BaseTestRealDevice;
import com.RND.pages.AadharDetailsPage;
import com.RND.pages.AddNewBeneficiaryPage;
import com.RND.pages.LoginPage;
import com.RND.pages.MultipleSectorPage;
import com.RND.pages.SupervisorHomePage;
import com.RND.pages.VerifyMobileNumberPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.util.Date;

public class RND_Test extends BaseTestRealDevice {

	
	
	@Test(priority=01,testName ="01 Verification of login functionality")
	public void TC_01_verificationOfLoginFunctionalityMobileNumber() throws IOException {
		try {
			
			LoginPage loginPage= new LoginPage(driver);
			loginPage.login();
			
			// Add a wait after the first test
	        //gf.waitTillElementVisible(otpField);
		}catch(Exception e) {
			String base64Screenshot  = util.getScreenshotAsBase64(driver, testMethodName );
        	test.fail( MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        	test.fail(e);
		}
		
	}
	
	@Test(priority=02,testName ="02 Verification of login functionality with OTP",enabled=true)
	public void TC_02_verificationOfLoginFunctionalityWithOTP() throws IOException {
		try {
			VerifyMobileNumberPage verifyLoginPage= new VerifyMobileNumberPage(driver);
			verifyLoginPage.loginOTP();
			
		}catch(Exception e) {
			String base64Screenshot  = util.getScreenshotAsBase64(driver, testMethodName );
        	test.fail( MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        	test.fail(e);
			
		}
		
	}
	
	@Test(priority=03,testName ="03 Verification of Change Multi Sector Functionality",enabled=true)
	public void TC_03_VerificationOfChangeMultiSectorFunctionality() throws IOException {
		try {
			MultipleSectorPage multiSector = new MultipleSectorPage(driver);
			//multiSector.checkForChangeSectorOne();
//			SupervisorHomePage supervisorPage= new SupervisorHomePage(driver);
//			supervisorPage.checkForChangeSectorTwo();
//			ProfileImageButtonPage profileImageButtonPage = new ProfileImageButtonPage(driver);
//			profileImageButtonPage.chooseSectorButtonValidation();
			multiSector.checkForSupervisorAllValidation();
			
		}catch(Exception e) {
			String base64Screenshot  = util.getScreenshotAsBase64(driver, testMethodName );
        	test.fail( MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        	test.fail(e);
			
		}
		
	}

	@Test(priority=04,testName ="04 Verification of Supervisor home page",enabled=true)
	public void TC_04_VerificationOfSupervisorHomePage() throws IOException {
		try {
			SupervisorHomePage supervisorPage= new SupervisorHomePage(driver);
			supervisorPage.addNewBeneficiary();
			
		}catch(Exception e) {
			String base64Screenshot  = util.getScreenshotAsBase64(driver, testMethodName );
        	test.fail( MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        	test.fail(e);
			
		}
		
	}
	
	@Test(priority=05,testName ="05 Verification of Add new beneficiary",enabled=true)
	public void TC_05_verificationOfAddNewBeneficiary() throws IOException {
		try {
			AddNewBeneficiaryPage addProfileDetails= new AddNewBeneficiaryPage(driver);
			addProfileDetails.addProfileData();
			
		}catch(Exception e) {
			String base64Screenshot  = util.getScreenshotAsBase64(driver, testMethodName );
        	test.fail( MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        	test.fail(e);
			
		}
		
	}
	
	@Test(priority=06,testName ="06 Verification of Add new beneficiary aadhar",enabled=true)
	public void TC_06_verificationOfAddNewBeneficiaryAadhar() throws IOException {
		try {
			AadharDetailsPage addAadhar= new AadharDetailsPage(driver);
			addAadhar.addGuardianAadharDetatilsButton();
			
		}catch(Exception e) {
			String base64Screenshot  = util.getScreenshotAsBase64(driver, testMethodName );
        	test.fail( MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        	test.fail(e);
			
		}
		
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
	 
}