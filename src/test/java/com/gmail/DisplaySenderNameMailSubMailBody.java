package com.gmail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisplaySenderNameMailSubMailBody {
	
	public static String emailID = "sanimondal7@gmail.com";
	String emailbody = "Hi Sani\n\ntesting mail\n\nRegards\n\nSani";
	String expectedsub = "Gmail";
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sanimondal7@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);;
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("9339286973");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
	}
	
	@Test
	public void displaySenderNameMailSubMailBody() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=':po']/div/input[@class='wA']//following::textarea")).sendKeys(emailID);
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys(expectedsub);
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']")).sendKeys(emailbody);
		driver.findElement(By.xpath("//div[@id=':p9']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='aim'][4]//child::div//child::div")).click();
		Thread.sleep(3000);
		
		String ID = driver.findElement(By.xpath("//*[@id=':qm']/tbody/tr/td[5]/div/span/span[@email='sanimondal7@gmail.com']")).getAttribute("email");
		System.out.println(ID);
		String subject = driver.findElement(By.xpath("//*[@id=':qm']/tbody/tr/td[6]/div/div/div[2]/span/span")).getText();
		System.out.println(subject);
		Thread.sleep(5000);
		String body = driver.findElement(By.xpath("//*[@id=':qm']/tbody/tr/td[6]/div/div/span[text()='Hi Sani testing mail Regards']")).getText();
		System.out.println(body);
		
		Assert.assertEquals(ID, emailID,"id not matched");
		Assert.assertEquals(subject, expectedsub,"sub not matched");
		Assert.assertEquals(body, "testing mail","body not matched");
		
		
		
		
		
	}

}
