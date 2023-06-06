package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tasks {
	
	@Test
	
	public void openbrowserandspicejetpage() throws Exception{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.quit();
	
	}
	@Test
	public void validatingsignuppage() throws Exception{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='Signup']")).click();
		//Handling Multiple window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowlist.get(1));
		
		driver.findElement(By.xpath("//option[text()='Select an option']//following::option[text()='Mr']")).click();
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Prasanna");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Babu");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='dobDate']")).sendKeys("10/19/1996", Keys.ENTER);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@class=' form-control']")).sendKeys("8668117797");
		Thread.sleep(1500);
		//EMAIL ID IS NOT DISPLAYING
		driver.findElement(By.xpath("//input[@id='email_id']")).sendKeys("lrprasannaraghu@gmail.com");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='new-password']")).sendKeys("Prasanna@1");		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='c-password']")).sendKeys("Prasanna@1");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='defaultCheck1']")).click();
		driver.quit();
	}
	
	@Test
	
	public void dummyloginidpassword() throws Exception{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@data-testid='user-mobileno-input-box']")).sendKeys("8668117797");
		driver.findElement(By.xpath("//input[@data-testid='password-input-box-cta']")).sendKeys("Prasanna@1");
		driver.findElement(By.xpath("//div[@data-testid='login-cta']")).click();
		driver.quit();
	}

	@Test
	
	public void dummyinfofororiginanddestination() throws Exception{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("MAA", Keys.ENTER);
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("DEL", Keys.ENTER);
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//div[text()='19'])[5]")).click();		
		
		WebElement ele = driver.findElement(By.xpath("//div[text()='Search Flight']"));
		WebDriverWait wait =new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Actions click =new Actions(driver);
		click.click(ele).perform();
		driver.quit();
	}
	@Test
	
	public void roundtrip()throws Exception{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("MAA", Keys.ENTER);
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("DEL", Keys.ENTER);
		Thread.sleep(1500);
		driver.findElement(By.xpath("(//div[text()='21'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='21'])[2]")).click();
		WebElement ele = driver.findElement(By.xpath("//div[text()='Search Flight']"));
		WebDriverWait wait =new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Actions click =new Actions(driver);
		click.click(ele).perform();
		driver.quit();
	}
@Test
	
	public void validatethecheckin() throws Exception{
	
	//CHECK IN
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='check-in']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("CCQU7Q");
		driver.findElement(By.xpath("//input[@placeholder='john.doe@spicejet.com']")).sendKeys("lrprasannaraghu@gmail.com");
		WebElement ele = driver.findElement(By.xpath("//div[text()='Search Booking']"));
		WebDriverWait wait =new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Actions click =new Actions(driver);
		click.click(ele).perform();
		
		
	//FLIGHT STATUS	
		driver.findElement(By.xpath("//div[text()='flight status']")).click();
		driver.findElement(By.xpath("//div[text()='Today Tue, 6 Jun, 2023']")).click();	
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("MAA", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("DEL", Keys.ENTER);
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//div[text()='Search Flights']"));
		WebDriverWait wait1 =new WebDriverWait(driver, 25);
		wait1.until(ExpectedConditions.visibilityOf(ele1));
		wait1.until(ExpectedConditions.elementToBeClickable(ele));
		Actions click1 =new Actions(driver);
		click1.click(ele).perform();
		

	//MANAGE BOOKING	
		driver.findElement(By.xpath("//div[text()='manage booking']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("CCQU7Q");
		driver.findElement(By.xpath("//input[@placeholder='john.doe@spicejet.com']")).sendKeys("lrprasannaraghu@gmail.com");
		WebElement ele2 = driver.findElement(By.xpath("//div[text()='Search Flights']"));
		WebDriverWait wait2 =new WebDriverWait(driver, 25);
		wait2.until(ExpectedConditions.visibilityOf(ele2));
		wait2.until(ExpectedConditions.elementToBeClickable(ele));
		Actions click2 =new Actions(driver);
		click2.click(ele).perform();
		driver.quit();
}
@Test

public void selectflightandproceedbookingpage() throws Exception{
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.spicejet.com/");
	Thread.sleep(1500);
	driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("DEL", Keys.ENTER);
	Thread.sleep(1500);
	
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("BLR", Keys.ENTER);
	Thread.sleep(1500);
	driver.findElement(By.xpath("(//div[text()='21'])[1]")).click();
	WebElement ele = driver.findElement(By.xpath("//div[text()='Search Flight']"));
	WebDriverWait wait =new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(ele));
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	Actions click =new Actions(driver);
	click.click(ele).perform();
	driver.findElement(By.xpath("//div[text()='Continue']")).click();

	driver.quit();
	
}
}
