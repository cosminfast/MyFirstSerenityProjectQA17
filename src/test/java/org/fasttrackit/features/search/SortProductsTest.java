package org.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.serenity.LoginSteps;
import org.fasttrackit.steps.serenity.SortProductsSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SortProductsTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private SortProductsSteps sortProductsSteps;

    @Test
    public void checkSortByPriceFunction(){
        loginSteps.navigateToHomepage();
        sortProductsSteps.searchForProduct("neck");
        sortProductsSteps.sortByPrice();
        sortProductsSteps.checkPriceAscending();
    }
}
