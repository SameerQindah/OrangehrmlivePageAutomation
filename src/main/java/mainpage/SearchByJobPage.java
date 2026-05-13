package mainpage;

import org.openqa.selenium.By;

public class SearchByJobPage extends BasePage {
	
	public void clickOnPIMTab () { //Pre-condition for go next to "PIM" page
    	driver.findElement(By.cssSelector("a[href='/web/index.php/pim/viewPimModule']")).click();
    	}
	
}
