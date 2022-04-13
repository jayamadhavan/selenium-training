package mavenproject.class1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenAndValidLink {
	WebDriver driver = null;
    int linkcounts = 0;
    String[] broken;
	String[] unbroken;
    int i;
	String filelocation = "C:\\Users\\Ideapad320\\Documents\\j files\\jaya.Broken non Broken.txt excelsheet\\xlsx";


	public void Launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://shop.bigbazaar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public void BrokenandValidLinks() {
		List<WebElement> homepage = driver.findElements(By.tagName("a"));
		linkcounts = homepage.size();
		System.out.println("Total Links are :" + linkcounts);
		for (int i = 0; i < homepage.size(); i++) {
		WebElement element = homepage.get(i);
		String url = element.getAttribute("href");
		// System.out.println(url);
		if (url == null || url.isEmpty()) {
			System.out.println(url + "URL is Empty");
			continue;
		}

		try {
			HttpsURLConnection link = (HttpsURLConnection) new URL(url).openConnection();
			link.connect();
			if (link.getResponseCode() >= 400) {
				broken = (String[]) ArrayUtils.add(broken, url);
				System.out.println(url + " --is broken");
			} else {
				unbroken = (String[]) ArrayUtils.add(unbroken, url);
				System.out.println(url + " --is valid");
			}

		} catch (MalformedURLException e) {
			System.err.println(url + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (StaleElementReferenceException ser) {
			System.out.println(ser.getMessage());
		}
	}

	}
public void brokenlinks() {

	try {
		System.out.println("Broken Links:" + broken.length);
		for (String brokenurl : broken) {
			System.out.println(brokenurl);
		}
	} catch (NullPointerException npe) {
		System.out.println(npe.getMessage());
	}

}
public void unbrokenlinks() {
	try {
		System.out.println("UnBroken Links:" + unbroken.length);
		for (String unbrokenurl : unbroken) {
			System.out.println(unbrokenurl);
		}
	} catch (NullPointerException NPE) {
		System.out.println(NPE.getMessage());
	}

}
public void ImportExcelsheet() throws IOException {

	try {
		File excelfile = new File(filelocation);
		FileOutputStream fos = new FileOutputStream(excelfile);
		boolean exists = excelfile.exists();
		System.out.println(exists);
		if (exists == false) {
			boolean present = excelfile.createNewFile();
			System.out.println(present);
		}
		XSSFWorkbook wbook = new XSSFWorkbook();
		XSSFSheet wsheet = wbook.createSheet();
		wsheet.createRow(0);
		wsheet.getRow(0).createCell(0).setCellValue("UnBroken Links");
		wsheet.getRow(0).createCell(1).setCellValue("Broken Links");
		System.out.println("Heading ok");
		for (int x = 0; x < unbroken.length; x++) {
			wsheet.createRow(x + 1);
			wsheet.getRow(x + 1).createCell(0).setCellValue(unbroken[x]);
		}
		System.out.println("unbroken ok");

		for (int i = 0; i < broken.length; i++) {

			wsheet.getRow(i + 1).createCell(1).setCellValue(broken[i]);
		}
		System.out.println("broken ok");

		wbook.write(fos);
		wbook.close();
	} catch (NullPointerException NPE) {
		System.out.println(NPE.getMessage());
	} catch (ArrayIndexOutOfBoundsException AE) {
		AE.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e){
		e.printStackTrace();
	}
	System.out.println("File created sucessfully");
	driver.close();
}






	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		BrokenAndValidLink LBE = new BrokenAndValidLink();
		LBE.Launch();
		LBE.BrokenandValidLinks();
		//LBE.ImportExcelsheet();
	}

}
