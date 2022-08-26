package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepsChekIssueName {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searhRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").pressEnter();
    }

    @Step("Кликаем по ссылке {repo}")
    public void clickOnRepositoryLink() {
        $("a[href*='eroshenkoam/allure-example']").click();
    }

    @Step("Открываем вкладку Issue")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем название Issue")
    public void checkIssueName() {
        $("#issue_80_link").shouldHave(Condition.text("e.sh"));
    }

}
