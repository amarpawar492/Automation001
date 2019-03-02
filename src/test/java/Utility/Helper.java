package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper
{ 
	public String addCaptureScreenshot(WebDriver driver,String testName) throws IOException
	{
		 String path=System.getProperty("user.dir")+"\\AppsSreenshot\\"+testName+".jpg";
		 
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 FileUtils.copyFile(src,new File(path));
		 
		 return path;
	}
	
	public void captureScreenshot(WebDriver driver,String testName) throws IOException
	{
		 String path=System.getProperty("user.dir")+"\\AppsSreenshot\\"+testName+".jpg";
		 
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 FileUtils.copyFile(src,new File(path));
		 
		// return path;
	}
	

}
