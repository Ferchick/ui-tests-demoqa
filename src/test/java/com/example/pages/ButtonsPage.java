package com.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage extends BasePage {
    private final By doubleClickBtn = By.id("doubleClickBtn");
    private final By rightClickBtn = By.id("rightClickBtn");
    private final By doubleClickMsg = By.id("doubleClickMessage");
    private final By rightClickMsg = By.id("rightClickMessage");

    public ButtonsPage(WebDriver d, WebDriverWait w) { super(d, w); }

    @Step("Открыть страницу Buttons")
    public void open() { driver.get("https://demoqa.com/buttons"); }

    @Step("Выполнить двойной клик")
    public void doubleClick() {
        new Actions(driver).doubleClick(el(doubleClickBtn)).perform();
    }

    @Step("Выполнить правый клик")
    public void rightClick() {
        new Actions(driver).contextClick(el(rightClickBtn)).perform();
    }

    public String doubleClickMessage() { return el(doubleClickMsg).getText(); }
    public String rightClickMessage() { return el(rightClickMsg).getText(); }
}