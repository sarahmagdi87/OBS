package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseMethods;


public class OBSHomePage extends BaseMethods{
	
		static Logger logger =  LoggerFactory.getLogger(OBSHomePage.class);
		
		private static By pageLogo = By.xpath("//img[@src='/themes/theme_boosted/orange-business-services.png']");
		private static By menuItem;
		private static By subItem;
		
		 public static WebElement getLogo() {
			 return driver.findElement(pageLogo);
		 }
		 
		 public static WebElement getSolutionBtn(String menuItemTxt) {
			 menuItem = By.xpath("//div[@class='collapse navbar-collapse navbar-inverse']//a[@title="+menuItemTxt+"]");
		     return driver.findElement(menuItem);
		 }
		 
		 public static WebElement getAllProductsBtn(String subItemText) {
			 subItem = By.xpath("//div[@class='nav navbar-nav nav-menu']//ul[@class='sous-items']//a[@title="+subItemText+"]");
		     return driver.findElement(subItem);
		 }
		 
		 public void validateLogo() throws Throwable {
			try {
				getLogo().isDisplayed();
				logger.info("OBS logo is diplayed");
				test.log(LogStatus.INFO, "OBS logo is diplayed");
				} catch (Exception e)
			{
				 logger.error("Exception -> "+e);
				 test.log(LogStatus.FAIL, "Exception -> "+e);
				 takeSnapShot();
				 driver.close();
		     }
		 }
		 
		 public void selectSubItemFromMenu(String menuItem , String subItem) throws Throwable {
			try {
				getSolutionBtn(menuItem).click();
				getAllProductsBtn(subItem).click();
				logger.info(menuItem+"->"+subItem);
				test.log(LogStatus.INFO, "OBS logo is diplayed");
				} catch (Exception e)
			{
				 logger.error("Exception -> "+e);
				 test.log(LogStatus.FAIL, "Exception -> "+e);
				 takeSnapShot();
				 driver.close();
		     }
		 }		 
}