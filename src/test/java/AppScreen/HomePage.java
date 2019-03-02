package AppScreen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage

{
	public WebDriver driver;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	WebElement closeButton;
	
	@FindBy(xpath="//a[@href='/account/login?ret=/']")
	WebElement loginSignup;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement searchItem;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement searchButton;
	
    public HomePage(WebDriver driver)
    {
	    this.driver=driver;
    }
    public String getTitle()
    {
    	return driver.getTitle();
	
     }
    public void ClickOnCloseButton()
    {
    	closeButton.click();
    }
    public void clickLogin()
    {
    	loginSignup.click();
    }
     public void EnterText(String inputtext)
     {
	    searchItem.sendKeys(inputtext);
	
      }
    public void ClickOnSearchButton()
    {
	   searchButton.click();
     }
}
