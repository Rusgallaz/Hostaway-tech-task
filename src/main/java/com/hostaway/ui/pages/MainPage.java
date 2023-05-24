package com.hostaway.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement searchButton() {
        return $(byXpath("//button[contains(.,'Search')]"));
    }
}
