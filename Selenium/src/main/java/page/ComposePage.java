package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComposePage {

	WebDriver driver;

	public ComposePage(WebDriver driver) {

		this.driver = driver;

	}

	public static final By CREATE_BUTTON = By.xpath(".//*[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']");
	public static final By RECEIPIENT = By.xpath("//textarea[@class='js-input compose__labels__input']");
	public static final By SUBJECT = By.xpath("//input[@class='b-input']");
	public static final By BODY = By.xpath(".//body[@id='tinymce']");
	public static final By SAVE_DRAFT = By.xpath(
			".//*[@class='b-toolbar__btn b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_false b-toolbar__btn_grouped b-toolbar__btn_grouped_first js-shortcut']");
	public static final By SAVED_STATE = By.xpath("//div[contains(text(),'Saved in')]");
	public static final By FRAME = By.xpath(".//iframe[contains(@id,'composeEditor_ifr')]");

	public void openCreateScreen() {
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(CREATE_BUTTON);
		driver.findElement(CREATE_BUTTON).click();
	}

	public void fillInReceipient(String email) {
		driver.findElement(RECEIPIENT).sendKeys(email);

	}

	public void fillInSubject(String n) {
		driver.findElement(SUBJECT).sendKeys(n);

	}

	public void fillInBody(String body) {
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(FRAME);
		driver.switchTo().frame(driver.findElement(FRAME)).findElement(BODY).sendKeys(body);
		driver.switchTo().defaultContent();
	}

	public void saveAsDraft() {
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(SAVE_DRAFT);
		driver.findElement(SAVE_DRAFT).click();
		
	}
	
	public String checkDraftIsSaved(){
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(SAVED_STATE);
		String saved_state = driver.findElement(SAVED_STATE).getText();
		return saved_state;
	}

}