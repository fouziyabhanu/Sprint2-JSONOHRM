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
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		Thread.sleep(2000);
	}


	@When("^Admin is on job title page$")
	public void admin_is_on_job_title_page() throws InterruptedException {
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		Thread.sleep(2000);
	}

	

	@Then("^User is able to add the job title$")
	public void user_is_able_to_add_the_job_title() throws InterruptedException {
		driver.findElement(By.id("btnAdd")).click();
	
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Analyst09qwss");
		Thread.sleep(3000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000); 
	}


	@And("^User should able to delete the job$")
	public void user_should_able_to_delete_the_job() throws InterruptedException {
		driver.findElement(By.name("chkSelectRow[]")).click();
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		Thread.sleep(2000);
	}

	@Then("^User is able to edit the job details$")
	public void user_is_able_to_edit_the_job_details() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("jobTitle_jobTitle")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Devpwd");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
	}
}
