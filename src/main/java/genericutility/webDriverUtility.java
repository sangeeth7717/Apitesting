package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of generic method realated to webdriver actions
 */
public class webDriverUtility {
	private static final String TakeScreenshot = null;

	/**
	 * This method is used to maximize window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimize window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to wait for page load
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * This method is used to wait for element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method is used to perform mouse over action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform the drop downs w.r.t index
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method is used to perform the drop downs w.r.t value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method is used to perform the drop downs w.r.t visibletext
	 * 
	 * @param visibleText
	 * @param element
	 */
	public void handleDropdown(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to perform the right click action w.r.t element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method is used to right click action with out any element
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method is used to double click action without element
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method is used to double click action w.r.t element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to drag and drop action
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	/**
	 * This method is used to drag and drop action w.r.t to co-ordinates
	 * 
	 * @param driver
	 * @param src
	 * @param x
	 * @param y
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, int x, int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x, y);
	}

	/**
	 * This method is used to switch to frames
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to switch to parent frames
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to switch to main frame
	 * 
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to accept the alert pop-up
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to dismiss the alert pop-up
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to get text from pop-up
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlerttext(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * This method is used to take the screenshot
	 * 
	 * @param driver
	 * @param screenshot
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenshot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dsc = new File("\\screenshot\\" + screenshot + ".png");
		Files.copy(src, dsc);
		return dsc.getAbsolutePath();// used for extent reports
	}

	/**
	 * This method is used to perform the scroll actions
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollAction(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");
	}

	/**
	 * This method is used to perform switch to windows based on window title
	 * 
	 * @param driver
	 * @param PartialTitle
	 */
	public void switchToWindow(WebDriver driver, String PartialTitle) {
		Set<String> winIDs = driver.getWindowHandles();
		for (String winId : winIDs) {
			driver.switchTo().window(winId);
			if (winId.contains(PartialTitle)) {
				break;
			}
		}
	}

}
