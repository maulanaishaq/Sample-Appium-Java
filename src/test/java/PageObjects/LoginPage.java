package PageObjects;


public interface LoginPage {


    void inputUsername(String name);

    void inputPassword(String password);

    void clickLogin();

    void assertName(String expectedName);

    boolean isDisplayed(Boolean expected);

    void assertErrorMessage(String expectedErrorMessage);




}
