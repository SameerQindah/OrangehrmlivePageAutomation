package orangehrmlive;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import locaters.loginlocaters;
import mainpage.BasePage;

public class LoginTestDataProviders extends BasePage{
	
	@BeforeMethod
    public void openBrowser() {
        setUp();
    }
    @Test(dataProvider= "create")
    public void validLogin(String username , String password , String expectedResult) throws InterruptedException { //valid login with correct user name and password 
        Thread.sleep(5000);

    	TextElement(username, loginlocaters.Username);
    	TextElement(password, loginlocaters.Password);
        
        Thread.sleep(5000);

        clickButton(loginlocaters.SubmitButton);
        Thread.sleep(3000);

        if (expectedResult.equals("success")) {

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("dashboard"),
                    "Login failed, dashboard page not opened"
            );

        } else if (expectedResult.equals("invalid")) {

            Assert.assertTrue(
                    driver.getPageSource().contains("Invalid credentials"),
                    "Invalid credentials message is not displayed"
            );

        } else if (expectedResult.equals("required")) {

            Assert.assertTrue(
                    driver.getPageSource().contains("Required"),
                    "Required message is not displayed"
            );
        }
    }
    
    @DataProvider(name= "create")
    public Object [][] dataSet1(){
    	return new Object [][] {
    		{"Admin", "admin123" , "success"},
    		{"sameer", "sameer123" , "invalid"},
    		{"Admin", "" , "required"},
    		{"", "admin123", "required"},
    		{" ", "" , "required"}
    	};
    }
   
    @AfterMethod
    public void tearDown() {
        quit();
    }
}
