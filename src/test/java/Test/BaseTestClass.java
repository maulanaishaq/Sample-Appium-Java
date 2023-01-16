package Test;

import AppiumSuport.AppiumBaseClass;
import AppiumSuport.AppiumController;
import PageObjects.LoginPage;
import PageObjects.LoginPageAndroid;
import org.junit.After;
import org.junit.Before;

public class BaseTestClass extends AppiumBaseClass {

    LoginPage loginPage;

    @Before
    public void setUp() throws Exception{
        AppiumController.instance.start();
        switch (AppiumController.executionOS){
            case ANDROID:
                loginPage = new LoginPageAndroid(driver());
                    break;
            case IOS :
                loginPage = new LoginPageAndroid(driver());
                break;

        }
    }

    @After
    public void tearDown(){
        AppiumController.instance.stop();
    }


}
