package TestingSCAP;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FireInspector {
	WebDriver driver;
	
	@Test
	public void FireInspector() throws InterruptedException
	{
		//Open the browser path
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://biadev.eventcentric.local/bia_release/ia-scap/cap/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Clicking on Home button
		WebElement element = driver.findElement(By.partialLinkText("Home"));
		element.click();
		Thread.sleep(3*1000);
		
		//Changing Role of user
		Actions actions = new Actions(driver);
		WebElement changeRole = driver.findElement(By.linkText("Change Role"));
		Thread.sleep(3*1000);
		actions.moveToElement(changeRole).build().perform();
		Thread.sleep(3*1000);
		
		//Selecting user role
		WebElement ChangRoleDropDown = driver.findElement(By.linkText("Fire Inspector"));
		actions.moveToElement(ChangRoleDropDown).build().perform();
		Thread.sleep(2*1000);
		ChangRoleDropDown.click();
		System.out.println(driver.getCurrentUrl());
		
		//Verification check point for pope up window
		String PageHeader = "Would you like to change roles";
		String viewPageSouce = driver.getPageSource();
		boolean isResult = viewPageSouce.contains(PageHeader);
		
		if (isResult)
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		////Clicking pope up "Yes" button 
		WebElement PopUpButton = driver.findElement(By.xpath(".//*[@id='changeRoleConfirmModal']/div/div/form/div[2]/button[1]"));
		Thread.sleep(3*1000);
		PopUpButton.click();
		System.out.println(driver.getCurrentUrl());
		
		//Verification check point for new window
		String WelComePageHeader = "<strong>Fire Inspector</strong>";
		String ViewPageSouce = driver.getPageSource();
		boolean IsResult = viewPageSouce.contains(WelComePageHeader);
		
		if (isResult)
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		driver.close();
	}

}
