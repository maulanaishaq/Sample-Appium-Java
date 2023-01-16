package AppiumSuport;

import io.appium.java_client.AppiumDriver;

public abstract class AppiumBaseClass {


    public AppiumDriver driver(){
        return AppiumController.instance.driver;
    }


}
