package org.allureHomework.Pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.SelenideElement;

public class SearchPage {
    private static final String REPO_LINK = "janlar00/homework_10_Allure";

    private final SelenideElement repoLink = $(linkText(REPO_LINK));

    public SearchPage repoLinkClick() {
        repoLink.click();
        return this;
    }
}
