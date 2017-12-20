import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ProductSearch {
    /**
     * object repository
     */
    private By ebayLogo = By.xpath("//android.widget.ImageView[@resource-id='android:id/home']");
    private By searchTextBox = By.xpath("//android.widget.TextView[@resource-id='com.ebay.mobile:id/home_search_text']");
    private By searchIcon = By.xpath("//android.widget.ImageView[@resource-id='android:id/search_go_btn']");
    private By sortOption = By.xpath("");
    private By customSortOption;
    private By firstResult = By.xpath("");
    private By watchButton = By.xpath("");
    private By signInButton = By.xpath("");
    private By userNameTextBox = By.xpath("");
    private By backButton = By.xpath("");

    private AndroidDriver<AndroidElement> androidDriver;

    public ProductSearch() throws MalformedURLException {
        File f = new File("src");
        File fs = new File(f, "com.ebay.mobile-3.0.0.19-72-minAPI17.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5");
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    /**
     * method to verify the eBay logo
     *
     * @return {@code boolean}
     */
    public boolean isEbayLogoDisplayed() {
        return androidDriver.findElement(ebayLogo).isDisplayed();
    }

    /**
     * method to pass a value to search box
     */
    public void enterProductToSearchTextBox(String productName) {
        androidDriver.findElement(searchTextBox).sendKeys(productName);
    }

    /**
     * method to click on search icon
     */
    public void clickOnSearchIcon() {
        androidDriver.findElement(searchIcon).click();
    }

    /**
     * method for a pause
     *
     * @param milliseconds {@code milliseconds}
     * @throws InterruptedException
     */
    public void waitForElementLoad(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    /**
     * method to close the driver
     */
    public void closeDriver() {
        androidDriver.closeApp();
    }

    /**
     * method to verify search results page
     *
     * @return
     */
    public boolean isSortOptionDisplayed() {
        return androidDriver.findElement(sortOption).isDisplayed();
    }

    /**
     * method to click on sort in the App
     */
    public void clickOnSort() {
        androidDriver.findElement(sortOption).click();
    }

    /**
     * method to click on a option under sort option
     *
     * @param optionToSelect
     */
    public void clickOnCustomOptionUnderSort(String optionToSelect) {
        customSortOption = By.xpath(String.format("text(),'%s'", optionToSelect));
        androidDriver.findElement(customSortOption).click();
    }

    public void clickOnFirstSearchResult() {
        androidDriver.findElement(firstResult).click();
    }

    public boolean isWatchButtonDisplayed() {
        return androidDriver.findElement(watchButton).isDisplayed();
    }

    public void clickOnWatchButton() {
        androidDriver.findElement(watchButton).click();
    }

    public boolean isSignInButtonDisplayed() {
        return androidDriver.findElement(signInButton).isDisplayed();
    }

    public void enterUserName(String userName) {
        androidDriver.findElement(userNameTextBox).sendKeys(userName);
    }

    public void clickOnBackButtonInSignInPage() {
        androidDriver.findElement(backButton).click();
    }
}
