package com.expedia.selenium.ExpediaMavenTest.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.expedia.selenium.ExpediaMavenTest.pages.HomeScreen;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class AbstractTest {
	
	public static WebDriver driver = null;
	public static ExtentReports extentReport = null;
	public static ExtentTest extentTest = null;
	//private String localFilePath = "D:/SOFTWARE TESTING/TECHNOSOFT/Workspace/ExpediaMavenTest/screenshot/";
	public static String expedia = "https://www.expedia.com";
	private File localFilePath = new File("screenshot").getAbsoluteFile();
	
	@BeforeSuite
	public void setUp(){
		
		getInstance();
		driver = new FirefoxDriver();
		
		
		/*ReadConfigFile file = new ReadConfigFile();
		
		if("firefox".equalsIgnoreCase(file.getBrowser())){
			driver = new FirefoxDriver();
		}else if("chrome".equalsIgnoreCase(file.getBrowser())) {
			System.setProperty("webdriver.chrome.driver", "D:/SOFTWARE TESTING/TECHNOSOFT/Workspace/ExpediaTest/chromedriver32/chromedriver.exe");
			driver = new ChromeDriver();
		}else if("safari".equalsIgnoreCase(file.getBrowser())) {
			driver = new SafariDriver();
		}else {
			driver = new HtmlUnitDriver();
		}*/
		
		startBrowser();
		
	}
	
	@AfterSuite(alwaysRun=true)
	public void closeBrowser(){
		extentReport.flush();
		extentReport.close();
		driver.close();
		//driver.quit();
	}
	
	@AfterClass
	public void navigateToHome(){
		startBrowser();
	}
	
	@AfterMethod(enabled = true)
	public void handleScreenShot(ITestResult result){
		
		if(result.getStatus() == ITestResult.FAILURE){
			
			String screenShot_path = captureScreenShot(driver, result.getName());
			String image = extentTest.addScreenCapture(screenShot_path);
			extentTest.log(LogStatus.FAIL, "Failed Method Name : "+ result.getName(),image);
			extentReport.endTest(extentTest);
		}
		
		
	}
	
	public static void startBrowser(){
		
		driver.navigate().to(expedia);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}
	
	public static void waitForSeconds(int sec){
		
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
	}
	
	private ExtentReports getInstance(){
		
		extentReport = new ExtentReports("Extent_Reports/textExtent.html", true);
		extentReport.config().documentTitle("Automation Report")
					.reportName("Regression Result")
					.reportHeadline("Report for built #101");
		return extentReport;
	}
	
	public String captureScreenShot(WebDriver driver, String screenShotName){
		
		try {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			String dest = localFilePath +"/" + screenShotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("ScreenShot Taken");
			return dest;
		} catch (IOException e) {
			System.out.println("Exception while taking Screenshot "
					+ e.getMessage());
			return e.getMessage();
		}
		
	}
	
	public static void browserWindowHandle(){
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String windowHandle : handles){
			if(!windowHandle.equals(parentWindow)){
				driver.switchTo().window(windowHandle);
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
	}
	
	public static WebElement getElement(String locator, String attributeOfLocator){
		
		if(locator.equalsIgnoreCase("id")){
			return driver.findElement(By.id(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("className")){
			return driver.findElement(By.className(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("name")){
			return driver.findElement(By.name(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("xpath")){
			return driver.findElement(By.xpath(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("css")){
			return driver.findElement(By.cssSelector(attributeOfLocator));
		}else
			throw new NoSuchElementException("No Such Element" + attributeOfLocator);
	}
	
	public static List<WebElement> getElements(String locator, String attributeOfLocator,WebElement element){
		
		if(locator.equalsIgnoreCase("id")){
			return element.findElements(By.id(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("className")){
			return element.findElements(By.className(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("name")){
			return element.findElements(By.name(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("xpath")){
			return element.findElements(By.xpath(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("css")){
			return element.findElements(By.cssSelector(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("tagName")){
			return element.findElements(By.tagName(attributeOfLocator));
		}else
			throw new NoSuchElementException("No Such Element" + attributeOfLocator);
	}
	
	public static List<WebElement> getElements(String locator, String attributeOfLocator){
		
		if(locator.equalsIgnoreCase("id")){
			return driver.findElements(By.id(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("className")){
			return driver.findElements(By.className(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("name")){
			return driver.findElements(By.name(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("xpath")){
			return driver.findElements(By.xpath(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("css")){
			return driver.findElements(By.cssSelector(attributeOfLocator));
		}else if(locator.equalsIgnoreCase("tagName")){
			return driver.findElements(By.tagName(attributeOfLocator));
		}else
			throw new NoSuchElementException("No Such Element" + attributeOfLocator);
	}
	
	//Object for Home Screen
	public HomeScreen homeScreen(){
		HomeScreen homeScreen = new HomeScreen(driver);
		return homeScreen;
	}

}
