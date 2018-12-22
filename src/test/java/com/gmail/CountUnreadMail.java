package com.gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CountUnreadMail {

	@Test
	public void count() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sanimondal7@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);;
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("9339286973");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);
		String unread = driver.findElement(By.xpath("//div[@class='qj qr']//following::div//div")).getText();
		System.out.println(unread);
	}

	

}
