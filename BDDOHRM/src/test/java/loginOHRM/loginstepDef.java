package loginOHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstepDef {
	WebDriver driver;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			System.out.println("The title of the page is: "+driver.getTitle());
			
	}

	@When("^User enters valid username and valid password$")
	
	public void user_enters_valid_username_and_valid_password(DataTable usercredentials) throws InterruptedException {
		
		List<List<String>> data = usercredentials.cells();
        //Enter data
        driver.findElement(By.id("txtUsername")).sendKeys(data.get(0).get(0));
        driver.findElement(By.name("txtPassword")).sendKeys(data.get(0).get(1));
        
		Thread.sleep(3000);
	}

	@Then("^User should logs in successfully$")
	public void user_should_logs_in_successfully() {
		driver.findElement(By.id("btnLogin")).click();
	}
}
