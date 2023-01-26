package Test;

import AppiumSuport.AppiumBaseClass;
import AppiumSuport.AppiumController;
import PageObjects.LoginPage;
import PageObjects.LoginPageAndroid;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Reporter.log;


public class BaseTestClass extends AppiumBaseClass {

    LoginPageAndroid loginPage;

    @BeforeMethod
    public void setUp() throws Exception{
        AppiumController.instance.start();
        switch (AppiumController.executionOS){
            case ANDROID_EMULATOR:
                loginPage = new LoginPageAndroid(driver());
                break;
            case ANDROID_REAL_DEVICE:
                loginPage = new LoginPageAndroid(driver());
                break;
            case IOS:
                loginPage = new LoginPageAndroid(driver());
                break;

        }
    }

    public void waitFor(int numberOfSeconds) {
        try {
            log("Sleep for " + numberOfSeconds);
            Thread.sleep(numberOfSeconds * 1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(){
        AppiumController.instance.stop();
    }


}