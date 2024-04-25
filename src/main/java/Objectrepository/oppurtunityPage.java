package Objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class oppurtunityPage {
@FindBy(xpath="//img[@title='Create Opportunity...']")
private WebElement CreteOppurtEdt;
//intialaization
public WebElement getCreteOppurtEdt() {
	return CreteOppurtEdt;
}
/**
 * This is a business class which deals with Create opportunity element
 * @author USER
 */
public void createOpportunityybtn() {
	CreteOppurtEdt.click();
}
}
