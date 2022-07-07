package logOut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LogOutStepDef {
	
	WebDriver driver;
	
	@Given("^Admin is on home page$")
	
	public void user_is_on_home_page() {
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
			
		 driver = new ChromeDriver();
		 
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			
			driver.findElement(By.id("btnLogin")).click();
			
	}
	@When("^Admin clicks on welcome link$")
	public void User_clicks_on_welcome_link()  {
		
		//Assert.assertTrue(driver.findElement(By.id(("welcome"))).getText().matches("Welcome [a-z|A-Z]+"));
		
		 // System.out.println(driver.findElement(By.id(("welcome"))).getText());

		
		driver.findElement(By.className("panelTrigger")).click();
		

		driver.findElement(By.linkText("Logout")).click();
		
		
	}

	@Then("^Admin should logs out successfully$")
	
	public void User_should_logs_out_successfully()  {
		
		
		System.out.println("User logs out successfully");
		
		driver.close();
	}


}
