package pim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStepDef {
	
	WebDriver driver;
	
	@Given("^Admin is on Employee List page$")
	
	public void admin_is_on_employee_list_page() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	}

	
	//Search employee
	
	@When("^Admin enters the employee name and employee ID,Supervisor Name$")
	public void admin_enters_the_employee_name_and_employee_id_supervisor_name() throws InterruptedException {
		
		driver.findElement(By.id("empsearch_id")).sendKeys("0272");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Then("^Clicks on search$")
	public void clicks_an_search() throws InterruptedException {
		
		driver.findElement(By.id("searchBtn")).click();
		
	}

	@And("^User details displayed$")
	public void user_detail_displayed() {
		
		System.out.println("user details displayed");
	}
	
	//Add Employee
	
	@When("^User click on add$")
	
	public void user_click_on_add() throws InterruptedException {
		driver.findElement(By.id("btnAdd")).click();
		
		Thread.sleep(2000);
	}

	@Then("^Enters firstname and lastname$")
	
	public void enters_firstname_and_lastname() throws InterruptedException {
		
		driver.findElement(By.id("firstName")).sendKeys("Fouziya");
	
		driver.findElement(By.id("lastName")).sendKeys("Bhanu");
		
	}
	@And("^Clicks on save button$")
	
	public void click_save_button() throws InterruptedException {
		
		driver.findElement(By.id("btnSave")).click();
		
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	
	}

	@Then("^Select user to delete$")
	
	public void select_user_to_deleted() throws InterruptedException {
		driver.findElement(By.name("chkSelectRow[]")).click();
		
	}
	@And("^Delete the user$")
	
	public void delete_the_user() {
		
		driver.findElement(By.id("btnDelete")).click();
		
		driver.findElement(By.id("dialogDeleteBtn")).click();
	}
}
