package mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import locaters.loginlocaters;

public class AddUserPage extends BasePage{
    
    public void clickOnAdminTab () { //Pre-condition for go next to "add user" page
    	driver.findElement(By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']")).click();
    	}
    
    public void clickOnAddButton (){ //Pre-condition for go next to "add user" page
    	driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
    	}
    
}
