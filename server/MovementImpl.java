import ajorah.rspeer.MovementServiceGrpc;

import ajorah.rspeer.ToggleRunResponse;
import ajorah.rspeer.ToggleRunRequest;
import ajorah.rspeer.GetRunEnergyRequest;
import ajorah.rspeer.GetRunEnergyResponse;
import ajorah.rspeer.IsRunEnabledRequest;
import ajorah.rspeer.IsRunEnabledResponse;
import ajorah.rspeer.WorldPosition;
import ajorah.rspeer.WalkToResponse;

import io.grpc.stub.StreamObserver;

import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Position;

public class MovementImpl extends MovementServiceGrpc.MovementServiceImplBase {
  @Override
  public void toggleRun(ToggleRunRequest req, StreamObserver<ToggleRunResponse> responseObserver) {
    ToggleRunResponse resp =  ToggleRunResponse.newBuilder()
      .setSuccess(Movement.toggleRun(req.getShouldRun()))
      .build();
    responseObserver.onNext(resp);
    responseObserver.onCompleted();
  }

  @Override
  public void getRunEnergy(GetRunEnergyRequest req, StreamObserver<GetRunEnergyResponse> responseObserver) {
    GetRunEnergyResponse resp = GetRunEnergyResponse.newBuilder()
      .setRunEnergy(Movement.getRunEnergy())
      .build();
    responseObserver.onNext(resp);
    responseObserver.onCompleted();
  }

  @Override
  public void isRunEnabled(IsRunEnabledRequest req, StreamObserver<IsRunEnabledResponse> responseObserver) {
    IsRunEnabledResponse resp = IsRunEnabledResponse.newBuilder()
      .setIsEnabled(Movement.isRunEnabled())
      .build();
    responseObserver.onNext(resp);
    responseObserver.onCompleted();
  }

  @Override
  public void walkTo(WorldPosition worldPos, StreamObserver<WalkToResponse> responseObserver) {
    Position pos = new Position(worldPos.getWorldX(), worldPos.getWorldY(), worldPos.getFloorLevel());
    WalkToResponse resp = WalkToResponse.newBuilder()
      .setSuccess(Movement.walkTo(pos))
      .build();
    responseObserver.onNext(resp);
    responseObserver.onCompleted();
  }
}
