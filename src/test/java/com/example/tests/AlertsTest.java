package com.example.tests;

import com.example.pages.AlertsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Alerts, Frame & Windows")
@Feature("Alerts")
public class AlertsTest extends BaseTest {

    @Test(description = "Confirm: dismiss выводит корректный результат")
    @Severity(SeverityLevel.MINOR)
    public void shouldDismissConfirm() {
        var page = new AlertsPage(driver, wait);
        page.open();
        page.openConfirmAndDismiss();
        Assert.assertTrue(page.confirmText().toLowerCase().contains("cancelled") ||
                        page.confirmText().toLowerCase().contains("cancel"),
                "Ожидался текст о выборе Cancel.");
    }

    @Test(description = "Prompt: введённый текст отражается в результате")
    @Severity(SeverityLevel.NORMAL)
    public void shouldAcceptPromptWithText() {
        var page = new AlertsPage(driver, wait);
        page.open();
        page.openPromptAndSend("demo");
        Assert.assertTrue(page.promptText().toLowerCase().contains("demo"),
                "Ожидалось отображение введённого текста в результате.");
    }

    @Test(description = "Alert: простой alert принимается без ошибок")
    @Severity(SeverityLevel.MINOR)
    public void shouldAcceptSimpleAlert() {
        var page = new AlertsPage(driver, wait);
        page.open();
        page.openAlertAndAccept();
    }
}