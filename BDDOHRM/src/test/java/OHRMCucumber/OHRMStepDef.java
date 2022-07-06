package OHRMCucumber;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OHRMStepDef {
	WebDriver driver;
	@Given("^User is on login page$")
	public void user_is_on_login_page() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
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

	
//Fouziya
	@Given("^Admin is on the User management page$")
	public void admin_is_on_the_user_management_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();		
	
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
		
	}
	@When("^Admin enters username and clicks on search button$")
	public void admin_enters_username_and_clicks_search_button() throws InterruptedException {
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("dilshad");
		Thread.sleep(3000);
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(2000);
	}

	@Then("^Admin clicks on reset button$")
	public void admin_clicks_on_reset() throws InterruptedException {
		driver.findElement(By.id("resetBtn")).click();
		Thread.sleep(2000);
	}

	@When("^User clicks on add button$")
	public void user_click_on_add_button() throws InterruptedException {
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(2000);
		
	}

	@And("^Enters Employee details$")
	public void enters_employee_details() throws InterruptedException {
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		Thread.sleep(2000);
		driver.findElement(By.name("systemUser[userName]")).sendKeys("fouziyabhanu3");
		Thread.sleep(2000);
		driver.findElement(By.id("systemUser_password")).sendKeys("fouzi123");
		Thread.sleep(2000);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("fouzi123");
		Thread.sleep(2000);
	}


	@Then("^Clicks on save button$")
	public void click_on_save_button() throws InterruptedException {
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
	
	}
	@Given("^Admin is on edit user page$")
	public void admin_is_on_edit_user_page() throws InterruptedException {
		driver.findElement(By.cssSelector("div.box.noHeader:nth-child(1) div.inner table.table.hover tbody:nth-child(2) tr.odd td.left:nth-child(2) > a:nth-child(1)")).click();
		Thread.sleep(2000);
	}

	@When("^Admin edits users information$")
	public void admin_edits_users_information() throws InterruptedException {
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fouziya Bhanu");
		Thread.sleep(2000);
		driver.findElement(By.id("systemUser_userName")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("systemUser_userName")).sendKeys("Fouziya3");
		Thread.sleep(2000);
	}
	@Then("^User clicks on save button$")
	public void user_click_on_save() throws InterruptedException {
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
	}


	@When("^Admin selects a user to be deleted$")
	public void admin_selects_a_user_to_be_deleted() throws InterruptedException {
		driver.findElement(By.name("chkSelectRow[]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.id("btnDelete")).click();
		Thread.sleep(2000);
	}


	@Then("^Clicks on delete button$")
	public void click_delete() throws InterruptedException {
		driver.findElement(By.id("dialogDeleteBtn")).click();
		Thread.sleep(2000);
	}
//Reddy Kumari
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
	
	
//Vinayak
	

@Given("^Admin is on personal details page$")
public void admin_is_on_personal_details_page() throws InterruptedException {
System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();

driver.get("https://opensource-demo.orangehrmlive.com/");
driver.findElement(By.id("txtUsername")).sendKeys("Admin");
driver.findElement(By.id("txtPassword")).sendKeys("admin123");
driver.findElement(By.id("btnLogin")).click();

driver.findElement(By.id("menu_pim_viewMyDetails")).click();
Thread.sleep(2000);

}
@When("^Admin clicks on edit button$")
public void admin_clicks_on_edit_button() throws InterruptedException {
	driver.findElement(By.id("btnSave")).click();
	Thread.sleep(2000);
}

@And("^Edit user details$")
public void edit_user_details() throws InterruptedException {
	driver.findElement(By.name("personal[txtEmpFirstName]")).clear();
	
	driver.findElement(By.name("personal[txtEmpFirstName]")).sendKeys("abcr");

	driver.findElement(By.name("personal[txtEmpLastName]")).clear();    

	driver.findElement(By.name("personal[txtEmpLastName]")).sendKeys("xvvr");
	Thread.sleep(2000);
}

@Then("^Clicks on save button$")
public void click_save() throws InterruptedException {
	driver.findElement(By.id("btnSave")).click();
	Thread.sleep(2000);
}

@Given("^Admin is on custom feild$")
public void admin_is_on_custom_feild() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
}

@When("^Admin clicks on edit$")
public void admin_clicks_on_edit() throws InterruptedException {
	driver.findElement(By.id("btnEditCustom")).click();
	Thread.sleep(2000);
}

@And("^Choose blood groop, vaccination details$")
public void choose_blood_groop_vaccination_details() throws InterruptedException {
	WebElement ele = driver.findElement(By.name("custom1"));
	Select s = new Select(ele);
	s.selectByVisibleText("A+");
	Thread.sleep(2000);
}

@Then("^Admin clicks on save button$")
public void admin_clicks_on_save() throws InterruptedException {
	driver.findElement(By.id("btnEditCustom")).click();
	Thread.sleep(2000);
}
@When("^Admin select file$")
public void admin_select_file() throws InterruptedException {
	driver.findElement(By.name("chkattdel[]")).click();
	Thread.sleep(2000);
}
@Then("^clicks on delete button$")
public void click_delete_button() throws InterruptedException {
	driver.findElement(By.id("btnDeleteAttachment")).click();
	Thread.sleep(2000);
}

//Ankita
		
@Given("^Admin is on Employee List page$")
public void admin_is_on_employee_list_page() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	
driver.findElement(By.id("menu_pim_viewPimModule")).click();
driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
}

@When("^Admin enters the employee name and employee ID,Supervisor Name$")
public void admin_enters_the_employee_name_and_employee_id_supervisor_name() throws InterruptedException {
	driver.findElement(By.id("empsearch_id")).sendKeys("0272");
	Thread.sleep(2000);
}
@Then("^Clicks on search$")
public void clicks_an_search() throws InterruptedException {
	driver.findElement(By.id("searchBtn")).click();
	Thread.sleep(2000);
}

@And("^User details displayed$")
public void user_detail_displayed() {
	System.out.println("user details displayed");
}
@When("^User click on add$")
public void user_click_on_add() throws InterruptedException {
	driver.findElement(By.id("btnAdd")).click();
	Thread.sleep(2000);
}

@Then("^Enters firstname and lastname$")
public void enters_firstname_and_lastname() throws InterruptedException {
	driver.findElement(By.id("firstName")).sendKeys("xywa");
	Thread.sleep(2000);
	driver.findElement(By.id("lastName")).sendKeys("abcww");
	Thread.sleep(2000);
}
@And("^Clicks on save button$")
public void click_save_button() throws InterruptedException {
	driver.findElement(By.id("btnSave")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("menu_pim_viewPimModule")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	Thread.sleep(2000);
}

@Then("^Select user to delete$")
public void select_user_to_deleted() throws InterruptedException {
	driver.findElement(By.name("chkSelectRow[]")).click();
	Thread.sleep(2000);
}
@Then("^Delete the user$")
public void delete_the_user() throws InterruptedException {
	driver.findElement(By.id("btnDelete")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("dialogDeleteBtn")).click();
	Thread.sleep(2000);
}


}
