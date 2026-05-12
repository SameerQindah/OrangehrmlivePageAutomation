package locaters;

import org.openqa.selenium.By;

public class AddUserLocaters {
	
	public static final By UserRoleText = By.xpath("//label[text()='User Role']/../following-sibling::div//div[@class='oxd-select-text-input']");
	public static final By AdminOption =By.xpath("//div[@role='option']//span[text()='Admin']");
	public static final By EssOption =By.xpath("//div[@role='option']//span[text()='ESS']");
	public static final By EmployeeName = By.cssSelector("input[placeholder='Type for hints...']");
	public static final By EmployeeDropdown =By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]");
	public static final By EmployeeOption =By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]//*[text()='savina dulvin dulvin']");
	public static final By UserName =By.xpath("//label[text()='Username']/../following-sibling::div//input");
	public static final By Status =By.xpath("//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
	public static final By EnabledOption =By.xpath("//div[@role='option']//span[text()='Enabled']");
	public static final By DisabledOption =By.xpath("//div[@role='option']//span[text()='Disabled']");
    public static final By Password =By.xpath("//label[text()='Password']/../following-sibling::div//input");
    public static final By ConfirmPassword =By.xpath("//label[text()='Confirm Password']/../following-sibling::div//input");
    public static final By emptyerrorMessage =By.cssSelector("span.oxd-input-field-error-message");
    public static final By SaveButton =By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
	public static final By CancelButton = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--ghost");
    
	
}