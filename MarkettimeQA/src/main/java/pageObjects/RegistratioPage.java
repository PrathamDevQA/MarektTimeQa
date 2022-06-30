package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Action;
import base.ReptimeBase;

public class RegistratioPage extends ReptimeBase {

	Action action = new Action();

	@FindBy(xpath = "//p-radiobutton[@label='Salesperson']//div[2]")
	WebElement salespersonRadioButton;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement NextButton;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement enterFirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement enterLastName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//div[normalize-space()='Email is already in use']")
	WebElement existingEmail;

	@FindBy(xpath = "//input[@id='confirmEmail']")
	WebElement enterConfirmEmail;

	@FindBy(xpath = "//input[@id='username']")
	WebElement enterUsername;

	@FindBy(xpath = "///div[contains(text(),'Username taken')]")
	WebElement usernameTaken;

	@FindBy(xpath = "//input[@id='password']")
	WebElement enterPassword;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement enterConfirmPassword;

	@FindBy(xpath = "//button[@type='submit']//span[1]")
	WebElement nextToBusinessTab;

	@FindBy(xpath = "//h2[normalize-space()='Other']")
	WebElement selectBusinessType;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	WebElement nextToCompanyInfoTab;

	@FindBy(xpath = "//input[@id='re-name']")
	WebElement companyname;

	@FindBy(xpath = "//input[@id='re-address1']")
	WebElement address1;

	@FindBy(xpath = "//input[@id='re-address2']")
	WebElement address2;

	@FindBy(xpath = "//input[@id='re-zip']")
	WebElement zipcode;

	@FindBy(xpath = "//input[@autocomplete='work tel']")
	WebElement phonenumber;

	@FindBy(xpath = "//p-inputmask[@id='re-fax']//input[@type='text']")
	WebElement faxnumber;

	@FindBy(id = "re-email")
	WebElement companyemail;

	@FindBy(xpath = "//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")
	WebElement iagree;

	@FindBy(xpath = "//button[@type='submit']//span[@class='ui-button-text ui-clickable']")
	WebElement submit;

	@FindBy(xpath = "//span[contains(text(),'Thank you for registering')]")
	WebElement registeredSuccessfully;

	@FindBy(xpath = "//button[@label='Go Back to Login']")
	WebElement backTOLoginPageButton;

	public RegistratioPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage createSalesperson() throws InterruptedException {
		// Select salesperson account
		action.click(getDriver(), salespersonRadioButton);
		action.click(getDriver(), NextButton);

		// Enter User Details
		action.type(enterFirstName, "Test1");
		action.type(enterLastName, "Test11");

		for (int i = 0; i < 100; i++) {

			String email = "markettimetest+" + i + "@gmail.com";

			action.type(enterEmail, email);
			action.type(enterConfirmEmail, email);
//			action.type(enterUsername, username);
			Thread.sleep(2000);
			try {
				if (!action.isDisplayed(getDriver(), existingEmail)) {
					break;
				} else if (!action.isDisplayed(getDriver(), usernameTaken)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		for (int i = 0; i <= 100; i++) {
			String username = "markettime" + i;
			action.type(enterUsername, username);
			try {
				if (!action.isDisplayed(getDriver(), usernameTaken)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

//		action.type(enterUsername, "Test111");
		action.type(enterPassword, "Reptime1!");
		action.type(enterConfirmPassword, "Reptime1!");
		action.click(getDriver(), nextToBusinessTab);

		// Select Business type
		action.click(getDriver(), selectBusinessType);
		action.click(getDriver(), nextToCompanyInfoTab);

		// Enter Company Details

		action.type(companyname, "Heros");
		action.type(address1, "Dallsa");
		action.type(address2, "LS");
		action.type(zipcode, "90001");

		action.type(phonenumber, "999999000000");
		action.type(faxnumber, "7777788888");
		action.type(companyemail, "pratham@markettime.com");

		action.click(getDriver(), iagree);
		Thread.sleep(3000);

		action.click(getDriver(), submit);

		Thread.sleep(5000);
//		action.isDisplayed(driver, registeredSuccessfully);

		action.click(getDriver(), backTOLoginPageButton);

		return new LoginPage();
	}

	/*
	 * public LoginPage createNewAccount(String Firstname, String Lastname, String
	 * Password, String ConfirmPassword, String Companyname, String Address1, String
	 * Address2, String ZipCode, String PhoneNumber, String Fax, String
	 * CompanyEmail) throws InterruptedException { action.click(getDriver(),
	 * salespersonRadioButton); action.click(getDriver(), NextButton);
	 * action.type(enterFirstName, Firstname); action.type(enterLastName, Lastname);
	 * 
	 * for (int i = 0; i < 100; i++) {
	 * 
	 * String email = "marekttimetest+" + i + "@gmail.com"; String username =
	 * "Marekttime"+i;
	 * 
	 * 
	 * action.type(enterEmail, email); action.type(enterConfirmEmail, email);
	 * action.type(enterUsername,username); Thread.sleep(2000); try { if
	 * (!action.isDisplayed(getDriver(), existingEmail)) { break; } } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * } action.type(enterPassword, Password); action.type(enterConfirmPassword,
	 * ConfirmPassword); action.click(getDriver(), nextToBusinessTab);
	 * 
	 * action.click(getDriver(), selectBusinessType); action.click(getDriver(),
	 * nextToCompanyInfoTab);
	 * 
	 * action.type(companyname, Companyname); action.type(address1, Address1);
	 * action.type(address2, Address2); action.type(zipcode, ZipCode);
	 * 
	 * action.type(phonenumber, PhoneNumber); action.type(faxnumber, Fax);
	 * action.type(companyemail, CompanyEmail);
	 * 
	 * action.click(getDriver(), iagree); Thread.sleep(3000);
	 * 
	 * action.click(getDriver(), submit);
	 * 
	 * Thread.sleep(5000); action.click(getDriver(), backTOLoginPageButton);
	 * 
	 * 
	 * 
	 * 
	 * return new LoginPage(); }
	 */
}
