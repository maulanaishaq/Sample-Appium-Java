package Test;

import org.junit.Test;

public class LoginTest extends BaseTestClass{


    @Test
    public void loginWithUsernamePasswordValid() throws InterruptedException {

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(300);
        loginPage.assertName("ADD TO CART");
        loginPage.isDisplayed(true);


    }


}
