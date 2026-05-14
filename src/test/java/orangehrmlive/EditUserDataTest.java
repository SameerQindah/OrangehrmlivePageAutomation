package orangehrmlive;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import locaters.EditUserDataLocaters;
import mainpage.EditUserDataPage;

public class EditUserDataTest extends EditUserDataPage {
	
	@BeforeClass
	public void openBrowser() throws InterruptedException {
        setUp();
        Thread.sleep(10000);
        loginOrangehrmlive ();
	}
	
	@BeforeMethod
    public void nextToHomePage() throws InterruptedException {
        Thread.sleep(10000);
        clickOnAdminTab();
        Thread.sleep(10000);
        clickOnEditButton();
        Thread.sleep(10000);
    }
	
	@Test
    public void validEditDataUser() throws InterruptedException { //update all data of user successful
		clickButton(EditUserDataLocaters.UserRoleDropdown);
        Thread.sleep(2000);
        clickButton(EditUserDataLocaters.AdminOption);
        
        clear(EditUserDataLocaters.EmployeeNameInput);
        TextElement("sa" , EditUserDataLocaters.EmployeeNameInput);
        Thread.sleep(3000);
        clickButton(EditUserDataLocaters.EmployeeOption);
        
        clear(EditUserDataLocaters.UsernameInput);
        TextElement("sameer a" , EditUserDataLocaters.UsernameInput);
        
        clickButton(EditUserDataLocaters.StatusDropdown);
        Thread.sleep(2000);
        clickButton(EditUserDataLocaters.EnableOption);;

        clickButton(EditUserDataLocaters.ChangePasswordCheckbox);

        TextElement("admin12", EditUserDataLocaters.PasswordInput);
    	TextElement("admin12", EditUserDataLocaters.ConfirmPasswordInput);
        
        clickButton(EditUserDataLocaters.SaveButton);
       
        Thread.sleep(2000);

        Assert.assertTrue(
            driver.getPageSource().contains("Successfully Updated"),
            "User data was not updated successfully"
        );
        Thread.sleep(5000);
        String employeeName = "sameer a";

        Assert.assertTrue(
                driver.findElement(EditUserDataLocaters.employeeNameInList(employeeName)).isDisplayed(),
                "Updated employee name is not displayed in the list"
        );
        
    }
	
	@Test
    public void cancelEdit() throws InterruptedException { //cancel the edit user process
    	clickButton(EditUserDataLocaters.CancelButton);
        Thread.sleep(5000);

        String actual = driver.getCurrentUrl();;
        String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        Assert.assertEquals(actual, expected);
    }
	
	@AfterClass
    public void tearDown() {
        quit();
    }
}
