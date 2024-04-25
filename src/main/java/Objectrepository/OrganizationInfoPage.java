package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement ObtainOrgname;
public OrganizationInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getObtainOrgname() {
	return ObtainOrgname;
}
/**
 * @author USER
 */
public	String OrgNameInfo()
{
return	ObtainOrgname.getText();
	
}
}
