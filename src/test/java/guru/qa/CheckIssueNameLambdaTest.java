package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckIssueNameLambdaTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    void checkNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () ->{
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").pressEnter();
        });
        step("Кликаем по ссылке " + REPOSITORY, () -> {
            $("a[href*='eroshenkoam/allure-example']").click();
        });
        step("Открываем вкладку Issue", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем название Issue", () -> {
            $("#issue_80_link").shouldHave(Condition.text("e.sh"));
        });
    }

    @Test
    public void testAnnotationStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsChekIssueName steps = new WebStepsChekIssueName();

        steps.openMainPage();
        steps.searhRepository(REPOSITORY);
        steps.clickOnRepositoryLink();
        steps.openIssueTab();
        steps.checkIssueName();
    }
}
