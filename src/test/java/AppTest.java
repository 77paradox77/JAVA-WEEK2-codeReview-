import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Rule;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#phrase").with("Blue");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("View Word List"));
    assertThat(pageSource()).contains("All Words");
  }

  @Test
  public void wordCanBeAddedToWordList() {
    goTo("http://localhost:4567/");
    click("a", withText("View Word List"));
    click("a", withText("Add A New word"));
    assertThat(pageSource()).contains("Add a word");
  }
}
