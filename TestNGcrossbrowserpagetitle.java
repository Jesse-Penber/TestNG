package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//created by Jesse Penber 7-30-2018
//Simple TestNG script, imports parameter value for browser from .xml file and checks page title

@Listeners(test.TestNGSource.class)

public class VerifyPageTitle {
	
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void verifyPageTitle(String browserName) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			
		} else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpenber\\Downloads\\chromedriver.exe");
			
		} else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\jpenber\\Downloads\\iexplore.exe");
			driver=new InternetExplorerDriver();
		} else {
			System.out.println("No browser specified");
		}
		
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
		System.out.println(driver.getTitle());
	}

}
