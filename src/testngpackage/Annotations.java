package testngpackage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotations {
	private WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void OpeningBrowser(String browser){
		if (browser.equalsIgnoreCase("firefox")){
		driver = new FirefoxDriver();
	       }
		else if (browser.equalsIgnoreCase("chrome")){
	    driver = new ChromeDriver();
	       }
		else if (browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\upali\\Downloads\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();		
		}
		else {
			 throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		driver.get("http://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//@Test(dataProvider = "getData")
	@Test
	public void Login() {
		
		WebElement input = driver.findElement(By.xpath("html/body/div[2]/header/div/div[1]/div[3]/div/form/div[3]/div[1]/input"));
		input.sendKeys("star");
		input.sendKeys(Keys.DOWN);
		input.sendKeys(Keys.DOWN);
		input.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement link = driver.findElement(By.linkText("Star Wars: A New Hope"));
		link.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement tab = driver.findElement(By.xpath("//input[@value='Add to Watchlist']"));
		tab.click();
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("testmail02015@gmail.com");
		WebElement pass = driver.findElement(By.id("ap_password"));
		pass.sendKeys("ganesha123");
		WebElement submit = driver.findElement(By.id("signInSubmit"));
		submit.click();
		WebElement moreinfo = driver.findElement(By.linkText("More Purchase Options"));
		moreinfo.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.className("dv-modal-close-button-dark")).click();
	}
	//@DataProvider
//	public Object[][] getData(){
	//Object[][] data = new Object[0][2];
//	data[0][0] = "testmail02015@gmail.com";
//	data[0][1]= "ganesha123";
		//return data;	
//	}
	
	@AfterTest
	public void aftertest(){
		try{
			driver.quit();
		}
		catch(Exception e) {
			driver = null;
		}
		
	}
	
	
	
            
	
}	


