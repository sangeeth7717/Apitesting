package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement newcontactbtn;

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewcontactbtn() {
		return newcontactbtn;
	}

	/**
	 * This is business method
	 * 
	 * @author USER
	 */
	public void createcontact() {
		newcontactbtn.click();
	}
}
