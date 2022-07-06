package userManagement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDef {
	WebDriver driver;
	
	@Given("^Admin is on the User management page$")
	
	public void admin_is_on_the_user_management_page() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();		
	
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
		
	}
	
	//Search User
	
	@When("^Admin enters username and clicks on search button$")
	
	public void admin_enters_username_and_clicks_search_button() throws InterruptedException {
		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("dilshad");
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		driver.findElement(By.id("searchBtn")).click();
	
	}

	@Then("^Admin clicks on reset button$")
	
	public void admin_clicks_on_reset() throws InterruptedException {
		
		driver.findElement(By.id("resetBtn")).click();
		
		Thread.sleep(2000);
	}

	//Add user
	
	
	@When("^User clicks on add button$")
	
	public void user_click_on_add_button() throws InterruptedException {
		
		driver.findElement(By.id("btnAdd")).click();
		
		
		
	}

	@And("^Enters Employee details$")
	
	public void enters_employee_details() throws InterruptedException {
		
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		
		
		driver.findElement(By.name("systemUser[userName]")).sendKeys("fouziyabhanu3");
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		driver.findElement(By.id("systemUser_password")).sendKeys("fouzi123");
	
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("fouzi123");
	
	}


	@Then("^Clicks on save button$")
	
	public void click_on_save_button() throws InterruptedException {
		
		driver.findElement(By.id("btnSave")).click();
		
		
	
	}
	
	//Edit user
	
	@Given("^Admin is on edit user page$")
	
	public void admin_is_on_edit_user_page() throws InterruptedException {
		
		driver.findElement(By.cssSelector("div.box.noHeader:nth-child(1) div.inner table.table.hover tbody:nth-child(2) tr.odd td.left:nth-child(2) > a:nth-child(1)")).click();
		
		
	}

	@When("^Admin edits users information$")
	
	public void admin_edits_users_information() throws InterruptedException {
		
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fouziya Bhanu");
		
		driver.findElement(By.id("systemUser_userName")).clear();
	
		driver.findElement(By.id("systemUser_userName")).sendKeys("Fouziya3");
		
	}
	
	@Then("^User clicks on save button$")
	
	public void user_click_on_save() throws InterruptedException {
		
		driver.findElement(By.id("btnSave")).click();
	
	}

	//Delete user
	
	@When("^Admin selects a user to be deleted$")
	
	public void admin_selects_a_user_to_be_deleted() throws InterruptedException {
		
		driver.findElement(By.name("chkSelectRow[]")).click();
	
		driver.findElement(By.id("btnDelete")).click();
	
	}


	@Then("^Clicks on delete button$")
	
	public void click_delete() throws InterruptedException {
		
		driver.findElement(By.id("dialogDeleteBtn")).click();
	
	}
}
