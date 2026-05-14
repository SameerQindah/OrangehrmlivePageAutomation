package mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class EditUserDataPage extends AddUserPage{
	
	public void clickOnEditButton() {
	    driver.findElement(By.cssSelector("i.oxd-icon.bi-pencil-fill")).click();
	}
	
	public void clear(By locator) {
	    driver.findElement(locator).click();
	    driver.findElement(locator).sendKeys(Keys.COMMAND + "a"); // just for Mac
	    driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
	}

}
