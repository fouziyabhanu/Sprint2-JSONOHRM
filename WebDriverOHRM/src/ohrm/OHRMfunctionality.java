package ohrm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OHRMfunctionality {
	 
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver;
		
		File src= new File("C:\\Users\\shabhanu\\eclipse-workspace\\WebDriverOHRM\\TestResources\\OHRM.property");
	        
		 FileInputStream fis1 = new FileInputStream(src);    
	    
	        // Load the properties File
	        Properties prop = new Properties();
	        
	        prop.load(fis1);
	        
	        System.setProperty("webdriver.chrome.driver","C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Selenium1\\selenium jars\\chromedriver_win32//chromedriver.exe");                    
	        
	        driver = new ChromeDriver();    
	        
	        driver.get(prop.getProperty("URL"));     
	        
	        driver.manage().window().maximize();            
	  
	        //Excel Sheet
	        
	    FileInputStream fis2 = new FileInputStream("C:\\Users\\shabhanu\\Documents\\OneDrive - Capgemini\\Desktop\\Project\\OHRMlogin.xlsx");
	    
	    XSSFWorkbook workbook = new XSSFWorkbook(fis2);
		
	    XSSFSheet ws = workbook.getSheetAt(0);
	    
			int rownum  = ws.getLastRowNum();
			int colnum = ws.getRow(0).getPhysicalNumberOfCells();
			
			System.out.println(colnum);
			
			System.out.println(rownum);
			XSSFCell userName;
			
			XSSFCell password;
			
			XSSFCell search;
			
			XSSFCell empName;
			
			XSSFCell enterUserName;
			
			XSSFCell pswd;
			
			XSSFCell cpswd;
			
			XSSFCell empolyName;
			
			XSSFCell uName;
			
			XSSFCell jobName;
			
			XSSFCell jobds;
			
			XSSFCell editjob;
			
			XSSFCell searchp;
			
			XSSFCell emFN;
			
			XSSFCell emLN;
			
			XSSFCell emId;
			
			XSSFCell pFN;
			
			XSSFCell pLN;
			
			XSSFCell eid;
			
			XSSFCell oid;
			
			XSSFCell licNo;
			
			for(int i=1;i<=rownum;i++) {
			   
			    userName = ws.getRow(i).getCell(0);
			    password = ws.getRow(i).getCell(1);
         
         System.out.println("Username is: "+userName);
         
         System.out.println("Password is: "+password);
         driver.findElement(By.name(prop.getProperty("userName"))).sendKeys(userName.toString());
         
        Thread.sleep(3000);
        
        driver.findElement(By.name(prop.getProperty("password"))).sendKeys(password.toString());
	    
    	//Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       
        driver.findElement(By.name(prop.getProperty("loginButton"))).click();
			
        
        //Validation
        
        Assert.assertTrue(driver.findElement(By.id(prop.getProperty("welcomeUser"))).isDisplayed());   
        
		System.out.println("logo validated successfully by assertion");
		
		WebElement wel =driver.findElement(By.id("welcome"));                          
		if (wel.isDisplayed()) {
			System.out.println("welcome message is displayed");
		}
		else {
			System.out.println("welcome message is not displayed");
		}
		
		
		
		//Admin-User
		driver.findElement(By.className(prop.getProperty("clickAdmin"))).click();
		
        driver.findElement(By.id(prop.getProperty("userManagement"))).click();
       
        //search user
        search=ws.getRow(i).getCell(2);
        
        driver.findElement(By.name(prop.getProperty("searchName"))).sendKeys(search.toString());
        
        driver.findElement(By.id(prop.getProperty("search"))).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       
        //add user
        driver.findElement(By.id(prop.getProperty("add"))).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       
        empName=ws.getRow(i).getCell(3);
        
        driver.findElement(By.id(prop.getProperty("empName"))).sendKeys(empName.toString());
        
        enterUserName=ws.getRow(i).getCell(4);
        
        driver.findElement(By.id(prop.getProperty("enterUN"))).sendKeys(enterUserName.toString());
       
        pswd=ws.getRow(i).getCell(5);
        
        driver.findElement(By.id(prop.getProperty("enterPswd"))).sendKeys(pswd.toString());
        
        cpswd=ws.getRow(i).getCell(6);
        
        driver.findElement(By.id(prop.getProperty("conPswd"))).sendKeys(cpswd.toString());
        
        driver.findElement(By.id(prop.getProperty("save"))).click();
        
        driver.findElement(By.id(prop.getProperty("check"))).click();
       
        WebElement check1 = driver.findElement(By.xpath(prop.getProperty("check")));   
        check1.click();
        
        driver.findElement(By.id(prop.getProperty("delete"))).click();
        
        driver.findElement(By.id(prop.getProperty("popUp"))).click();
       
       // String alertMessage=driver.switchTo().alert().getText();
        //System.out.println(alertMessage);
      //  driver.switchTo().alert().accept();
       
	   driver.findElement(By.cssSelector("div.box.noHeader:nth-child(1) div.inner table.table.hover tbody:nth-child(2) tr.odd:nth-child(1) td.left:nth-child(2) > a:nth-child(1)")).click();
       
	   //Explicit wait
	    WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20));
	    
	    //Edit user
         wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("div.box.noHeader:nth-child(1) div.inner table.table.hover tbody:nth-child(2) tr.odd:nth-child(1) td.left:nth-child(2) > a:nth-child(1)")));
	    
         driver.findElement(By.id(prop.getProperty("edit"))).click();
	    
	     driver.findElement(By.id(prop.getProperty("empolNameclr"))).clear();
	     
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       
	     empolyName=ws.getRow(i).getCell(7);
	     
	     driver.findElement(By.id(prop.getProperty("empolName"))).sendKeys(empolyName.toString());
	     
	     driver.findElement(By.name(prop.getProperty("UNclr"))).clear();
	     
	     uName=ws.getRow(i).getCell(8);
	     
	     driver.findElement(By.name(prop.getProperty("UN"))).sendKeys(uName.toString());	        
         
        
        driver.findElement(By.id(prop.getProperty("save1"))).click();
        
        driver.findElement(By.id(prop.getProperty("reset"))).click();
        
        driver.navigate().back();
        
        
	
        //Admin-Job
        
        driver.findElement(By.id(prop.getProperty("adminJob"))).click();
        
        driver.findElement(By.linkText(prop.getProperty("job"))).click();
		
        //add job
        driver.findElement(By.id(prop.getProperty("addJ"))).click();
        
        jobName=ws.getRow(i).getCell(9);
        
		driver.findElement(By.name(prop.getProperty("jobTitle"))).sendKeys(jobName.toString());
		
		jobds=ws.getRow(i).getCell(10);
		
		 driver.findElement(By.id(prop.getProperty("jobDes"))).sendKeys(jobds.toString());
		 
		Thread.sleep(3000);
		
		driver.findElement(By.id(prop.getProperty("saveJ"))).click();
		
		driver.findElement(By.name(prop.getProperty("checkJ"))).click();
	
		driver.findElement(By.id(prop.getProperty("chkSelectRow[]"))).click();
		
		driver.findElement(By.id(prop.getProperty("deleteJ"))).click();
        
		driver.findElement(By.xpath(prop.getProperty("okJ"))).click();
		
		driver.findElement(By.id(prop.getProperty("jobT"))).click();
		
		//Edit job
		
		driver.findElement(By.id(prop.getProperty("editJ"))).click();
		
		driver.findElement(By.id(prop.getProperty("clearJ"))).clear();
		
		
		editjob=ws.getRow(i).getCell(11);
		
		driver.findElement(By.id(prop.getProperty("enterJ"))).sendKeys(editjob.toString());
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       
		
		driver.findElement(By.id(prop.getProperty("saveJ1"))).click();

		
		//PIM
		
		driver.navigate().back();
		
		driver.findElement(By.xpath(prop.getProperty("pimC"))).click();
		
		searchp=ws.getRow(i).getCell(12);
		
        driver.findElement(By.id(prop.getProperty("searchE"))).sendKeys(searchp.toString());
       
        //Check box
        WebElement check2 = driver.findElement(By.id(prop.getProperty("checkE")));   
        
        check2.click();
        
        driver.findElement(By.id(prop.getProperty("delE"))).click();
        
        driver.findElement(By.id(prop.getProperty("delOk"))).click();
        
        driver.findElement(By.xpath(prop.getProperty("clickE"))).click();
        
        driver.findElement(By.id(prop.getProperty("clickEdit"))).click();
        
        driver.findElement(By.id(prop.getProperty("empFNC"))).clear();
        
        Thread.sleep(3000);
        
        emFN=ws.getRow(i).getCell(13);
        
        driver.findElement(By.id(prop.getProperty("empFN"))).sendKeys(emFN.toString());
        
        driver.findElement(By.id(prop.getProperty("empLNC"))).clear();
        
        emLN=ws.getRow(i).getCell(14);
        
        driver.findElement(By.id(prop.getProperty("empLN"))).sendKeys(emLN.toString());
        
        
        emId=ws.getRow(i).getCell(15);
        
        driver.findElement(By.id(prop.getProperty("empID"))).sendKeys(emId.toString()); 
        
        
        driver.findElement(By.xpath(prop.getProperty("empSave"))).click();
        
        //Blood group details
        
        driver.findElement(By.xpath(prop.getProperty("customField"))).click();
        
        Select custom1 = new Select(driver.findElement(By.name("custom1")));   
        
        custom1.selectByValue("A");
        
       driver.findElement(By.id(prop.getProperty("customClick"))).click();
       
       driver.navigate().back();
       
       
      //My Info 
       driver.findElement(By.xpath(prop.getProperty("MyInfo"))).click();
       
       driver.findElement(By.xpath(prop.getProperty("editButton"))).click();
       
       driver.findElement(By.id(prop.getProperty("PFNC"))).clear();
       
       pFN=ws.getRow(i).getCell(16);
       
       driver.findElement(By.id(prop.getProperty("PFN"))).sendKeys(pFN.toString());
      
       driver.findElement(By.id(prop.getProperty("PLNC"))).clear();
       
       pLN=ws.getRow(i).getCell(17);
       
       driver.findElement(By.id(prop.getProperty("PLN"))).sendKeys(pLN.toString());
       
       eid=ws.getRow(i).getCell(18);
       
       driver.findElement(By.id(prop.getProperty("EMPID"))).sendKeys(eid.toString());
       
       oid=ws.getRow(i).getCell(19);
       
       driver.findElement(By.id(prop.getProperty("Otherid"))).sendKeys(oid.toString());
       
       Thread.sleep(3000);
       
       licNo=ws.getRow(i).getCell(20);
       
       driver.findElement(By.id(prop.getProperty("LINO"))).sendKeys(licNo.toString());
       
       driver.findElement(By.id(prop.getProperty("EXPDATEc"))).clear();
       
       driver.findElement(By.id(prop.getProperty("EXPDATE"))).sendKeys("2022-07-10");
       Thread.sleep(3000);
     
       //Radio button 
       WebElement male = driver.findElement(By.id("personal_optGender_1"));   
       
       WebElement female= driver.findElement(By.id("personal_optGender_2"));   
      
       female.click();
       driver.findElement(By.xpath(prop.getProperty("InfoSave"))).click();
       
       //Blood Group
       
       driver.findElement(By.xpath(prop.getProperty("customEdit"))).click();  
       
       Select custom = new Select(driver.findElement(By.name("custom1")));  
       
       custom.selectByValue("AB-");
       
       driver.findElement(By.xpath(prop.getProperty("saveCustom"))).click();  
       
       driver.findElement(By.xpath(prop.getProperty("clickAttach"))).click();   
       
       Thread.sleep(3000);
       
       WebElement fileInput = driver.findElement(By.name("ufile"));
      
      //Attachment
      fileInput.sendKeys("C:\\Users\\shabhanu\\Downloads\\photo.jpg");
      
      driver.findElement(By.xpath(prop.getProperty("saveAttach"))).click();
     
    
   // driver.findElement(By.xpath("//input[@value='1']")).click(); // delete particular single record
     
     driver.findElement(By.xpath(prop.getProperty("checkAll"))).click(); // delete all records
       
      driver.findElement(By.xpath(prop.getProperty("delAttach"))).click(); 
      
      //Logout
      driver.findElement(By.className(prop.getProperty("welcomeTab"))).click();
      
     Assert.assertTrue(driver.findElement(By.id(prop.getProperty("welcomeuser"))).getText().matches("Welcome [a-z|A-Z]+"));
     
      System.out.println(driver.findElement(By.id(prop.getProperty("welcomeuser"))).getText());
      
      driver.findElement(By.xpath(prop.getProperty("logout"))).click();
       
	
	
	
}}
}
