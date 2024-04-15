package nopCommerceAutomationProject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Register extends TestBase {

	public static HomePage homePage;
	public static RegisterPage registerPage;
	public static Login login;


	@BeforeClass
	  public void beforeClass() throws IOException
	  {

		  setup();

	  }





	  @Test( dataProvider = "testData")
	  public   void registerAndLogOUt(String firstName,String lastName, String dayOfBirth,String monthOfBirth, String yearOfBirth,String email,String password, String confirmPassword) throws InterruptedException, IOException {
		    homePage= new HomePage( );
		    registerPage=new RegisterPage();
            login= new Login();
		    driver.findElement(homePage.registerLink()).click();

		    RegisterPage.registerFunction(driver,firstName,lastName,dayOfBirth,monthOfBirth,yearOfBirth,email,password,confirmPassword);

		     String expectedMessage = "Your registration completed";
	         String actualMessage = driver.findElement(registerPage.successMessage()).getText();
             SoftAssert Assert= new SoftAssert();

             Assert.assertEquals(expectedMessage, actualMessage);
 		     Login.loginWithValidData(email,password );
          Assert.assertTrue(driver.findElement(homePage.LogOutLink()).isDisplayed());



      }






    @Test( dataProvider = "testData")
    public   void registerWithEmptyEmail(String firstName,String lastName, String dayOfBirth,String monthOfBirth, String yearOfBirth,String email,String password, String confirmPassword) throws InterruptedException, IOException {
        homePage= new HomePage( );
        registerPage=new RegisterPage();
        login= new Login();
        driver.findElement(homePage.registerLink()).click();

        RegisterPage.registerFunction(driver,firstName,lastName,dayOfBirth,monthOfBirth,yearOfBirth,email,password,confirmPassword);

        String expectedMessage = "Email is required.";
        String actualMessage = driver.findElement(registerPage.errorMessage()).getText();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test( dataProvider = "testData")
    public   void registerWithEmptyPassword(String firstName,String lastName, String dayOfBirth,String monthOfBirth, String yearOfBirth,String email,String password, String confirmPassword) throws InterruptedException, IOException {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        login = new Login();
        driver.findElement(homePage.registerLink()).click();

        RegisterPage.registerFunction(driver, firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, password, confirmPassword);

        String expectedMessage = "The password and confirmation password do not match.";
        String actualMessage = driver.findElement(registerPage.passwordError()).getText();
        assertEquals(expectedMessage, actualMessage);
    }



    @Test( dataProvider = "testData")
    public   void registerWithEmptyLastName(String firstName,String lastName, String dayOfBirth,String monthOfBirth, String yearOfBirth,String email,String password, String confirmPassword) throws InterruptedException, IOException {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        login = new Login();
        driver.findElement(homePage.registerLink()).click();

        RegisterPage.registerFunction(driver, firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, password, confirmPassword);

        String expectedMessage = "Last name is required.";
        String actualMessage = driver.findElement(registerPage.lastNameError()).getText();
        assertEquals(expectedMessage, actualMessage);
    }

 @AfterClass
	  public void afterClass() throws IOException
	  {

        driver.quit();

  }



    @DataProvider
    public Object[][] testData(Method method) throws Throwable {
        Object[][] data = null;
        if (method.getName().equals("registerAndLogOUt")) {
             data = getDataFromSheet("Register Data", 1, 1);
        } else if (method.getName().equals("registerWithEmptyEmail")) {
            data = getDataFromSheet("Register Data", 2, 1);
        } else if (method.getName().equals("registerWithEmptyPassword")) {
            data = getDataFromSheet("Register Data", 3, 1);

        }else if (method.getName().equals("registerWithEmptyLastName")) {
            data = getDataFromSheet("Register Data", 4, 1);

        }
        return data;
    }

}
