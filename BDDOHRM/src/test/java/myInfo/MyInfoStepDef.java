package myInfo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyInfoStepDef {
	
	WebDriver driver;
	
	@Given("^Admin is on personal details page$")
	
	public void admin_is_on_personal_details_page() throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
	
	driver = new ChromeDriver();

	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	
	driver.findElement(By.id("btnLogin")).click();

	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	

	}
	
	//Edit details
	
	@When("^Admin clicks on edit button$")
	

	public void admin_clicks_on_edit_button() throws InterruptedException {
		
		driver.findElement(By.id("btnSave")).click();
	
	}

	@And("^Edit user details$")
	public void edit_user_details() throws InterruptedException {
		driver.findElement(By.name("personal[txtEmpFirstName]")).clear();
		
		driver.findElement(By.name("personal[txtEmpFirstName]")).sendKeys("fb123");

		driver.findElement(By.name("personal[txtEmpLastName]")).clear();    

		driver.findElement(By.name("personal[txtEmpLastName]")).sendKeys("sfb");
		
	}

	@Then("^Clicks on save button$")
	
	public void click_save() throws InterruptedException {
		
		driver.findElement(By.id("btnSave")).click();
		
	}

	@Given("^Admin is on custom feild$")
	
	public void admin_is_on_custom_feild() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)");
	}

	@When("^Admin clicks on edit$")
	
	public void admin_clicks_on_edit() throws InterruptedException {
		
		driver.findElement(By.id("btnEditCustom")).click();
		
	}

	@And("^Choose blood groop, vaccination details$")
	
	public void choose_blood_groop_vaccination_details() throws InterruptedException {
		
		WebElement ele = driver.findElement(By.name("custom1"));
		
		Select s = new Select(ele);
		
		s.selectByVisibleText("A+");
		

	}

	@Then("^Admin clicks on save button$")
	
	public void admin_clicks_on_save() throws InterruptedException {
		
		driver.findElement(By.id("btnEditCustom")).click();
		
	}
	
	//Add Attachment
	
	@When("^Admin select file$")
	
	public void admin_select_file() throws InterruptedException {
		driver.findElement(By.name("chkattdel[]")).click();
		
	}
	@Then("^clicks on delete button$")
	public void click_delete_button() throws InterruptedException {
		driver.findElement(By.id("btnDeleteAttachment")).click();
		
	}
}
