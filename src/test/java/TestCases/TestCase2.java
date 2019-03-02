package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AppScreen.HomePage;
import AppScreen.LoginPage1;
import ExcelDataProvider.ExcelDataProvider1;
import Utility.Helper;
import junit.framework.Assert;

public class TestCase2 
{
	public WebDriver driver;
	public String Title="Electronics";
	ExcelDataProvider1 pd;
	HomePage h;
	LoginPage1 l;
	Helper hl;
	ExtentReports report;
	ExtentTest logger;
	String HtmlPath;
	
	@BeforeClass
	public void loginpage()
	{
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\Selenium jars\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pd=new ExcelDataProvider1();
		h=PageFactory.initElements(driver, HomePage.class);
		l=PageFactory.initElements(driver, LoginPage1.class);
        hl=new Helper();
		
		HtmlPath=System.getProperty("user.dir")+"\\Reports\\TestCase2.html";
		report =new ExtentReports(HtmlPath,true);
		logger=report.startTest("Login Function for invalid username and password");
	}
  @Test
  public void LoginPage2() throws InterruptedException, IOException
  {
	  System.out.println(h.getTitle());
	  Assert.assertTrue(h.getTitle().contains(Title));
	  h.ClickOnCloseButton();
	  logger.log(LogStatus.INFO, "user is navigated to homepage");
	  hl.addCaptureScreenshot(driver,"click on close");
	  hl.captureScreenshot(driver, "aaaa");
	  h.clickLogin();
	  System.out.println(System.getProperty("user.dir"));
	  l.email(pd.getData(3, 1, 0));
	  
	  l.password(pd.getData(3, 1, 1));	
	  hl.captureScreenshot(driver, "login password");
	 
	  Thread.sleep(3000);
	  l.ClickLogin1();
	  System.out.println("test case2 succesfully executed");
  }
  @AfterMethod
  public void tearDown(ITestResult result) throws IOException
  {
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  logger.log(LogStatus.FAIL, "Test cases is failed due to  this "+result.getName());
		  logger.log(LogStatus.FAIL,logger.addScreenCapture(hl.addCaptureScreenshot(driver, result.getName())));
		 // logger.add
	  }
	  else if(ITestResult.SUCCESS==result.getStatus())
	  {   
		  logger.log(LogStatus.PASS, result.getName()+" test case is passed.");
		  logger.log(LogStatus.PASS,logger.addScreenCapture(hl.addCaptureScreenshot(driver, result.getName()))); 
	  }
} 
   @AfterClass
  public void afterClass() 
  {    
	  
	  //driver.close();
	  report.endTest(logger);
	  report.flush();
  }
}
