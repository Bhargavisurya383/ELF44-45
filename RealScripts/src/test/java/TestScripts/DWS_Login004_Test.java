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
/***
 * 
 * @author bhargavi
 * Verify from a category user is able to add the product to Whishlist section
 *
 */

public class DWS_Login004_Test {
	@Test(groups="System")
	public void wishlist() throws EncryptedDocumentException, IOException {
		// TestStep 1- Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Reading the data from excel
		FileInputStream fis = new FileInputStream("./src/test/resources/Resources/DemoWebShop.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet("Sheet1").getRow(9).getCell(6).getStringCellValue().toString();
		// TestStep 2-Enter the test URL
		driver.get(data.substring(4));
		// TestStep 3- click on category
		Base_Page basepage = new Base_Page(driver);
		basepage.getJewellery().click();
		// Test step 4-Select the product
		driver.findElement(By.linkText("Black & White Diamond Heart")).click();
		// Test Step 5- Click on add to wishlist button
		driver.findElement(By.id("add-to-wishlist-button-14")).click();
		// Test step 6- Click on wishlist in homepage
		basepage.getWishlist().click();
		// Verification
		String product = driver.findElement(By.xpath("//table[@class='cart']")).getText();
		if (product.contains("Black & White Diamond Heart")) {
			Reporter.log("Product added successfully to wishlist", true);
		} else {
			Reporter.log("Unable to add product to wishlist", true);
		}

	}


}
