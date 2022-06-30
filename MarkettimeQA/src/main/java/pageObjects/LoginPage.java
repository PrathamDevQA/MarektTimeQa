package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Action;
import base.ReptimeBase;

public class LoginPage extends ReptimeBase{

	Action action = new Action();

	@FindBy(id="username") 
	WebElement Username; 
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//img[@class='logo logo-img']")
	WebElement loGo;
	
	@FindBy(xpath= "//a[text()='Create an Account']")
	WebElement createAnAccountButton;
	
	@FindBy(xpath = "//a[text()='Forgot your username?']")
	WebElement forgotUsrnameButton;
	
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement forgotPasswordButton;
	
	
	
	public LoginPage() {
		
		PageFactory.initElements(getDriver(), this);
		
	}


	public boolean validateLogo() {
		action.isDisplayed(getDriver(), loGo);
		return true;
	}
	
	public DashBoard login(String username, String password) {
		
		action.type(Username, username);
		action.type(Password, password);
		action.click(getDriver(),loginButton);
		return new DashBoard();
	}
	
	public RegistratioPage registerAccount() {
		action.click(getDriver(),createAnAccountButton);
		return new RegistratioPage();
	}
	
	public ForgotUsernamePage fUsername() {
		action.click(getDriver(),forgotUsrnameButton);
		return new ForgotUsernamePage();
	}

	public ForgotPasswordPage fPassword() {
		action.click(getDriver(),forgotPasswordButton);
		return new ForgotPasswordPage();
	}
}
