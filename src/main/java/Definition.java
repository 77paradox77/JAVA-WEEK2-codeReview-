import java.time.LocalDateTime;
import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mDefinition;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private int mId;

  public Definition(String definition) {
    mDefinition = definition;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }


// TEST METHODS FOR DEFINITION FUNCTIONS
  public String getDefinition() {
    return mDefinition;
  }

  public void completeDefinition(){
    mCompleted = true;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static ArrayList<Definition> all() {
    return instances ;
  }

  public int getId(){
    return mId;
  }

  public static Definition find(int id){
    try{
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }

  public static void clear() {

    //METHOD BELOW IS A BUILT IN METHOD
    instances.clear();
  }

}
