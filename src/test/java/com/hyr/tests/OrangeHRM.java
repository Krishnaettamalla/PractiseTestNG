package com.hyr.tests;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	
	WebDriver driver;
	@Parameters("browserName")
	@BeforeTest
	public void InitiliseBrowser(@Optional("chrome") String browserName){
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();			
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();			
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();			
			break;
		default:
			System.out.println("Browser name is invalid");
			break;
		}
	
		driver.manage().window().maximize();
		
	}
	@Parameters("sleepTime")
	@AfterTest
	//insteaad of converting to string i am using long
	public void Teardown(long sleepTime) throws Exception{
		//public void Teardown(String sleepTime) throws Exception{
		System.out.println(sleepTime);
		Thread.sleep(sleepTime);
		//Thread.sleep(Long.valueOf(sleepTime));
		driver.quit();
	}
	
	@Parameters("url")
	@Test
	public void LaunchApp(String url) {
	driver.get(url);	
	}
	
	@Parameters({"username","password"})
	@Test
	public void EnterLoginDetails(String username, String password) throws Exception {
//		WebDriverManager.chromedriver().setup();
//		driver= new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/");	
	Thread.sleep(5000);
		driver.findElement(By.xpath("//div/input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//div/input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//div/button[@type='submit']")).click();
		}
	@Test
	public void NavigateToMyInfo() throws Exception 
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/ul/li/a[@class='oxd-main-menu-item active toggle']")).click();}
	@Test
	public void VerifyMyInfo() throws Exception {
		Thread.sleep(5000);
	boolean actualValue=driver.findElement(By.id("//div/h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")).isDisplayed();
		//System.out.println(driver.findElement(By.id("//div/h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")).isDisplayed());
		assertTrue(actualValue);
	}
		
	@Test
	public void VerifyLogin() throws Exception {
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//div/h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));
		//System.out.println(element.isDisplayed());
		//System.out.println(element.getText().startsWith("Welcome"));
		
	}

}
