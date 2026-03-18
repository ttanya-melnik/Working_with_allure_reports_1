import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AttachmentsTest {


  @Test
  public void testLambdaAttachments() {
    SelenideLogger.addListener("allure", new AllureSelenide());


    //Открывается github.com
    //Берётся page source (полный HTML страницы на момент вызова) через webdriver().driver().source()
    //Этот HTML прикрепляется к шагу как текстовый файл с именем "Source"
    step("Открываем главную страницу", () -> {
      open("https://github.com");
     // attachment("Source", webdriver().driver().source());
    });
  }


  //После открытия страницы вызывается метод takeScreenshot()
  //Он возвращает байты PNG-скриншота
  //Благодаря @Attachment Allure автоматически:
  //прикрепляет его как картинку
  //даёт имя "Скриншот"
  //тип "image/png"
  @Test
  public void testAnnotatedAttachments() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();

    steps.openMainPage();
  //  steps.takeScreenshot();
  }

}
