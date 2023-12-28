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
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_lib.Base_Page;
import Generic_lib.Login_Page;

/***
 * 
 * @author bhargavi 
 * Verify user added product from particular category is added in Cart section
 *
 */

public class DWS_Login002_Test {
	@Test(groups="Smoke")
	public void addToCart() throws EncryptedDocumentException, IOException {
		// Test step1-Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Launched browser successfully", true);
		// data Reading from excel
		FileInputStream fis = new FileInputStream("./src/test/resources/Resources/DemoWebShop.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet("Sheet1").getRow(7).getCell(6).getStringCellValue().toString();
		String[] arr = data.split("\n");
		// Test Step2- enter the URL
		Reporter.log(arr[0].substring(4), true);
		driver.get(arr[0].substring(4));
		Reporter.log("Navigated to the proper web application", true);
		// Test step3- click on login link
		Base_Page login = new Base_Page(driver);
		login.getLogin().click();
		Reporter.log("Clicked on log in link", true);
		// Test step4- Enter the email in email textbox
		Login_Page loginpage = new Login_Page(driver);
		loginpage.getEmailTextBox().sendKeys(arr[1].substring(6));
		Reporter.log("Enterd email in email text box", true);
		// Test Step-5 Enter Password in password textBox
		loginpage.getPasswordTextBox().sendKeys(arr[2].substring(9));
		Reporter.log("Password enterd successfully", true);
		// Test step-6 click on login button
		loginpage.getLogin().click();
		Reporter.log("Clicked on log in link", true);
		// Test step-7 click on add to cart button of any product
		driver.findElement(By.xpath("//a[contains(text(),'14.1-inch Laptop')]/../..//input[@value='Add to cart']"))
				.click();
		Reporter.log("Clicked on add to cart button of laptop", true);
		// Test Step-8 click on shopping cart link
		Base_Page basepage = new Base_Page(driver);
		basepage.getShoppingCart().click();
		Reporter.log("clicke on shopping cart link", true);
		String pro = driver.findElement(By.xpath("//table[@class='cart']")).getText();
		if (pro.contains("14.1-inch Laptop")) {
			Reporter.log("Product is present in the cart", true);
		} else {
			Reporter.log("Add to cart is failed", true);
		}

	}

}
