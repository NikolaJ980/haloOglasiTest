package test;

import base.BasePage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import page.*;

import java.util.Random;

public class TestPage extends BasePage {
    public TestPage() {
        PageFactory.initElements(driver, this);
    }

    HomePage homePage;
    InboxMailinatorPage inboxMailinatorPage;
    LogInPage logInPage;
    MailinatorPage mailinatorPage;
    RegistrationPage registrationPage;
    SuccessfulRegistrationPage successfulRegistrationPage;
    Random random = new Random();

    String name = "lepoIme" + random.nextInt(999999);
    String email = name + "@mailinator.com";
    String password = "12345678";
    String upitnik = "!";
    String registartionMassage = "Registracija je uspela!\n" +
            "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na :" + " " + email + " " + upitnik;

    String successfulMass = "Vaš nalog je uspešno aktiviran!\n" +
            "Produžite na stranicu za logovanje kako biste pristupili našem portalu. Prijava";
    String emailName = "email:" + " " + email;
    String nameName = "korisničko ime:" + " " + name;
    @Before
    public void setUpTestPage() {
        homePage = new HomePage();
        inboxMailinatorPage = new InboxMailinatorPage();
        logInPage = new LogInPage();
        mailinatorPage = new MailinatorPage();
        registrationPage = new RegistrationPage();
        successfulRegistrationPage = new SuccessfulRegistrationPage();

    }
    @Test
    public void successRegistration() {
        logInPage.ulogujSeClick();
        registrationPage
                .registracijaButtonClick()
                .userNameInput(name)
                .emailInput(email);
        logInPage.lozinkaInput(password);
        registrationPage
                .potvrdaLozinkeInput(password)
                .saglasanClick()
                .registrujMeClick();
        assertTrue(successfulRegistrationPage.successfulRegistrationIsDispay());
        assertEquals(registartionMassage, successfulRegistrationPage.successfulRegistrationText());
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.mailinator.com/");
        mailinatorPage.enterInboxinput(email);
        mailinatorPage.searchClick(Keys.ENTER);
        inboxMailinatorPage
                .massageInboxClick()
                .iFrameSwitch()
                .aktivirajNalogClick();
        successfulRegistrationPage.switchNewTab();
        assertTrue(successfulRegistrationPage.successfulRegistrationIsDispay());
        assertEquals(successfulMass, successfulRegistrationPage.successfulRegistrationText());
        successfulRegistrationPage.prijavaClick();
        logInPage
                .korisnickoImeInput(name)
                .lozinkaInput(password)
                .ulogujMeClick();
        homePage.profilMeniHover();
        assertTrue(homePage.userMailIsDisplay());
        assertEquals(emailName, homePage.userMailText());
        assertTrue(homePage.userNameIsDisplay());
        assertEquals(nameName, homePage.userNameText());
    }
}
