package TestCases;


import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import AppScreen.HomePage;
import AppScreen.Shopping;
import ExcelDataProvider.ExcelDataProvider1;

public class TestCase4
{
   
	public WebDriver driver;
	//public String Title="Electronics";
    Shopping shop;
    HomePage hp;
    ExcelDataProvider1 pd;
    public String Karnataka;
    
    @BeforeClass
    public void NavigateToBabyAndKids()
    {
    	System.setProperty("webdriver.gecko.driver","D:\\selenium\\Selenium jars\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		shop=PageFactory.initElements(driver, Shopping.class);
		hp=PageFactory.initElements(driver, HomePage.class);
		pd=new ExcelDataProvider1();
		
    }
    @Test(priority=1)
    public void NaviagteOnBabyAndLKids() throws InterruptedException 
    {
    	//System.out.println(shop.getTitle());
	     hp.ClickOnCloseButton();
	     shop.clickOnBabyAndKids();
	     Thread.sleep(2000);
	     shop.clickOnsoftToys();
	     shop.clickOnTeddy();
	     Thread.sleep(1000); 
	     String parentWindow=driver.getWindowHandle();
	     Set<String>set=driver.getWindowHandles();
	     System.out.println(set);
	    
	    for(String ss:driver.getWindowHandles())
	     {
	    	 //String ss=it.next();
	    	 driver.switchTo().window(ss);
	     }
	     Thread.sleep(4000);
	     shop.ClickOnAddToCart();
	     //shop.enterpincode(pd.getData(1, 1, 0));
	     shop.clickOnPlaceOrder();
	     shop.ClickOnMobileNumber(pd.getData(0, 1, 0));
	     Thread.sleep(2000);
	     shop.ClickOnContinueButton();
	     shop.EnterThePassword(pd.getData(0, 1, 1));
	     shop.ClickOnLoginButton();
	     shop.EnterName(pd.getData(4, 1, 0));
	     shop.EnterMobNo(pd.getData(4, 1, 1));
	     shop.EnterPincode2(pd.getData(4, 1, 2));
	     shop.EnterLocality(pd.getData(4, 1, 3));
	     shop.EnterAddress(pd.getData(4, 1, 4));
	     shop.SelectState();
	    
	     
	     //shop.ClickOnHomeRadioButton();
	     //shop.EnterTheLandmark(pd.getData(4, 1, 5));
	     
    }
   @Test(priority=2)
   public void radioButton1()
   {
	  shop.radioButtonHome();
   }
}