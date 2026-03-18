import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

import io.qameta.allure.Step;

public class WebSteps {

  @Step("Открываем главную страницу")
  public void openMainPage() {
    open("https://github.com");
  }

  @Step("Ищем репозиторий {repo}")
  public void searchForRepository(String repo) {
    $("[data-target = 'qbsearch-input.inputButtonText']").click();
    $("#query-builder-test").sendKeys(repo);
    $("#query-builder-test").submit();
  }

  @Step("Кликаем по ссылке репозитория {repo}")
  public void clickOnRepositoryLink(String repo) {
    $(linkText(repo)).click();
  }
}


/* @Step("Открываем таб Issues")
  public void openIssuesTab() {
    $("#issues-tab").click();
  }
   @Step("Проверяем наличие Issue с номером {issue}")
  public void shouldSeeIssueWithNumber(int issue) {
    $(withText("#" + issue)).should(Condition.exist);
  }
   @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
  public byte[] takeScreenshot() {
    return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
} */

