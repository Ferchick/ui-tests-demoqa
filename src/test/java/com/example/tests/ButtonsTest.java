package com.example.tests;

import com.example.pages.ButtonsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Elements")
@Feature("Buttons")
public class ButtonsTest extends BaseTest {

    @Test(description = "Двойной клик по кнопке отображает сообщение")
    @Severity(SeverityLevel.NORMAL)
    public void shouldHandleDoubleClick() {
        var page = new ButtonsPage(driver, wait);
        page.open();
        page.doubleClick();
        Assert.assertTrue(page.doubleClickMessage().contains("double click"),
                "Ожидалось сообщение о двойном клике.");
    }

    @Test(description = "Правый клик по кнопке отображает сообщение")
    @Severity(SeverityLevel.NORMAL)
    public void shouldHandleRightClick() {
        var page = new ButtonsPage(driver, wait);
        page.open();
        page.rightClick();
        Assert.assertTrue(page.rightClickMessage().contains("right click"),
                "Ожидалось сообщение о правом клике.");
    }
}