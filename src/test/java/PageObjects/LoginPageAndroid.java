package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAndroid implements LoginPage{


    public LoginPageAndroid(AppiumDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(accessibility = "test-Username")
    private MobileElement txtUserName;


    @AndroidFindBy(accessibility = "test-Password")
    private MobileElement txtPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView")
    private MobileElement btnLogin;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
    private MobileElement cartButton;

    public void inputUsername(String username){
        txtUserName.sendKeys(username);
    }

    public void inputPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void assertName(String expectedName) {
        Assert.assertEquals(expectedName, cartButton.getText());

    }

    @Override
    public boolean isDisplayed(Boolean expected) {
        Assert.assertEquals(expected, cartButton.isDisplayed());
        return expected;
    }
}
