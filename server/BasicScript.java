import org.rspeer.script.ScriptMeta;
import org.rspeer.script.Script;

@ScriptMeta(developer = "AjorahAhai", desc = "demo script", name = "Demo")
public class BasicScript extends Script {
  @Override
  public void onStart() {
    System.out.println("onStart");
  }

  @Override
  public void onStop() {
    System.out.println("  Stopping!");
  }

  @Override
  public int loop() {
    System.out.println("  Looping");
    return 500;
  }
}
