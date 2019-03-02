package AppScreen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//div[@class='_2aUbKa']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[@class='_2k68Dy']")
	WebElement myProfile;
	
	@FindBy(xpath="//span[@class='_1x4IU1']")
	WebElement editInfo;
	
	@FindBy(xpath="//input[@class='_16qL6K _366U7Q']")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement LastName;
	
	@FindBy(xpath="//button[@class='_2AkmmA rAx-Sv']")
	WebElement clickOnSave;
	
	public MyProfilePage(WebDriver driver)
	   {
		   this.driver=driver;
	   }
	
	   public String getTitle2()
	   {
		return driver.getTitle();   
	   }
	   
	   public void clickOnMyAccount()
	   {
		   myAccount.click();
	   }
	   public void clickMyProfile()
	   {
		   myProfile.click();
	   }
	   public void clickOnEditInfo()
	   {
		   editInfo.click();
	   }
	   public void enterFirstName(String firstname)
	   {
		   firstName.sendKeys(firstname);
	   }
	   public void enterLastname(String lastname)
	   {
		   LastName.sendKeys(lastname);
	   }
	   public void enterClickOnSave() 
	   {
		   clickOnSave.click();
	   }
}
