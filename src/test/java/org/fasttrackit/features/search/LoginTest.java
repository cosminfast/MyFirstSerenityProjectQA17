package org.fasttrackit.features.search;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.serenity.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void validLoginTest(){
        loginSteps.navigateToHomepage();
        loginSteps.goToLogin();
        loginSteps.enterCredentials("cosmin@fasttrackit.org","123456");
        loginSteps.clickLogin();
        loginSteps.checkLoggedIn("Hello, McFlono McFlooney Loo!");
    }
}
