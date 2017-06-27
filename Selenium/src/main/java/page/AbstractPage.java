package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	public static final int WAIT_FOR_ELEMENT_TIMEOUT = 10;
	WebDriver driver;

	public AbstractPage(WebDriver driver) {

		this.driver = driver;

	}

	public void waitForElementPresent(By locator) {

		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void waitForElementEnabled(By locator) {

		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementVisible(By locator) {

		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForFrame(By locator){
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframe"));
	}
	public void waitForElementClickable(By locator){
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
	}
}
