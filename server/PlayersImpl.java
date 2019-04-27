import ajorah.rspeer.PlayersServiceGrpc;

import ajorah.rspeer.GetLocalRequest;
import ajorah.rspeer.AjorahPlayer;
import ajorah.rspeer.WorldPosition;

import io.grpc.stub.StreamObserver;

import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.movement.position.Position;

public class PlayersImpl extends PlayersServiceGrpc.PlayersServiceImplBase {
  @Override
  public void getLocal(GetLocalRequest req, StreamObserver<AjorahPlayer> responseObserver) {
    Player player = Players.getLocal();

    WorldPosition worldPosition = WorldPosition.newBuilder()
      .setWorldX(player.getX())
      .setWorldY(player.getY())
      .setFloorLevel(player.getFloorLevel())
      .build(); 

    AjorahPlayer resp = AjorahPlayer.newBuilder()
      .setName(player.getName())
      .setPosition(worldPosition)
      .setIsMoving(player.isMoving())
      .build();

    responseObserver.onNext(resp);
    responseObserver.onCompleted();
  }
}
