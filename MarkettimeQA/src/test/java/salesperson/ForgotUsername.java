package salesperson;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ReptimeBase;
import pageObjects.ForgotUsernamePage;

public class ForgotUsername extends ReptimeBase{

	public ForgotUsernamePage forgotusername;

	@Test
	public void verifyEmail() throws InterruptedException {

		forgotusername = loginpage.fUsername();
		Thread.sleep(3000);
		boolean flag = forgotusername.recoverUname(props.getProperty("Email"));
		Thread.sleep(5000);
		Assert.assertTrue(flag);
	}
	//Back To Home
	
	@Test
	public void backToLogin() throws InterruptedException {
		forgotusername  =loginpage.fUsername();
		Thread.sleep(3000);
		
		loginpage = forgotusername.backToLogin();
		Thread.sleep(5000);
		
		String actualURL = getDriver().getCurrentUrl();
		String expectedURL = props.getProperty("URL");
		Assert.assertEquals(actualURL, expectedURL);
		
	} 

}
