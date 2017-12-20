import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Util {


    private AndroidDriver androidDriver;

    public Util() throws MalformedURLException {
        File f = new File("src");
        File fs = new File(f, "com.ebay.mobile-3.0.0.19-72-minAPI17.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus5");
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public List<String> getValues(String xpath, int N) {
        List<WebElement> elements = androidDriver.findElements(By.xpath(xpath));
        List<String> values = new ArrayList<String>();

        for (int i = 0; i < N && elements.size() > N; i++) {
            values.add(elements.get(i).getText());
        }
        return values;
    }
}
