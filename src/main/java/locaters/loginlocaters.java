package locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginlocaters {
	public static final By Username = By.cssSelector("input[name='username']");
	public static final By Password = By.cssSelector("input[name='password']");
	public static final By SubmitButton = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
	public static final By Forgotpassword = By.cssSelector("p.oxd-text.oxd-text--p.orangehrm-login-forgot-header");
	public static final By linkOrangeHRM = By.cssSelector("a[href='http://www.orangehrm.com']");
	public static final By invaliderrorMessage = By.cssSelector("p.oxd-alert-content-text");
	public static final By emptyerrorMessage = By.cssSelector("span.oxd-input-field-error-message");


	}