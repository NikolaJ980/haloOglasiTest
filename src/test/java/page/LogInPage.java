package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Uloguj se']")
    WebElement ulogujSeButton;
    @FindBy(id="EMailOrUsername")
    WebElement korisnickoImeField;
    @FindBy(id="Password")
    WebElement lozinkaField;
    @FindBy(xpath = "//button[.='Uloguj me']")
    WebElement ulogujMeButton;

    public LogInPage ulogujSeClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(ulogujSeButton)).click();
        return  this;
    }
    public LogInPage korisnickoImeInput(String ime) {
        wdWait.until(ExpectedConditions.visibilityOf(korisnickoImeField)).clear();
        korisnickoImeField.sendKeys(ime);
        return  this;
    }
    public LogInPage lozinkaInput(String lozinka) {
        wdWait.until(ExpectedConditions.visibilityOf(lozinkaField)).clear();
        lozinkaField.sendKeys(lozinka);
        return  this;
    }
    public LogInPage ulogujMeClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(ulogujMeButton)).click();
        return  this;
    }

}
