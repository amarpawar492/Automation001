package AppScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shopping
{
	 
	public WebDriver driver;
	 
	// WebDriverWait wait=new WebDriverWait(driver, 20);
    //@FindBy(xpath="//span[@class='_1QZ6fC _3Lgyp8']")
	@FindBy(xpath="//*[text()='Baby & Kids']")
    WebElement babyAndKids;
    
    /*@FindBy(xpath="//[text()='Toys']")
    WebElement Toys;*/
    
    @FindBy(xpath="//a[@title='Soft Toys']")
    WebElement softToys;
    
    @FindBy(xpath="//a[@class='_2cLu-l']")
    WebElement teddy;
    /*
    @FindBy(xpath="//input[@id='pincodeInputId']")
    WebElement enterpincode;
    */
  /*  @FindBy(xpath="//button[@class='_2AkmmA _1wk2G8 _2HNZdt _7UHT_c']")
    WebElement porder; */ 
    
    @FindBy(xpath="//li[@class='col col-6-12']")
    WebElement AddToCart1;
    
    @FindBy(xpath="//button[@class='_2AkmmA _14O7kc _7UHT_c']")
    WebElement placeOrderTeddy;
    
    @FindBy(xpath="//input[@class='_2zrpKA _14H79F']")
    WebElement EnterMobNo;
    
    @FindBy(xpath="//div[@class='_2CQ7Aq']")
    WebElement continueButton;
    
    @FindBy(xpath="//input[@class='_2zrpKA _3v41xv _14H79F']")
    WebElement enterpassword;
    
    @FindBy(xpath="//button[@class='_2AkmmA _1poQZq _7UHT_c']")
    WebElement loginButton;
    
    @FindBy(xpath="//input[@class='_16qL6K _366U7Q']")
    WebElement name;
    
    @FindBy(xpath="//input[@name='phone']")
    WebElement mobno;
    
    @FindBy(xpath="//input[@name='pincode']")
    WebElement pincode1;
    
    @FindBy(xpath="//input[@name='addressLine2']")
    WebElement locality;
    
    @FindBy(xpath="//textarea[@class='giyiJa _16qL6K _21icXK']")
    WebElement address;
    
  /*  @FindBy(xpath="//input[@class='landmark']")
    WebElement enterLandmark;*/
    
    @FindBy(xpath="//div[@class='_6ATDKp']")  
    WebElement radionbutton;
    
    @FindBy(xpath="//select[@class='_3092M2 _3fgAI3 N25bMB QoXnA9']")
    WebElement dd;
    
    @FindBy(xpath="//div[@class='_6ATDKp']")
    WebElement homeRadioButton;
    
    public Shopping(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    public String getTitle()
    {
		return driver.getTitle();
    }
    
    public void clickOnBabyAndKids()
    {
    	babyAndKids.click();
    }
    public void clickOnsoftToys()
    {
    	softToys.click();
    }
   /* public void clickOnToys()
    {
    	Toys.click();
    }*/
    public void clickOnTeddy()
    {
    	teddy.click();
    }
    public void ClickOnAddToCart()
    {
    	AddToCart1.click();
    }
    
   /* public void enterpincode(String pincode)
    {
    	enterpincode.sendKeys(pincode);
    }*/
    public void clickOnPlaceOrder()
    {
    	placeOrderTeddy.click();
    }
    public void ClickOnMobileNumber(String email)
    {
    	EnterMobNo.sendKeys(email);
    }
    
    public void ClickOnContinueButton()
    {
    	 //wait.until(ExpectedConditions.elementToBeClickable(continueButton));

    	continueButton.click();
    }
    public void EnterThePassword(String password)
    {
    	enterpassword.sendKeys(password);
    }
    public void ClickOnLoginButton()
    {
    	loginButton.click();
    }
    public void EnterName(String name1)
    {
    	name.sendKeys(name1);
    }
    public void EnterMobNo(String mobno1)
    {
    	mobno.sendKeys(mobno1);
    }
    public void EnterLocality(String locality1)
    {
    	locality.sendKeys(locality1);
    }
    public void EnterAddress(String address1)
    {
    	address.sendKeys(address1);
    }
    public void EnterPincode2(String pincode12)
    {
    	pincode1.sendKeys(pincode12);
    }
   /* public void ClickOnHomeRadioButton()
    {
    	radionbutton.click();
    }*/
   /* public void EnterTheLandmark(String landmark1)
    {
    	enterLandmark.sendKeys(landmark1);
    }*/
   /* public void porder1()
    {
    	porder.click();
    }*/
   
    public void SelectState() 
    {
	Select dropdown=new Select(dd);
	dropdown.selectByIndex(5);
	
    }
    public void radioButtonHome()
    {
    	radionbutton.isSelected();
    }
	
}
