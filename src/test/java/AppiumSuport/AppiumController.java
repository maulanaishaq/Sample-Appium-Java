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

    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
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
            case ANDROID:
                File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/app/Android");
                File app = new File(appDir, "Calculator.apk");
                cap.setCapability("deviceName", "Redmi Note 11");
                cap.setCapability("udid", "3cc067d6");
                cap.setCapability("platformName", "Android");
                cap.setCapability("platformVersion", "12");
                cap.setCapability("appium:appPackage", "com.swaglabsmobileapp");
                cap.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
                break;
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
