package Generic_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Base_Page {
	public Base_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Register")
	private WebElement register;
	@FindBy(linkText = "Log in")
	private WebElement login;
	@FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
	private WebElement ShoppingCart;
	@FindBy(xpath = "//span[contains(text(),'Wishlist')]")
	private WebElement wishlist;
	@FindBy(partialLinkText = "BOOKS")
	private WebElement Books;
	@FindBy(partialLinkText = "COMPUTERS")
	private WebElement Computers;
	@FindBy(partialLinkText =  "Apparel & Shoes")
	private WebElement shoes;
	@FindBy(partialLinkText = "DIGITAL DOWNLOADS")
	private WebElement digital;
	@FindBy(partialLinkText = "JEWELRY")
	private WebElement jewellery;
	@FindBy(partialLinkText = "GIFT CARDS")
	private WebElement giftcards;
	@FindBy(id = "newsletter-email")
	private WebElement newsletter;
	@FindBy(id = "newsletter-subscribe-button")
	private WebElement newsSubscribe;
	@FindBy(id = "small-searchterms")
	private WebElement searchbar;
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchbutton;
	@FindBy(partialLinkText = "ELECTRONICS")
	private WebElement electronics;
	@FindBy(partialLinkText = "Camera, photo")
	private WebElement camera;
	@FindBy(partialLinkText = "Cell phones")
	private WebElement cellphones;
	@FindBy(linkText = "Recently viewed products")
	private WebElement recentlyViewedProduct;
	@FindBy(linkText = "Compare products list")
	private WebElement compareProducts;
	@FindBy(linkText = "New products")
	private WebElement newProducts;

	public WebElement getRecentlyViewedProduct() {
		return recentlyViewedProduct;
	}

	public WebElement getCompareProducts() {
		return compareProducts;
	}

	public WebElement getNewProducts() {
		return newProducts;
	}

	public WebElement getElectronics() {
		return electronics;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getShoppingCart() {
		return ShoppingCart;
	}

	public WebElement getWishlist() {
		return wishlist;
	}

	public WebElement getBooks() {
		return Books;
	}

	public WebElement getComputers() {
		return Computers;
	}

	public WebElement getShoes() {
		return shoes;
	}

	public WebElement getDigital() {
		return digital;
	}

	public WebElement getJewellery() {
		return jewellery;
	}

	public WebElement getGiftcards() {
		return giftcards;
	}

	public WebElement getNewsletter() {
		return newsletter;
	}

	public WebElement getNewsSubscribe() {
		return newsSubscribe;
	}

	public WebElement getSearchbar() {
		return searchbar;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getCamera() {
		return camera;
	}

	public WebElement getCellphones() {
		return cellphones;
	}

}
