import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StepsTest {
  private static final String REPOSITORY = "eroshenkoam/allure-example";
  // private static final int ISSUE = 80;


  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; //  Делаем окно большим, чтобы ничего не съезжало
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически.
  }


  @Test
  public void testLambdaStep() {

    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () -> {
      open("https://github.com");
    });
    step("Ищем репозиторий " + REPOSITORY, () -> {
      $("[data-target = 'qbsearch-input.inputButtonText']").click();
      $("#query-builder-test").sendKeys(REPOSITORY);
      $("#query-builder-test").submit();
    });
    step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
      $(linkText(REPOSITORY)).click();
    });


    //step("Открываем таб Issues", () -> {
    // $("#issues-tab").click(); });
    //step("Проверяем наличие Issue с номером " + ISSUE, () -> {
    //$(withText("#" + ISSUE)).should(Condition.exist); });


    }

  }


