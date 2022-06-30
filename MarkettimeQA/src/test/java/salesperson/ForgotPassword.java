package salesperson;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ReptimeBase;
import pageObjects.ForgotPasswordPage;
import pageObjects.ResetPasswordPage;

public class ForgotPassword extends ReptimeBase {

	public ForgotPasswordPage forgotpassword;
	public ResetPasswordPage resetpassword;
	
	@Test()
	public void resetPassWord() throws InterruptedException {
		forgotpassword = loginpage.fPassword();
		resetpassword = forgotpassword.enterUsername(props.getProperty("username"));
		Thread.sleep(5000);
		String actualTitle = getDriver().findElement(By.xpath("//span[text()='Confirm New Password']")).getText();
		String expetedTitle= "Confirm New Password";
		Assert.assertEquals(actualTitle, expetedTitle);
		
	}
	
	@Test
	public void backToLogin() throws InterruptedException {
		
		forgotpassword = loginpage.fPassword();
		Thread.sleep(5000);

		loginpage = forgotpassword.backToLogin();
		Thread.sleep(7000);
		String actualURL = getDriver().getCurrentUrl();
		String expectedURL = props.getProperty("URL");
		Assert.assertEquals(actualURL, expectedURL);
	}

}
