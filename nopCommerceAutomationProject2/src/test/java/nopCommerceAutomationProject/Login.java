package nopCommerceAutomationProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Login extends TestBase{

	public static HomePage homePage;
	public static LoginPage loginPage;


	   @BeforeClass
	  public void beforeClass() throws IOException
	  {

		  setup();

	  }

//
	  @Test(dataProvider = "testData")
	  public static void loginWithValidData(String email,String password) throws InterruptedException, IOException
	  {
		  homePage=new HomePage();
		  loginPage=new LoginPage();
		driver.findElement(homePage.loginLink()).click();

		LoginPage.loginFunction(driver, email,password);
		  assertTrue(driver.findElement(homePage.LogOutLink()).isDisplayed());




  }

	@Test(dataProvider = "testData")
	public static void loginWithEmptyPassword(String email,String password) throws InterruptedException, IOException
	{
		homePage=new HomePage();
		loginPage=new LoginPage();
		driver.findElement(homePage.loginLink()).click();

		LoginPage.loginFunction(driver, email,password);
  		String ExpectedResult="Login was unsuccessful. Please correct the errors and try again.";
		String ActualResult=driver.findElement(loginPage.errorMessage()).getText();
		System.out.println(ActualResult);
		assertTrue( ActualResult.contains(ExpectedResult));

	}

	@Test(dataProvider = "testData")
	public static void loginWithEmptyEmail(String email,String password) throws InterruptedException, IOException
	{
		homePage=new HomePage();
		loginPage=new LoginPage();
		driver.findElement(homePage.loginLink()).click();

		LoginPage.loginFunction(driver, email,password);
		String ExpectedResult="Please enter your email";
		String ActualResult=driver.findElement(loginPage.emailError()).getText();
		System.out.println(ActualResult);
		assertEquals(ExpectedResult,ActualResult);

	}


	@Test(dataProvider = "testData")
	public static void loginWithInvalidEmailFormat(String email,String password) throws InterruptedException, IOException
	{
		homePage=new HomePage();
		loginPage=new LoginPage();
		driver.findElement(homePage.loginLink()).click();

		LoginPage.loginFunction(driver, email,password);
		String ExpectedResult="Wrong email";
		String ActualResult=driver.findElement(loginPage.emailError()).getText();
		System.out.println(ActualResult);
		assertEquals(ExpectedResult,ActualResult);

	}


 	  @AfterClass
  	  public void afterClass() throws IOException
 	  {

         driver.quit();

 	  }

	@DataProvider
	public Object[][] testData(Method method) throws Throwable {
		Object[][] data = null;
		if (method.getName().equals("loginWithValidData")) {
			// Data for loginWithValidData test case (second row)
			data = getDataFromSheet("Login Data", 1, 1);
		} else if (method.getName().equals("loginWithEmptyPassword")) {
 			data = getDataFromSheet("Login Data", 2, 1);
		} else if (method.getName().equals("loginWithEmptyEmail")) {
			data = getDataFromSheet("Login Data", 3, 1);
		}
		else if (method.getName().equals("loginWithInvalidEmailFormat")) {
			data = getDataFromSheet("Login Data", 4, 1);
		}

		return data;
	}

}
