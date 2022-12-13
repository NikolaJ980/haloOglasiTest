package page;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorPage extends BasePage {
    public MailinatorPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="search")
    WebElement enterInboxField;
    @FindBy(xpath = "//button[@value='Search for public inbox for free']")
    WebElement searchButton;

    public void enterInboxinput(String emailName) {
        wdWait.until(ExpectedConditions.visibilityOf(enterInboxField)).clear();
        enterInboxField.sendKeys(emailName);
    }
    public void searchClick(Keys keyboard) {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton)).sendKeys(keyboard);
    }

}
