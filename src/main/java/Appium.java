import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Appium {
    private URL url;
    private static AppiumDriver appiumDriver;
    private static Appium appium = new Appium();

    private Appium() {}

    public void initAppium(String deviceName, String deviceID, String platformName,
                           String platformVersion, String appPackage, String appActivity){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName",deviceName);
        cap.setCapability("udid",deviceID);
        cap.setCapability("platformName",platformName);
        cap.setCapability("platformVersion",platformVersion);
        cap.setCapability("APP",appPackage);
        cap.setCapability("appActivity",appActivity);

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AppiumDriver<MobileElement>(url,cap);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Appium getInstance(){ return appium;}

    public static AppiumDriver getDriver() {
        return appiumDriver;
    }
}
