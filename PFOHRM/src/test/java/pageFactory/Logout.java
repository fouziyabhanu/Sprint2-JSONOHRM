package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	public Logout(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="welcome")
	WebElement welcome;
	
	public void welcome() {
		 welcome.click();
		
	}
	@FindBy(xpath="//a[@id='welcome']")
	WebElement userName;
	
	public void userName() {
		userName.getText();
	}
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logOut;
	
	public void logOut() {
		logOut.click();
		
	}
}
