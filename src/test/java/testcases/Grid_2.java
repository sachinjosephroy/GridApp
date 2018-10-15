package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid_2 {
	
	WebDriver driver;
	String baseurl, nodeUrl;
	
	@BeforeTest
	@Parameters({"browserName", "remoteURL"})
	public void setUp(String browserName, String remoteURL) throws MalformedURLException {
		baseurl = "http://newtours.demoaut.com/";
		nodeUrl = "http://192.168.1.226:5566/wd/hub";
		DesiredCapabilities capability = null;
		
		if(browserName.equalsIgnoreCase("chrome")) {
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
		}
		
		/*else if(browserName.equalsIgnoreCase("firefox")) {
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
		}*/
		
		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL(remoteURL), capability);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void simpleTest() {
		driver.get(baseurl);
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	}

}
