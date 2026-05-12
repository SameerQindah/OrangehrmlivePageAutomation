package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import locaters.AddUserLocaters;
import mainpage.AddUserPage;

public class TestAddUser extends AddUserPage {
	
	@BeforeMethod
    public void openBrowser() throws InterruptedException {
        setUp();
        Thread.sleep(5000);
        loginOrangehrmlive ();
        Thread.sleep(5000);
        clickOnAdminTab();
        Thread.sleep(5000);
        clickOnAddButton();
        Thread.sleep(5000);
    }


    @Test
    public void validLogin() throws InterruptedException { //valid add with correct all text filed
    	TextElement("Admin", AddUserLocaters.UserRoleText);
        Thread.sleep(2000);
        clickButton(AddUserLocaters.AdminOption);

    	
    	TextElement("sa" , AddUserLocaters.EmployeeName);
        Thread.sleep(5000);
        clickButton(AddUserLocaters.EmployeeOption);

        
        TextElement("maysam2", AddUserLocaters.UserName);
        
    	TextElement("Enabled", AddUserLocaters.Status);
        Thread.sleep(2000);
        clickButton(AddUserLocaters.EnabledOption);

    	TextElement("admin12", AddUserLocaters.Password);
    	TextElement("admin12", AddUserLocaters.ConfirmPassword);
        
        Thread.sleep(3000);

        clickButton(AddUserLocaters.SaveButton);
       
        Thread.sleep(10000);
        String actualText = driver.findElement(By.xpath("//div[text()='maysam2']")).getText();
        Assert.assertEquals(actualText, "maysam2"); 
    }
    
	
	
    @Test
    public void invalidAdd() throws InterruptedException {//add with invalid employee name
    	TextElement("Admin", AddUserLocaters.UserRoleText);
        clickButton(AddUserLocaters.AdminOption);

    	TextElement("aa", AddUserLocaters.EmployeeName);
    	TextElement("sameer", AddUserLocaters.UserName);
    	TextElement("Enabled", AddUserLocaters.Status);
        clickButton(AddUserLocaters.EnabledOption);

    	TextElement("admin12", AddUserLocaters.Password);
    	TextElement("admin12", AddUserLocaters.ConfirmPassword);
                
        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(AddUserLocaters.emptyerrorMessage);
        String actualMessageText = errorMessage.getText();
        String expectedMessageText = "Invalid";
        Assert.assertEquals(actualMessageText, expectedMessageText);
    }
    
    @Test
    public void emptyAdd() throws InterruptedException { //add with invalid text field
        Thread.sleep(2000);

    	clickButton(AddUserLocaters.SaveButton);
        Thread.sleep(2000);


        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(AddUserLocaters.emptyerrorMessage);
        String actualMessageText = errorMessage.getText();
        String expectedMessageText = "Required";
        Assert.assertEquals(actualMessageText, expectedMessageText);
    }
   
	@Test
    public void cancelAdd() throws InterruptedException { //cancel the add
    	clickButton(AddUserLocaters.CancelButton);
        Thread.sleep(2000);

        String actual = driver.getCurrentUrl();;
        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        Assert.assertEquals(actual, expected);
    }
     
    
    @AfterMethod
    public void tearDown() {
        quit();
    }
}
