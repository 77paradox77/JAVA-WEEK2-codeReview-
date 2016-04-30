import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
    @After
    public void tearDown() {
      Definition.clear();
    }

// POSSIBILY MAY NOT NEED
  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("Mow the lawn");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithDescription_String() {
    Definition myDefinition = new Definition("Mow the lawn");
    assertEquals("Mow the lawn", myDefinition.getDefinition());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    Definition myDefinition = new Definition("Mow the lawn");
    assertEquals(false, myDefinition.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Definition myDefinition = new Definition("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myDefinition.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("Mow the lawn");
    Definition secondDefinition = new Definition("Buy groceries");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void newId_DefinitionsInstantiateWithAnID_true() {
    Definition myDefinition = new Definition("Mow the lawn");
    assertEquals(Definition.all().size(), myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("Mow the lawn");
    Definition secondDefinition = new Definition("Buy groceries");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(999) == null);
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("Mow the lawn");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }
}
