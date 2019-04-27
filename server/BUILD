java_binary(
    name = "ServerScriptMain",
    main_class = "org.rspeer.Application",
    runtime_deps = [":ServerScript"],
)

java_library(
    name = "ServerScript",
    srcs = glob(["**/*.java"]),
    deps = [
        "//:rspeer",
        ":grpc",
        "//proto:activity_java_library",
    ],
)

java_library(
    name = "grpc",
    exports = [
        "@io_grpc_grpc_java//netty",
        "@io_grpc_grpc_java//core",
        "@io_grpc_grpc_java//stub",
    ],
)
