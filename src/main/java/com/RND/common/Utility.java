package com.RND.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.*;

import com.aventstack.extentreports.model.Media;
import com.google.common.io.Files;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


	

public class Utility {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "xlsx";

	static JavascriptExecutor js;
	static Actions act;
	WebDriver driver;
	public String path;

	public Utility(WebDriver driver) {

		this.driver = driver;

	}

	// *****************************READ_DATA_FROM_EXCEL************************************

	public  Object[][] readExcel(String filePath, String sheetName) throws IOException {
		new File(filePath);
		FileInputStream inputStream = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("Total row = " + sheet.getLastRowNum());
		System.out.println("Total cell = " + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}


	// **********************************CAPTURE_SCREENSHOT_CURRENTPAGE********************************

	public  String CaptureScreenshot(String filePath) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String absolutepathlocation=(new File(filePath).getAbsolutePath());
		Files.copy(screenshotFile, new File(filePath));
		return absolutepathlocation;

	}
	// **********************************CAPTURE_SCREENSHOT_SELECTEDELEMENT********************************
	public  String CaptureScreenshotofElement(WebElement element,String filePath) throws IOException {

		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		String absolutepathlocation=(new File(filePath).getAbsolutePath());
		Files.copy(screenshotFile, new File(filePath));
		return absolutepathlocation;
	}
	
	public String getScreenShot(WebDriver drive, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File scrshotLocation = new File(destination);
        FileUtils.copyFile(source, scrshotLocation);
        return destination;
        }

	 public String getScreenShotForMultiple(WebDriver driver, String screenshotName) throws IOException {
	        // Get the current date and time
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	        Date currentDate = new Date();
	        String timestamp = sdf.format(currentDate);

	        // Convert WebDriver object to TakesScreenshot
	        TakesScreenshot ts = (TakesScreenshot) driver;

	        // Capture the screenshot as a file
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        
	     // Define the destination file path
	        String destinationPath = System.getProperty("user.dir") + "/Screenshots/" + "_" + timestamp + ".png";

	        
	        File scrshotLocation = new File(destinationPath);

	        
	        //Path destination = Path.of(destinationPath);

	        // Copy the screenshot to the destination path
	        FileUtils.copyFile(source, scrshotLocation);

	        return destinationPath;
	    }

	 public String getScreenshotAsBase64(WebDriver driver, String screenshotName) throws IOException {
	        // Get the current date and time
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	        Date currentDate = new Date();
	        String timestamp = sdf.format(currentDate);

	        // Convert WebDriver object to TakesScreenshot
	        TakesScreenshot ts = (TakesScreenshot) driver;

	        // Capture the screenshot as a Base64 string
	        String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);

	        // Define the destination file path (optional)
	        String destinationPath = System.getProperty("user.dir") + "/Screenshots/" + "_" + timestamp + ".png";

	        // Save the Base64 string to a file (optional)
	        FileUtils.writeByteArrayToFile(new File(destinationPath), org.apache.commons.codec.binary.Base64.decodeBase64(base64Screenshot));

	        // Return the Base64 string
	        return base64Screenshot;
	    }

	   
	    

}
