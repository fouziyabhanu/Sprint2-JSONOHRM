package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Job {
	@FindBy(xpath="//b[contains(text(),'Admin')]")
	WebElement admin;
	
	@FindBy(id="menu_admin_Job")
	WebElement job;
	
	@FindBy(id="menu_admin_viewJobTitleList")
	WebElement jobTitles;
	
	@FindBy(id="btnAdd")
	WebElement add;
	
	@FindBy(id = "jobTitle_jobTitle")
	WebElement adJ;
	
	@FindBy(id = "btnSave")
	WebElement ss;
	
	@FindBy(name = "chkSelectRow[]")
	WebElement clickOnJobTitleCheckBox;
	
	@FindBy(id="btnDelete")
	WebElement delete;
	
	@FindBy(id = "dialogDeleteBtn")
	WebElement dialogdt;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")
	WebElement clickOnJobTitle;
	
	@FindBy(id="btnSave")
	WebElement edit;
	
	@FindBy(name ="jobTitle[jobTitle]")
	WebElement jobTitle;
	
	@FindBy(id="jobTitle_jobTitle")
	WebElement jobTitleEdit;
	
	@FindBy(id = "btnSave")
	WebElement svb;
	
public Job(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void admin() {
   admin.click();
	}

	public void cjob() {
	 job.click();

	}

	public void jobTitles() {
	jobTitles.click();

	}

	//add job

	public void add() {
	add.click();

	}
	
	
	public void adJ(String adjb) {
		adJ.sendKeys(adjb);
	}
	
	
	public void ss() {
		 ss.click();
		
	}
	
	//delete job
	
	public void clickOnJobTitlCheckcBox() {
	clickOnJobTitleCheckBox.click();

	}


	public void delete() {
	 delete.click();

	}
	
	public void dialogdt() {
	dialogdt.click();
		
	}

	public void clickOnJobTitle() {
	 clickOnJobTitle.click();

	}
	
	// Edit job
	
	public void edit() {
	edit.click();

	}
	
	public void jobTitle() {
		 jobTitle.click();
		
	}
	
	public void jobTitleEdit(String jte) {
		jobTitleEdit.sendKeys(jte);
	}
		
	public void svb() {
		 svb.click();
		
	}
	
}
