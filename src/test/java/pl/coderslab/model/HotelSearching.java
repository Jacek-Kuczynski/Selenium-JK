//
//package pl.coderslab.model;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pl.coderslab.model.HotelCreateAnAccountPage;
//import pl.coderslab.model.HotelLoginPage;
//import pl.coderslab.model.HotelMainPage;
//import pl.coderslab.model.HotelMyAccountPage;
//
//import java.time.Duration;
//import java.util.Random;
//
//import static org.junit.Assert.assertEquals;
//
//public class HotelSearching {
//
//    private WebDriver driver;
//
//    @Before
//    public void setUp() {
//        //        Ustaw gdzie jest chromedriver -> STEROWNIK
//        System.setProperty("webdriver.chrome.driver",
//                "src/main/resources/drivers/chromedriver.exe");
//        //        Otworz przegladarke
//        this.driver = new ChromeDriver();
//        //        Jesli test nie przechodzi poprawnie, to pewnie za wolno laduje sie strona -> Dodaj czekanie.
//        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
////    @After
////    public void tearDown() {
////        driver.quit();
////    }
//
//    @Test
//    public void testCreateNewUser() {
//
//        // Wejdz na strone glowna
//        this.driver.get("https://hotel-testlab.coderslab.pl/en/");
//
//        HotelMainPage hotelMainPage = new HotelMainPage(this.driver);
//        hotelMainPage.clickSignIn();
//
//        HotelLoginRegisteredAccount hotelLoginRegisteredAccount = new HotelLoginRegisteredAccount(this.driver);
//        hotelLoginRegisteredAccount.loginWithEmail("Franek@gmail.com", "12345");
//
//        WebElement goToHomePage = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/ul/li/a"));
//        goToHomePage.click();
//    }
//
//
//
//
//
//
//
//
//
//
//
////        HotelCreateAnAccountPage hotelCreateAnAccountPage = new HotelCreateAnAccountPage(this.driver);
////        hotelCreateAnAccountPage.fillFormAndSubmit("Janusz", "Januszewski", "12345");
////
////        HotelMyAccountPage hotelMyAccountPage = new HotelMyAccountPage(driver);
////        String alertText = hotelMyAccountPage.getAlertText();
////        assertEquals(expectedAlertText, alertText);
////
////        String pageTitle = hotelMyAccountPage.getPageTitle();
////        assertEquals("My account - MyBooking", pageTitle);
//
//    }
//
//}
