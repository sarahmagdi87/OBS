package stepDefinations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Pages.GoogleHomePage;
import Pages.GoogleSearchPage;
import Pages.OBSHomePage;
import base.BaseMethods;
import Pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OBSSteps extends BaseMethods{
	
	Logger logger =  LoggerFactory.getLogger(OBSSteps.class);
	GoogleHomePage googleHomePageObj ;
	GoogleSearchPage googleSearchPageobj;
	OBSHomePage obsHomePagebj;
	ProductsPage productsPageObj;
	
		@Before
		public void do_before_each_scenario() {	
			logger.info("Scenario is Start");
			test = report.startTest("Scenarios");
			googleHomePageObj = new GoogleHomePage();
			googleSearchPageobj = new GoogleSearchPage();
			obsHomePagebj = new OBSHomePage();
			productsPageObj = new ProductsPage();
			openBrowser();
		}
		
		 @Given("^navigate to google$")
		 public void navigate_to_google() throws Throwable {
			 NavigateToGoogle();
		}

		@When("^open (.+) that has the URL (.+)$")
		public void open_page_that_has_url(String pageTitle, String pageURL) throws Throwable {
			googleSearchPageobj.clickTilte(pageTitle);
		}

	    @Then("^validate the options (.+)$")
	    public void validate_the_options(String options) throws Throwable {
	    	productsPageObj.validaDDLOptions(options);
	    	test.log(LogStatus.PASS, "The Expected Options is displayed in DDL");
	    }

		@And("^search for (.+)$")
		public void search_for_something(String keyword) throws Throwable {
			googleHomePageObj.setSearchTxt(keyword);
			googleHomePageObj.clickSearchBtn();
		}

		@And("^click on (.+) -> (.+)$")
		public void click_on_something_something(String menuItem, String subItem) throws Throwable {
			obsHomePagebj.validateLogo();
			obsHomePagebj.selectSubItemFromMenu(menuItem, subItem);
		}

		@And("^select (.+)$")
		public void choose_something(String item) throws Throwable {
			productsPageObj.selectItemFromDDL(item);
		}

		@And("^click apply$")
		public void click_apply() throws Throwable {
			productsPageObj.clickApplyBtn();
		}

		@And("^choose the item with title (.+)$")
		public void choose_the_item_with_title_something(String title) throws Throwable {
			productsPageObj.selectOption(title);
		}

		 @And("^validate that the system opens the right article with title (.+)$")
		 public void validate_that_the_system_opens_the_right_article(String title) throws Throwable {
			 boolean flag = productsPageObj.validateItemPageTitle(title);
			 Assert.assertTrue(flag);
			 test.log(LogStatus.PASS, "The system opens the right article");
		}
		 
		@And("^close the browser$")
		public void close_the_browser(){
			closeBrowser();
		}
					
		@After
		public void doActionsAfterEachScenario() {
			logger.info("Scenario is End");
			report.endTest(test);
			report.flush();
		}
}