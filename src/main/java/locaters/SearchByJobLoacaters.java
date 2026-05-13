package locaters;

import org.openqa.selenium.By;

public class SearchByJobLoacaters {
	public static final By JobTitleDropdown =By.xpath("//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");	 
    public static final By jobTitles = By.xpath("//div[@class='oxd-table-card']//div[@role='cell'][5]//div");
    public static final By SubmitButton =By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space");
    public static final By ResetButton = By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--ghost");
    public static final By JobTitleSelectedText =By.xpath("//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
    public static final By NoRecordsFoundMessage =By.xpath("//span[text()='No Records Found']");
}
