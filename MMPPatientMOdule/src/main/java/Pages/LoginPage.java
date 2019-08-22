package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
@FindBy(id="username") WebElement untbox;
@FindBy(id="password") WebElement pwtbox;
@FindBy(name="submit") WebElement smbutton;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(this.driver, this);
}
public String loginValidData(String username,String password)
{
	untbox.sendKeys(username);
	pwtbox.sendKeys(password);
	smbutton.click();
	String user=driver.findElement(By.xpath("//h3[@class='page-header']")).getText();
	System.out.println("abcc");
	return user;
}
public String loginInvalidData(String username,String password)
{
	untbox.sendKeys(username);
	pwtbox.sendKeys(password);
	smbutton.click();
	Alert alert=driver.switchTo().alert();
	String user=alert.getText();
	alert.accept();
	return user;
}
/*public String loginBlankData(String username,String password)
{
	untbox.sendKeys(username);
	pwtbox.sendKeys(password);
	smbutton.click();
	Alert alert=driver.switchTo().alert();
	String user=alert.getText();
	alert.accept();
	return user;
}*/
public String forgetpasswordIvalidId(String invalidemailId)
{
	driver.findElement(By.xpath(" //a[contains(text(),'forgot Username / Password')]")).click();
	driver.findElement(By.id("emailid")).sendKeys(invalidemailId);
	driver.findElement(By.id("sign_user")).click();
	String Msg =driver.findElement(By.id("container_body")).getText();
	return Msg;
} 
public String forgetpasswordValidId(String validemailId)
{
	driver.findElement(By.xpath(" //a[contains(text(),'forgot Username / Password')]")).click();
	driver.findElement(By.id("emailid")).sendKeys(validemailId);
	driver.findElement(By.id("sign_user")).click();
	//String Msg =driver.findElement(By.id("container_body")).getText();
	
	//return Msg;
	return "abc";
} 


}
