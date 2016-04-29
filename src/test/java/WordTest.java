import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.clear();
    Definition.clear();
  }

  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Home");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getName_wordInstantiatesCorrectly_Home() {
    Word testWord = new Word("Home");
    assertEquals("Home", testWord.getName());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
      Word firstWord = new Word("Home");
      Word secondWord = new Word("Work");
      assertTrue(Word.all().contains(firstWord));
      assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_emptiesAllCategoriesFromList_0() {
    Word testWord = new Word("Home");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnWordWithSameId_secondWord() {
    Word firstWord = new Word("Home");
    Word secondWord = new Word("Work");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyList_ArrayList(){
    Word testWord = new Word("Home");
    assertEquals(0, testWord.getDefinitions().size());
  }

  @Test
  public void addDefinition_addsDefinitionToList_true(){
    Word testWord = new Word("Home");
    Definition testDefinition = new Definition("Mow the lawn");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }



}
