package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver,  this);
    }
    @FindBy(css = ".header-category-link.logged-in-wrapper")
    WebElement profilMeni;
    @FindBy(css = ".user-email")
    WebElement userMail;
    @FindBy(css = ".user-username")
    WebElement userName;

    public void profilMeniHover() {
        wdWait.until(ExpectedConditions.elementToBeClickable(profilMeni));
        actions.moveToElement(profilMeni).perform();
    }
    public boolean userMailIsDisplay() {
      return  wdWait.until(ExpectedConditions.visibilityOf(userMail)).isDisplayed();
    }
    public String userMailText() {
        return wdWait.until(ExpectedConditions.visibilityOf(userMail)).getText();
    }
    public boolean userNameIsDisplay() {
        return  wdWait.until(ExpectedConditions.visibilityOf(userName)).isDisplayed();
    }
    public String userNameText() {
        return wdWait.until(ExpectedConditions.visibilityOf(userName)).getText();
    }

}
