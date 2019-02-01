package DEMO_RPH;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Timer;


public class Main_Navigation {
	//https://www.youtube.com/watch?v=_JNeiGbAgL4      @ 16min
	//ONLY USE THROWS INTERRUPTED FOR THE THREAD.SLEEP BELOW
	public static void main(String[] args) throws InterruptedException 
	{
	//STEP 1: Set up Webdriver	
		System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\rph_1\\Documents\\Work - Resolute\\Selenium Downloads and Steps\\RPH_Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://id.dc.res0.net/users/sign_in");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //used to wait for pieces on page to load up
		driver.manage().window().maximize();				//Go to Web Page

//SECTION 1	: LOGIN
		//STEP 2: Find and use web elements
		driver.findElement(By.id("user_email")).sendKeys("rhubbard@resolutebi.com");
		driver.findElement(By.id("user_password")).sendKeys("Mormon64");
		//STEP 3: click the "NEXT" button
		driver.findElement(By.name("commit")).click();
		
		
//SECTION 2: CONFIG NAVIGATION
	//INTEGRATOR START
		//GO TO CONFIGURATION PAGE
		//STEP 4: Confirm on right page by its title
		String X_page_title = driver.getTitle();
		CheckLocation CurrentLocation = new CheckLocation();
		CurrentLocation.Location(X_page_title, "ResoluteBI - Configuration");
		

		//GO to Overview Page
		driver.findElement(By.xpath("/html/body/article/table/tbody/tr[6]/td[6]/button")).click(); 
		X_page_title = driver.getTitle();
		CurrentLocation.Location(X_page_title, "ResoluteBI - Overview");
		driver.findElement(By.xpath("//*[@id=\"log-out-rbi-link\"]")).click(); 
		
		X_page_title = driver.getTitle();
		CurrentLocation.Location(X_page_title, "ResoluteBI - Configuration");
		
		//GO to Overview Page
		driver.findElement(By.xpath("//html/body/article/table/tbody/tr[6]/td[6]/button")).click(); 
		X_page_title = driver.getTitle();
		CurrentLocation.Location(X_page_title, "ResoluteBI - Overview");
	//INTEGRATOR END

/*-----------------------------------------------------------------------------------------------------------------------------------------*/		

		
//SECTION 3: Left Side Bar Links 		
		ArrayList<LeftColumn> columnChoices = new ArrayList<LeftColumn>();
		columnChoices.add(new LeftColumn(1, "/html/body/nav/ul/li[1]/a/span", "ResoluteBI - Overview"));
		columnChoices.add(new LeftColumn(2, "/html/body/nav/ul/li[2]/a/span", "ResoluteBI - Energy Usage"));		
		columnChoices.add(new LeftColumn(3, "/html/body/nav/ul/li[3]/a/span", "ResoluteBI - Comfort"));
		columnChoices.add(new LeftColumn(4, "/html/body/nav/ul/li[4]/a/span", "ResoluteBI - Action Center"));
		columnChoices.add(new LeftColumn(5, "/html/body/nav/ul/li[5]/a/span", "ResoluteBI - Explorer"));
		columnChoices.add(new LeftColumn(6, "/html/body/nav/ul/li[6]/a/span", "ResoluteBI - Analytics"));		
		columnChoices.add(new LeftColumn(7, "/html/body/nav/ul/li[7]/a/span", "ResoluteBI - Custom Insights"));
		columnChoices.add(new LeftColumn(8, "/html/body/nav/ul/li[8]/a/span", "ResoluteBI - Reports Center"));		
		columnChoices.add(new LeftColumn(9, "/html/body/nav/ul/li[9]/a/span", "ResoluteBI - User Management"));
		columnChoices.add(new LeftColumn(10, "/html/body/nav/ul/li[10]/a/span", "ResoluteBI - Assistance"));
		
		System.out.print("\n");
		
/*		int LeftTotal = 0;
		for (int A = 0; A < columnChoices.size(); A++) {
			for (int B = A+1; B < columnChoices.size(); B++) {
				driver.findElement(By.xpath("/html/body/nav/ul/li[" + columnChoices.get(A).get_Order() + "]/a/span")).click(); 
	    		X_page_title = driver.getTitle();
	    		CurrentLocation.Location(X_page_title, columnChoices.get(A).get_Page_Title());
	    		LeftTotal = LeftTotal +1;
	    		//return to page A
	    		driver.findElement(By.xpath("/html/body/nav/ul/li[" + columnChoices.get(B).get_Order() + "]/a/span")).click(); 
	    		X_page_title = driver.getTitle();
	    		CurrentLocation.Location(X_page_title, columnChoices.get(B).get_Page_Title()); //CHANGE LATER
	    		LeftTotal = LeftTotal +1;
			}
		}
		System.out.print("\nTotal = " + LeftTotal + "\n");
*/		
/*-----------------------------------------------------------------------------------------------------------------------------------------*/		

		
		
		
//Section 4 - Mid-page Selection	
	//MIDPAGE - OVERVIEW
		/*driver.findElement(By.xpath("//*[@id=\"portfolio-table\"]/tbody/tr[1]")).click(); 
		Thread.sleep(2000);
		
		//Open Building List
		driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]")).click(); 
		//Select Option From List
		driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/ul/li[1]")).click(); //Return to "Portfolio" Page
		Thread.sleep(2000);*/
	
	//MIDPAGE - COMFORT
		//Go to Comfort by left side
	/*	driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a")).click(); 
		for (int Building = 1; Building < 12; Building++) {
			//Select Building from midpage
			driver.findElement(By.xpath("//*[@id=\"action-overview-table\"]/tbody/tr["+ Building +"]/td[1]/div")).click(); 
			if (Building == 1)
			{
				System.out.print(Building + " at  " + driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/span")).getText()+ "\n");
			}
			else
			{
				System.out.print(Building + " at  " + driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/span")).getText()+ "\n");
			}

			//Open List, then Select Option From List
			driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/span")).click();
			driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/ul/li[1]")).click();	//Return to "Portfolio" Page
			if (Building == 1)
			{
				System.out.print(Building + "    returned to " + driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/span")).getText()+ "\n");
			}
			else
			{
				System.out.print(Building + " at  " + driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/span")).getText()+ "\n");
			}
		} 
-----------------------------------------------------------------------------------------------------------------------------------------*/	

	
//Section 5 - Select all Buildings
		System.out.print("\nX\n");

		//DELETE LATER. FOR A MOMENT GO TO "Energy Usage" PAGE FOR LESS DELAY
		driver.findElement(By.xpath("/html/body/nav/ul/li[1]/a/span")).click();
		
		
       int TOTAL = 0; //DO X<11 AND Y<11 FOR THE 10 COMBINATION PAGE
        for (int X = 1; X < 13; X++) {
        	for (int Y = 1+X; Y < 13; Y++) {
        		//Select Building From List
        		driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]")).click(); 
        		driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/ul/li[" + Y + "]")).click(); ///ACTION_CENTER_BUG
        		TOTAL = TOTAL + 1;
        		System.out.print(TOTAL + " " + driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/span")).getText()+ "\n");
        		//return to first/original page
        		driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]")).click(); 
        		driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/ul/li[" + X + "]")).click();
        		TOTAL = TOTAL + 1;
        		System.out.print(TOTAL + "    returned to " + driver.findElement(By.xpath("//*[@id=\"building-dropdown\"]/span")).getText()+ "\n");
        		
        		
        //TIMER CODING ATTEMPT	
        		//refresh the page
        		//driver.navigate().refresh();
        		//Instant start = Instant.now();
        		
        		/*long start = System.currentTimeMillis();
        		long finish = System.currentTimeMillis();
        		long timeElapsed = finish - start;*/
        		        		
        		/*Instant finish = Instant.now();
        		long timeElapsed = (Duration.between(start, finish).toMillis())/1000;
        		System.out.print(" TIME " + timeElapsed + " seconds\n");*/
        	}
        }
       /* -----------------------------------------------------------------------------------------------------------------------------------------*/	
		
//Section 6 - Logout
		driver.findElement(By.xpath("//*[@id=\"log-out-link\"]")).click(); 
		Thread.sleep(2000);		
		System.out.print("\nFINISHED");
		
		
//STEP 7 - Close Browser:  		
		driver.close();
	}	
}