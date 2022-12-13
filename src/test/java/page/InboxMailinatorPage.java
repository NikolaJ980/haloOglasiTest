package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxMailinatorPage extends BasePage {
    public InboxMailinatorPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//td[contains(text(),'Molimo aktivirajte Vaš Halo oglasi nalog')])[1]")
    WebElement messagesInbox;
    @FindBy(id="html_msg_body")
    WebElement iFrameDoc;
    @FindBy(xpath = "//strong[.='Aktiviraj nalog']")
    WebElement aktivirajNalogButton;

    public InboxMailinatorPage massageInboxClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(messagesInbox)).click();
        return this;
    }
    public InboxMailinatorPage iFrameSwitch() {
       wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameDoc));
       return this;
    }
    public InboxMailinatorPage aktivirajNalogClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(aktivirajNalogButton)).click();
        return this;
    }

}
