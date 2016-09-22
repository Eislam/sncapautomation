package TestingSCAP;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CAmanager {
	WebDriver driver;
	
	@Test
	public void CaManager() throws InterruptedException
	{
		//Open the browser path
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://biadev.eventcentric.local/bia_release/ia-scap/cap/");
		driver.get("https://biadev.eventcentric.local/bia_release/ia-scap/cap/index.cfm?fuseaction=main.default");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 
		//Clicking on Home button
		WebElement element = driver.findElement(By.partialLinkText("Home"));
		element.click();
		
		//Changing Role of user
		Actions actions = new Actions(driver);
		WebElement changeRole = driver.findElement(By.linkText("Change Role"));
		Thread.sleep(3*1000);
		actions.moveToElement(changeRole).build().perform();
		Thread.sleep(1000);
		
		//Selecting user role
		WebElement ChangRoleDropDown = driver.findElement(By.linkText("CA Manager"));
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
		
		
		//Clicking pope up "Yes" button 
		WebElement PopUpButton = driver.findElement(By.xpath(".//*[@id='changeRoleConfirmModal']/div/div/form/div[2]/button[1]"));
		Thread.sleep(3*1000);
		PopUpButton.click();
		System.out.println(driver.getCurrentUrl());
		
		//Verification check point for new window
		String WelComePageHeader = "<strong>CA Manager</strong>";
		String ViewPageSouce = driver.getPageSource();
		boolean IsResult = ViewPageSouce.contains(WelComePageHeader);
		
		if (IsResult)
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}

		//Click on request drop-down button
		WebElement InspectionReq = driver.findElement(By.partialLinkText("Inspection Request"));
		System.out.println(InspectionReq.getText());
		InspectionReq.click();
		
		//Selects the CA inspection request link
		WebElement CaInsReq = driver.findElement(By.partialLinkText("CA Inspection Request"));
		System.out.println(CaInsReq.getText());
		CaInsReq.click();
		Thread.sleep(2*1000);
		
		//Selecting Inspector
		WebElement inspector = driver.findElement(By.id("s2id_autogen6"));
		inspector.click();
		WebElement dropdownSel = driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[3]/div"));
		dropdownSel.click();
		
		/*
		//Putting numbers in the edit field
	    WebElement Trip = driver.findElement(By.id("TRIP_NUMBER"));
	    System.out.println(Trip.getText());
	    Trip.clear();
	    Trip.sendKeys("62");
	    Thread.sleep(3*1000);
	    */
		
	    //Selecting location from drop-down menu
	    WebElement location = driver.findElement(By.id("s2id_autogen3"));
	    System.out.println(location.getText());
	    location.click();
	    WebElement Select = driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[24]/div"));
	    Select.click();
	    Thread.sleep(2*1000);
	    
	    //Save the new request form
	    WebElement SaveButton = driver.findElement(By.id("saveStepBtn"));
	    System.out.println(SaveButton.getText());
	    SaveButton.click();
	    Thread.sleep(5*1000);
	    
	    //Inspection Added.
	    String SaveInpPageHeader = "Inspection Added.";
		String SaveInsviewPageSouce = driver.getPageSource();
		boolean SaveInsisResult = SaveInsviewPageSouce.contains(SaveInpPageHeader);
		
		if (SaveInsisResult)
		{
			System.out.println("Inspection Add to the list");
		}
		else
		{
			System.out.println("Inspection did not add to the list");
		}
	   
	    //Clicking "Next - Select Inspection locations" 
	    WebElement NextInpLocation = driver.findElement(By.id("nextStepBtn"));
	    NextInpLocation.click();
	    driver.getCurrentUrl();
	    Thread.sleep(2*1000);
	    
		//Page verification header
		String NextInpPageHeader = "Inspection Added.";
		String NextInsviewPageSouce = driver.getPageSource();
		boolean NextInsisResult = NextInsviewPageSouce.contains(NextInpPageHeader);
			
		if (NextInsisResult)
		{
			System.out.println("Inspection Updated--->PASS");
		}
		else
		{
			System.out.println("Inspection did not appear in the header---->FAIL");
		}
	    
	    //Finds the element of Inspection Number
		WebElement InspectionNum = driver.findElement(By.id("summaryDataInspectionNumber"));
		System.out.println(InspectionNum.getText());
		
	    //Putting text values in the string
		String InspectionNumber = driver.findElement(By.id("summaryDataInspectionNumber")).getText();
		
		/*String rt =RandomStringUtils.randomNumeric(12);
		System.out.println(rt);
		*/	
		//Selecting "Inspection Data Entry" link
		WebElement InspectionDataEntry = driver.findElement(By.partialLinkText("Inspection Data Entry"));
		InspectionDataEntry.click();
		System.out.println(driver.getCurrentUrl());
		
		//Putting the value of CA inspection number to filter it
		driver.findElement(By.id("F6")).sendKeys(InspectionNumber);
		
		//Clicking on inspection status
		WebElement InspectionStatus = driver.findElement(By.xpath(".//*[@id='columnsTable']/tbody/tr[3]/td[11]/div/button"));
		InspectionStatus.click();
		
		//Select check box from the drop-down
		WebElement chechbox = driver.findElement(By.xpath("html/body/div[7]/div/ul/li[1]/a/span[2]"));
		chechbox.click();
		
		//Putting data in the Inspection Edit field
		WebElement search = driver.findElement(By.id("search"));
		search.click();
		System.out.println(driver.getCurrentUrl());
			
		//Page verification 
		String FilterHeader = "Please select an inspection";
		String FilterHeaderViewSource = driver.getPageSource();
		boolean FilterHeaderFinalResult = FilterHeaderViewSource.contains(FilterHeader);
			
		if (FilterHeaderFinalResult)
		{
			System.out.println(FilterHeader+"--->PASS");
		}
		else
		{
			System.out.println(FilterHeader+"Inspection did not appear--->Fail");
		}
		
		
		//Clicking Inspection List
		WebElement InspectionList = driver.findElement(By.partialLinkText("Inspection List"));
		InspectionList.click();
		
		//Clicking on Dashboard button
		WebElement Dashboard = driver.findElement(By.linkText("Dashboard"));
		System.out.println(driver.findElement(By.linkText("Dashboard")).getSize());
		Dashboard.click();
		
		//Verification check point
		String DashboardPage = driver.findElement(By.id("selected-inspection")).getText();
		System.out.println(DashboardPage);
		String DashboardPageViewSource = driver.getPageSource();
		boolean DashboardPageFinalResult = DashboardPageViewSource.contains(DashboardPage);
			
		if (DashboardPageFinalResult)
		{
			System.out.println(DashboardPage+" It retrives the current page header verification--> PASS");
		}
		else
		{
			System.out.println(DashboardPage+" It does not retrive the current page header verification--> Fail");
		}
		
		//Selecting "Inspection Data Entry" link
		WebElement InspectionDataEntry2 = driver.findElement(By.partialLinkText("Inspection Data Entry"));
		InspectionDataEntry2.click();
		System.out.println(driver.getCurrentUrl());
		
		//Selecting the row of Condition Assessment
		WebElement ConditionAssessment = driver.findElement(By.id("inspType_2"));
		ConditionAssessment.click();
		
		//Selecting the Location button
		WebElement Locations = driver.findElement(By.linkText("Locations"));
		Locations.click();
		System.out.println(Locations);
		System.out.println(driver.getCurrentUrl());
		
		
		//
		
		/*
	    //Clicking the radio button to finalized it
	    WebElement finalized = driver.findElement(By.id("finalizeStepBtn"));
	    System.out.println(finalized);
	    finalized.click();
	    driver.getCurrentUrl();
	    
	    //Inspection Finalized.  Please prepare a 30-day notice for this Inspection request.
		String FinalPageHeader = "Inspection Finalized.  Please prepare a 30-day notice for this Inspection request.";
		String FinalviewPageSouce = driver.getPageSource();
		boolean FinalisResult = FinalviewPageSouce.contains(FinalPageHeader);
		
		if (isResult)
		{
			System.out.println("Inspection finalized with confirmation");
		}
		else
		{
			System.out.println("Inspection did not finalize with confirmation");
		}
		
	    */
	    //Closing the current running browser
		//driver.close();
	
	
	
	}

}
