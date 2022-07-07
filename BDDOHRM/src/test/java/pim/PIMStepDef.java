package pim;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


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
		
		driver.close();
		
	}
}
