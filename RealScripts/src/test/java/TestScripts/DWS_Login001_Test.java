package TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_lib.Base_Page;
import Generic_lib.Login_Page;
/***
 * 
 * @author bhargavi
 * Verify user is able to login with registered credentials
 *
 */

public class DWS_Login001_Test {
	@Test(groups="Smoke")
	public void LogIn() throws EncryptedDocumentException, IOException {
		// Expected result-Home page should be dispayed
		
		WebDriver driver=new ChromeDriver();
		
		
		Reporter.log("Lauched browser successfully", true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// data Reading from excel
		FileInputStream fis = new FileInputStream("./src/test/resources/Resources/DemoWebShop.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet("Sheet1").getRow(6).getCell(6).getStringCellValue().toString();
		String[] arr = data.split("\n");
		// Test Step2- enter the URL
		Reporter.log(arr[0].substring(4), true);
		driver.get(arr[0].substring(4));
		// Test step3- click on login link
		Base_Page login = new Base_Page(driver);
		login.getLogin().click();
		Reporter.log("Clicked on login in link", true);
		// Test step4- Enter the email in email textbox
		Login_Page loginpage = new Login_Page(driver);
		loginpage.getEmailTextBox().sendKeys(arr[1].substring(6));
		Reporter.log("Enter email in email textbox", true);
		// Test Step-5 Password in password textBox
		loginpage.getPasswordTextBox().sendKeys(arr[2].substring(9));
		Reporter.log("Entered password in password textbox", true);
		// click on login button
		loginpage.getLogin().click();
		Reporter.log("Clicked on log in button", true);
		// actual result
		String title = driver.getTitle();
		if (title.equals("Demo Web Shop")) {
			Reporter.log("Home page is displayed", true);
		} else {
			Reporter.log("Home page is not displayed", true);
		}

	}

}
