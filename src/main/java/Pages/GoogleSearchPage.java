package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseMethods;

public class GoogleSearchPage extends BaseMethods{
	
	static Logger logger =  LoggerFactory.getLogger(GoogleSearchPage.class);

	private static By pageTilte = By.xpath("//a[@href='https://www.orange-business.com/en']/child::h3[text()='Orange Business Services: Your partner for digital ...']");

	 public static WebElement getTilte() {
		 return driver.findElement(pageTilte);
	 }
	 	 
	 public void clickTilte(String Title) throws Throwable {
			try {
				getTilte().click();
				logger.info(Title+"is clicked");
				test.log(LogStatus.INFO, Title+"is clicked");
				} catch (Exception e)
			{
				 logger.error("Exception -> "+e);
				 test.log(LogStatus.FAIL, "Exception -> "+e);
				 takeSnapShot();
				 driver.close();
		     }
		 }
}