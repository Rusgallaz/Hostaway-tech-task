package com.hostaway.steps;

import com.google.inject.Inject;
import com.hostaway.steps.webdriver.UrlSteps;
import com.hostaway.ui.pages.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.hostaway.utils.PropertyUtil.getBaseUrl;

public class MainPageSteps {

    @Inject private UrlSteps urlSteps;
    @Inject private MainPage mainPage;

    @Step("Open main page")
    public MainPageSteps openMainPage() {
        urlSteps.openPath("");
        return this;
    }

    @Step("Click on search button")
    public MainPageSteps clickSearchButton() {
        mainPage.searchButton().shouldBe(visible).click();
        return this;
    }
}
