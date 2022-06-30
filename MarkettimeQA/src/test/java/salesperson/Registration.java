package salesperson;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ReptimeBase;
import pageObjects.RegistratioPage;


public class Registration extends ReptimeBase{
	
	public RegistratioPage registration;
//	public LoginPage registeredaccount;
	
	@Test
	public void createNewAccount() throws InterruptedException {
		
		registration = loginpage.registerAccount();
		loginpage = registration.createSalesperson();
		
		String actualText = getDriver().getCurrentUrl();
		String expectedText = "https://reptimeqa.com/login";
		
		Assert.assertEquals(actualText, expectedText);
		
	}

	

}
