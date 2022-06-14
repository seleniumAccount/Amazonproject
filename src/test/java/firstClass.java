import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class firstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.setProperty("webdriver.chrome.driver","./drivers_folder/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
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
		
	}


}
