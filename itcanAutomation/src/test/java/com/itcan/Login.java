package com.itcan;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	public static WebDriver driver;
	public static WebElement element;

	public static String URL = "https://www.itcanapp.com/signup";

	@Test
	public static void myLogin() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);


		 WebElement btnGoogle=driver.findElement(By.xpath("//div[contains(text(),'Continue with Google')]"));
	        btnGoogle.click();
	        String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
        		
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);

	                WebElement email = driver.findElement(By.id("identifierId"));
	                email.sendKeys("ah6298496@gmail.com");
	                WebElement nextButton=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"));
	                nextButton.click();
	                WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
	                pass.sendKeys("AH1234ah");
	                WebElement nextButtonagain=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[2]"));
	                nextButtonagain.click();
	            }

	        }
	        driver.close();
	        
	}
	
}
