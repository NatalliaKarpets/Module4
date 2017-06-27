package page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DraftPage {

	WebDriver driver;

	public DraftPage(WebDriver driver) {

		this.driver = driver;
	}

	public static final By OPEN_DRAFTS = By.xpath(".//div[@data-id='500001']");
	public static final By OPEN_DRAFT = By.xpath(".//div[@class='b-datalist__body']/[div1]");
	public static final By GET_SUBJ = By.xpath("//div[@id='b-letters']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]");
	public static final By GET_SUBJ_SENT = By
			.xpath("//div[@id='b-letters']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]");
	public static final By GET_EMAIL = By.xpath("//div[@class='b-datalist__body']/div[1]/div[1]/a[1]");
	public static final By GET_BODY = By.xpath(".//span[contains(@class, 'b-datalist__item__subj')]");
	public static final By SEND = By
			.xpath("//div[@class='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']");
	public static final By FRAME = By.xpath(".//iframe[contains(@id,'composeEditor_ifr')]");
	public static final By BODY = By.xpath(".//body[@id='tinymce']");

	public void openDrafts() {

		driver.navigate().to("https://e.mail.ru/messages/drafts/");
	}

	public String assertDraftReceipient() {

		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(GET_EMAIL);
		String receipient = driver.findElement(GET_EMAIL).getAttribute("title");
		return receipient;
	}

	public String assertDraftSubj() {

		String subj = driver.findElement(GET_SUBJ).getAttribute("data-subject");
		return subj;
	}

	public String assertDraftBody() {
		String body = driver.findElement(GET_BODY).getText();
		return body;
	}

	public String sendDraft() {

		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(GET_SUBJ);
		abstractPage.waitForElementVisible(GET_SUBJ);
		String subjOfDraft_Sent = driver.findElement(GET_SUBJ).getAttribute("data-subject");
		driver.findElement(GET_SUBJ).click();
		abstractPage.waitForElementPresent(FRAME);
		driver.switchTo().frame(driver.findElement(FRAME)).findElement(BODY).sendKeys(" ");
		driver.switchTo().defaultContent();
		abstractPage.waitForElementPresent(SEND);
		driver.findElement(SEND).click();
		return subjOfDraft_Sent;

	}

	public void sendAndAssertDraftIsSent() {
		DraftPage draftPage = new DraftPage(driver);
		String subjOfDraft_Sent = draftPage.sendDraft();
		driver.navigate().to("https://e.mail.ru/messages/drafts/");
		String subjOfDraft_Draft = driver.findElement(GET_SUBJ).getAttribute("data-subject");
		assertNotEquals(subjOfDraft_Sent, subjOfDraft_Draft);
		driver.navigate().to("https://e.mail.ru/messages/sent/");
		String subjOfSent = driver.findElement(GET_SUBJ_SENT).getAttribute("data-subject");
		assertEquals(subjOfDraft_Sent, subjOfSent);
	}

}
