package Generic_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Base_Page {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement firstName;
	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lastname;
	@FindBy(id = "BillingNewAddress_Email")
	private WebElement email;
	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryDropdown;
	@FindBy(id = "BillingNewAddress_City")
	private WebElement city;
	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1;
	@FindBy(id = "BillingNewAddress_Address2")
	private WebElement address2;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement ZipPostalCode;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phonenumber;
	@FindBy(xpath = "//input[@title='Continue']")
	private WebElement continueButton;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement continueShipping;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement continueShippingMethod;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement continuePaymentMethod;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	private WebElement continuePaymentInfo;

	@FindBy(id = "shippingoption_0")
	private WebElement ground;
	@FindBy(id = "shippingoption_1")
	private WebElement NextDayAir;
	@FindBy(id = "shippingoption_2")
	private WebElement SecondDayAir;
	@FindBy(id = "paymentmethod_0")
	private WebElement COD;
	@FindBy(id = "paymentmethod_1")
	private WebElement Check;
	@FindBy(id = "paymentmethod_2")
	private WebElement CreditCard;
	@FindBy(id = "paymentmethod_3")
	private WebElement PurchaseOrder;
	@FindBy(xpath = "//input[@value='Confirm']")
	private WebElement confirmButton;

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getAddress2() {
		return address2;
	}

	public WebElement getZipPostalCode() {
		return ZipPostalCode;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getGround() {
		return ground;
	}

	public WebElement getNextDayAir() {
		return NextDayAir;
	}

	public WebElement getSecondDayAir() {
		return SecondDayAir;
	}

	public WebElement getCOD() {
		return COD;
	}

	public WebElement getCheck() {
		return Check;
	}

	public WebElement getCreditCard() {
		return CreditCard;
	}

	public WebElement getPurchaseOrder() {
		return PurchaseOrder;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getContinueShipping() {
		return continueShipping;
	}

	public WebElement getContinueShippingMethod() {
		return continueShippingMethod;
	}

	public WebElement getContinuePaymentMethod() {
		return continuePaymentMethod;
	}

	public WebElement getContinuePaymentInfo() {
		return continuePaymentInfo;
	}

}
