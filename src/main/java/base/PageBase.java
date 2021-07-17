package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageBase {
	
	public static WebDriver driver;
	static Logger logger =  LoggerFactory.getLogger(PageBase.class);
	
	public static void WaitInvisibilityOf(WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOf(Element));
		logger.info("Element is InVisibile");
	}
	
	public static void WaitvisibilityOf(WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Element));
		logger.info("Element is Visibile");
	}
	
	public static void WaitElementClickable(WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		logger.info("Element is Clickable");
	}

}
