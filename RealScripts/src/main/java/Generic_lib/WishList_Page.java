package Generic_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishList_Page extends Base_Page {
	public WishList_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='removefromcart']")
	private WebElement removeCheckbox;
	@FindBy(xpath = "//input[@name='addtocart']")
	private WebElement addTOCart;
	@FindBy(name = "updatecart")
	private WebElement UpdateWishlist;
	@FindBy(name = "addtocartbutton")
	private WebElement AddToCart;
	@FindBy(xpath = "//input[@value='Email a friend']")
	private WebElement EmailAFriend;
	@FindBy(xpath = "//input[@class='qty-input']")
	private WebElement quantityInput;

	public WebElement getRemoveCheckbox() {
		return removeCheckbox;
	}

	public WebElement getAddTOCart() {
		return addTOCart;
	}

	public WebElement getUpdateWishlist() {
		return UpdateWishlist;
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}

	public WebElement getEmailAFriend() {
		return EmailAFriend;
	}

	public WebElement getQuantityInput() {
		return quantityInput;
	}

}
