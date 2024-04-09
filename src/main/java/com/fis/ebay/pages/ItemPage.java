package com.fis.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class ItemPage {
    WebDriver driver;

    @FindBy(xpath = "//*[text()=\"Add to cart\"]")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[contains(@aria-label, 'Close the show me how overlay')]")
    WebElement closeOverlay;

    private String strCartCount="#gh-cart-n";
//    @FindBy(xpath="")
    WebElement cartCount;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToNewTab() {
        Set<String> windowHandles = driver.getWindowHandles();

        String newTabHandle = null;
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
                newTabHandle = handle;
                break;
            }
        }

        if (newTabHandle != null) {
            driver.switchTo().window(newTabHandle);
        } else {
            throw new RuntimeException("New tab not found");
        }
    }
    public void addToCart() {
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 3); // Set your desired timeout
        wait.until(ExpectedConditions.visibilityOf(closeOverlay));
        closeOverlay.click();
    }

    public String getCartItemCount() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gh-cart-n")));
        return element.getText();
    }

}
