package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIM {
	
	@FindBy(xpath="//b[contains(text(),'PIM')]")
	WebElement PIMbtn;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement Emplylist;
	
	@FindBy(id="empsearch_id")
	WebElement Emplyid;
	
	@FindBy(id="searchBtn")
	WebElement search;
	
	@FindBy(id="btnAdd")
	WebElement Add;
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="btnSave")
	WebElement save;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	WebElement Empl;
	
	@FindBy(name="chkSelectRow[]")
	WebElement PIMbtn1;
	
	@FindBy(id="btnDelete")
	WebElement delete;
	
	@FindBy(id="dialogDeleteBtn")
	WebElement ok;
	
	public PIM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void pim() {
		 PIMbtn.click();
	}
	
	
	public void Empoly() {
		 Emplylist.click();
	}
	
		
		
		public void empid(String Empid) {
			Emplyid.sendKeys(Empid);
		}
		
		
		public void srchbtn() {
			 search.click();
		}
	
		public void btnadd() {
			Add.click();
		}
		
		public void firstName(String fn) {
			firstName.sendKeys(fn);
		}
		
		public void lastName1(String ln) {
			lastname.sendKeys(ln);
		}
		
		public void save() {
			 save.click();
		}
		
		
		public void Emp() {
			 Emplylist.click();
		}
		
		
		public void pimbtn() {
			 PIMbtn1.click();
		}
		
		public void deletebtn() {
			 delete.click();
		}
		
		public void okdlt() {
			ok.click();

}
}
