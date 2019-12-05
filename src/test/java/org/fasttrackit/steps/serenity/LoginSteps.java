package org.fasttrackit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.fasttrackit.pages.DashboardPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.junit.Assert;

public class LoginSteps {

    private DashboardPage dashboardPage;
    private HomePage homePage;
    private LoginPage loginPage;

    @Step
    public void navigateToHomepage(){
        homePage.open();
    }

    @Step
    public void goToLogin(){
        homePage.clickAccountLink();
        homePage.clickOnLoginLink();
    }

    @Step
    public void enterCredentials(String email, String pass){
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
    }

    @Step
    public void clickLogin(){
        loginPage.clickLogin();
    }

    @Step
    public void checkLoggedIn(String user){
        Assert.assertTrue(dashboardPage.checkHelloText(user));
    }

    @Step
    public void login(String user, String pass){
        navigateToHomepage();
        goToLogin();
        enterCredentials(user,pass);
        clickLogin();
    }
}
