package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private MobileElement txtErrorMessage;

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


    public boolean isDisplayed(Boolean expected) {
        Assert.assertEquals(expected.booleanValue(), cartButton.isDisplayed());
        return expected;
    }


    public void assertErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, txtErrorMessage.getText());
    }
}
