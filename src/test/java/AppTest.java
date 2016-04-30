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

  // @Test
  // public void wordIsCreatedTest() {
  //   goTo("http://localhost:4567/word-form.vtl");
  //   click("a", withText("Add word"));
  //   fill("#word").with("Apple");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Add a word");
  // }

  // @Test
  // public void wordIsDisplayedTest() {
  //   goTo("http://localhost:4567/words/new");
  //   fill("#define").with("All Words");
  //   submit(".btn");
  //   click("a", withText("Add A New word"));
  //   assertThat(pageSource()).contains(" ");
  // }
}
