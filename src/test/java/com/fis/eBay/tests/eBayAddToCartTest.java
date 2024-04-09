package com.fis.eBay.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.fis.ebay.pages.HomePage;
import com.fis.ebay.pages.ItemPage;

import static org.junit.Assert.assertEquals;

public class eBayAddToCartTest {
    WebDriver driver;
    HomePage homePage;
    ItemPage itemPage;

    @Before
    public void setUp() {
        String chromeDriverPath = System.getProperty("user.dir") + "/source/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePage.class);
        itemPage = PageFactory.initElements(driver, ItemPage.class);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addItems() {
        homePage.openWebsite();
        homePage.searchForItem("book");
        homePage.clickFirstBook();
        itemPage.switchToNewTab();
        itemPage.addToCart();
        String cartItemCount =  itemPage.getCartItemCount();

        assertEquals("1", cartItemCount);
    }

}
