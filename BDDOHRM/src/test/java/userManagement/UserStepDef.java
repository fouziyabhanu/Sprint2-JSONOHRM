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
	public void admin_is_on_the_user_management_page()  {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		System.out.println("The title of the page is: "+driver.getTitle());
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();		
	
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
		
	}
	//Search user
	
	@When("^Admin enters username and clicks on search button$")
	public void admin_enters_username_and_clicks_search_button()  {
		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("dilshad");
		
		
		
	}

	@Then("^User details should be displayed$")
	public void user_details_should_be_displayed() {

		driver.findElement(By.id("searchBtn")).click();
		
		System.out.println("Searched user details displayed");
		
		
		
	}

	//Add user
	
	@When("^Admin clicks on add button$")
	public void user_click_on_add_button()  {
		
		driver.findElement(By.id("btnAdd")).click();
		
		
	}

	@And("^Enters Employee details and clicks on save button$")
	public void enters_employee_details() {
		
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		
		driver.findElement(By.name("systemUser[userName]")).sendKeys("fouziyabhanu3");
		
		driver.findElement(By.id("systemUser_password")).sendKeys("fouzi123");
		
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("fouzi123");
		
	}


	@Then("^A new user is added$")
	public void click_on_save_button()  {
		
		driver.findElement(By.id("btnSave")).click();
		
		if(driver.findElement(By.id("btnSave")).isDisplayed()) {
			
	        System.out.println("The message is: "+driver.findElement(By.id("btnSave")).getText());
	       
	    }
	    else
	    {
	        driver.navigate().back();
	       
	    }
		
	
	}
	
	// Edit user
	
	
	@Given("^Admin is on edit user page$")
	public void admin_is_on_edit_user_page() throws InterruptedException {
		driver.findElement(By.cssSelector("div.box.noHeader:nth-child(1) div.inner table.table.hover tbody:nth-child(2) tr.odd td.left:nth-child(2) > a:nth-child(1)")).click();
		
	}

	@When("^Admin edits users information and clicks on save button$")
	public void admin_edits_users_information() throws InterruptedException {
		
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fouziya Bhanu");
		
		Thread.sleep(2000);
	
		driver.findElement(By.id("systemUser_userName")).clear();

		driver.findElement(By.id("systemUser_userName")).sendKeys("Fouziya3");
		
	}
	@Then("^The user details are updated$")
	public void user_click_on_save()  {
		
		driver.findElement(By.id("btnSave")).click();
		
		if(driver.findElement(By.id("btnSave")).isDisplayed()) {
	        System.out.println("The message is: "+driver.findElement(By.id("btnSave")).getText());
	       
	    }
	    else
	    {
	        driver.navigate().back();
	       
	    }
	
	}

//delete user
	
	@When("^ Admin selects a user to be deleted and clicks on delete button$")
	public void admin_selects_a_user_to_be_deleted()  {
		
		driver.findElement(By.name("chkSelectRow[]")).click();
		
	
		driver.findElement(By.id("btnDelete")).click();
		
	}


	@Then("^The selected user is deleted$")
	public void click_delete()  {
		
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		driver.findElement(By.id("resetBtn")).click();
		
		driver.close();
	}
}
