package com.hostaway.ui.elements.filter;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;

import static org.openqa.selenium.By.xpath;

@AllArgsConstructor
public class RoomBedsFilterElement {

    private SelenideElement root;

    public SelenideElement minusButton() {
        return root.$(xpath(".//button[1]"));
    }

    public SelenideElement plusButton() {
        return root.$(xpath(".//button[2]"));
    }

    public SelenideElement countLabel() {
        return root.$(xpath(".//span"));
    }

}
