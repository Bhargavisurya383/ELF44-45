package TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_lib.Base_Page;
import Generic_lib.Cart_Page;
import Generic_lib.CheckOutPage;

/***
 * 
 * @author bhargavi Verify user is able to place an order through "Credit card"
 *         "Payment Method"
 *
 */

public class DWS_Login007_Test {
	@Test(groups="Smoke")
	public void payment() throws EncryptedDocumentException, IOException {
		// Test step 1- Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Browser launched successfully", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Reading the data from excel
		FileInputStream fis = new FileInputStream("./src/test/resources/Resources/DemoWebShop.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet("Sheet1").getRow(12).getCell(6).getStringCellValue().toString();
		String[] arr = data.split("\n");
		// Test step 2- Enter the test URL
		driver.get(arr[1]);
		Reporter.log("Entered test URL ", true);
		// Test step 3- Select the category link
		Base_Page basepage = new Base_Page(driver);
		basepage.getElectronics().click();
		Reporter.log("Clicked on electronics", true);
		// Test step 4-Select a product
		basepage.getCellphones().click();
		Reporter.log("Clicked on cell phones", true);
		// Test Step 5- Click on add to cart button of smartphone
		driver.findElement(By.xpath("//a[contains(text(),'Smartphone')]/../..//input[@value='Add to cart']")).click();
		Reporter.log("Clicked on add to cart button of smart phone", true);
		// Test step 6- click on shopping cart link
		basepage.getShoppingCart().click();
		Reporter.log("Clicked shopping cart link in home page", true);
		// Test step 7- select the terms and service checkbox
		Cart_Page cart = new Cart_Page(driver);
		cart.getTermsOfService().click();
		Reporter.log("Checked terms and service check box", true);
		// Test Step 8- click on checkout button
		cart.getCheckOutButton().click();
		Reporter.log("Clicked on checkout button", true);
		driver.findElement(By.xpath("//input[@value='Checkout as Guest']")).click();
		// Test Step 9- Fill the billing address
		CheckOutPage address = new CheckOutPage(driver);
		address.getFirstName().clear();
		address.getFirstName().sendKeys("saloni");
		Reporter.log("Entered first name", true);
		address.getLastname().clear();
		address.getLastname().sendKeys("Dhotkar");
		Reporter.log("Enterd last name", true);
		address.getEmail().clear();
		address.getEmail().sendKeys("salonydhotkar@gmail.com");
		Reporter.log("Entered email properly", true);
		Select country = new Select(address.getCountryDropdown());
		country.selectByVisibleText("India");
		Reporter.log("Selected India in coutry dropdown", true);
		address.getCity().clear();
		address.getCity().sendKeys("pune");
		Reporter.log("Enterd pune in city textbox", true);
		address.getAddress1().clear();
		address.getAddress1().sendKeys("Pathan Girls Hostel");
		Reporter.log("Enterd address in address1 textbox", true);
		address.getZipPostalCode().clear();
		address.getZipPostalCode().sendKeys("5629182");
		Reporter.log("Entered postal code in zipPostalcode textbox", true);
		address.getPhonenumber().sendKeys("8277430898");
		Reporter.log("Entered phone number", true);
		// Test step 10- Click on continue button
		address.getContinueButton().click();
		Reporter.log("Clicked on continue button", true);
		address.getContinueShipping().click();
		// Test step 11- Select the shipping method
		address.getGround().click();
		// Test step 12- click on continue button
		address.getContinueShippingMethod().click();
		// Test step 13- Select the payment method
		address.getCreditCard().click();
		// Test step 14
		address.getContinuePaymentMethod().click();
		WebElement card = driver.findElement(By.id("CreditCardType"));
		Select cardtype = new Select(card);
		// Test step 14- select card type
		cardtype.selectByVisibleText("Visa");
		// Test step 15-Enter card holder name
		driver.findElement(By.id("CardholderName")).sendKeys("saloni");
		Reporter.log("Enterd card holder name", true);
		// Test step 16- Enter card number
		driver.findElement(By.id("CardNumber")).sendKeys("5314625640123");
		Reporter.log("Enterd card number", true);
		// Test step 17- Select the expire date
		WebElement expMonth = driver.findElement(By.id("ExpireMonth"));
		Select mon = new Select(expMonth);
		mon.selectByValue("7");
		WebElement expYear = driver.findElement(By.id("ExpireYear"));
		Select year = new Select(expYear);
		year.selectByVisibleText("2023");
		// Test step 18- enter the card code
		driver.findElement(By.id("CardCode")).sendKeys("123");
		Reporter.log("Enterd card code", true);
		// Test step 19- click on continue button
		Reporter.log("Clicked on continue button", true);
		address.getContinuePaymentInfo().click();
		// Test step 20- click on confirm button
		address.getConfirmButton().click();
		Reporter.log("Clicked on continue button", true);
		// Verification
		WebElement msg = driver.findElement(By.xpath("//strong[contains(text(),'successfully processed')]"));
		if (msg.isDisplayed()) {
			Reporter.log("Order placed successfully through credit card", true);
		} else {
			Reporter.log("Unable to place the order", true);
		}

	}

}
