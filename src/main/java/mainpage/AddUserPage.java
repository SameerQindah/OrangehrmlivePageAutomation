package mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import locaters.loginlocaters;

public class AddUserPage extends BasePage{

    public void loginOrangehrmlive () { //Pre-condition for login this website 
    	TextElement("Admin", loginlocaters.Username);
    	TextElement("admin123", loginlocaters.Password);
        clickButton(loginlocaters.SubmitButton);
    }
    
    public void clickOnAdminTab () { //Pre-condition for go next to "add user" page
    	driver.findElement(By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']")).click();
    	}
    
    public void clickOnAddButton (){ //Pre-condition for go next to "add user" page
    	driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
    	}

    public void quit() {
        driver.quit();
    }
    
}
