package mavenproject.class1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement cancel = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		Highlight(driver, cancel);
		cancel.click();

//		WebElement login = driver.findElement(By.className("_1_3w1N"));
//		login.click();
//		
//		WebElement emailBox = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
//		emailBox.click();
//		emailBox.sendKeys("jaya@gamil.com");
//		
//		WebElement passWard = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
//		passWard.click();
//		passWard.sendKeys("12345");
//		
//		WebElement loginButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
//		loginButton.click();

		// WebElement search =
		// driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		// search.click();

		WebElement searchbar = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		searchbar.sendKeys("Mobiles" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement selectmobile = driver.findElement(By.xpath("//div[@data-id='MOBG6MY4UGGFQWYY']"));
		selectmobile.click();
		Set<String> WindowHandles = driver.getWindowHandles();
		for (String newtab : WindowHandles) {
			driver.switchTo().window(newtab);

		}
		WebElement addtocart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		addtocart.click();

		WebElement placeorder = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']"));
		placeorder.click();

		WebElement mobilenumber = driver.findElement(By.xpath("//input[@class='_2IX_2- _17N0em']"));
		mobilenumber.click();
		mobilenumber.sendKeys("6382202370");

		WebElement Continue = driver.findElement(By.xpath("//button[@class='_2KpZ6l _20xBvF _3AWRsL']"));
		Continue.click();

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.click();
		password.sendKeys("loginpassword");

		WebElement loginbtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _20xBvF _3AWRsL']"));
		loginbtn.click();
		
		driver.quit();

		System.out.println("Order Placed Sucessfully");
        
		
	}

	public static void Highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);
   
	}
}
