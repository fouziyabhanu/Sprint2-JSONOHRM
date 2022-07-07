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
import junit.framework.Assert;

public class OHRMStepDef {
	WebDriver driver;
	
	//Login
	
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

	//Admin-User

	@Given("^User is on the User management page$")
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
	@When("^Admin enters username and clicks on search butto$")
	public void admin_enters_username_and_clicks_search_button() throws InterruptedException {
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("dilshad");
		
		driver.findElement(By.id("searchBtn")).click();
		
	}

	@Then("^User details should be displayed$")
	public void user_details_should_be_displayed() {

		driver.findElement(By.id("searchBtn")).click();
		
		System.out.println("Searched user details displayed");
		
		
		
	}

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


	@When("^Admin selects a user to be deleted$")
	public void admin_selects_a_user_to_be_deleted()  {
		
		driver.findElement(By.name("chkSelectRow[]")).click();
		
	
		driver.findElement(By.id("btnDelete")).click();
		
	}


	@Then("^The selected user is deleted$")
	public void click_delete() throws InterruptedException {
		
		driver.findElement(By.id("dialogDeleteBtn")).click();
		
		driver.findElement(By.id("resetBtn")).click();
		
		Thread.sleep(2000);
	}

	
	//Admin-Job
	
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
	
	
//MYInfo
	

@Given("^Admin is on MyInfo  page$")
public void admin_is_on_personal_details_page() throws InterruptedException {
System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();

driver.get("https://opensource-demo.orangehrmlive.com/");

driver.findElement(By.id("txtUsername")).sendKeys("Admin");

driver.findElement(By.id("txtPassword")).sendKeys("admin123");

driver.findElement(By.id("btnLogin")).click();

driver.findElement(By.id("menu_pim_viewMyDetails")).click();


}
@When("^Admin clicks on edit button and edit user details$")
public void Admin_clicks_on_edit_button_and_edit_user_details() {
	driver.findElement(By.id("btnSave")).click();

	driver.findElement(By.name("personal[txtEmpFirstName]")).clear();
	
	driver.findElement(By.name("personal[txtEmpFirstName]")).sendKeys("Fouziya");

	driver.findElement(By.name("personal[txtEmpLastName]")).clear();    

	driver.findElement(By.name("personal[txtEmpLastName]")).sendKeys("Bhanu");
	
}

@Then("^Admin updated the details$")
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

@And("^Choose blood group,vaccination details$")
public void choose_blood_group_vaccination_details() throws InterruptedException {
	WebElement ele = driver.findElement(By.name("custom1"));
	Select s = new Select(ele);
	s.selectByVisibleText("A+");
	
}

@Then("^Admin updated the blood group and vaccination details$")
public void Admin_updated_the_blood_group_and_vaccination_details()  {
	driver.findElement(By.id("btnEditCustom")).click();
	
}
@When("^Admin selects the file to be deleted$")
public void admin_selects_the_file_to_be_deleted() throws InterruptedException {
	driver.findElement(By.name("chkattdel[]")).click();
	Thread.sleep(2000);
}
@Then("^The selected file deleted successfully$")
public void the_selected_file_deleted_successfully() {
	driver.findElement(By.id("btnDeleteAttachment")).click();
	
}


//PIM 

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

@When("^Admin enters employee ID and employee name$")
public void admin_enters_the_employee_ID_and_employee_name() throws InterruptedException {
	driver.findElement(By.id("empsearch_id")).sendKeys("0272");
	driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Fouziya");
	
}
@Then("^Admin gets the searched employee id$")
public void clicks_an_search()  {
	driver.findElement(By.id("searchBtn")).click();
	System.out.println("user details displayed");
}



@When("^Admin clicks on add button and enters the name and edit details$")

public void admin_clicks_on_add_button_and_enters_the_name_and_edit_details()  {
	
	driver.findElement(By.id("btnAdd")).click();
	
	driver.findElement(By.id("firstName")).sendKeys("Fouziya");
	
	driver.findElement(By.id("lastName")).sendKeys("Bhanu");
	
}
@Then("^Added the employee successfully$")
public void added_the_employee_successfully()  {
	
	driver.findElement(By.id("btnSave")).click();//save
	
	driver.findElement(By.id("btnSave")).click();//edit
	
	
	
	//Radio button
	 WebElement male = driver.findElement(By.id("personal_optGender_1"));    
	 
     WebElement female= driver.findElement(By.id("personal_optGender_2"));   
    
    female.click();
    
    //drop down
    Select nationality= new Select(driver.findElement(By.name("personal[cmbNation]")));
    
    nationality.selectByVisibleText("Indian");
	
    driver.findElement(By.id("btnSave")).click();
    
	driver.findElement(By.id("menu_pim_viewPimModule")).click();
	
	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	
	
	
}

@When("^Admin selects the employee to be deleted$")
public void admin_selects_the_employee_to_be_deleted_and_click_on_delete_button()  {
	
	driver.findElement(By.name("chkSelectRow[]")).click();

}
@Then("^Employee deletes successfully$")

public void employee_deletes_successfully() {
	
	driver.findElement(By.id("btnDelete")).click();
	
	driver.findElement(By.id("dialogDeleteBtn")).click();
	
	
}


//Logout

@Given("^Admin is on home page$")

public void Admin_is_on_homepage() {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://opensource-demo.orangehrmlive.com");
	
	System.out.println("The title of the page is: "+driver.getTitle());
	
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	
	driver.findElement(By.id("btnLogin")).click();
	
}
@When("^Admin clicks on welcome link$")
public void User_clicks_on_welcome_link()  {
	
	Assert.assertTrue(driver.findElement(By.id(("welcome"))).getText().matches("Welcome [a-z|A-Z]+"));
	
	  System.out.println(driver.findElement(By.id(("welcome"))).getText());

	
	driver.findElement(By.className("panelTrigger")).click();
	 
}

@Then("^Admin should logs out successfully$")
public void User_should_logs_out_successfully() {
	
	driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	
	System.out.println("User logs out successfully");
	
	driver.close();

   
	
}





}
