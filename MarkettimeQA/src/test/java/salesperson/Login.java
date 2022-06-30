package salesperson;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ReptimeBase;
import dataprovider.DataProviders;
import pageObjects.DashBoard;
import pageObjects.ForgotPasswordPage;
import pageObjects.ForgotUsernamePage;
import pageObjects.RegistratioPage;
import utility.Log;

public class Login extends ReptimeBase {

	DashBoard dashBoard;
	RegistratioPage registration;
	ForgotUsernamePage forgotusrname;
	ForgotPasswordPage forgotPassword;
	
	@Test(priority=1)
	public void verifyLogo() {
		Log.startTestCase("verfiyLogo");
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
		Log.info("Logo Verified");
		Log.endTestCase("verifyLogo");
	}
	
	@Test(priority=5,dataProvider = "credentials",dataProviderClass = DataProviders.class)
	public void verifyLogin(String username, String password) {
		Log.startTestCase("verfiyLogin");
		
//		dashBoard = loginpage.login(props.getProperty("username"),props.getProperty("password"));
		dashBoard = loginpage.login(username,password);
		Log.info("User going to enter Username, Password and click on the Login button");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualURL = getDriver().getCurrentUrl();
		String expectedURL = "https://reptimeqa.com/dashboard";
		
		Log.info("Verifying if user is able to Login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Sucess");
		Log.endTestCase("verifyLogin");
		
	}
	
	@Test(priority=4)
	public void verifyCreateAccount() {
		
		registration = loginpage.registerAccount();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String actualURL = getDriver().getCurrentUrl();
		String expectedURL = "https://reptimeqa.com/register";
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(priority=2)
	public void forgotUsername() {
		forgotusrname = loginpage.fUsername();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actulURL = getDriver().getCurrentUrl();
		String expectedURL = "https://reptimeqa.com/forgot-username";
		
		Assert.assertEquals(actulURL, expectedURL);
	}
	
	
	@Test(priority=3)
	public void forgotPassword() {
		forgotPassword = loginpage.fPassword();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String actualURL = getDriver().getCurrentUrl();
		String expectedURL = "https://reptimeqa.com/forgot-password";
		
		Assert.assertEquals(actualURL, expectedURL);
	}

}
