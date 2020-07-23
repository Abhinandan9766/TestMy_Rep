package mes.testcase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import MesloginPom.LoginPage;
import db.Connectdatabase;
import db.User;
import modules.security.ScreenMaster;
import modules.security.ScreenMasterService;

public class verifymesLogin {
	final static Logger errorLogger = Logger.getLogger("errorLog");

	@Test
	public void verifyValidlogin() throws InterruptedException {
		List<User> userList = new ArrayList<>();

		System.setProperty("webdriver.gecko.driver",
				"D:\\Abhinandan\\E drive\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		Thread.sleep(20000);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Thread.sleep(20000);

//		driver.get("http://192.168.10.242/mes-web-app");
		// driver.get("http://localhost:4200");
		driver.get("http://192.168.10.226:4200");

		Utility.Capturescreenshot(driver, "User");

		LoginPage login = new LoginPage(driver);

		Connectdatabase connectdatabase = new Connectdatabase();

		try {
			connectdatabase.testDB();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		userList = connectdatabase.getUserList();
		System.out.println(userList);
		User current = new User();
		for (User user : userList) {

			System.out.println("user Name: " + user.getUsername());
			System.out.println("user Password: " + user.getPassword());
			current = user;
		}

		try {
			login.typeUserName(current.getUsername());
			login.typePassword(current.getPassword());
			login.clickOnlogin();

			// SAVE MULTIPLE RECORD AND SAVE FUNCTION

			List<ScreenMaster> list = ScreenMasterService.fetchScreenMaster();
			for (ScreenMaster screenMaster : list) {
				try {
					driver.manage().deleteAllCookies();

					Thread.sleep(10000);
					ScreenMasterService.openScreenMasterTab(driver);

					// ScreenMaster screenMaster= new
					// ScreenMaster("TESTNGSCREENDUMMY","TESTNGSCREENDUMMY
					// DESC","TESTING/TESTNGSCREENDUMMY","SCHEDULING","Active");
					ScreenMasterService.addScreenMasterRow(driver, screenMaster);

				} catch (Exception e) {
					e.printStackTrace();
				}

				Thread.sleep(2000);
				try {
					ScreenMasterService.saveScreenMasterRow(driver);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("NEW RECORD SUCESSFULLY.....!");
				Thread.sleep(2000);
			}
			ScreenMasterService.openScreenMasterTab(driver);

			// EDIT SINGLE ROW
			ScreenMasterService.openScreenMasterTab(driver);
			ScreenMasterService.getEdit(driver, 3, "BY USING TESTNG AUTOMATION DESC");

			// driver.findElement(By.id("SCREEN_PID8 ")).sendKeys("SCHEDULING");

			// driver.findElement(By.id("SCREEN_ACTIVE8 ")).sendKeys("Active");

			// driver.findElement(By.id(screenActive));

			Thread.sleep(5000);
			driver.quit();

		} catch (Exception e) {
			errorLogger.error("Exception: " + e.getMessage());
		}

	}

}
