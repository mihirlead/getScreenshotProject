import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstclass {
	WebDriver driver;
	
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://122.170.14.195:8080/uth/gadgetsgallery/catalog/");
		
	}
	
	@Test
	public void getScreenshots() {
		
		System.out.println("this is the method");
	}
}
