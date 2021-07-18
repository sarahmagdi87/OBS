package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseMethods;

public class ProductsPage extends BaseMethods{
	
	static Logger logger =  LoggerFactory.getLogger(ProductsPage.class);
	

	private static By pageTitle = By.xpath("//h1[text()='Products']");
	private static By searchDDL = By.id("edit-solutions");
	private static By filterBtn = By.id("edit-submit-subhomes");
	private static By filterResultItem = By.xpath("//div[@class='txt col-lg-12']");
	private static By filterResult = By.xpath("//div[@class='txt col-lg-12']//span");
	private static By itemPageTitle;	
	
	 public static WebElement getTitle() {
		 return driver.findElement(pageTitle);
	 }
	 
	 public static Select getSearchDDL() {
		 Select ddl = new Select(driver.findElement(searchDDL));
		 return ddl;
	 }
	 
	 public static WebElement getFilterBtn() {
		 return driver.findElement(filterBtn);
	 }
	 
	 public static List<WebElement> getFilterResult() {
		 return driver.findElements(filterResult);
	 }
	 
	 public static List<WebElement> getFilterResultItem() {
		 return driver.findElements(filterResultItem);
	 }
	 
	 public static WebElement getitemPageTitle(String pageTitle) {
		 itemPageTitle = By.xpath("//h1[@class='page-header']//span[text("+pageTitle+")]");
		 return driver.findElement(itemPageTitle);
	 }
	 
	 public void selectItemFromDDL(String item) throws Exception
	 {
		 try {
		 getSearchDDL().selectByValue(item);
		 logger.info("Select Option"+item);
		 test.log(LogStatus.INFO, "Select Option"+item);
		} catch (Exception e)
		{
			 logger.error("Exception -> "+e);
			 test.log(LogStatus.FAIL, "Exception -> "+e);
			 takeSnapShot();
			 driver.close();
		}
	}
	 
	 public void clickApplyBtn() throws Exception
	 {
		 try {
		 getFilterBtn().click();
		 logger.info("Filter button is clicked");
		 test.log(LogStatus.INFO, "Filter button is clicked");
		} catch (Exception e)
		{
			 logger.error("Exception -> "+e);
			 test.log(LogStatus.FAIL, "Exception -> "+e);
			 takeSnapShot();
			 driver.close();
		}
	}
	 	 
	public boolean validateItemPageTitle(String title) throws Exception
	{
		boolean flag = false;
		try {
			flag = getitemPageTitle(title).isDisplayed();
			logger.info(title+"is displayed");
			test.log(LogStatus.PASS, title+"is displayed");
		} catch (Exception e)
		{
			 logger.error("Exception -> "+e);
			 test.log(LogStatus.FAIL, "Exception -> "+e);
			 takeSnapShot();
			 driver.close();
		}
		return flag;
	}
	 
	public void validaDDLOptions(String options) throws Exception
	{
		String[] expectedOptions = options.toString().split("-");
		try {
				List<WebElement> ddlOptions = getSearchDDL().getOptions();
				for(WebElement ddlOption : ddlOptions)
				{
					for (int i=0 ; i<expectedOptions.length ;i++)
					{
						if(ddlOption.getText().contains(expectedOptions[i]))
						{
							logger.info(expectedOptions[i]+" is found");
							test.log(LogStatus.PASS, expectedOptions[i]+" is found");
						}
					}
				}
			} catch (Exception e)
		{
			 logger.error("Exception -> "+e);
			 test.log(LogStatus.FAIL, "Exception -> "+e);
			 takeSnapShot();
			 driver.close();
		}
	}
	 
	 public void selectOption(String title) throws Exception
	 {
		 try {
			 List<WebElement>  results = getFilterResult();
             for (WebElement result : results)
			 {
				result.getText().equals(title);
				result.click();
				test.log(LogStatus.INFO, title+"is clicked");
			 }
		 } catch (Exception e)
		 {
			 logger.error("Exception -> "+e);
			 test.log(LogStatus.FAIL, "Exception -> "+e);
			 takeSnapShot();
			 driver.close();
		 }
	}
}
