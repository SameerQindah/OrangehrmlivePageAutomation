package orangehrmlive;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import locaters.SearchByJobLoacaters;
import mainpage.SearchByJobPage;

public class TestSearchByJob extends SearchByJobPage {
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
        setUp();
        Thread.sleep(5000);
        loginOrangehrmlive ();
	}
	
	@BeforeMethod
    public void nextToHomePage() throws InterruptedException {
        Thread.sleep(5000);
        clickOnPIMTab();    
        Thread.sleep(5000);
    }
	
	@Test
    public void ResetJob() throws InterruptedException { // the user can reset the job title search filter
        clickButton(SearchByJobLoacaters.JobTitleDropdown);
        Thread.sleep(2000);
        clickButton(By.xpath("//div[@role='option']//span[text()='QA Engineer']"));
        clickButton(SearchByJobLoacaters.SubmitButton);
    
    	clickButton(SearchByJobLoacaters.ResetButton);
        Thread.sleep(5000);

        String recordsAfterReset = driver.findElement(SearchByJobLoacaters.JobTitleSelectedText).getText();
        String recordsBeforeSearch ="-- Select --";
        Assert.assertEquals(recordsAfterReset, recordsBeforeSearch);
        
    }
	
	@Test
    public void validSearchNotFound() throws InterruptedException { //searching by job title shows no records when no matching users are found
		clickButton(SearchByJobLoacaters.JobTitleDropdown);
        Thread.sleep(2000);
        clickButton(By.xpath("//div[@role='option']//span[text()='Account Assistant']"));

    	
        clickButton(SearchByJobLoacaters.SubmitButton);
       
        Thread.sleep(5000);

        String actualMessage = driver.findElement(SearchByJobLoacaters.NoRecordsFoundMessage).getText();
        String expected = "No Records Found";
        Assert.assertEquals(actualMessage, expected);

    }
	
	
	@Test
    public void validSearchFound() throws InterruptedException { // searching by job title displays users with the selected job title
		clickButton(SearchByJobLoacaters.JobTitleDropdown);
        Thread.sleep(2000);
        clickButton(By.xpath("//div[@role='option']//span[text()='QA Engineer']"));

    	
        clickButton(SearchByJobLoacaters.SubmitButton);
       
        Thread.sleep(5000);
        List<WebElement> jobTitles = driver.findElements(SearchByJobLoacaters.jobTitles);

            for (int i = 0; i < jobTitles.size(); i++) {
                String actualText = jobTitles.get(i).getText();
                String expected = "QA Engineer";
                Assert.assertEquals(actualText, expected);
            }
    }
	
	@AfterClass
    public void tearDown() {
        quit();
    }
	
}
