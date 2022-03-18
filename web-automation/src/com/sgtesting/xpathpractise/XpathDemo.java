package com.sgtesting.xpathpractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo 
{
	public static WebDriver object=null;//Declaration of WebDriver Object
	public static void main(String[] args) 
	{
		launchBrowser();
		navigate();
		login();
		minimizeFlyoutWindow();
		createUser();
		closeApplication();

	}
	
	private static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\ExampleAutomation\\Automation\\Web-Automation\\Library\\Driver\\chromedriver.exe");
		object=new ChromeDriver();
		
	}
	
	private static void navigate()
	{
		try
		{
			object.get("http://localhost:81/login.do");
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void login()
	{
		try
		{
			object.findElement(By.id("username")).sendKeys("admin");
			Thread.sleep(1000);
			object.findElement(By.name("pwd")).sendKeys("manager");
			Thread.sleep(1000);
			object.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void minimizeFlyoutWindow()
	{
		try
		{
			object.findElement(By.xpath("//div[text()='Getting Started Shortcuts']")).click();
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void createUser()
	{
		try
		{
			object.findElement(By.xpath("//a[@class='content users']")).click();
			Thread.sleep(2000);
			object.findElement(By.xpath("//*[@class='addUserButton beigeButton useNativeActive']")).click();
			Thread.sleep(2000);
			object.findElement(By.xpath("//input[@type='text'][@placeholder='First Name']")).sendKeys("User1");
			Thread.sleep(2000);
			object.findElement(By.xpath("//input[@type='text' and @placeholder='Last Name']")).sendKeys("Demo");
			Thread.sleep(2000);
			object.findElement(By.xpath("//input[starts-with(@class,'emailField')]")).sendKeys("user1@gmail.com");
			Thread.sleep(2000);
			object.findElement(By.xpath("//input[contains(@class,'usernameField inputFieldWithPlaceholder')]")).sendKeys("User1");
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void closeApplication()
	{
		object.close();
	}

}
