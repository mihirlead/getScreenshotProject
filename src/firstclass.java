import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
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
		
		driver.findElement(By.partialLinkText("Specials")).click();
		getScreenShot("special",driver);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		getScreenShot("My Account",driver);
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Shopping Cart")).click();
		getScreenShot("Shopping Cart",driver);
		driver.navigate().back();driver.findElement(By.partialLinkText("Checkout")).click();
		getScreenShot("Checkout",driver);
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Home")).click();
		getScreenShot("Home",driver);
		
		
		
	}
	
	public static String getScreenShot(String imageName, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File scrFile = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\src\\shots\\" + imageName
				+ System.currentTimeMillis() + ".png";

		// System.out.println(path);
		File destination = new File(path);

		try {

			FileHandler.copy(scrFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}
}
