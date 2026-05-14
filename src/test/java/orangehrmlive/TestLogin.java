package orangehrmlive;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import locaters.loginlocaters;
import mainpage.BasePage;

public class TestLogin extends BasePage {

	@BeforeMethod
    public void openBrowser() {
        setUp();
    }
    @Test
    public void validLogin() throws InterruptedException { //valid login with correct user name and password 
    	TextElement("Admin", loginlocaters.Username);
    	TextElement("admin123", loginlocaters.Password);
        
        Thread.sleep(3000);

        clickButton(loginlocaters.SubmitButton);
        
        Thread.sleep(3000);
        String actualurl = driver.getCurrentUrl();;
        String expectedurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(actualurl, expectedurl);
        
    }
    @Test
    public void invalidLogin() throws InterruptedException {//invalid login with not correct user name and password 
    	TextElement("sameer", loginlocaters.Username);
    	TextElement("sameer123", loginlocaters.Password);

        Thread.sleep(3000);

        clickButton(loginlocaters.SubmitButton);

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(loginlocaters.invaliderrorMessage);
        String actualMessageText = errorMessage.getText();
        String expectedMessageText = "Invalid credentials";
        Assert.assertEquals(actualMessageText, expectedMessageText);
    }
    
    @Test
    public void ForgotPassword () throws InterruptedException { // click on forgot your password because not reminder the password
    	clickButton(loginlocaters.Forgotpassword);
    	Thread.sleep(3000);
    	
    	String actualurl = driver.getCurrentUrl();;
        String expectedurl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
        Assert.assertEquals(actualurl, expectedurl);
    }
    
    @Test
    public void OrangeHRMIncLink () throws InterruptedException { //click on  OrangeHRM, Inc link
    	clickButton(loginlocaters.linkOrangeHRM);
    	Thread.sleep(3000);
    	
    	Object[] windows = driver.getWindowHandles().toArray();
        driver.switchTo().window(windows[1].toString());   
    	
    	String actualurl = driver.getCurrentUrl();;
        String expectedurl = "https://orangehrm.com/";
        Assert.assertEquals(actualurl, expectedurl);
    }
    
    @Test
    public void emptyLogin() throws InterruptedException { //invalid login with empty user name and password 
        clickButton(loginlocaters.SubmitButton);

        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(loginlocaters.emptyerrorMessage);
        String actualMessageText = errorMessage.getText();
        String expectedMessageText = "Required";
        Assert.assertEquals(actualMessageText, expectedMessageText);
    }
    
    @AfterMethod
    public void tearDown() {
        quit();
    }
}
