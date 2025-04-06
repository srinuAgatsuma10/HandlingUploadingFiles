package automateNow;

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
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice-automation.com/file-upload/");
//		driver.manage().window().maximize();
	}

	@Test
	public void uploadFile() {
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
		chooseFile.sendKeys(System.getProperty("user.dir") + "\\FIlesForUploading\\Selenium_Theory.txt");
//		WebElement warningMsg = driver.findElement(By.cssSelector(".wpcf7-not-valid-tip"));
//		if (warningMsg.isDisplayed() && warningMsg.getText().equals("Uploaded file is too big.")) {
//			System.out.println("The file you uploaded : " + chooseFile.getText());
//			System.out.println("Please check the Size of the File.");
//		} else {
			driver.findElement(By.xpath("//input[@id='upload-btn']")).click();
			System.out.println(driver.findElement(By.xpath("//div[@class='wpcf7-response-output']")).getText());
//		}
	}

	// Need To Implement.....
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
