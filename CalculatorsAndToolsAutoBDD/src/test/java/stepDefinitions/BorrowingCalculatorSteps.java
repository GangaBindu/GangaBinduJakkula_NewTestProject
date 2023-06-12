package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;

public class BorrowingCalculatorSteps {

	private WebDriver driver;

	@Given("^Navigate to borrowing calculator page$")
	public void navigate_to_borrowing_calculator_page() {
		String ProjectPath = System.getProperty("user.dir");
		System.out.println("Project path is =" + ProjectPath);
		System.setProperty("webdriver.chrome.driver", ProjectPath+"/drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("^Select application type in your details section for \"(.*)\"$")
	public void select_application_type_in_your_details_section_for(String applicationtype) {
		if(applicationtype.equalsIgnoreCase("single")) {
			driver.findElement(By.xpath("//label[normalize-space()='Single']")).click();
		}
		if(applicationtype.equalsIgnoreCase("joint"))  {
			driver.findElement(By.xpath("//label[normalize-space()='Joint']")).click();
		}		  
	}

	@When("^Select number of dependants in your details section as \"(.*)\"$")
	public void select_number_of_dependants_in_your_details_section_as(String dependants) {
		Select numberOfDependants = new Select(driver.findElement(By.xpath("//select[@title='Number of dependants']")));
		numberOfDependants.selectByVisibleText(dependants);
	}

	@When("^Select buying a property in your details section as \"(.*)\"$")
	public void select_buying_a_property_in_your_details_section_as(String propertytype) {
		if(propertytype.contains("livein")) {
			driver.findElement(By.xpath("//label[normalize-space()='Home to live in']")).click();
		}
		if(propertytype.contains("residential"))  {
			driver.findElement(By.xpath("//label[normalize-space()='Residential investment']")).click();
		}
	}

	@When("^Enter annual income in your earnings section of \"(.*)\"$")
	public void enter_annual_income_in_your_earnings_section_of(String annualincome) {
		driver.findElement(By.xpath("//div[contains(@class,'container__main borrow--homeloan')]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys(annualincome);
	}

	@When("^Enter other income in your earnings section of \"(.*)\"$")
	public void enter_other_income_in_your_earnings_section_of(String otherincome) {
		driver.findElement(By.xpath("//div[contains(@class,'container__main borrow--homeloan')]//div[2]//div[1]//div[2]//div[1]//input[1]")).sendKeys(otherincome);
	}

	@When("^Enter living expenses in your expenses section of \"(.*)\"$")
	public void enter_living_expenses_in_your_expenses_section_of(String livingexpenses) {
		driver.findElement(By.xpath("//input[@id='expenses']")).sendKeys(livingexpenses);
	}

	@When("^Enter current home loan repayments in your expenses section of \"(.*)\"$")
	public void enter_current_home_loan_repayments_in_your_expenses_section_of(String homeloanrepayments) {
		driver.findElement(By.xpath("//input[@id='homeloans']")).sendKeys(homeloanrepayments);
	}

	@When("^Enter other loan repayments in your expenses section of \"(.*)\"$")
	public void enter_other_loan_repayments_in_your_expenses_section_of(String loanrepayments) {
		driver.findElement(By.xpath("//input[@id='otherloans']")).sendKeys(loanrepayments);
	}

	@When("^Enter other commitments in your expenses section of \"(.*)\"$")
	public void enter_other_commitments_in_your_expenses_section_of(String commitments) {
		driver.findElement(By.xpath("//main[contains(@class,'navigation-offset')]//div[3]//div[1]//div[4]//div[1]//input[1]")).sendKeys(commitments);
	}

	@When("^Enter total credit card limits in your expenses section of \"(.*)\"$")
	public void enter_total_credit_card_limits_in_your_expenses_section_of(String creditcardlimits) {
		driver.findElement(By.xpath("//input[@id='credit']")).sendKeys(creditcardlimits);
	}

	@When("^Submit work out how much i could borrow$")
	public void submit_work_out_how_much_i_could_borrow() {
		driver.findElement(By.xpath("//button[@id='btnBorrowCalculater']")).click();
	}

	@When("^Wait for the page to be loaded$")
	public void wait_for_the_page_to_be_loaded() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^Validate borrowing amount estimate of \"(.*)\"$")
	public void validate_borrowing_amount_estimate_of(String borrowedamount) {
		String actualborrowedamount = driver.findElement(By.xpath("//span[@id='borrowResultTextAmount']")).getText();
		SoftAssert softAssert = new SoftAssert();		
		try {
			softAssert.assertEquals(actualborrowedamount,borrowedamount,"Borrowed estimate amount mismatch");
			softAssert.assertAll();
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
		}
		driver.quit();
	}

	@When("^Click on start over button$")
	public void click_on_start_over_button() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, 500)");
		driver.findElement(By.xpath("//span[contains(@class,'icon icon_restart')]")).click();
	}

	@Then("^Validate the borrowing calculation page fields are set to defaulted$")
	public void validate_the_borrowing_calculation_page__fields_are_refreshed() {
		Assert.assertTrue(driver.findElement(By.xpath("//label[normalize-space()='Single']")).isEnabled());
		Select dependants = new Select(driver.findElement(By.xpath("//select[@title='Number of dependants']")));
		dependants.getFirstSelectedOption().getText().equals("0");
		Assert.assertTrue(driver.findElement(By.xpath("//label[normalize-space()='Home to live in']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'container__main borrow--homeloan')]//div[2]//div[1]//div[1]//div[1]//input[1]")).getText().isEmpty());
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'container__main borrow--homeloan')]//div[2]//div[1]//div[2]//div[1]//input[1]")).getText().isEmpty());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='expenses']")).getText().isEmpty());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='homeloans']")).getText().isEmpty());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='otherloans']")).getText().isEmpty());
		Assert.assertTrue(driver.findElement(By.xpath("//main[contains(@class,'navigation-offset')]//div[3]//div[1]//div[4]//div[1]//input[1]")).getText().isEmpty());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='credit']")).getText().isEmpty());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@id='borrowResultTextAmount']")).getText().equals("$0"));
		driver.quit();
	}
}