package DEMO_RPH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class A_Example_Demo {
	//https://www.youtube.com/watch?v=_JNeiGbAgL4      @ 16min
	//ONLY USE THROWS INTERRUPTED FOR THE THREAD.SLEEP BELOW
	public static void main(String[] args) throws InterruptedException 
	{
		//Set Webdriver	
		System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\rph_1\\Documents\\Work - Resolute\\Selenium Downloads and Steps\\RPH_Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com/");
		driver.manage().window().maximize();
		//use web element
		//"ID is "identifierID", then post what we want (EX: sendkeys)
		driver.findElement(By.id("identifierId")).sendKeys("phubbs64@gmail.com");
		Thread.sleep(2000); //slow down process for user to see results of step
		//click the "NEXT" button
		driver.findElement(By.className("CwaK9")).click();
		Thread.sleep(2000); //slow down process for user to see results of step
		String at = driver.getTitle();
		String et = "gmail";
		driver.close();
		if(at.equalsIgnoreCase(et))
		{
			System.out.print("Test Success RPH");
		}
		else 
		{
			System.out.print("Test Failed RPH");
		}	
	}	
}
