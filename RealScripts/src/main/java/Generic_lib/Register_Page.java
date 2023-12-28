package Generic_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Page extends Login_Page {
	public Register_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	private WebElement gender_male;
	@FindBy(id = "gender-female")
	private WebElement gender_female;
	@FindBy(id = "FirstName")
	private WebElement firstName;
	@FindBy(id = "LastName")
	private WebElement LastName;
	@FindBy(id = "Email")
	private WebElement email;
	@FindBy(id = "Password")
	private WebElement Password;
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPassword;
	@FindBy(id = "register-button")
	private WebElement registerButton;

	public WebElement getGender_male() {
		return gender_male;
	}

	public WebElement getGender_female() {
		return gender_female;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

}
