package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import AppScreen.MyProfilePage;
import AppScreen.OrderDelivery;
import ExcelDataProvider.ExcelDataProvider1;
import Utility.Helper;
import junit.framework.Assert;

public class TestCases1Amruta
{
	public WebDriver driver;
	public String Title="Electronics";
	ExcelDataProvider1 pd;
	HomePage h;
	LoginPage1 l;
	MyProfilePage p;
    OrderDelivery orderdelivery;
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
		p=PageFactory.initElements(driver, MyProfilePage.class);
		orderdelivery=PageFactory.initElements(driver, OrderDelivery.class);
        hl=new Helper();
		
		HtmlPath=System.getProperty("user.dir")+"\\Reports\\TestCase1.html";
		report =new ExtentReports(HtmlPath,true);
		logger=report.startTest("Search Function of Application");
	}
  @Test(priority=1)
  public void LoginPage1() throws InterruptedException, IOException 
  { 
	  System.out.println(h.getTitle());
	  Assert.assertTrue(h.getTitle().contains(Title));
	  h.ClickOnCloseButton();
	  logger.log(LogStatus.INFO, "user is navigated to homepage");
	  hl.addCaptureScreenshot(driver,"click on close");
	  hl.captureScreenshot(driver, "aaaa");
	  h.clickLogin();
	  System.out.println(System.getProperty("user.dir"));
	  l.email(pd.getData(0, 1, 0));
	  l.password(pd.getData(0, 1, 1));	
	  Thread.sleep(2100);
	  hl.captureScreenshot(driver, "login password");
	 
	  Thread.sleep(3000);
	  l.ClickLogin1();
	  System.out.println("test case1 succesfully executed");
  }
   @Test(priority=2)
    public void editUserInfo() throws InterruptedException
    {
	     System.out.println(p.getTitle2());
		 Assert.assertTrue(p.getTitle2().contains(Title));
	    p.clickOnMyAccount();
	    Thread.sleep(2000);
	    p.clickMyProfile();
	    p.clickOnEditInfo();
	    p.enterFirstName(pd.getData(1, 1, 0));
	    p.enterLastname(pd.getData(1, 1, 1));
	    Thread.sleep(2000);
	     p.enterClickOnSave();
	    System.out.println("test case2 succesfully executed");
  }
  
  /*@Test(priority=3)
  public void searchItem1() throws InterruptedException
  {
	  System.out.println(p.getTitle2());
	  Assert.assertTrue(p.getTitle2().contains(Title));
	  orderdelivery.EnterSearchText(pd.getData(2, 1, 0));
	  System.out.println(pd.getData(2, 1, 0));
	  orderdelivery.ClickOnSearchButton();
	  orderdelivery.ClickonMobile();
	  Thread.sleep(1000);
	 // orderdelivery.enterPincode(pd.getData(3, 1, 0));
	  orderdelivery.clickOnAddToCart();
  }*/
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
