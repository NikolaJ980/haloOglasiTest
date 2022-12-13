package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SuccessfulRegistrationPage extends BasePage {
    public SuccessfulRegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".regsitration-success")
    WebElement successefulRegistration;
    @FindBy(css = "a[href='/prijava']")
    WebElement prijavaButton;

    public boolean successfulRegistrationIsDispay() {
        return wdWait.until(ExpectedConditions.visibilityOf(successefulRegistration)).isDisplayed();
    }
    public String successfulRegistrationText() {
      return  wdWait.until(ExpectedConditions.visibilityOf(successefulRegistration)).getText();
    }
    public void prijavaClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(prijavaButton)).click();
    }
    public void switchNewTab() {
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(3));
        ArrayList<String> numberOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(numberOfTabs.get(2));
    }

}
