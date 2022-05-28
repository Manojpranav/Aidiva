package Myproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class UserManagement

{
	public static ChromeDriver driver;
public static Actions build;
	@BeforeClass
	public void login()
	{
		// Login Process
		
		ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://flash.sit.rigelsoft.com/");
		driver.findElement(By.name("email")).sendKeys("manomanoj87@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Manojkumar@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement menus = driver.findElement(By.xpath("//span[.='settings']"));
    	      build = new Actions(driver);
    	    build.moveToElement(menus).perform();
    	   menus.click();	
		
	}
	@AfterClass
	public void logout() throws InterruptedException
	{
		//Logout Process
		
	  driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		Thread.sleep(3000);
		driver.close();
		
	}
	
	@Test(priority=0)
    public void addpractice() throws InterruptedException
    {
  	  // Add Practice Information
		
 	  driver.findElement(By.xpath("//button[.='Add Practice']")).click();
  	  driver.findElement(By.name("establishmentname")).sendKeys("Sai Clinic");
  	  driver.findElement(By.id("tenantTypeSelect")).click();
  	  driver.findElement(By.id("tenantTypeSelect")).sendKeys("Clinic",Keys.ENTER);
  	  driver.findElement(By.id("practiceSpeciality")).click();
  	  driver.findElement(By.id("practiceSpeciality")).sendKeys("Abdominal Radiology", Keys.ENTER);
  	  driver.findElement(By.id("practiceSpeciality")).sendKeys("Chest Radialogy", Keys.ENTER);
  	  driver.findElement(By.id("practiceSpeciality")).sendKeys("Emergency Medicine", Keys.ENTER);
  	  driver.findElement(By.id("practiceSpeciality")).sendKeys("Immunology", Keys.ENTER);
  	  driver.findElement(By.id("practiceSpeciality")).sendKeys("Transplant Cardiology", Keys.ENTER);  
  	 driver.findElement(By.name("gstnnumber")).sendKeys("33SAIHO9236A1OS");
  	  driver.findElement(By.name("website")).sendKeys("www.saiclinic.com");
  	  driver.findElement(By.name("addressOne")).sendKeys("No 74, Krishna Nagar");
  	  driver.findElement(By.name("addressTwo")).sendKeys("Arul Street");
  	  
  	  Thread.sleep(2000);
  	    	  WebElement country = driver.findElement(By.xpath("(//input[contains(@id,'country')])[5]"));
  	  driver.executeScript("arguments[0].scrollIntoView();", country);
  	Thread.sleep(2000);
  	  country.sendKeys("India",Keys.ARROW_DOWN,Keys.INSERT); 	
  	Thread.sleep(2000);
  	  country.sendKeys(Keys.ENTER);
  	Thread.sleep(2000);
   driver.executeScript("arguments[0].click();",country);
  	  
  	  WebElement state = driver.findElement(By.xpath("//input[contains(@id,'state')]"));
  	  Thread.sleep(2000);

  	  state.sendKeys("Tamil Nadu",Keys.ARROW_DOWN,Keys.ENTER);
  	Thread.sleep(2000);
  	  driver.executeScript("arguments[0].click();",state);
  	  
  	  WebElement city = driver.findElement(By.xpath("(//input[contains(@id,'city')])[3]"));
    	Thread.sleep(2000);
  	  city.sendKeys("Coimbatore/ Tamil Nadu",Keys.ARROW_DOWN,Keys.INSERT);
  	Thread.sleep(2000);
  	city.sendKeys(Keys.ENTER);
  	Thread.sleep(2000);
  	  	  driver.executeScript("arguments[0].click();",city);
    	     
  	  
  	  driver.findElement(By.xpath("(//input[@id='pincode'])[2]")).sendKeys("600011");
	  driver.findElement(By.xpath("(//button[contains(text(),'Save')])[5]")).click();
  	
    }
	
	 @Test(priority=1)
	public void Management() throws InterruptedException
	{
		 //Add User Management Details
		 
		  Thread.sleep(500);
		
		WebElement alert = driver.findElement(By.xpath("//span[.='User Management']"));
	      build = new Actions(driver);
	    build.moveToElement(alert).perform();
	   alert.click();
	     Thread.sleep(1000);
	    
	     
	  driver.findElement(By.xpath("//button[.='Add User']")).click();
	   driver.findElement(By.name("name")).sendKeys("Poonu Samy");
	     driver.findElement(By.name("regnumber")).sendKeys("1195117");
	    driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("6685632112");
	    driver.findElement(By.name("email")).sendKeys("poonusamy52@gmail.com");
	    driver.findElement(By.name("Physiotherapist")).click();
	    driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[2]/*[1]")).click();
	driver.findElement(By.name("dailySms")).click();
	driver.findElement(By.name("dailyMail")).click();
	driver.findElement(By.name("appSms")).click();
	driver.findElement(By.name("appMail")).click();
	driver.findElement(By.xpath("(//button[contains(text(),'Save')])[4]")).click();
	

	}
	 
	
          @Test(priority=2)
        public void calender() throws InterruptedException 
          {
        	  //Add Practice Timing Details
       
        	  	WebElement alert = driver.findElement(By.xpath("//span[text()='Calender']"));
     	     build = new Actions(driver);
     	    build.moveToElement(alert).perform();
     	    alert.click();
     	    
     	   WebElement hosname =    driver.findElement(By.xpath("(//input[@id='combo-box-demo'])[3]"));
        	  Thread.sleep(2000);
        	  driver.findElement(By.xpath("(//input[@id='combo-box-demo'])[3]")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.CLEAR));
        	         	hosname.sendKeys("Sai Clinic", Keys.ARROW_DOWN, Keys.ENTER);
        	 Thread.sleep(2000);
        	  driver.executeScript("arguments[0].click()", hosname);
     	         	    
     	     	    Thread.sleep(2000);
    	    driver.findElement(By.xpath("//button[.=' Add ']")).click();
    	   
    	    WebElement patname = driver.findElement(By.id("practice-details"));
    	    driver.findElement(By.id("practice-details")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.CLEAR));
       	  Thread.sleep(2000);
       	patname.sendKeys("Sai Clinic", Keys.ARROW_DOWN, Keys.ENTER);
       	 Thread.sleep(2000);
    	        	   
    	     WebElement speciality =    driver.findElement(By.id("specialityDetails[0].specialityName"));
     	  Thread.sleep(2000);
     	  speciality.sendKeys("Emergency Medicine", Keys.ARROW_DOWN, Keys.ENTER);
     	 Thread.sleep(2000);
     	  driver.executeScript("arguments[0].click()", speciality);
     	     driver.findElement(By.id("custom-checkbox-3")).click();
     	    driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-u8fnkc'])[2]")).click();
     	    driver.findElement(By.xpath("//div[@class='css-1umqo6f']")).click();
     	    driver.findElement(By.xpath("//span[text()='8']")).click();
     	    driver.findElement(By.xpath("//button[@title='open next view']")).click();
     	   driver.findElement(By.xpath("//span[text()='15']]")).click();
     	   driver.findElement(By.xpath("//span[text()='PM']")).click();
          driver.findElement(By.id("specialityDetails[0].details[0].timings[0].consultantionFees")).sendKeys("300",Keys.ENTER);
          driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();

          Thread.sleep(2000);
          WebElement time =  driver.findElement(By.id("specialityDetails[0].details[0].timings[0].consultantionDuration"));
          Thread.sleep(2000);
          driver.executeScript("arguments[0].scrollIntoView();", time);
          time.sendKeys("30 mins",Keys.ARROW_DOWN, Keys.ENTER);
          Thread.sleep(2000);
          driver.executeScript("arguments[0].click()", time);

          
          driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]")).click();
          driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[2]/button[2]")).click();
         
     	    
          
          }
          
          @Test(priority=3)
         public void Billing() throws InterruptedException
         {
        	  //Add billing Detials in List
        	  
     WebElement alertbill = driver.findElement(By.xpath("//span[contains(text(),'Billing')]"));
      	      build = new Actions(driver);
      	    build.moveToElement(alertbill).perform();
      	    alertbill.click();
      	    
           	     
      	    Thread.sleep(1000);
      	    driver.findElement(By.xpath("(//input[@id='name'])[1]")).sendKeys("Crocin", Keys.ENTER);
      	    driver.findElement(By.id("gstvalue")).sendKeys("12.5",Keys.ENTER);
      	    driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
      	  Thread.sleep(2000);
      	  driver.findElement(By.xpath("//body/div[@id='root']/div[@id='fuse-layout']/div[2]/main[1]/div[2]/div[1]/div[2]/div[2]/div[10]/div[1]/p[1]/div[1]/div[2]/div[1]/div[2]/*[1]")).click();
    	    driver.findElement(By.xpath("(//input[contains(@id,'name')])[2]")).sendKeys("Crocin", Keys.ENTER);
    	    driver.findElement(By.id("paymentType")).sendKeys("Netbanking",Keys.ENTER);
    	    driver.findElement(By.id("vendorFee")).sendKeys("15");
    	    driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
      	    
         }
          
          @Test(priority=4)
          public void AddAppointment() throws InterruptedException, AWTException
          {
        	       
        	  // Add Appointment in calendar
        	  
             WebElement alertapp = driver.findElement(By.xpath("//span[.='calendar_today']"));
        	          build = new Actions(driver);
        	       build.moveToElement(alertapp).perform();
        	       alertapp.click();
        	 
        	        driver.findElement(By.xpath("//button[text()='Add Appointment']")).click();
        	    
        	           WebElement appname =  driver.findElement(By.id("patientName"));
        	    Thread.sleep(2000);
        	    appname.sendKeys("Naveen",Keys.ARROW_DOWN, Keys.ENTER);
        	    Thread.sleep(2000);
        	    driver.executeScript("arguments[0].click()", appname);
         	    driver.findElement(By.id("custMobile")).sendKeys("6612020523",Keys.ENTER);
        	  driver.findElement(By.xpath("//body/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/button[1]/*[1]")).click();
        	    driver.findElement(By.xpath("//body/div[7]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[6]/button[1]")).click();
        	   driver.findElement(By.id("custEmail")).sendKeys("naveen523@gmail.com");
        	   driver.findElement(By.xpath("//input[@id='duration']")).sendKeys("45 min",Keys.ENTER);
        	   WebElement docname = driver.findElement(By.id("doctorName"));
        	   Thread.sleep(2000);
        	   docname.sendKeys("Raj Kumar",Keys.ARROW_DOWN, Keys.ENTER);
        	   Thread.sleep(2000);
        	   driver.executeScript("arguments[0].click()", docname); 
        	   
        	   WebElement time = driver.findElement(By.id("timeDuration"));
        	   Thread.sleep(2000);
        	   time.sendKeys("05:30 PM",Keys.ARROW_DOWN, Keys.ENTER);
        	   Thread.sleep(2000);
        	   driver.executeScript("arguments[0].click()", time);
        	   
                     	  
        	    driver.findElement(By.id("notes")).sendKeys("Need Appointment from Doctor on Given time");
        	   
        	   WebElement modeapp = driver.findElement(By.id("appointmentMode"));
        	   Thread.sleep(2000);
        	   modeapp.sendKeys("Online",Keys.ARROW_DOWN, Keys.ENTER);
        	   Thread.sleep(2000);
        	   driver.executeScript("arguments[0].click()", modeapp);
        	    
        	    driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click(); 
        	    
        	    Thread.sleep(3000);
        	    driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
        	            	           
          }
          
          @Test(priority=5)
          public void addremanider() throws InterruptedException, AWTException
          {
        	// Adding for remainder in calendar
   	       
 	         driver.findElement(By.xpath("//button[contains(text(),'Add Reminder')]")).click();
 	         driver.findElement(By.id("title")).sendKeys("Remainder for Sakthiganga Patient", Keys.TAB);
 	         Thread.sleep(100);
 	        
 	         WebElement doctorname = driver.findElement(By.xpath("//body/div[5]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]"));
 	         Thread.sleep(1000);
 	         doctorname.sendKeys("Uma", Keys.ARROW_DOWN, Keys.ENTER);
 	         Thread.sleep(1000);
 	         driver.executeScript("arguments[0].click", doctorname);
 	         driver.findElement(By.name("date")).click();
 	         driver.findElement(By.xpath("//div[@class='PrivatePickersSlideTransition-root css-dhopo2']/div/div[@role='row'][3]/div[@role='cell'][3]")).click();
 	            
 	              Robot robot = new Robot();
 	              robot.keyPress(KeyEvent.VK_ESCAPE);
 	                 	    
 	       driver.findElement(By.xpath("(//button[text()='Save'])[3]")).click(); 
          }
        		
          
          @Test(priority=6)
          public void blockcalendar() throws InterruptedException, AWTException
          {
        	  
   	       //Adding for  BlockCalendar
     	  
   	  driver.findElement(By.xpath("(//button[text()='Block Calendar'])[1]")).click();
   	       driver.findElement(By.xpath("//input[@id='leaveDetail']")).sendKeys("Doctor is Leave for the days");
   	    WebElement dropdoc=   driver.findElement(By.xpath("(//input[@id='doctorName'])[3]"));
   	    Thread.sleep(100);
   	    dropdoc.sendKeys("Raj Kumar", Keys.ARROW_DOWN, Keys.ENTER);
   	    Thread.sleep(100);
   	    driver.executeScript("arguments[0].click", dropdoc);
   	    driver.findElement(By.name("From Date")).click();
   	    driver.findElement(By.xpath("//div[@class='PrivatePickersSlideTransition-root css-dhopo2']/div/div[@role='row'][4]/div[@role='cell'][1]")).click();
   	    Robot robot1 = new Robot();
   	    robot1.keyPress(KeyEvent.VK_ESCAPE);
   	    
   	    driver.findElement(By.name("To Date")).click();
   	    driver.findElement(By.xpath("//div[@class='PrivatePickersSlideTransition-root css-dhopo2']/div/div[@role='row'][4]/div[@role='cell'][7]")).click();
   	    
   	    robot1.keyPress(KeyEvent.VK_ESCAPE);
   	    
   	    driver.findElement(By.name("direct")).click();
   	    driver.findElement(By.name("online")).click();
   	    driver.findElement(By.name("home")).click();
   	    
   	    driver.findElement(By.xpath("(//button[text()='Save'])[4]")).click();
          }
          
          @Test(priority=7)
          public void pricing() throws InterruptedException
          {
        	Thread.sleep(500);
        	  WebElement catalog = driver.findElement(By.xpath("//span[.='Catalog']"));
 	          build = new Actions(driver);
 	       build.moveToElement(catalog).perform();
 	       catalog.click();
 	       driver.findElement(By.xpath("(//span[text()='Pricing'])[1]")).click();
 	          driver.findElement(By.xpath("(//button[text()='Add Procedure'])[1]")).click();
 	   WebElement procedure =   driver.findElement(By.id("priceDetailList[0].procedurename"));
 	   Thread.sleep(500);
 	   procedure.sendKeys("Fluoroscopic angioplasty of femoral artery",Keys.ARROW_DOWN, Keys.ENTER);
 	   driver.executeScript("arguments[0].click", procedure);
 	   driver.findElement(By.name("priceDetailList[0].cost")).sendKeys("500000");
 	  
 	   	  Thread.sleep(1000);
 	 WebElement tax = driver.findElement(By.xpath("//input[@id='priceDetailList[0].tax']"));
 	     Thread.sleep(2000);
 	     tax.sendKeys("17.5",Keys.ARROW_DOWN, Keys.ENTER);
 	    Thread.sleep(2000);
 	 	   driver.executeScript("arguments[0].click", tax);
 	 	   
 	 	   driver.findElement(By.name("priceDetailList[0].notes")).sendKeys("Find the Total Amount with GST");
 	 	 Thread.sleep(2000);
 	 	   driver.findElement(By.xpath("//body/div[4]/div[3]/div[1]/div[1]/form[1]/div[1]/button[1]/span[1]/*[1]")).click();
 	 	 Thread.sleep(2000);
 	 	   driver.findElement(By.xpath("//body/div[4]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[12]/button[1]/*[1]")).click();
 	 	  Thread.sleep(2000);
 	 	   driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
 	 	  
 	       //Edit Option
 	       
 	     Thread.sleep(1000);
 	 	   driver.findElement(By.xpath("(//span[text()='edit'])[1]")).click();
 	 	   driver.findElement(By.xpath("(//input[@id='outlined-basic'])[1]")).click();
 	 	 driver.findElement(By.xpath("(//input[@id='outlined-basic'])[1]")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
 	 	  driver.findElement(By.xpath("(//input[@id='outlined-basic'])[1]")).sendKeys("450000");
 	 	 driver.findElement(By.xpath("(//input[@id='outlined-basic'])[3]")).click();
 	 	 driver.findElement(By.xpath("(//input[@id='outlined-basic'])[3]")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
 	 	   driver.findElement(By.xpath("(//input[@id='outlined-basic'])[3]")).sendKeys("Given Amount is Include with GST");
 	 	 driver.findElement(By.xpath("(//button[text()='Save'])[4]")).click();
 	 	driver.switchTo().alert().accept();
 	 	 
 	     
          }
          @Test(priority=8)
          public void drug() throws InterruptedException
          {
        	 
        	 driver.findElement(By.xpath("(//span[text()='Drug'])[1]")).click();
        	  driver.findElement(By.xpath("(//button[text()='Add Drug'])[1]")).click();
        	  driver.findElement(By.xpath("//input[@id='drugDetailList[0].drugname']")).sendKeys("Vicco Skin Cream");
        	WebElement type =  driver.findElement(By.xpath("//input[@id='drugDetailList[0].type']"));
        	Thread.sleep(500);
        	type.sendKeys("Cream", Keys.ARROW_DOWN, Keys.ENTER);
        	driver.executeScript("arguments[0].click", type);
        	driver.findElement(By.name("drugDetailList[0].strength")).sendKeys("15");
        	WebElement unit =  driver.findElement(By.xpath("//input[@id='drugDetailList[0].unit']"));
        	Thread.sleep(500);
        	unit.sendKeys("gm", Keys.ARROW_DOWN, Keys.ENTER);
        	driver.executeScript("arguments[0].click", unit);
        	driver.findElement(By.name("drugDetailList[0].notes")).sendKeys("Take Cream on time");
        	driver.findElement(By.xpath("(//button[text()='Save'])[3]")).click();
                	
        	
          }
          
          @Test(priority=9)
          public void clinicalnotes() throws InterruptedException
          {
        	  //Add Complaints	  
        	   driver.findElement(By.xpath("(//span[text()='Clinical Notes'])[1]")).click();
             driver.findElement(By.xpath("(//textarea[@name='categoryname'])[1]")).sendKeys("Need To Attend the Patient on time");
        	 driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();
        	 Thread.sleep(500);
        	  driver.findElement(By.xpath("(//button//span[@class='material-icons notranslate MuiIcon-root MuiIcon-fontSizeSmall css-129dyhp'])[1]")).click();
           	  driver.findElement(By.name("complaintname")).click();
        	  driver.findElement(By.name("complaintname")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
          	  driver.findElement(By.name("complaintname")).sendKeys("Keep the Record in regular basis");
        	  driver.findElement(By.xpath("(//button[text()='Save'])[7]")).click();
        	  //Add Observation
        	  Thread.sleep(500);
        	  driver.findElement(By.xpath("(//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19'])[1]")).click();
        	  driver.findElement(By.xpath("//input[@name='categoryname']")).sendKeys("First Time Observation");
        	  driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
        	  Thread.sleep(500);
        	  //Add Diagnosis
        	  driver.findElement(By.xpath("(//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19'])[2]")).click();
        	  driver.findElement(By.xpath("(//textarea[@name='categoryname'])[2]")).sendKeys("First Time Diagnosis");
        	  driver.findElement(By.xpath("(//button[text()='Save'])[3]")).click();
        	  Thread.sleep(500);
        	  //Add Note
           	  driver.findElement(By.xpath("(//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19'])[3]")).click();
        	  driver.findElement(By.xpath("(//textarea[@name='categoryname'])[3]")).sendKeys("Take the Complete note");
        	  driver.findElement(By.xpath("(//button[text()='Save'])[4]")).click();
        	  
        	  
          }
          @Test(priority=10)
          public void chartingtemplate() throws InterruptedException
          {
        	/*  driver.findElement(By.xpath("(//span[text()='Charting Template']")).click();
        	  driver.findElement(By.xpath("//button[text()='Add Template']")).click();
        	WebElement  dropdaig = driver.findElement(By.xpath("//input[@name='PatientId']"));
        	 Thread.sleep(500);
        	 dropdaig.sendKeys("Blood",Keys.ARROW_DOWN, Keys.ENTER);
        	 driver.executeScript("arguments[0].click", dropdaig);
        	driver.findElement(By.name("templateName")).sendKeys("Test Template");*/
        	 
          }
          
}
