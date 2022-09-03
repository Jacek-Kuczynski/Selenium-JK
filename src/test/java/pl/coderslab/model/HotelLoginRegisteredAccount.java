package pl.coderslab.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelLoginRegisteredAccount {
    private WebDriver driver;

    public HotelLoginRegisteredAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void loginWithEmail(String registeredEmail, String password) {
        WebElement loginEmailInput = this.driver.findElement(By.id("email"));
        WebElement loginPasswordInput = this.driver.findElement(By.id("passwd"));
        WebElement submitButton = this.driver.findElement(By.id("SubmitLogin"));

        loginEmailInput.clear();
        loginEmailInput.sendKeys(registeredEmail);

        loginPasswordInput.clear();
        loginPasswordInput.sendKeys(password);

        submitButton.click();

        WebElement goToHomePage = this.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/ul/li/a"));
        goToHomePage.click();
    }
}
