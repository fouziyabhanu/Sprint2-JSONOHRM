package adminJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobStepDef {
	WebDriver driver;
	
	@Given("^Admin is on job page$")
	public void admin_is_on_job_page() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		
		driver.findElement(By.id("menu_admin_Job")).click();
	
	}


	@When("^Admin clicks on add button and enter the job to be added$")
	public void  admin_clicks_on_add_button_and_enter_the_job_to_be_added() {
		
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
		
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Analyst34");
	}

	

	@Then("^Admin is added the job successfully$")
	public void user_is_able_to_add_the_job_title()  {
		
	driver.findElement(By.id("btnSave")).click();
	System.out.println("Job is added successfully");
	if(driver.findElement(By.id("btnSave")).isDisplayed()) {
        System.out.println("The message is: "+driver.findElement(By.id("btnSave")).getText());
       
    }
    else
    {
        driver.navigate().back();
       
    }
		
	}


	@When("^Admin selects the job to be deleted and clicks on delete button$")
	public void admin_selects_the_job_to_be_deleted_and_clicks_on_delete_button()  {
		driver.findElement(By.name("chkSelectRow[]")).click();
		
		driver.findElement(By.id("btnDelete")).click();
		
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
	}
	
	@Then("^The selected job is deleted$")
	public void the_selected_job_is_deleted() {

	driver.findElement(By.id("dialogDeleteBtn")).click();
	}
	@When("^Admin edits the job details$")
	public void admin_edits_the_job_details()  {
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).click();
		
		driver.findElement(By.id("btnSave")).click();
	
		driver.findElement(By.id("jobTitle_jobTitle")).clear();

		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Business Analyst");
		
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("Collects Requirements");
	}
		@Then("^Admin updates the job details$")
		
		public void admin_updates_the_job_details() {
			
		
		driver.findElement(By.id("btnSave")).click();
		if(driver.findElement(By.id("btnSave")).isDisplayed()) {
	        System.out.println("The message is: "+driver.findElement(By.id("btnSave")).getText());
	       
	    }
	    else
	    {
	        driver.navigate().back();
	    }
	     
	      
		
	}
}
