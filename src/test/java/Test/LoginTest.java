package Test;


import org.testng.annotations.Test;

public class LoginTest extends BaseTestClass{


    @Test
    public void loginWithUsernamePasswordValid() throws InterruptedException {

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(200);
        loginPage.assertName("ADD TO CART");
        loginPage.isDisplayed(true);
    }

    @Test
    public void loginWithLockedUser() throws InterruptedException {
        loginPage.inputUsername("locked_out_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.assertErrorMessage("Sorry, this user has been locked out.");

    }
    @Test
    public void loginWithProblemUser() throws InterruptedException {
        loginPage.inputUsername("problem_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.assertName("ADD TO CART");
        loginPage.isDisplayed(true);
    }

    @Test
    public void loginWithperformance_glitch_user() throws InterruptedException {
        loginPage.inputUsername("performance_glitch_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.assertErrorMessage("Username and password do not match any user in this service.");
    }
    @Test
    public void loginWithUserNameInvalidAndPasswordValid() throws InterruptedException {
        loginPage.inputUsername("Test123");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.assertErrorMessage("Username and password do not match any user in this service.");
    }
    @Test
    public void loginWithUserNameValidAndPasswordInvalid() throws InterruptedException {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("Test123");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.assertErrorMessage("Username and password do not match any user in this service.");

    }

    @Test
    public void loginWithUserNameInvalidAndPasswordInvalid() throws InterruptedException {
        loginPage.inputUsername("Test123");
        loginPage.inputPassword("Test321");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.assertErrorMessage("Username and password do not match any user in this service.");

    }

    @Test
    public void loginWithUserNameAndPasswordEmpty() throws InterruptedException {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.assertErrorMessage("Password is required");
    }
    @Test
    public void loginWithUserNameEmptyAndPasswordValid() throws InterruptedException {
        loginPage.inputUsername("");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.assertErrorMessage("Username is required");
    }






}
