package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	 	
	public static WebDriver driver;
	public static Properties properties;
	public static ExtentTest test;
	public static ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\ExtentReportResults"+timestamp()+".html");
	static Logger logger =  LoggerFactory.getLogger(TestBase.class);
	private final String propertyFilePath= "./src/test/resources/Properties/testconfig.properties";
			
	public void openBrowser() { 		
		ConfigFileReader();
		String Browser = properties.getProperty("Browser");
		try {
			if (Browser.equals("Chrome"))			
			{	        
				WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");	
	            driver = new ChromeDriver();
	            test.log(LogStatus.PASS, "Chrome is started");
			}	
			else if (Browser.equals("FF"))
			{
				WebDriverManager.firefoxdriver().setup();
				System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");	
		        driver = new FirefoxDriver();
		        test.log(LogStatus.PASS, "FF is started");
			}
			else if(Browser.equals("IE"))	
			{
				WebDriverManager.iedriver().setup();
				System.setProperty("webdriver.ie.driver", "./src/main/resources/drivers/IEDriverServer.exe");	
	            driver = new InternetExplorerDriver();
	            test.log(LogStatus.PASS, "IE is started");
			}
			else
			{
				logger.error("Browser not handled");
				test.log(LogStatus.FAIL, "Browser not handled");
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e)
			{
				logger.error("Exception -> "+e);
				test.log(LogStatus.FAIL, "Exception -> "+e);
			  }    
	}	
				
		public void ConfigFileReader(){
		BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("Exception -> "+e);
					test.log(LogStatus.FAIL, "Exception -> "+e);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				logger.error("Exception -> "+e);
				test.log(LogStatus.FAIL, "Exception -> "+e);
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			   }
		}
		
		public void NavigateToGoogle() throws Throwable {
			try {
				ConfigFileReader();
				String URL = properties.getProperty("url");
				logger.info("Navigate to Home Page");
				driver.get(URL);
		        driver.manage().window().maximize();
		        if(driver.getTitle().contains("Gourmet Egypt"))
		        {
		        	logger.info("Navigated to -> "+URL);
		        	test.log(LogStatus.PASS, "Navigated to -> "+URL);
		        }
		        else
		        {
		        	logger.error("Home Page not loaded");
		        	test.log(LogStatus.ERROR, "Home Page not loaded");
		        	takeSnapShot();
		        }
				}
	        catch (Exception e)
			 {
				 logger.error("Exception -> "+e);
				 test.log(LogStatus.FAIL, "Exception -> "+e);
				 takeSnapShot();
				 driver.close();
			   }
		}
		
		public static void closeBrowser() {
			logger.info("Close Browser");
			test.log(LogStatus.PASS, "Close Browser");
			driver.quit();
		}
		
		public void takeSnapShot() throws Exception{
	        TakesScreenshot scrShot =((TakesScreenshot)driver);
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	        File destination= new File("./Reports/screenshot_"+timestamp()+".jpeg");
	        FileUtils.copyFile(SrcFile, destination);
	    }
		
		 public static String timestamp() {
		        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}
}