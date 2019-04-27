import org.rspeer.script.ScriptMeta;
import org.rspeer.script.Script;
import org.rspeer.runetek.api.commons.Time;

import java.io.IOException;

@ScriptMeta(developer = "AjorahAhai", desc = "gRPC server for actions", name = "gRpc Server")
public class ListenScript extends Script {
  ListenServer server;

  @Override
  public void onStart() {
    server = new ListenServer();
    server.init();

    try {
      System.out.println("Started Server...");
      server.start();
    } catch (IOException e) {
      // TODO: Setup logging
      System.err.println("Failed to start server: " + e);
    }
  }

  @Override
  public void onStop() {
    server.stop();
    System.out.println("  Stopping!");
  }

  @Override
  public int loop() {
    return 500;
  }
}
