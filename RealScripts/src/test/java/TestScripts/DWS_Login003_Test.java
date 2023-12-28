package TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_lib.Base_Page;
import Generic_lib.Cart_Page;
import Generic_lib.CheckOutPage;
/***
 * 
 * @author bhargavi
 * Verify product is removed from "Shopping cart" after placing order
 *
 */

public class DWS_Login003_Test {
	@Test(groups="System")
	public void RemoveFromCartAfterOrder() throws EncryptedDocumentException, IOException {
		// TestStep1-Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		// Reading the data from excel
		FileInputStream fis = new FileInputStream("./src/test/resources/Resources/DemoWebShop.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet("Sheet1").getRow(8).getCell(6).getStringCellValue().toString();
		String[] arr = data.split("\n");
		// Test step2- Enter the test URL
		driver.get(arr[0].substring(4));
		// Test step 3- Click on a electronics category
		Base_Page basepage = new Base_Page(driver);
		basepage.getElectronics().click();
		// Test step 4- click on cellphones
		basepage.getCellphones().click();
		// Test Step 5- Click on add to cart button of smartphone
		driver.findElement(By.xpath("//a[contains(text(),'Smartphone')]/../..//input[@value='Add to cart']")).click();
		// Test step 6- click on shopping cart link
		basepage.getShoppingCart().click();
		// Test step 7- select the terms and service checkbox
		Cart_Page cart = new Cart_Page(driver);
		cart.getTermsOfService().click();
		// Test Step 8- click on checkout button
		cart.getCheckOutButton().click();
		driver.findElement(By.xpath("//input[@value='Checkout as Guest']")).click();
		// Test Step 9- Fill the billing address
		CheckOutPage address = new CheckOutPage(driver);
		address.getFirstName().clear();
		address.getFirstName().sendKeys(arr[3].substring(11));
		address.getLastname().clear();
		address.getLastname().sendKeys(arr[4].substring(9));
		address.getEmail().clear();
		address.getEmail().sendKeys(arr[5].substring(6));
		Select country = new Select(address.getCountryDropdown());
		country.selectByVisibleText("India");
		address.getCity().clear();
		address.getCity().sendKeys(arr[9].substring(5));
		address.getAddress1().clear();
		address.getAddress1().sendKeys(arr[10].substring(10));
		address.getZipPostalCode().clear();
		address.getZipPostalCode().sendKeys(arr[12].substring(16));
		address.getPhonenumber().sendKeys(arr[13].substring(12));
		// Test step 10- Click on continue button
		address.getContinueButton().click();
		address.getContinueShipping().click();
		// Test step 11- Select the shipping method
		address.getGround().click();
		// Test step 12- click on continue button
		address.getContinueShippingMethod().click();
		// Test step 13- Select the payment method
		address.getCOD().click();
		// Test step 14- click on continue button
		address.getContinuePaymentMethod().click();
		// Test step 15- click on continue button
		address.getContinuePaymentInfo().click();
		// Test step 16- click on confirm button
		address.getConfirmButton().click();
		driver.navigate().refresh();
		// Verification
		basepage.getShoppingCart().click();
		//WebElement cartTable = driver.findElement(By.xpath("//table[@class='cart']"));
		String msg=driver.findElement(By.xpath("//div[contains(text(),'empty')]")).getText();

		if (msg.contains("empty")) {
			Reporter.log("Product is removed from the Shoppingcart", true);
		} else {
			Reporter.log("Product is not removed from the cart", true);
		}

	}

}
