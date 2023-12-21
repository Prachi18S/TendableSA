package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tendable {
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public void teardown() {
		driver.quit();
	}
	@Given("user navigates to Tendable URL")
	public void user_navigates_to_tendable_url() {
		 driver.get("https://www.tendable.com//");
	}
	@Then("user can access top--level menus: Home, Our Story, Our Solution, and Why Tendable")
	public void user_can_access_top_level_menus_home_our_story_our_solution_and_why_tendable() {
		WebElement home =driver.findElement(By.xpath("//a[@href='https://www.tendable.com/']"));
		Assert.assertEquals(true,home.isEnabled());
		
		WebElement Our_Story = driver.findElement(By.linkText("Our Story"));
		Assert.assertEquals(true,Our_Story.isEnabled());
		
		WebElement Our_Solution = driver.findElement(By.linkText("Our Solution"));
		Assert.assertEquals(true,Our_Solution.isEnabled());
		
		WebElement Why_Tendable = driver.findElement(By.linkText("Why Tendable?"));
		Assert.assertEquals(true,Why_Tendable.isEnabled());
	   
	}

	@Given("user clicks {string}")
	public void user_clicks(String menu) {
		driver.findElement(By.linkText(menu)).click();
		
	}
	@Then("user can see Request a Demo button is present and active")
	public void user_can_see_request_a_demo_button_is_present_and_active() {
		WebElement Request_a_Demo = driver.findElement(By.linkText("Request a Demo"));
		Assert.assertEquals(true,Request_a_Demo.isDisplayed());
	   
	}
	@When("user navigates to {string} section")
	public void user_navigates_to_section(String string) {
		driver.findElement(By.xpath("//button[text()='Contact']")).click();
	}

	@When("user submits fullName, organisationName, Phone Number, email, jobRole")
	public void user_submits_full_name_organisation_name_phone_number_email_job_role() {
		WebElement fullName= driver.findElement(By.name("fullName"));
		fullName.sendKeys("Prachi Singla");
		WebElement organisationName= driver.findElement(By.name("organisationName"));
		organisationName.sendKeys("TSYS");
		WebElement cellPhone= driver.findElement(By.name("cellPhone"));
		cellPhone.sendKeys("8872233491");
		WebElement email= driver.findElement(By.name("email"));
		email.sendKeys("prachisingla18@gmail.com");
		WebElement jobRole= driver.findElement(By.name("jobRole"));
		Select select = new Select(jobRole);
		select.selectByValue("Executive Board Member");
	}

	@When("user clicks {string}  button")
	public void user_clicks_button(String button) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name(button)).click();
	}
	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() throws InterruptedException {
		Thread.sleep(2000);
		WebElement submit= driver.findElement(By.name("form_page_submit"));
		submit.click();
		Thread.sleep(2000);
	}
	

	@Then("{string} error should be displayed")
	public void error_should_be_displayed(String message) {
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='contactMarketingPipedrive-163701']/div[1]/p"))
				.getText(), message);
		
	}

}
