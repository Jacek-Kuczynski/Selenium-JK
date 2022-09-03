
package pl.coderslab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.model.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        //        Ustaw gdzie jest chromedriver -> STEROWNIK
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        //        Otworz przegladarke
        this.driver = new ChromeDriver();
        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCreateNewUser() {

        String email = new Random().nextInt(100000000) + "TEA26@test.com";
        String expectedAlertText = "Your account has been created.";

        // Wejdz na strone glowna
        this.driver.get("https://hotel-testlab.coderslab.pl/en/");

        HotelMainPage hotelMainPage = new HotelMainPage(this.driver);
        hotelMainPage.clickSignIn();

        HotelLoginPage hotelLoginPage = new HotelLoginPage(this.driver);
        hotelLoginPage.createAnAccountWithEmail(email);

        HotelCreateAnAccountPage hotelCreateAnAccountPage = new HotelCreateAnAccountPage(this.driver);
        hotelCreateAnAccountPage.fillFormAndSubmit("Janusz", "Januszewski", "12345");

        HotelMyAccountPage hotelMyAccountPage = new HotelMyAccountPage(driver);
        String alertText = hotelMyAccountPage.getAlertText();
        assertEquals(expectedAlertText, alertText);

        String pageTitle = hotelMyAccountPage.getPageTitle();
        assertEquals("My account - MyBooking", pageTitle);

    }

    @Test
    public void hotelRoomSearching() {

        // Wejdz na strone glowna
        this.driver.get("https://hotel-testlab.coderslab.pl/en/");

        HotelMainPage hotelMainPage = new HotelMainPage(this.driver);
        hotelMainPage.clickSignIn();

        HotelLoginRegisteredAccount hotelLoginRegisteredAccount = new HotelLoginRegisteredAccount(this.driver);
        hotelLoginRegisteredAccount.loginWithEmail("Franek@gmail.com", "12345");

        hotelMainPage.searchForHotelRoomsBetweenDates("The Hotel Prime", "22-09-2022", "29-09-2022");

        HotelRoomSearching hotelRoomSearching = new HotelRoomSearching(this.driver);
        assertTrue(hotelRoomSearching.isAnyRoomOnTheListPresent());
        assertTrue(hotelRoomSearching.getAvailableRoomNumber() > 0);

    }
}
