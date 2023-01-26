package Test;


import org.testng.annotations.Test;

public class LoginTest extends BaseTestClass{


    @Test
    public void loginWithUsernamePasswordValid()  {

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        waitFor(2);
        loginPage.assertName("ADD TO CART");
        loginPage.isDisplayed(true);
    }

    @Test
    public void loginWithLockedUser()  {
        loginPage.inputUsername("locked_out_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        waitFor(2);
        loginPage.assertErrorMessage("Sorry, this user has been locked out.");

    }
    @Test
    public void loginWithProblemUser() {
        loginPage.inputUsername("problem_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        waitFor(2);
        loginPage.assertName("ADD TO CART");
        loginPage.isDisplayed(true);
    }

    @Test
    public void loginWithperformance_glitch_user() {
        loginPage.inputUsername("performance_glitch_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        loginPage.assertErrorMessage("Username and password do not match any user in this service.");
    }
    @Test
    public void loginWithUserNameInvalidAndPasswordValid()  {
        loginPage.inputUsername("Test123");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        loginPage.assertErrorMessage("Username and password do not match any user in this service.");
    }
    @Test
    public void loginWithUserNameValidAndPasswordInvalid()  {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("Test123");
        loginPage.clickLogin();
        loginPage.assertErrorMessage("Username and password do not match any user in this service.");

    }

    @Test
    public void loginWithUserNameInvalidAndPasswordInvalid()  {
        loginPage.inputUsername("Test123");
        loginPage.inputPassword("Test321");
        loginPage.clickLogin();
        loginPage.assertErrorMessage("Username and password do not match any user in this service.");

    }

    @Test
    public void loginWithUserNameAndPasswordEmpty()  {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("");
        loginPage.clickLogin();
        loginPage.assertErrorMessage("Password is required");
    }
    @Test
    public void loginWithUserNameEmptyAndPasswordValid() {
        loginPage.inputUsername("");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        loginPage.assertErrorMessage("Username is required");
    }






}
