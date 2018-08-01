package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Verifies GMail page title in three browsers sequentially
//Updated 8-1-2018: gets browser parameter from @DataProvider, 

@Listeners(test.TestNGSource.class)

public class VerifyPageTitlewithDataProvider {
	
	WebDriver driver;
	
	@Test(dataProvider="data-provider")
	public void verifyPageTitle(String browserName) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			
		} else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpenber\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\jpenber\\Downloads\\iexplore.exe");
			driver=new InternetExplorerDriver();
		} else {
			System.out.println("No browser specified");
		}
		
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
		System.out.println(driver.getTitle());
		driver.close();
	}
	
	@DataProvider(name="data-provider")
	public Object[][] dataProviderMethod() {
		return new Object[][]
		{
			{"chrome"},
			{"firefox"},
			{"ie"}
		};
	}

}