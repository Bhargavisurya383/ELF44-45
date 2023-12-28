package Generic_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Cart_Page extends Base_Page {
	public Cart_Page(WebDriver driver) {
		super(driver);
	}
 
	@FindBy(xpath = "//input[@name='removefromcart']")
	private WebElement removeCheckbox;
	@FindBy(xpath = "//input[@name='updatecart']")
	private WebElement updateShoppingcart;
	@FindBy(xpath = "//input[@name='continueshopping']")
	private WebElement continueShopping;
	@FindBy(xpath = "//input[@class='qty-input']")
	private WebElement quantityInput;
	@FindBy(name = "discountcouponcode")
	private WebElement discountcouponcode;
	@FindBy(name = "applydiscountcouponcode")
	private WebElement applyCouponButton;
	@FindBy(name = "giftcardcouponcode")
	private WebElement giftcardCoupon;
	@FindBy(name = "applygiftcardcouponcode")
	private WebElement applycard;
	@FindBy(name = "ZipPostalCode")
	private WebElement ZipPostalCode;
	@FindBy(name = "estimateshipping")
	private WebElement EstimateShippingButton;
	@FindBy(id = "CountryId")
	private WebElement Countrylist;
	Select country = new Select(Countrylist);
	@FindBy(id = "termsofservice")
	private WebElement termsOfService;
	@FindBy(id = "checkout")
	private WebElement checkOutButton;

	public WebElement getRemoveCheckbox() {
		return removeCheckbox;
	}

	public WebElement getUpdateShoppingcart() {
		return updateShoppingcart;
	}

	public WebElement getContinueShopping() {
		return continueShopping;
	}

	public WebElement getQuantityInput() {
		return quantityInput;
	}

	public WebElement getDiscountcouponcode() {
		return discountcouponcode;
	}

	public WebElement getApplyCouponButton() {
		return applyCouponButton;
	}

	public WebElement getGiftcardCoupon() {
		return giftcardCoupon;
	}

	public WebElement getApplycard() {
		return applycard;
	}

	public WebElement getZipPostalCode() {
		return ZipPostalCode;
	}

	public WebElement getEstimateShippingButton() {
		return EstimateShippingButton;
	}

	public WebElement getCountrylist() {
		return Countrylist;
	}

	public Select getCountry() {
		return country;
	}

	public WebElement getTermsOfService() {
		return termsOfService;
	}

	public WebElement getCheckOutButton() {
		return checkOutButton;
	}


}
