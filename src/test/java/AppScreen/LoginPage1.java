package AppScreen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage1
{
	public WebDriver driver;
	   
	   @FindBy(xpath="//input[@class='_2zrpKA']")
	   WebElement email;
	   
	   @FindBy(xpath="//input[@class='_2zrpKA _3v41xv']")
	   WebElement password;
	   
	   @FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	   WebElement clickOnLogin;
	   
	   public LoginPage1(WebDriver driver)
	   {
		   this.driver=driver;
	   }
	   public String getTitle1()
	   {
		return driver.getTitle();
		   
	   }
	   
	   public void email(String user)
	   {
		   email.sendKeys(user);
	   }
	   public void password(String pass)
	   {
		   password.sendKeys(pass);
	   }
	   public void ClickLogin1()
	   {
		   clickOnLogin.click();
	   }
}
