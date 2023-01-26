package AppiumSuport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumController {

    public static OS executionOS = OS.ANDROID_EMULATOR;

    public enum OS {
        ANDROID_EMULATOR,
        ANDROID_REAL_DEVICE,
        IOS
    }

    public static AppiumController instance = new AppiumController();

    public AppiumDriver driver;


    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }

        DesiredCapabilities cap = new DesiredCapabilities();

        switch (executionOS){
            case ANDROID_EMULATOR:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/Android");
                File app = new File(appDir, "SauceLabs.apk");
                cap.setCapability("deviceName", "Android_Emulator");
                cap.setCapability("udid", "emulator-5554");
                cap.setCapability("platformName", "Android");
                cap.setCapability("platformVersion", "12");
                cap.setCapability("appium:appPackage", "com.swaglabsmobileapp");
                cap.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
                cap.setCapability("automationName" , "uiautomator2");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                break;
            case ANDROID_REAL_DEVICE:
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app/Android");
                app = new File(appDir, "SauceLabs.apk");
                cap.setCapability("deviceName", "Redmi Note 11");
                cap.setCapability("udid", "3cc067d6");
                cap.setCapability("platformName", "Android");
                cap.setCapability("platformVersion", "12");
                cap.setCapability("appium:appPackage", "com.swaglabsmobileapp");
                cap.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
                cap.setCapability("automationName" , "uiautomator2");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

            case IOS:
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app/iOS/");
                app = new File(appDir, "ContactsSimulator.app");
                cap.setCapability("platformName", "ios");
                cap.setCapability("deviceName", "iPhone 7");
                cap.setCapability("app", app.getAbsolutePath());
                cap.setCapability("automationName", "XCUITest");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                break;

        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }



}
