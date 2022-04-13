package mavenproject.class1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAndArrayList {

	WebDriver driver;

	public void Launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void Productselect() {

		WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
		searchbar.click();
		searchbar.sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		// product.click();

	}
	/*public void Login() {
		WebElement login =driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		login.click();;
	driver.findElement(By.xpath("//input[@name='email']")).click();
	login.sendKeys("jlakmi88.gmail.com");
	driver.findElement(By.xpath("//input[@name='password']"));
	login.sendKeys("jai@15");
	}*/

	public void AddtoCart() {

		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();

		Set<String> tab = driver.getWindowHandles();
		for (String handles : tab) {
			driver.switchTo().window(handles);
		}
		driver.findElement(By.id("add-to-cart-button")).click();

	}

	//@SuppressWarnings("unchecked")
	public void ArraySearchitem() {

		List<WebElement> Searchitem = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		ArrayList<String> Webelementtext = new ArrayList<String>();
		for (int i = 0; i < Searchitem.size(); i++) {
			Webelementtext.add(Searchitem.get(i).getText());
			System.out.println(Webelementtext);
		}

	}

	public static void main(String[] args) {
		AmazonAndArrayList Page = new AmazonAndArrayList();
		// Page.Login();
		Page.Launch();
		Page.Productselect();
		//Page.AddtoCart();
		Page.ArraySearchitem();
	}

}
