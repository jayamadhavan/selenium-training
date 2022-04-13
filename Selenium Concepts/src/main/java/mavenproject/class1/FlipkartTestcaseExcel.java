package mavenproject.class1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTestcaseExcel {
	WebDriver driver = null;
	private WebElement searchbar;

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
		searchbar.sendKeys("SonyTv");
		// searchbar.click();
		driver.findElement(By.className("L0Z3Pu")).click();
		driver.findElement(By.xpath("//div[@class='_4rR01T']")).click();
		driver.findElement(By.className("_2KpZ6l _2U9uOA _3v1-ww"));
		//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		//driver.findElement(By.className("_1_3w1N")).click();
		//driver.findElement(By.className("_2IX_2- VJZDxU")).click();
		//searchbar.sendKeys("9092360060");
		searchbar.click();
		//driver.quit();
		
		
		

	}

	public void AddToCart() {
		Set<String> Tab = driver.getWindowHandles();
	for (String Handle : Tab) {
			driver.switchTo().window(Handle);
			//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
			driver.findElement(By.xpath("//li[@class='col col-6-12']"));
			searchbar.click();
			//driver.quit();

		}

	}

	public static void main(String[] args) {
		FlipkartTestcaseExcel TC = new FlipkartTestcaseExcel();
		TC.Launch();
		TC.SearchProduct();
		TC.AddToCart();

	}

}
