package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagement {
	WebDriver driver;
	@FindBy(xpath ="//b[contains(text(),'Admin')]")
	WebElement admin;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement user;
	
	@FindBy(id="searchSystemUser_userName")
	WebElement usn;
	
	@FindBy(id="searchBtn")
	WebElement search;
	
	@FindBy(name="btnAdd")
	WebElement add;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement addEN;
	
	@FindBy(id="systemUser_userName")
	WebElement eUN;
	
	@FindBy(id="systemUser_password")
	WebElement pswd;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement cpd;
	
	@FindBy(id="btnSave")
	WebElement save;
	
	@FindBy(name="chkSelectRow[]")
	WebElement chck;
	
	@FindBy(id="btnDelete")
	WebElement del;
	
	@FindBy(id="dialogDeleteBtn")
	WebElement ok;
	
	
	public UserManagement(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 public void clickAdmin() {
		 admin.click();
	 }
	 public void clickUser() {
		 user.click();
		 
	 }
	
	 //search user
	 
	 public void userName(String un) {
		 usn.sendKeys(un);
	 }
	 
	 public void clickSearch() {
		 search.click();
	 }
	 
	 //add user
	 
	public void clickAdd() {
		add.click();
	}
	
	public void addEmpN(String en) {
		addEN.sendKeys(en);
	}
	
	public void  enterUN(String eun) {
		eUN.sendKeys(eun);
	}
	
	public void password(String pwd) {
		pswd.sendKeys(pwd);
	}
	
	public void confirmpswd(String cpwd) {
		cpd.sendKeys(cpwd);
	}
	
	public void saveBtn() {
		save.click();
	}
	
	
	
	public void check() {
		chck.click();
	}
	
	public void delete() {
		del.click();
	}
	
	public void dialogdel() {
		ok.click();
	}
	
}

