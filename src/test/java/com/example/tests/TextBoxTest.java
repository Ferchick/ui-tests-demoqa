package com.example.tests;

import com.example.pages.TextBoxPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Elements")
@Feature("Text Box")
public class TextBoxTest extends BaseTest {

    @Test(description = "Позитив: валидные данные приводят к отображению блока результата")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ferchick")
    public void shouldSubmitValidData() {
        var page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "ivan.petrov@example.com", "Current", "Permanent");
        Assert.assertTrue(page.isOutputVisible(), "Ожидалось появление блока результатов.");
    }

    @Test(description = "Негатив: невалидный email подсвечивается как ошибка")
    @Severity(SeverityLevel.NORMAL)
    public void shouldHighlightInvalidEmail() {
        var page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "not-an-email", "Current", "Permanent");
        Assert.assertTrue(page.emailFieldClass().contains("error") ||
                        page.emailFieldClass().contains("invalid"),
                "Ожидалась индикация ошибки для поля email.");
    }
}