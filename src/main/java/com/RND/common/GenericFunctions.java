package com.RND.common;

import java.util.Map;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;




//import freemarker.core.ParseException;



public class GenericFunctions{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "xlsx";

	private FileInputStream fis;
	private FileOutputStream fileOut;
	private WorkbookFactory workbookfactory;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	static JavascriptExecutor js;
	static Actions act;
	Utility util;
	public WebDriver driver;
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	String testMethodName;
	String descriptiveTestName;
	boolean value;
	String title;
	public static String ACCOUNT_SID= "AC4af75b47dbff459e3d57fad688262298";
	public static String AUTH_TOKEN= "3ff1cae11f273991cdf9d4838a20b074";

	public String path;
	
	


	public GenericFunctions(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);	

	}
	
	public void setup(Method method) {
		testMethodName = method.getName();
		descriptiveTestName = method.getAnnotation(Test.class).testName();
		test = extent.createTest(descriptiveTestName);
	}
	
	
	
	public void navigateToSignInPage() {
		
	}
	
	
	
//	public Stream<Message> getMessages(){
//		ResourceSet<Message> messages= Message.reader(ACCOUNT_SID).read();
//		return StreamSupport.stream(messages.spliterator(), false);
//	}

	public void getUrl(String url)  {

		driver.get(url);
	}

	// *********************************HANDLE_IFRAME**********************************************
	public  void switchToElement(WebElement element) {
		driver.switchTo().frame(element);

	}

	public void switchToName(String Name) {
		driver.switchTo().frame(Name);

	}
	public  void switchToId(String Id) {
		driver.switchTo().frame(Id);

	}

	public  void switchToIndex(int Index) {
		driver.switchTo().frame(Index);

	}

	public  void switchToDefault() {
		driver.switchTo().defaultContent();

	}
	public String getCurrentDate(String format) {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat(format);

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1= dateFormat.format(date);

		return date1;

	}
	public String addDateToCurrentDate(String format,int days) throws java.text.ParseException {
		// Create object of SimpleDateFormat class and decide the format
				DateFormat dateFormat = new SimpleDateFormat(format);

				//get current date time with Date()
				Date date = new Date();
				
				String date1= dateFormat.format(date);

				Calendar cal = Calendar.getInstance();  
		        cal.setTime(dateFormat.parse(date1));  
		             
		        // use add() method to add the days to the given date  
		        cal.add(Calendar.DAY_OF_MONTH, days);  
		        String dateAfter = dateFormat.format(cal.getTime());  
		        return dateAfter;
	}
	
	
	// *********************************HIGHLIGHT_ELEMENTS**********************************************
	public  void highlightElements(List<WebElement> cells) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", cells);  

	}
	
	// *********************************HIGHLIGHT_ELEMENT**********************************************
	public void highlightMobileElement(AppiumDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
     // Change the border or background color of the element
        js.executeScript("arguments[0].style.border='2px solid red'", element);
		}



	// *********************************DRAG_AND_DROP**********************************************
	public  void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();

	}
	// *********************************SCROLL_UP(ACTION)**********************************************
	public  void scrollUpPage() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();

	}

	// *********************************GET_ELEMENT_BY_LOCATOR**********************************************
	public WebElement getElement(By locater) {
		WebElement element = driver.findElement(locater);
		return element;
	}

	// ***************************************CLICK********************************************************

	public  void Click(WebElement element) {
		element.click();
	}
	// ********************************SENDKEYS*******************************************

	public  void Sendkeys(WebElement element, String input) {
		element.sendKeys(input);
	}


	//***************************************RIGHT_CLICK************************************************************
	public  void RightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	// ***************************************DOUBLE_CLICK************************************************************
	public  void DoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	// ********************************CLEAR***********************************************

	public  void Clear(WebElement element) {
		element.clear();
	}
	// ***************************************SENDKEYS_WITH_ACTION************************************************************
	public void doSendKeysWithAction(WebElement element, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(element, value).perform();
	}
	// ***************************************CLICKANDHOLD_WITH_ACTION************************************************************
	public void clickAndHoldWithAction() {
		Actions act = new Actions(driver);
		act.clickAndHold();
	}

	// ***************************************CLICK_LOCATOR_WITH_ACTION************************************************************
	public void doClickWithAction(WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	// ***************************************GET_TEXT************************************************************
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// ***************************************ELEMENT_IS_DISPLAYED************************************************************
	public boolean isDisplayed(WebElement element) {
		boolean value=element.isDisplayed();
		return value;

	}

	// ***************************************ELEMENT_IS_SELECTED*****************************************************
	public boolean isSelect(WebElement element) {
		boolean value=element.isSelected();
		return value;
	}

	//// ***************************************ELEMENT_IS_ENABLED*****************************************************
	public boolean isEnable(WebElement element) {
		return element.isEnabled();
	}
	// ***********************************SELECT_FROM_DROPDOWN***********************************************
	// select by visible text
	public  void SelectByVisibleText(WebElement element, String text) {
		element.click();
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	// select by index
	public  void SelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// select by value
	public  void SelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	// ***********************************DESELECT_FROM_DROPDOWN***********************************************
	// deselect by index
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}

	// deselect by value
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);

	}

	// deselectAll drop down
	public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// deselectByVisibleText
	public void deselectByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByVisibleText(value);
	}
	// ***********************************CHECK_IF_SUPPORT_MULTISELECT_DROPDOWN***********************************************
	public boolean isSelectMultiple(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();

	}
	// ***********************************CHECK_DEFAULT_VALUE_DROPDOWN***********************************************
	public String getDefaultSelectedValue(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}
	
	public ArrayList<String> getOptions(WebElement element) {
		 Select select = new Select(element);
		ArrayList<String> options = new ArrayList<String>();
		 for(int i = 0; i<select.getOptions().size();i++) {
		 options.add(select.getOptions().get(i).getText());
		 }
		return options;
		}

	// ***********************************SWITCH_WINDOW***********************************************
	public void WindowHandle(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> list_of_windows = driver.getWindowHandles();

		Iterator<String> iterator = list_of_windows.iterator();

		while (iterator.hasNext()) {

			String child_window = iterator.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}
		}
		// again switching parent window
		driver.switchTo().window(parent);
	}
	// *********************************SWITCH_TO_ACTIVE_WINDOW_TAB**********************************************
	public  void switchToActiveWindow() {
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		//switch to active tab
		driver.switchTo().window(wid.get(1));
	}
	// *********************************SWITCH_TO_OPEN_WINDOW_TAB**********************************************
		public  void switchToOpenWindow(int id) {
			ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
			//switch to active tab
			driver.switchTo().window(wid.get(id));
		}
	// *********************************MOUSE_HOVER**********************************************
	public  void MouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

	}

	// get Title
	public String getTitle() {
		return driver.getTitle();
	}

	public String doGetText(WebElement element) {
		return element.getText();
	}

	// *************************************ALERT************************************************
	// To click on the ‘Cancel’ button of the alert.
	public  void DismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// To click on the ‘OK’ button of the alert.
	public  void AcceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// To capture the alert message.
	public  void getAlertMessage() {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
	}

	// To send some data to alert box.
	public  void SendDataToAlertBox(String Text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(Text);
	}

	// **********************************CHECKBOX*************************************************
	// single checkbox
	public static void SelectCheckbox(WebElement element) {
		element.click();
	}

	// multiple checkboxes
	public  void SelectMultipleCheckboxes(List<WebElement> listOfItems, int noOfCheckboxesToBeSelected) {
		for (int i = 0; i <= noOfCheckboxesToBeSelected - 1; i++) {
			listOfItems.get(i).click();
			System.out.println("Checkbox_" + i + " selected");
		}
	}
	// ****************************************UPLOAD_FILE**********************************

	public  void UploadFile(WebElement element, String filePath) {
		Sendkeys(element, filePath);
	}
	// **********************************TAB***********************************************

	public  void TAB(WebElement element) {
		element.sendKeys(Keys.TAB);
	}
	// ************************************VERTICAL_SCROLL************************************
	public  void WindowVerticalScroll(int pixel) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0," + pixel + ")");
	}
	// ************************************Horizontal_SCROLL************************************
		public  void WindowHorizontalScroll() {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("window.scrollBy(2000,0)");
		}

	// scroll it at the top and then by a 1/4th of the height of the view
	public  void WindowVerticalScroll(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);

	}

	// scroll it at the bottom
	public  void WindowScrollToBottom(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);

	}

	// scroll to the element
	public  void WindowScrollToTheElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	// scroll just below an element , eg fixed header
	public  void WindowScrollToBelowTheElement(WebElement element, WebElement header) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true); window.scrollBy(0, -arguments[1].offsetHeight);", element, header);

	}

	// *********************WAIT_TILL_ELEMENT_VISIBLE*************************************

	public  void waitTillElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// *********************WAIT_TILL_ELEMENTS_VISIBLE*************************************

		public  void waitTillElementsVisible(List<WebElement> element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
		}

	// ******************************WAIT_SOME_TIME*******************************************

	public  void waitForPageLoad(long mil) throws InterruptedException{
		Thread.sleep(mil);
	}

	// *************************************ASSERT***********************************************

	public boolean Assert(String actualtitle, String Expectedtitle) {

		if (actualtitle.equalsIgnoreCase(Expectedtitle))
			return true;
		else
			return false;

	}







	// ******************************JAVASCRIPT_FUNCTIONS*******************************************
	public String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		return js.executeScript("return document.title").toString();
	}

	// to refresh webPage 
	public Object refreshWebPageByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		return js.executeScript("history.go(0");

	}
	// to send the value By JS
	public void sendKeysByJS(String id, String value, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
	// to click On element By Js
	public void clickByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", element);
	}
	// to scroll the bottom of the page
	public void scrollDownPage(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	

	// this method  is to perform  scrollUp page
	public void scrollUpPage(String high) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,'"+high+"')");
	}

	public void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundcolor");
		for (int i = 0; i <= 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}

	}

	private void changeColor(String color, WebElement element, WebDriver driver2) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argumnts[0].style.backgroundcolor='" + color + "'", element);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// to draw broder using js
	public void drawbroder(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].style.broder='3px solid green'", element);

	}

	// alert message
	public void generateAlertMessage(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");

	}

	//	Js click
	public Object clickOnElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		return js.executeScript("argument[0].click();", element);
	}

	//	to refresh the page using Js
	public void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");

	}
	//  to getTitle BY Js
	public String toGetTitleByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;

	}

	//this will return the page text
	public String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;

	}
	//if data is get successfully then return row and column

	public String getCellStringValue(String rowName, int colNum, String sheetName) {
		try {
			if (colNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(rowName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(colNum - 1);
			if (row == null)
				return "";

			cell = row.getCell(col_Num);
			if (cell == null)
				return "";

			// System.out.println(cell.getCellType());
			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {

					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowName + " or column " + colNum + " does not exist in xls";
		}
	}

	// it returns the row count in a sheet

	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	

	// presenceOfAllElementsLocated
	public List<WebElement> waitForListOfElementPresent(By locater, Duration time) {

		WebDriverWait wait = new WebDriverWait(driver, time);

		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locater));

	}


	/*public Wait<WebDriver> waitForElementUntilElementLocated(By locater, int time, WebDriver diver) {
//					WebDriverWait wait = new WebDriverWait(driver, time);
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS);

				return wait;

			}*/



	public Wait<WebDriver> fluentWait(WebElement element, int time,int pollingTime) {

		Wait<WebDriver>wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(StaleElementReferenceException.class);
		return wait;
	}
//	public void stageLogout() {
//		GenericFunctions gf=new GenericFunctions(driver);
//		gf.switchToDefault();
//		gf.switchToName("menu");
//		if(btnLogout.isDisplayed()) {
//			gf.waitTillElementVisible(btnLogout);
//			btnLogout.click();
//		}
//		else {
//			labelSystem.click();
//			gf.waitTillElementVisible(btnLogout);
//			btnLogout.click();
//		}
//		
//		
//		
//	}
	public void returnToParentWindow() {
		// hold all window handles in array list
	    ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	    //close opened tab
	    driver.close();
	      //switch to new tab
	    driver.switchTo().window(newTb.get(0));
	}
	// *********************WAIT_TILL_ELEMENT_INVISIBLE*************************************

			public  void waitTillElementInVisible(WebElement element) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.invisibilityOf(element));
			}
		// 
			public void clearFolder(String folderPath) {
							}
			//************FileDownloaded*************************//
			public boolean isFileDownloaded(String fileName) {
				String home = System.getProperty("user.home");
				File dir = new File(home+"/Downloads/");
				File[] dirContents = dir.listFiles();
				for (int i = 0; i < dirContents.length; i++) {
					if (dirContents[i].getName().equals(fileName)) {
						return true;
					}
				}
				return false;
			}
			
			public void Wait(int time) throws InterruptedException {
				Thread.sleep(time);
			}
			//************FileDownloadedWithpath*************************//

			public boolean isFileDownloadedWithPath(String fileName,String path)
			{
				File dir = new File(path);
				File[] dirContents = dir.listFiles();
				for (int i = 0; i < dirContents.length; i++)
				{
					if (dirContents[i].getName().equals(fileName))
					{
						return true;
					}
				}
				return false;
			}
			
			//*****Excelsheet*****
			
			public boolean verifyExcelSheet(File excelFile, String sheetName, String valueToFind) throws IOException {
				FileInputStream fis = new FileInputStream(excelFile);
				Workbook workbook = WorkbookFactory.create(fis);
				Sheet sheet = workbook.getSheet(sheetName);
				if (sheet == null) {
					// Sheet not found
					workbook.close();
					return false;

				}
				for (Row row : sheet) {

					for (Cell cell : row) {
						CellType cellType = cell.getCellType();
						if (cellType == CellType.STRING ) {
							String cellValue = cell.getStringCellValue();
							if (cellValue.equals(valueToFind)) {
								workbook.close();
								return true;
							}}	
					}	
				}
				workbook.close();
				return false;
			}
			//******OPen any file*******
			public void openFile() throws IOException {
				//constructor of file class having file as argument
				File file = new File("C:/Users/arunj/Downloads/RewardsAccountReport.xls");
				if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
				{
					System.out.println("not supported");
					 return;
				}
				Desktop desktop = Desktop.getDesktop();
				if(file.exists())desktop.open(file);
			}
			
			
			//**********Get cell value a String**************
			private String getCellValueAsString(Cell cell) {
		        String cellValue = "";
		        if (cell != null) {
		            switch (cell.getCellType()) {
		                case STRING:
		                    cellValue = cell.getStringCellValue();
		                    break;
		                case NUMERIC:
		                    cellValue = String.valueOf(cell.getNumericCellValue());
		                    break;
		                // Handle other cell types as needed
		                default:
		                    break;
		            }
		        }
		        return cellValue;
		    }
