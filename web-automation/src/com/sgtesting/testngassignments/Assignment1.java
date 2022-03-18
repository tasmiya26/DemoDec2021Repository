package com.sgtesting.testngassignments;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;
    import org.testng.annotations.Test;
	
	public class Assignment1 {
		private static WebDriver oBrowser=null;
		public static Logger log=Logger.getLogger("Step Execution:");

		@Test(priority=1)
		public static void launchBrowser()
		{
			try
			{
				log.info("the browser is initiated to launch...");
				System.setProperty("webdriver.chrome.driver", "C:\\Example Automation\\Automation\\Web-Automation\\Library\\Drivers\\chromedriver.exe");
				oBrowser=new ChromeDriver();
				oBrowser.manage().window().maximize();
				log.info("the browser has launched successfully...");	
				Thread.sleep(2000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		@Test(priority=2)
		public static void navigate()
		{
			try
			{
				log.info("Navigation of actitime URL has initiated...");
				oBrowser.get("http://localhost:81/login.do");
				Thread.sleep(2000);
				log.info("acti_time URL Navigated successfully...");
				String actualstr=oBrowser.getTitle();
				String expstr="actiTIME - Login";
				Assert.assertEquals(actualstr, expstr);
				System.out.println("the validation of the url is successfull");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		@Test(priority=3)
		public static void login()
		{
			try
			{
				log.info("login to acti_Time has initiated...");
				oBrowser.findElement(By.id("username")).sendKeys("admin");
				oBrowser.findElement(By.name("pwd")).sendKeys("manager");
				oBrowser.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
				Thread.sleep(4000);
				log.info("successfully logged into acti_Time...");
				String actualstr=oBrowser.getTitle();
				Assert.assertEquals(actualstr, "actiTIME - Enter Time-Track");
				System.out.println("the validation of login is successfull");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		@Test(priority=4)
		public static void minimizeFlyOutWindow()
		{
			try
			{
				log.info("Minimizing flyout window has initiated...");
				oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
				Thread.sleep(2000);
				log.info("successfully minimized flyout window...");
				String actualstr=oBrowser.getTitle();
				Assert.assertEquals(actualstr, "actiTIME - Enter Time-Track");
				System.out.println("flyout window Minimized successfully");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		@Test(priority=5)
		public static void createUser()
		{
			try
			{
				log.info("Creating a new user....");
				oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
				Thread.sleep(2000);
				oBrowser.findElement(By.xpath("//*[@id='createUserDiv']/div/div[2]")).click();
				Thread.sleep(2000);
				oBrowser.findElement(By.name("firstName")).sendKeys("DemoUser1");
				oBrowser.findElement(By.name("lastName")).sendKeys("User1");
				oBrowser.findElement(By.name("email")).sendKeys("demouser1@gmail.com");
				oBrowser.findElement(By.name("username")).sendKeys("U1");
				oBrowser.findElement(By.name("password")).sendKeys("Welcome1");
				oBrowser.findElement(By.name("passwordCopy")).sendKeys("Welcome1");
				oBrowser.findElement(By.className("buttonTitle")).click();
				Thread.sleep(4000);
				log.info("Created new user successfully....");
				String actualstr=oBrowser.getTitle();
				Assert.assertEquals(actualstr, "actiTIME ");
				System.out.println("new user created successfully");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//@Test(priority=6)
		public static void deleteUser()
		{
			try
			{
				oBrowser.findElement(By.xpath("//*[@id='userListTableContainer']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]")).click();
				Thread.sleep(3000);
				oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
				Thread.sleep(2000);
				Alert oAlert=oBrowser.switchTo().alert();
				String content=oAlert.getText();
				System.out.println(content);
				oAlert.accept();
				Thread.sleep(2000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//@Test(priority=7)
		public static void logout()
		{
			try
			{
				oBrowser.findElement(By.linkText("Logout")).click();
				Thread.sleep(2000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//@Test(priority=8)
		public static void closeApplication()
		{
			try
			{
				oBrowser.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

