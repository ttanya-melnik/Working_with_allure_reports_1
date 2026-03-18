import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

  // Метаданные теста (labels, severity, links, owner и т.д.)


  // Способ задать эти метаданные через аннотации (статический, compile-time)
  @Test
  @Feature("Issue в репозитории") // фича (функциональность)
  @Story("Создание Issue") // стори (история)
  @Owner("eroshenkoam") // владелец теста (QA или разработчик)
  @Severity(SeverityLevel.BLOCKER) // серьёзность теста
  @Link(value = "Testing", url = "https://testing.github.com") // ссылка
  @DisplayName("Создание Issue для авторизованного пользователя") // название теста


  public void testStaticLabels() {
  }

  // Способ задать эти метаданные через динамические вызовы Allure API (runtime, гибкий)
  @Test
  public void testDynamicLabels() {
    Allure.getLifecycle().updateTestCase( // обновляет сам тест-кейс
        t -> t.setName("Создание Issue для авторизованного пользователя")
    );
    Allure.feature("Issue в репозитории"); // удобные shortcuts для часто используемых labels
    Allure.story("Создание Issue"); // удобные shortcuts для часто используемых labels
    Allure.label("owner", "eroshenkoam"); // универсальный способ задать любой label
    Allure.label("severity", SeverityLevel.CRITICAL.value()); // универсальный способ задать любой label
    Allure.link("Testing", "https://testing.github.com"); // добавляет ссылку
  }
}
