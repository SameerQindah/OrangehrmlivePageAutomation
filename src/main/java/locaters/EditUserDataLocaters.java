package locaters;

import org.openqa.selenium.By;

public class EditUserDataLocaters {
	    public static final By UserRoleDropdown =By.xpath("//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
	    public static final By EmployeeNameInput =By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
	    public static final By EmployeeOption =By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]//*[text()='savina dulvin dulvin']");
	    public static final By StatusDropdown =By.xpath("//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
	    public static final By UsernameInput =By.xpath("//label[text()='Username']/../following-sibling::div//input");
	    public static final By ChangePasswordCheckbox =By.xpath("//label[text()='Change Password ?']/../following-sibling::div//span[contains(@class,'oxd-checkbox-input')]");
	    public static final By PasswordInput =By.xpath("//label[text()='Password']/../following-sibling::div//input[@type='password']");
	    public static final By ConfirmPasswordInput =By.xpath("//label[text()='Confirm Password']/../following-sibling::div//input[@type='password']");
	    public static final By SaveButton =By.xpath("//button[@type='submit']");
	    public static final By CancelButton =By.xpath("//button[normalize-space()='Cancel']");
	
}
