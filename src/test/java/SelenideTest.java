import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
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


    //SelenideLogger.addListener("allure", new AllureSelenide());
    open("https://github.com");

    $(".header-search-input").click();
    $(".header-search-input").sendKeys("eroshenkoam/allure-example");
    $(".header-search-input").submit();


    $(By.linkText("eroshenkoam/allure-example")).click();
    $("#issues-tab").click();
    $(withText("#80")).should(Condition.exist);
  }


}
