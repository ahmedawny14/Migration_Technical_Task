package nopCommerceAutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage  {
 	public static HomePage homePage;
	public static LoginPage loginPage;
	

public static By genderMale() {
		
		By genderMale= By.id("gender-male");
		return genderMale;
	}
	
public By genderFemale( ) {
	
	By genderFemale= By.id("gender-female");
	return genderFemale;
}


public static By firstName() {
	
	By firstName= By.id("FirstName");
	return firstName;
}

public static By lastName() {
	
	By lastName= By.id("LastName");
	return lastName;
}

public static By dateOfBirthDay() {
	
	By dateOfBirthDay= By.name("DateOfBirthDay");
	return dateOfBirthDay;
}


public static By dateOfBirthMonth() {
	
	By dateOfBirthMonth=By.name("DateOfBirthMonth");
	return dateOfBirthMonth;
}


public static By dateOfBirthYear() {
	
	By dateOfBirthYear= By.name("DateOfBirthYear");
	return dateOfBirthYear;
}


public static By email() {
	
	By email= By.id("Email");
	return email;
}


public static By password() {
	
	By password=By.id("Password");
	return password;
}


public static By confirmPassword() {
	
	By confirmPassword= By.id("ConfirmPassword");
	return confirmPassword;
}


public static By registerButton() {
	
	By registerButton= (By.id("register-button"));
	return registerButton;
	
}

public By successMessage() {

	By successMessage = By.className("result");
	return successMessage;
}

	public By errorMessage()
	{

		By errorMessage =By.id("Email-error");
		return errorMessage;

	}

	public By passwordError()
	{

		By passwordError =By.id("ConfirmPassword-error");
		return passwordError;


	}
	public By lastNameError()
	{

		By lastNameError =By.id("LastName-error");
		return lastNameError;


	}



public static void registerFunction(WebDriver driver,String firstName,String lastName, String dayOfBirth,String monthOfBirth, String yearOfBirth,String email,String password, String confirmPassword) throws InterruptedException {





	driver.findElement( genderMale( )).click();
	driver.findElement(firstName()).sendKeys(firstName);
	driver.findElement( lastName()).sendKeys(lastName);



	Select day = new Select( driver.findElement( dateOfBirthDay()));

	day.selectByValue(dayOfBirth);



	Select month = new Select( driver.findElement( dateOfBirthMonth()));
	month.selectByValue( monthOfBirth);

	Select year = new Select( driver.findElement( dateOfBirthYear()));
	year.selectByValue(yearOfBirth);
 	driver.findElement(email()).sendKeys(email);
 	driver.findElement( password()).sendKeys(password);

	driver.findElement( confirmPassword()).sendKeys(confirmPassword);
	driver.findElement( registerButton()).click();

}

}

	








 




 


 