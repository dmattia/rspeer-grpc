from grpc import Channel, insecure_channel
from proto.activity_pb2 import ToggleRunRequest, GetRunEnergyRequest, IsRunEnabledRequest
from proto.activity_pb2_grpc import MovementServiceStub

channel = insecure_channel('localhost:5004')
stub = MovementServiceStub(channel)

def toggle_run(should_run):
    req = ToggleRunRequest(should_run=should_run)
    return stub.ToggleRun(req).success

def get_run_energy():
    return stub.GetRunEnergy(GetRunEnergyRequest()).run_energy

def walk_to(pos):
    return stub.WalkTo(pos).success

def is_run_enabled():
    return stub.IsRunEnabled(IsRunEnabledRequest()).is_enabled
