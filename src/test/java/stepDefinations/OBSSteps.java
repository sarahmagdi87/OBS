package stepDefinations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Pages.GoogleHomePage;
import Pages.OBSHomePage;
import Pages.ProductsPage;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OBSSteps extends TestBase{
	
	Logger logger =  LoggerFactory.getLogger(OBSSteps.class);
	OBSHomePage CatergoriesMethod; 
	GoogleHomePage CartMethods ;
	ProductsPage HomeMethod;
	
		@Before
		public void do_before_each_scenario() {	
			logger.info("Scenario is Start");
			test = report.startTest("Scenarios");
			openBrowser();
			HomeMethod = new ProductsPage(); 
			CatergoriesMethod = new OBSHomePage();
			CartMethods = new GoogleHomePage();
		}
		
		 @Given("^navigate to google$")
		 public void navigate_to_google() throws Throwable {
		}

		@When("^open (.+) that has the URL (.+)$")
		public void open_something_that_has_the_url_something(String strArg1, String strArg2) throws Throwable {
		}

	    @Then("^validate the options (.+)$")
	    public void validate_the_options() throws Throwable {
	    }

		@And("^search for (.+)$")
		public void search_for_something(String strArg1) throws Throwable {
		}

		@And("^click on (.+) -> (.+)$")
		public void click_on_something_something(String strArg1, String strArg2) throws Throwable {
		}

		@And("^choose (.+)$")
		public void choose_something(String strArg1) throws Throwable {

		}

		@And("^click apply$")
		public void click_apply() throws Throwable {
		}

		@And("^choose the item with title (.+)$")
		public void choose_the_item_with_title_something(String strArg1) throws Throwable {
		}

		 @And("^validate that the system opens the right article$")
		 public void validate_that_the_system_opens_the_right_article() throws Throwable {
		}
		
		@And("^close the browser$")
		public void close_the_browser() throws Throwable {
			closeBrowser();
		}
					
		@After
		public void doActionsAfterEachScenario() {
			logger.info("Scenario is End");
			report.endTest(test);
			report.flush();
		}
}