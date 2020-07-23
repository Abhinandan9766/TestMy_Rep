package MesloginPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class LoginPage {
	final static Logger logger1 = Logger.getLogger("loginLogger");
	final static Logger errorLogger = Logger.getLogger("errorLog");

	WebDriver driver;
	By username = By.xpath("//input[@id='userName']");
	By password = By.xpath("//input[@id='password']");
	By login = By.xpath("//button[contains(text(),'Login')]");

	public LoginPage(WebDriver driver) {

		try {
			this.driver = driver;
			logger1.info("User Login Sucessfully");
		} catch (Exception e) {
			errorLogger.error("Exception: " + e.getMessage());
		}

	}

	public void typeUserName(String uid) {
		driver.findElement(username).sendKeys(uid);

	}

	public void typePassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

	public void clickOnlogin() {
		driver.findElement(login).click();

	}

}
