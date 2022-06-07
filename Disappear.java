package week5.day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappear {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		
		WebElement source = driver.findElement(By.xpath("//button[@id='btn']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(source));
		
		//snapshot
		File source1 = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/disappear.png");
		FileUtils.copyFile(source1, destination);
	
	}
}
