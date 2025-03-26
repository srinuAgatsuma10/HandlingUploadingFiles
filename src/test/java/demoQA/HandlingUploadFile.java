package demoQA;

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
		driver.get("https://demoqa.com/upload-download");
//		driver.manage().window().maximize();
	}
	
	@Test
	public void uploadSingleFile() {
		// Approach One
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		String path = "E:\\Sailing_To_GitHub\\HandlingUploadingFiles\\FIlesForUploading\\TestNG_Theory.txt";
		chooseFile.sendKeys(path);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
