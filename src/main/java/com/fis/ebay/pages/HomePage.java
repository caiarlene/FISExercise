package com.fis.ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "gh-ac")
    WebElement searchBox;

    @FindBy(id = "gh-btn")
    WebElement searchButton;

    @FindBy(xpath = "(//div[contains(@class,\"s-item__image-wrapper\")])[2]")
    WebElement firstBookLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openWebsite() {
        driver.get("https://www.ebay.com");
    }

    public void searchForItem(String item) {
        searchBox.sendKeys(item);
        searchButton.click();
    }

    public void clickFirstBook() {
        firstBookLink.click();
    }


}
