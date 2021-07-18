package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseMethods;

public class GoogleHomePage extends BaseMethods{
	
	static Logger logger =  LoggerFactory.getLogger(GoogleHomePage.class);
	
	private static By searchTxt =  By.xpath("//input[@class='gLFyf gsfi']");
	private static By searchBtn =  By.xpath("//input[@class='gNO89b']");

	 public static WebElement getSearchTxt() {
		 return driver.findElement(searchTxt);
	 }
	 
	 public static WebElement getSearchBtn() {
	     return driver.findElement(searchBtn);
	 }
	 
	 public void clickSearchBtn() throws Exception {
		try {
			getSearchBtn().click();
			logger.info("Search button is clicked");
			test.log(LogStatus.INFO, "Search button is clicked");
			} catch (Exception e)
		{
			 logger.error("Exception -> "+e);
			 test.log(LogStatus.FAIL, "Exception -> "+e);
			 takeSnapShot();
			 driver.close();
	     }
	 }
	 
	 public void setSearchTxt(String searchTxt) throws Exception {
		 try {
			 getSearchTxt().sendKeys(searchTxt);
			 test.log(LogStatus.INFO, "Search Keywoard is Entered");
		 } catch (Exception e)
		{
			 logger.error("Exception -> "+e);
			 test.log(LogStatus.FAIL, "Exception -> "+e);
			 takeSnapShot();
			 driver.close();
	     }
		
	 }
}