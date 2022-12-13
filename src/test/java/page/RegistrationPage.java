package page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {
    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/registracija']")
    WebElement registracijaButton;
    @FindBy(id="UserName")
    WebElement userNameField;
    @FindBy(id="Email")
    WebElement emailField;
    @FindBy(id="ConfirmPassword")
    WebElement potvrdaLozinkeField;
    @FindBy(id="HasAgreedToGetFiscalReceiptByEmail")
    WebElement saglasanCheckbox;
    @FindBy(css = ".button-reg.save.save-entity")
    WebElement registrujMeButton;

    public RegistrationPage registracijaButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(registracijaButton)).click();
        return this;
    }
    public RegistrationPage userNameInput(String userName) {
        wdWait.until(ExpectedConditions.visibilityOf(userNameField)).clear();
        userNameField.sendKeys(userName);
        return this;
    }
    public RegistrationPage emailInput(String email) {
        wdWait.until(ExpectedConditions.visibilityOf(emailField)).clear();
        emailField.sendKeys(email);
        return this;
    }
    public RegistrationPage potvrdaLozinkeInput(String password) {
        wdWait.until(ExpectedConditions.visibilityOf(potvrdaLozinkeField)).clear();
        potvrdaLozinkeField.sendKeys(password);
        return this;
    }
    public RegistrationPage saglasanClick() {
        if(!wdWait.until(ExpectedConditions.elementToBeClickable(saglasanCheckbox)).isSelected())
            saglasanCheckbox.click();
        return this;
    }
    public RegistrationPage registrujMeClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujMeButton)).click();
        return this;
    }

}
