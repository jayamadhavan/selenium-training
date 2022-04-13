package mavenproject.class1;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartTCMobile {
	private ChromeDriver driver;

	public void Launch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

	}

	public void SearchProduct() {
		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.click();
		searchbar.sendKeys("Mobile");
		// searchbar.click();
		driver.findElement(By.className("L0Z3Pu")).click();
		driver.findElement(By.xpath("//div[@class='_4rR01T']")).click();
		driver.findElement(By.xpath("//a[@class='_1_3w1N']")).click();
		
		//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).click();login
//		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));buynow
//		driver.findElement(By.xpath("//footer[@class='_3voSl0']"));addtocart
//		driver.findElement(By.xpath("
		//div[@class='_1AtVbE col-12-12']"));addtocart
//		driver.findElement(By.className("_1KOMV2"));addtocart
//		searchbar.click();
		

}
	public static void main(String []args) {
		FlipcartTCMobile TCM = new FlipcartTCMobile();
		TCM.Launch();
		TCM.SearchProduct();
	}
	
}