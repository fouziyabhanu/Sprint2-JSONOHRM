package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfo {
	
	@FindBy(id="menu_pim_viewMyDetails")
	WebElement MYin;
	
	@FindBy(id="btnSave")
	WebElement Edit;
	
	@FindBy(name="personal[txtEmpFirstName]")
	WebElement firstName;
	
	@FindBy(name = "personal[txtEmpFirstName]")
	WebElement fname;
	
	@FindBy(id = "personal_txtEmpLastName")
	WebElement lastName;
	
	@FindBy(id = "personal_txtEmpLastName")
	WebElement lName;
	
	@FindBy(id = "btnSave")
	WebElement savebtn;
	
	@FindBy(name = "chkattdel[]")
	WebElement check;
	
	@FindBy(id = "btnDeleteAttachment")
	WebElement deletebtn;
	
	public MyInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void MYinf() {
		MYin.click() ;

	}
	
	
	public void edit1() {
		Edit.click() ;
	}
	
	public void firstname() {
		firstName.clear() ;
	}
	
	public void fname(String fn) {
		fname.sendKeys(fn);
		
	}

	public void lastName() {
		lastName.clear();
		
	}
	
	public void lName(String ln) {
		lName.sendKeys(ln);
	}
	
	
	
	public void savedtn() {
		 savebtn.click();
		
	}
	
	
	public void check() {
		check.click();
		
	}
	
	
	
	public void deletebtn() {
		 deletebtn.click();
		
	}
	
}