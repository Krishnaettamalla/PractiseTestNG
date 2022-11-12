package com.hyr.tests;

//import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	@Test
	public void TestGoogle() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("krishna",Keys.ENTER);
		String expectedTitle="krishna-Google Searvh";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"this is matched	");
//		System.out.println(driver.getTitle());
//		Thread.sleep(4000);
		driver.quit();	
	}
	 
	@Test
	public void TestFacebook() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("krishnae@gmil",Keys.ENTER);
		Thread.sleep(4000);
		
		SoftAssert softAssert=new SoftAssert();
		
		//title assertion
		String actualTitle=driver.getTitle();
		String expectedTitle="Log in to Facebook";
		//assertEquals(actualTitle,expectedTitle,"Title is mismatch");
		softAssert.assertEquals(actualTitle,expectedTitle,"Title is mismatch");
		
		//url assertion
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://www.facebook.com/";
		//assertEquals(actualURL,expectedURL,"URL is mismatched");
		softAssert.assertNotEquals(actualURL,expectedURL,"URL is mismatched");
		
		//text assertion
		String actualText=driver.findElement(By.id("email")).getAttribute("value");
		String expectedText="";
		//assertEquals(actualText,expectedText,"Username Text is mismatched");
		softAssert.assertEquals(actualText,expectedText,"Username Text is mismatched");
		
		//border assertion
		String actualBorder=driver.findElement(By.id("email")).getCssValue("border");
		String expectedBorder="1px solid rgb(240,40,73)";
		//assertEquals(actualBorder,expectedBorder,"user name Border is mismatched");
		softAssert.assertEquals(actualBorder,expectedBorder,"user name Border is mismatched");
		
		//errorMessage assertion
			String actualerrorMessage=driver.findElement(By.xpath("(//div/[@id='email_container'/div)[last()]]")).getText();
			String expectederrorMessage="The emailaddress or mobile number you entered isn't not connected to an account. Find your account and log in.";
			//assertEquals(actualerrorMessage,expectederrorMessage,"errorMessage is mismatched");
			softAssert.assertEquals(actualerrorMessage,expectederrorMessage,"errorMessage is mismatched");
				
				
				System.out.println(driver.getTitle());
		
		driver.quit();	
		softAssert.assertAll();
	}

}
 