package pageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;




public class TestOHRM {
	
	String driverPath = "C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32\\chromedriver.exe";
	
	WebDriver driver;
	
	Login objLogin;
	
	UserManagement objUserManagement;
	
	Job objJob;
	
	MyInfo objMyInfo;
	
	PIM objPIM;
	
	Logout objLogout;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver=new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println(driver.getTitle());
		
    }
	@Test(priority=0)
	public void test_OHRM() throws IOException, InterruptedException   {
		
		objLogin=new Login(driver);
		
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\shabhanu\\eclipse-workspace\\PFOHRM\\TestResources\\OHRM.csv"));
		
		List<String[]> li=reader.readAll();
		
		  System.out.println("Total rows that we have is "+li.size());
		  
		// create Iterator reference
		  Iterator<String[]>i1= li.iterator();
		    
		 // Iterate all values 
		  
		 while(i1.hasNext()){
			 String[] str=i1.next();
			 
			 objLogin.setUserName(str[0]);
			 
			 objLogin.setPassword(str[1]);
			 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       
			 objLogin.clickLogin();
		
		//objLogin.loginToOHRM("Admin","admin123");	
	
	//Admin-User	
	objUserManagement=new UserManagement(driver);
	
	objUserManagement.clickAdmin();
	
	//objUserManagement.clickUser();
	objUserManagement.userName(str[2]);
	
	objUserManagement.clickSearch();
	
	objUserManagement.clickAdd();
	
	objUserManagement.addEmpN(str[3]);
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	objUserManagement.enterUN(str[4]);
	
	objUserManagement.password(str[5]);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	objUserManagement.confirmpswd(str[6]);
	
	objUserManagement.saveBtn();
	
	objUserManagement.check();
	
	objUserManagement.delete();
	
	objUserManagement.dialogdel();
	
	
	//Admin-Job
	
	objJob=new Job(driver);
	
	objJob.admin();
	
	objJob.cjob();
	
	objJob.jobTitles();
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	objJob.add();
	
	objJob.adJ(str[7]);
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	objJob.ss();
	
	objJob.clickOnJobTitlCheckcBox();
	
	objJob.delete();
	
	objJob.dialogdt();
	
	objJob.clickOnJobTitle();
	
	objJob.edit();
	
	objJob.jobTitle();
	
	objJob.jobTitleEdit(str[8]);
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	objJob.svb();
	
	
	//PIM
	
	objPIM=new PIM(driver);
	
	objPIM.pim();
	
	objPIM.Empoly();
	
	objPIM.empid(str[9]);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	
	objPIM.srchbtn();
	
	objPIM.btnadd();
	
	objPIM.firstName(str[10]);

	objPIM.lastName1(str[11]);
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	objPIM.save();
	
	objPIM.Emp();
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	objPIM.pimbtn();
	
	objPIM.deletebtn();
	
	objPIM.okdlt();
	
	//MyInfo
	
	objMyInfo=new MyInfo(driver);
	
	objMyInfo.MYinf();
	
	objMyInfo.edit1();
	
	objMyInfo.firstname();
	
	objMyInfo.fname(str[12]);
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
	objMyInfo.lastName();
	
	objMyInfo.lName(str[13]);
	
	objMyInfo.savedtn();
	
	objMyInfo.check();
	
	objLogout=new Logout(driver);
	
	objLogout.welcome();
	
	objLogout.userName();
	
	//Assertion
	
    Assert.assertTrue(driver.findElement(By.className("panelTrigger")).getText().matches("Welcome [a-z|A-Z]+"));
    
     System.out.println(driver.findElement(By.id("panelTrigger")).getText());
     
     
	objLogout.logOut();
	
	driver.close();
	


	
		
		
		
	}
	}}	

