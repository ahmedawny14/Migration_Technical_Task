package nopCommerceAutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
	
	
	
	public static By email() {
		
		By email= By.id("Email");
		return email;
	}
public static By password() {
		
		By password= By.id("Password");
		return password;
	}

public static By loginBtn() {
	
	By loginBtn= By.xpath("//*[@class='button-1 login-button']");
	return loginBtn;
 }

	public static By errorMessage() {

		By errorMessage= By.xpath("//*[@class='message-error validation-summary-errors']");
		return errorMessage;
  	}

	public static By emailError() {

		By emailError= By.id("Email-error");
		return emailError;


	}


  
	public static void loginFunction(WebDriver driver, String email,String password)
	{

		driver.findElement( email()).sendKeys(email);
		driver.findElement(password()).sendKeys(password);
		driver.findElement(loginBtn()).click();




	}

}
