package mavenproject.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Rufclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		WebElement cancel = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		cancel.click();
		// ACCOUNT LOGIN:

		WebElement login = driver.findElement(By.className("_1_3w1N"));
		login.click();

		WebElement Username = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		Username.sendKeys("9486320251");

		WebElement Password = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		Password.sendKeys("FLIPKARTPASSWORD");

	}

}
