import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeOut", 300);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        switch (platformName) {
            case "Android":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3_API_30");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\VANDR\\Desktop\\FirstAppiumProjectMaven\\src\\main\\resources\\ApiDemos-debug.apk");
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                //caps.setCapability("appActivity", "io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");

                AppiumDriver driver = new AndroidDriver(url, caps);
                System.out.println("session id " + driver.getSessionId());

                return new AndroidDriver(url, caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iPhone 11");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\VANDR\\Desktop\\FirstAppiumProjectMaven\\src\\main\\resources\\ApiDemos-debug.apk");
                caps.setCapability("appPackage", "io.appium.android.apis");
                caps.setCapability("appActivity", "io.appium.android.apis.accessibility.CustomViewAccessibilityActivity");
                return new IOSDriver(url, caps);
            default:
                throw new Exception("invalid platform");

        }
    }
}