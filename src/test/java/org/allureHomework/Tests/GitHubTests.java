package org.allureHomework.Tests;

import static io.qameta.allure.Allure.step;

import org.allureHomework.BaseTest;
import org.allureHomework.Pages.MainPage;
import org.allureHomework.Pages.RepoPage;
import org.allureHomework.Pages.SearchPage;
import org.allureHomework.Steps.WebSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class GitHubTests extends BaseTest {
    private static final String REPONAME = "janlar00/homework_10_Allure";
    private static final String ISSUENAME = "Issues";

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    RepoPage repoPage = new RepoPage();
    WebSteps webSteps = new WebSteps();

    @Test
    @DisplayName("Проверить имя issue – тест Selenide")
    public void checkIssueNameSelenide() {
        mainPage.openPage().searchInputClick().searchInputSetValue(REPONAME).searchInputSubmit();
        searchPage.repoLinkClick();
        repoPage.issueTabClick().checkIssueTitle(ISSUENAME);
    }

    @Test
    @DisplayName("Проверить имя issue – тест с lamda-функцией step")
    public void checkIssueNameWithLambdaSteps() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Ищем репозиторий " + REPONAME, () -> {
            mainPage.searchInputClick().searchInputSetValue(REPONAME).searchInputSubmit();
        });
        step("Кликаем по ссылке репозитория " + REPONAME, () -> {
            searchPage.repoLinkClick();
        });
        step("Кликаем на таб Issues", () -> {
            repoPage.issueTabClick();
        });
        step("Проверяем имя Issue " + ISSUENAME, () -> {
            repoPage.checkIssueTitle(ISSUENAME);
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создать issue")
    @Owner("jan")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Проверить имя issue – тест с аннотацией @Step")
    public void checkIssueNameWithAnnotationStep() {
        webSteps.openMainPage();
        webSteps.searchForRepository(REPONAME);
        webSteps.clickOnRepositoryLink();
        webSteps.openIssuesTab();
        webSteps.checkIssueTitle(ISSUENAME);

    }

}
