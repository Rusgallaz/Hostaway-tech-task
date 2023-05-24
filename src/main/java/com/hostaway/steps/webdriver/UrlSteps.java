package com.hostaway.steps.webdriver;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.hostaway.utils.PropertyUtil.getBaseUrl;

public class UrlSteps {

    @Step("Open path `{path}`")
    public UrlSteps openPath(String path) {
        open(getBaseUrl() + path);
        return this;
    }

    @Step("Check url `{path}`")
    public UrlSteps checkPath(String path) {
        webdriver().shouldHave(url(getBaseUrl() + path));
        return this;
    }
}
