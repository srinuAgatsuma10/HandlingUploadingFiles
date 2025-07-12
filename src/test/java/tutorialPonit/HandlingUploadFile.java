package tutorialPonit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingUploadFile {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
		driver.manage().window().maximize();
	}

//	@Test(priority = 1)
	public void uploadFileApproachOne() {
		WebElement destination = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		String path = "----Enter Complete File Path----";
		destination.sendKeys(path);
	}

	@Test(priority = 2)
	public void uploadFileApproachTwo() {
		WebElement destination = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		destination.sendKeys(System.getProperty("user.dir")+"\\FIlesForUploading\\Selenium_Theory.txt");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
