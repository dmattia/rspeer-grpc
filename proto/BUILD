load("@build_stack_rules_proto//python:python_grpc_library.bzl", "python_grpc_library")
load("@build_stack_rules_proto//java:java_grpc_library.bzl", "java_grpc_library")

proto_library(
  name = "activity_proto",
  srcs = ["activity.proto"],
)

java_grpc_library(
  name = "activity_java_library",
  deps = [":activity_proto"],
  has_services = True,
  visibility = ["//server:__subpackages__"],
)

python_grpc_library(
  name = "activity_python_library",
  deps = [":activity_proto"],
  visibility = ["//client/python:__subpackages__"],
)

