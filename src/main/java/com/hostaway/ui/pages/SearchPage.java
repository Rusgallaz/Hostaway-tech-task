package com.hostaway.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    public SelenideElement propertiesFoundLabel() {
        return $(byXpath("//h2[contains(.,'properties found')]"));
    }

    public SelenideElement filterButton() {
        return $(byXpath("//button[contains(.,'Filter')]"));
    }

}
