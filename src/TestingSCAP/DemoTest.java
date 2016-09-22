package TestingSCAP;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class DemoTest
{
	WebDriver driver;
	
	@Test
	public void setup() throws InterruptedException{
	/*
	WebDriver driver = new FirefoxDriver();
	driver.get("https://biadev.eventcentric.local/bia_release/ia-scap/cap/");
	//C:\Users\eislam\Documents\Selenium Jar\ChromeDriver\chromedriver_win32
	*/
		
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://biadev.eventcentric.local/bia_release/ia-scap/cap/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement InspectionReq = driver.findElement(By.partialLinkText("Inspection Request"));
	InspectionReq.click();
	//System.out.println(driver.findElement(By.partialLinkText("Inspection Request").gettext();
	
	WebElement CaInsReq = driver.findElement(By.partialLinkText("CA Inspection Request"));
	CaInsReq.click();
	
	/*
	Thread.sleep(1000L);
	WebElement element = driver.findElement(By.id("s2id_autogen6"));
	//element.sendKeys("Contractor,CA");
	System.out.println(driver.findElement(By.id("s2id_autogen6")).getText());
	element.sendKeys("Contractor,CA");
	*/
	
	Thread.sleep(1000);
	Select oselect = new Select(driver.findElement(By.id("s2id_autogen6")));
	
	//oselect.selectByIndex(2);
	oselect.selectByVisibleText("Contractor,CA");
	//oselect.selectByValue(Contractor,CA);
	
	
    WebElement Trip = driver.findElement(By.id("TRIP_NUMBER"));
    Trip.clear();
    Trip.sendKeys("23");
    
    Select FMIS = new Select(driver.findElement(By.id("select2-choices")));
    //Select FMIS = new Select(driver.findElement(By.xpath(".//*[@id='s2id_autogen3']")));
    //FMIS.selectByIndex(4);
    FMIS.selectByVisibleText("P03-12: BIA WHITEMORE MT FIRE TOWER (FIELD LOCATION)");
    
    //WebElement FMIS = driver.findElement(By.id("select2-choices"));
    //FMIS.clear();
    //FMIS
	
    WebElement RadioButton = driver.findElement(By.id("saveStepBtn"));
    RadioButton.click();
    
    
    System.out.println(driver.getTitle());
    //driver.close();
}
}




