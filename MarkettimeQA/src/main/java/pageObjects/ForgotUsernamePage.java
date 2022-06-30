package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Action;
import base.ReptimeBase;

public class ForgotUsernamePage extends ReptimeBase{
	
	Action<?> action = new Action<Object>();

	@FindBy(xpath = "//input[@id='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//span[contains(text(),'Recover username')]")
	WebElement clickOnRecoverButton;

	@FindBy(xpath = "//h2[contains(text(),'Email Send Successful')]")
	WebElement succesfulEmail;

	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable']")
	WebElement backToLogin;

	@FindBy(xpath = "//a[@class='goto-login']")
	WebElement clickOnGoBackButton;

	public ForgotUsernamePage() {

		PageFactory.initElements(getDriver(), this);
	}

	public boolean recoverUname(String email) {

		action.type(enterEmail, email);
		action.click(getDriver(), clickOnRecoverButton);
		action.isDisplayed(getDriver(), succesfulEmail);
		return true;

	}
//Need To New Page
	public LoginPage BackToLoginPage() {
		action.click(getDriver(), backToLogin);
		return new LoginPage();
	}

	public LoginPage backToLogin() {
		clickOnGoBackButton.click();
		return new LoginPage();
	}

	

}
