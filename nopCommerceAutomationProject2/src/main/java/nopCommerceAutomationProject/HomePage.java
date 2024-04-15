package nopCommerceAutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class HomePage {

	
	public By loginLink(   ){
		
		By loginLink= By.className("ico-login");
		return loginLink;
		
}
	
public By registerLink( ){
		
		By registerLink= By.className("ico-register");
		return registerLink;
		
}

public By LogOutLink()
{
	By LogOutLink=By.xpath("//*[@class='ico-logout']");
			return LogOutLink;


}



	
}


 

 