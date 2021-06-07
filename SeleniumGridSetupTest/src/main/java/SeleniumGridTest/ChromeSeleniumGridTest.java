package SeleniumGridTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeSeleniumGridTest
{
	static String portNo;
	static String nodeUrl;
	static DesiredCapabilities cap;
	static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException 
	{		
		if (portNo.equalsIgnoreCase("4455"))
		{
			nodeUrl = "http://192.168.1.100:4444/wd/hub";
			System.out.println("Chrome Browser Test Environment created");
			cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
			
			driver = new RemoteWebDriver(new URL(nodeUrl), options);
			driver.manage().window().maximize();
		}
		else if (portNo.equalsIgnoreCase("4466"))
		{
			nodeUrl = "http://192.168.1.100:4444/wd/hub";
			System.out.println("InternetExplorer Browser Test Environment created");
			cap = new DesiredCapabilities().internetExplorer();
			cap.setBrowserName("internet explorer");
			cap.setPlatform(Platform.WINDOWS);
			
			driver = new RemoteWebDriver(new URL(nodeUrl), cap);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		else
		{
			System.err.println("Set the Port Number correctly");
		}
			
//		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		driver.get("https://google.com");
		System.out.println(driver.getTitle());	
		driver.quit();
	}
}