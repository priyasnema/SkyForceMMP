package basePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;


	@Parameters ({"browser","url"})
	@BeforeTest
	public void initBrowser(String browser,String url)
	{

		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();	
			driver=new InternetExplorerDriver();
		}

		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS );
		driver.get(url);
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test
	public void sample()
	{
		System.out.println("in test");
		driver.findElement(By.xpath("//a[@class='button button-alt'][contains(text(),'Login')]")).click();
		WebElement untbox=driver.findElement(By.id("username")); 
		WebElement pwtbox=driver.findElement(By.id("password")); 
		WebElement smbutton=driver.findElement(By.name("submit")); 
		//@FindBy(id="password") WebElement pwtbox;
		//@FindBy(name="submit") WebElement smbutton;
		untbox.sendKeys("ria1");
		pwtbox.sendKeys("Ria125");
		smbutton.click();
		//String str=driver.findElement(By.xpath("//h3[@class='page-header']")).getText();
				//+ "[contains(text(),' "+" ria1 "+" ')]"));
		Alert alert=driver.switchTo().alert();
		String user=alert.getText();
		alert.accept();
		System.out.println(user);
		

	}


}



