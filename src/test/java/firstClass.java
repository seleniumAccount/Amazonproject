import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class firstClass {
	
	public static WebDriver driver=null;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.setProperty("webdriver.chrome.driver","./drivers_folder/chromedriver.exe");
		 driver=new ChromeDriver();
		//WebDriver driver1=new InternetExplorerDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement nav_account_list=driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
		
		Actions actions=new Actions(driver);
		
		actions.moveToElement(nav_account_list).build().perform();
		
	    //sign in button main page
		WebElement signinBtn=driver.findElement(By.xpath("//div[@id=\"nav-flyout-ya-signin\"]/a"));
		signinBtn.click();
		
		//mobile number
		WebElement mobileNumber=driver.findElement(By.xpath("//input[@id=\"ap_email\"]"));
		mobileNumber.sendKeys("8801636401");
		
		//continue xpath
		WebElement continueBtn=driver.findElement(By.xpath("//input[@id=\"continue\"]"));
		continueBtn.click();
		
		//pasword 
		WebElement passwordTextbox=driver.findElement(By.xpath("//input[@id=\"ap_password\"]"));
		passwordTextbox.sendKeys("Yoga123$");
		
		//signin button in password section
		WebElement signInButton=driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]"));
		signInButton.click();
		
		screenshot();
		
		driver.close();
			
	}
	
	public static void screenshot()
	{
		//pass //fail // skip 
		try {
			
			//format setting the filename Sat_Apr_18_16-50-21_IST_2020
			String fileName = (new Date()).toString().replace(" ", "_").replace(":", "-").trim()+ ".png";//
					   //Tue_Mar_08_10-16-06_IST_2022.png                                                      
	
			
			String destinationFilePath = System.getProperty("user.dir")+File.separator+"ScreenShots/" +fileName;
			System.out.println(destinationFilePath);
			try {
			   
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE); //dynamic screenshots 
				File destination=new File(destinationFilePath);
				FileUtils.copyFile(source, destination);
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}
}

