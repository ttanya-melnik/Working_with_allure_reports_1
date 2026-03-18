import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SelenideTest {


  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; //  Делаем окно большим, чтобы ничего не съезжало
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически.
  }



  @Test
  public void  testIssueSearch() {


    SelenideLogger.addListener("allure", new AllureSelenide());
    // перешли на сайт gitHub
    // клик на поле ввода
    // ввели название нужного репозитория
    // enter
    // клик на первую ссылку открывшейся страницы
    // клик на issues
    // проверить, что issues '#80'

    open("https://github.com");
    $("[data-target = 'qbsearch-input.inputButtonText']").click();
    $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
    $("#query-builder-test").submit();
    $(By.linkText("eroshenkoam/allure-example")).click();
    // $("#_r_6_--label").click();
    //$(withText("#80")).should(Condition.exist);
  }
}
