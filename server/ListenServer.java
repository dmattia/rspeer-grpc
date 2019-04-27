import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class ListenServer {
  public void init() {
    // TODO: Add flag for port
    server = ServerBuilder
      .forPort(5004)
      .addService(new MovementImpl())
      .addService(new PlayersImpl())
      .build();
  }

  public void stop() {
    server.shutdown();
  }

  public void start() throws IOException {
    server.start();

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        server.shutdown();
        System.err.println("*** server shut down");
      }
    });
  }

  private Server server;
}