//			
			/*
			 * // //----------ScrollDown In Appium till element-----------// public void
			 * scrollDownBy(AppiumDriver driver, int pixels) { driver.findElement(new
			 * AppiumBy.
			 * ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
			 * + ".scrollIntoView(new UiSelector()" + ".textMatches(\"" + "" +
			 * "\").instance(0))"));
			 * 
			 * } // Add this section for scrolling public void scrollDownBy(AppiumDriver
			 * driver, int pixels) { WebDriverWait wait = new WebDriverWait(driver,
			 * Duration.ofSeconds(30)); RemoteWebElement scrollView = (RemoteWebElement)
			 * wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.
			 * accessibilityId("Swipe-screen")));
			 * 
			 * driver.executeScript("gesture: swipe", Map.of("elementId",
			 * scrollView.getId(), "percentage", 50, "direction", "up")); }
			 */
			
			public void scrollIntoViewMobile(String targetElementId, String direction) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		        RemoteWebElement scrollView = (RemoteWebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(targetElementId)));

		        // Cast AppiumDriver to JavascriptExecutor
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		     // Create a map for the swipe gesture parameters
		        Map<String, Object> swipeParameters = new HashMap<>();
		        swipeParameters.put("elementId", scrollView.getId());
		        swipeParameters.put("percentage", 50);
		        swipeParameters.put("direction", direction);

		        // Execute the swipe gesture using JavaScript
		        jsExecutor.executeScript("gesture: swipe", swipeParameters);
		    }
			
			

			
}			






