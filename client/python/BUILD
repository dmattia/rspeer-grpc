py_library(
    name = "Movement",
    srcs = ["Movement.py"],
    deps = [
        "//proto:activity_python_library",
    ],
)

py_library(
    name = "Players",
    srcs = ["Players.py"],
    deps = [
        "//proto:activity_python_library",
    ],
)

py_library(
    name = "Position",
    srcs = ["Position.py"],
    deps = [
        "//proto:activity_python_library",
    ],
)

py_binary(
    name = "Main",
    srcs = ["Main.py"],
    deps = [
        ":Movement",
        ":Position",
        ":Players",
    ],
)
