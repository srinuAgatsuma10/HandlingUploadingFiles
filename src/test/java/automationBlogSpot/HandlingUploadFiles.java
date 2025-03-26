package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingUploadFiles {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void uploadSingleFile() {
		driver.findElement(By.xpath("//input[@id='singleFileInput']"))
				.sendKeys(System.getProperty("user.dir") + "\\FIlesForUploading\\TestNG_Theory.txt");
		driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@id='singleFileStatus']")).getText());
	}

	@Test(priority = 2)
	public void uploadMultipleFiles() {
		String fileOne = "----Enter Complete File Path----";
		String fileTwo = "----Enter Complete File Path----";
		String fileThree = "----Enter Complete File Path----";
		String[] paths = { fileOne, fileTwo, fileThree };
		WebElement multipleFile = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		for (String i : paths) {
			multipleFile.sendKeys(i);
		}
		driver.findElement(By.xpath("//form[@id='multipleFilesForm']//button")).click();
		System.out.println(driver.findElement(By.xpath("//p[@id='multipleFilesStatus']")).getText());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
