package pl.coderslab.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelMainPage {

    private WebDriver driver;

    @FindBy(className = "user_login")
    private WebElement signInButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[5]/div/div/div[2]/div/form/div[2]/div/button/span[1]")
    private WebElement selectHotelDropdown;

    @FindBy(xpath = "//form[@id='search_hotel_block_form']//ul[@class='dropdown-menu hotel_dropdown_ul']")
    private List<WebElement> hotels;

    @FindBy(id = "check_in_time")
    private WebElement checkInDateInput;

    @FindBy(id = "check_out_time")
    private WebElement checkOutDateInput;

    @FindBy(id = "search_room_submit")
    private WebElement searchNowButton;

    public HotelMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signInButton = this.driver.findElement(By.className("user_login"));
        signInButton.click(); // Kliknij na przycisk SignIn
    }


    public void searchForHotelRoomsBetweenDates(String hotelName, String fromDate, String toDate) {
        selectHotelDropdown.click();


//        WebElement hotel = this.driver.findElement(By.xpath("//form[@id='search_hotel_block_form']//ul[@class='dropdown-menu hotel_dropdown_ul']/li"));
//        hotel.click();

        for (WebElement hotel : hotels) {
            if (hotel.getText().equals(hotelName)) {
                hotel.click();
                break;
            }
        }

        checkInDateInput.clear();
        checkInDateInput.sendKeys(fromDate);
        checkOutDateInput.clear();
        checkOutDateInput.sendKeys(toDate);

        searchNowButton.click();

    }
}

