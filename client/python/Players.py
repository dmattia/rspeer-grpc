from grpc import Channel, insecure_channel
from proto.activity_pb2 import GetLocalRequest
from proto.activity_pb2_grpc import PlayersServiceStub

channel = insecure_channel('localhost:5004')
stub = PlayersServiceStub(channel)

def get_local():
    #return stub.GetLocal(GetLocalRequest())
    player = stub.GetLocal(GetLocalRequest())
    print(player)
    return player
