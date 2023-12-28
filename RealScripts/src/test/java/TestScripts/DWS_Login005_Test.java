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
 * Verify the product is successfully added to "Compare products" section
 *
 */

public class DWS_Login005_Test {
	@Test(groups= {"Regression","Smoke"})
	public void Compare() throws EncryptedDocumentException, IOException {
		// Test step 1-Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Browser launched successfully",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Reading the data from the Excel
		FileInputStream fis = new FileInputStream("./src/test/resources/Resources/DemoWebShop.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet("Sheet1").getRow(10).getCell(6).getStringCellValue().toString();
		String[] arr = data.split("\n");
		// Test step 2- Enter the test URL
		driver.get("https://demowebshop.tricentis.com/");
		Reporter.log("Entered test URL",true);
		// Test step 3- Search for the product
		Base_Page page = new Base_Page(driver);
		page.getShoes().click();
		Reporter.log("Clicked on shoes",true);
		// Test Step 4-Select the product
		driver.findElement(By.linkText("Blue and green Sneaker")).click();
		Reporter.log("Clicked on blue and green sneakers",true);
		// Test step 5- Click on add to compare list button
		driver.findElement(By.xpath("//input[@value='Add to compare list']")).click();
		// Test step 6- Click on compare list link
		page.getCompareProducts().click();
		Reporter.log("Clicked on compare list product button",true);
		// Verification
		String text = driver.findElement(By.xpath("//table[@class='compare-products-table']")).getText();
		if (text.contains("Blue and green Sneaker")) {
			Reporter.log("Product added successfully to compare list", true);
		} else {
			Reporter.log("Unable to add product to compare list", true);
		}

	}

}
