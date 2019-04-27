# Elm Binary Rules
load("@com_github_edschouten_rules_elm//elm:def.bzl", "elm_binary", "elm_library")

elm_binary(
    name = "elm",
    main = "Main.elm",
    deps = [":elm-lib"],
)

elm_library(
    name = "elm-lib",
    srcs = ["Main.elm"],
    strip_import_prefix = "web",
    visibility = ["//visibility:public"],
    deps = [
        "@elm_package_elm_browser",
    ],
)

# Docker container Rules

load("@io_bazel_rules_docker//container:container.bzl", "container_image", "container_layer")

container_layer(
    name = "application",
    directory = "/usr/share/nginx/html",
    files = [":minified_output"],
)

container_layer(
    name = "static",
    data_path = ".",
    directory = "/usr/share/nginx/html",
    files = ["index.html"],
)

container_image(
    name = "elm_container_image",
    base = "@nginx_base//image",
    #legacy_run_behavior = False,
    #docker_run_flags  = "-p 8000:80",
    layers = [
        ":application",
        ":static",
    ],
)

#genrule(
#    name = "docker_runner",
#    srcs = [":elm_container_image"],
#    outs = [],
#    cmd = "docker kill $(docker ps -q) && bazel build //web:elm_container_image && docker run -p 8000:80 bazel/web:elm_container_image"
#)

# Custom rule for minifying javascript

genrule(
    name = "minified_output",
    srcs = [":elm"],
    outs = ["elm.min.js"],
    cmd = "uglifyjs $< --compress 'pure_funcs=\"F2,F3,F4,F5,F6,F7,F8,F9,A2,A3,A4,A5,A6,A7,A8,A9\",pure_getters,keep_fargs=false,unsafe_comps,unsafe' | uglifyjs --mangle --output=$@",
)

# Custom rule for running container with iblaze. Not working yet.

load("//:docker_runner.bzl", "docker_runner")

docker_runner(
    name = "docker_runner",
    #deps = [":elm_container_image"]
)
