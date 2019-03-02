package AppScreen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDelivery
{
	public WebDriver driver;
	
	@FindBy(xpath="//input[@class='LM6RPg']")
	WebElement searchText;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement ClickSearch;
	
	@FindBy(xpath="//div[@class='_3wU53n']")
	WebElement ClickMobile;

	/*@FindBy(xpath="//div[@class='_2dcihZ']")
	WebElement addToCart;*/
	 
	@FindBy(xpath="/html//div[@id='container']/div/div[3]/div[@class='_3e7xtJ']/div/div[@class='_1HmYoV hCUpcT']//ul[@class='row']/li[1]/button")
    WebElement addToCart;
	
	public OrderDelivery(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getTitle4()
	{
		
		return driver.getTitle();
		
	}
	public void EnterSearchText(String inputText)
	{
		searchText.sendKeys(inputText);
	}
	public void ClickOnSearchButton()
	{
		ClickSearch.click();
	}
	public void ClickonMobile()
	{
		ClickMobile.click();
	}
	
	/*public void enterPincode(String pincode)
	{
		pinCode.

	}*/
	public void clickOnAddToCart()
	{
		addToCart.click();
	}
	/*public void clickOnBuyNow()
	{
		buyNow.click();
	}*/
}

