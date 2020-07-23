package modules.security;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenMasterService {
	
	public ScreenMasterService() {
		
	}
	
	public static void	openScreenMasterTab(WebDriver driver){
		driver.findElement(By.xpath("//button[@id='menuButton']")).click();
		driver.findElement(By.xpath("//button[@id='securityButton']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'SCREEN MASTER')]")).click();
	
		
	}
	
	public static void	closeScreenMasterTab(WebDriver driver){
	
	}
	
	
	public static void	getEdit(WebDriver driver ,int rows,String screenDesc ) throws InterruptedException{
		
		String editButtonId="EDIT_BUTTON"+rows;
		//driver.findElement(By.xpath("//tbody//tr//td//button[@id='EDIT_BUTTON1']")).click();
		//driver.findElement(By.id("EDIT_BUTTON1")).click();
		System.out.println("editButtonId: " + editButtonId +"lenth: " + editButtonId.length());
		driver.findElement(By.id(editButtonId)).click();
		
		String screenDescId="SCREEN_DESC"+rows;
		driver.findElement(By.id(screenDescId)).clear();
		driver.findElement(By.id(screenDescId)).sendKeys(screenDesc);
		
		saveScreenMasterRow( driver);

	}
	
	public static void	addScreenMasterRow(WebDriver driver, ScreenMaster screenMaster) throws InterruptedException{
		
		driver.findElement(By.xpath("//div//button[@class='pointerBtn']")).click();
		Thread.sleep(2000);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered text-nowrap actionButton textDots']//tbody//tr"));
		System.out.println("rows="+rows.size());
		String screenNameId="SCREEN_NAME"+rows.size();
		String screenDescId="SCREEN_DESC"+rows.size();
		String screenPathId="SCREEN_PATH"+rows.size();
		String screenPId="SCREEN_PID"+rows.size()+" ";
		
		String screenActive="SCREEN_ACTIVE"+rows.size()+" ";
		
		
		System.out.println("screenPId: "+screenPId);
		System.out.println("screenActive: "+screenActive);
		
		driver.findElement(By.id(screenNameId)).sendKeys(screenMaster.getScreenName());
		driver.findElement(By.id(screenDescId)).sendKeys(screenMaster.getScreenDesc());
		driver.findElement(By.id(screenPathId)).sendKeys(screenMaster.getScreenPath());
		
		
		driver.findElement(By.id(screenPId)).sendKeys(screenMaster.getParentModuleId());
		
		driver.findElement(By.id(screenActive)).sendKeys(screenMaster.getScreenStatus());
	}
	
	
	public static void	saveScreenMasterRow(WebDriver driver) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//button[contains(text(),'Save')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//button[contains(text(),'No')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//button[contains(text(),'Save')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//button[contains(text(),'Yes')]")).click();
	}
	
	
public static List<ScreenMaster> fetchScreenMaster(){
	List<ScreenMaster> list = new ArrayList<>();
	
	for(int i=16;i<=17;i++) {
		list.add(new ScreenMaster("TESTNGSCREENDUMMY"+i,"TESTNGSCREENDUMMY"+i +"DESC","TESTING/TESTNGSCREENDUMMY"+i,"SCHEDULING","Active"));

	}
	
	return list;
	}

}
