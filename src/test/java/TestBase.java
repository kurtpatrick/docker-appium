import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.util.Random;

public class TestBase {

    protected AppiumDriver _driver;
    protected SampleAppPage _pageObject;

    @BeforeTest
    public void testSetup() throws Exception {

        String appPath = "/tmp/apk/sample_apk_debug.apk";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung_galaxy_s6_5.1.1"); //"nexus_5_5.1.1");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        caps.setCapability(MobileCapabilityType.APP, appPath);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        _driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);
        _pageObject = new SampleAppPage(_driver);
    }

    @AfterTest
    public void testTearDown() {
        if(_driver != null) {
            _driver.quit();
        }
    }

    protected static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
