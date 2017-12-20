import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class EbayTests {

    private ProductSearch productSearch;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        productSearch = new ProductSearch();
    }

    @Test
    public void testEbayProductSearch() throws InterruptedException {
        assertTrue(productSearch.isEbayLogoDisplayed(), "eBay logo was not be displayed");
        productSearch.enterProductToSearchTextBox("armani watches");
        productSearch.clickOnSearchIcon();
        productSearch.waitForElementLoad(5000);
        assertTrue(productSearch.isSortOptionDisplayed(), "Sort option was not be displayed");
        productSearch.clickOnSort();
        productSearch.clickOnCustomOptionUnderSort("Lowest Price + Shipping");
        productSearch.clickOnFirstSearchResult();
        assertTrue(productSearch.isWatchButtonDisplayed(), "Watch button was not be displayed");
        productSearch.clickOnWatchButton();
        assertTrue(productSearch.isSignInButtonDisplayed(), "Sign In button was not be displayed");
        productSearch.enterUserName("husny.jiffry");
        productSearch.clickOnBackButtonInSignInPage();
        assertTrue(productSearch.isWatchButtonDisplayed(), "Watch button was not be displayed");
        productSearch.closeDriver();
    }
}