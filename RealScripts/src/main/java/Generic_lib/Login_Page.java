package Generic_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Base_Page{

	public Login_Page(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="Email")
	private WebElement EmailTextBox;
	@FindBy(id="Password")
	private WebElement PasswordTextBox;
	@FindBy(id="RememberMe")
	private WebElement Rememberme;
	@FindBy(linkText="Forgot password?")
	private WebElement forgotPassword;
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement login;
	@FindBy(xpath="//input[@value='Register']")
	private WebElement register;
	public WebElement getEmailTextBox() {
		return EmailTextBox;
	}
	public WebElement getPasswordTextBox() {
		return PasswordTextBox;
	}
	public WebElement getRememberme() {
		return Rememberme;
	}
	public WebElement getForgotPassword() {
		return forgotPassword;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getRegister() {
		return register;
	}
    

}
