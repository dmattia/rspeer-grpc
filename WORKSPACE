load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

##############################################
########## Maven Dependency Junk #############
##############################################
RULES_JVM_EXTERNAL_TAG = "1.2"
RULES_JVM_EXTERNAL_SHA = "e5c68b87f750309a79f59c2b69ead5c3221ffa54ff9496306937bfa1c9c8c86b"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.google.firebase:firebase-admin:6.8.0",
        "com.google.guava:guava:27.0-jre",
        "com.google.protobuf:protobuf-java:3.7.1",
        "io.grpc:grpc-stub:1.20.0",
        "io.grpc:grpc-protobuf:1.20.0",
    ],
    repositories = [
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
    fetch_sources = True,
)

##############################################
########## Proto Rules, not junk #############
##############################################

http_archive(
    name = "bazel_toolchains",
    sha256 = "4329663fe6c523425ad4d3c989a8ac026b04e1acedeceb56aa4b190fa7f3973c",
    strip_prefix = "bazel-toolchains-bc09b995c137df042bb80a395b73d7ce6f26afbe",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-toolchains/archive/bc09b995c137df042bb80a395b73d7ce6f26afbe.tar.gz",
        "https://github.com/bazelbuild/bazel-toolchains/archive/bc09b995c137df042bb80a395b73d7ce6f26afbe.tar.gz",
    ],
)

http_archive(
    name = "build_stack_rules_proto",
    urls = ["https://github.com/stackb/rules_proto/archive/b0ee0b9a2c3d3a98aafe855f1f933bf464e74e29.tar.gz"],
    sha256 = "e15b267a546a32c663d71850c44fb7efe42365c1e6a8778962cefbee167a981e",
    strip_prefix = "rules_proto-b0ee0b9a2c3d3a98aafe855f1f933bf464e74e29",
)

load("@build_stack_rules_proto//python:deps.bzl", "python_grpc_library")

python_grpc_library()

load("@com_github_grpc_grpc//bazel:grpc_deps.bzl", "grpc_deps")

grpc_deps()

load("@io_bazel_rules_python//python:pip.bzl", "pip_import", "pip_repositories")

pip_repositories()

pip_import(
    name = "protobuf_py_deps",
    requirements = "@build_stack_rules_proto//python/requirements:protobuf.txt",
)

load("@protobuf_py_deps//:requirements.bzl", protobuf_pip_install = "pip_install")

protobuf_pip_install()

pip_import(
    name = "grpc_py_deps",
    requirements = "@build_stack_rules_proto//python:requirements.txt",
)

load("@grpc_py_deps//:requirements.bzl", grpc_pip_install = "pip_install")

grpc_pip_install()

load("@build_stack_rules_proto//:deps.bzl", "io_grpc_grpc_java")

io_grpc_grpc_java()

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories(omit_com_google_protobuf = True)

load("@build_stack_rules_proto//java:deps.bzl", "java_grpc_library")

java_grpc_library()


##############################################
########## Elm Rules, not junk ###############
##############################################

"""
#http_archive(
#    name = "bazel_toolchains",
#    sha256 = "4b1468b254a572dbe134cc1fd7c6eab1618a72acd339749ea343bd8f55c3b7eb",
#    strip_prefix = "bazel-toolchains-d665ccfa3e9c90fa789671bf4ef5f7c19c5715c4",
#    urls = [
#        "https://mirror.bazel.build/github.com/bazelbuild/bazel-toolchains/archive/d665ccfa3e9c90fa789671bf4ef5f7c19c5715c4.tar.gz",
#        "https://github.com/bazelbuild/bazel-toolchains/archive/d665ccfa3e9c90fa789671bf4ef5f7c19c5715c4.tar.gz",
#    ],
#)

http_archive(
    name = "build_bazel_rules_nodejs",
    sha256 = "fb87ed5965cef93188af9a7287511639403f4b0da418961ce6defb9dcf658f51",
    urls = ["https://github.com/bazelbuild/rules_nodejs/releases/download/0.27.7/rules_nodejs-0.27.7.tar.gz"],
)

#http_archive(
#    name = "com_github_edschouten_rules_elm",
#    sha256 = "0b8a4e288ce9fe255074adb07be443cdda3a9fa9667de775b01decb93507a6d7",
#    strip_prefix = "rules_elm-0.3",
#    urls = ["https://github.com/EdSchouten/rules_elm/archive/v0.3.tar.gz"],
#)

http_archive(
    name = "com_github_edschouten_rules_elm",
    sha256 = "f6f1bd1b2e03b2d6b59781e48115126ba14fd8792f4c08229f706c13461beae7",
    strip_prefix = "rules_elm-0.1",
    urls = ["https://github.com/EdSchouten/rules_elm/archive/v0.1.tar.gz"],
)

#load("@com_github_edschouten_rules_elm//elm:deps.bzl", "elm_register_toolchains")

#elm_register_toolchains()

load("@com_github_edschouten_rules_elm//repository:def.bzl", "elm_repository")

elm_repository(
    name = "elm_package_elm_browser",
    sha256 = "c4c3cb453bfe2dfc3a31f1760688d96e82d0bf091e00c99faadb8ed495dff5aa",
    strip_prefix = "browser-1.0.0",
    urls = ["https://github.com/elm/browser/archive/1.0.0.tar.gz"],
)

elm_repository(
    name = "elm_package_elm_core",
    sha256 = "9cfa20b6468b8bfb4f02c6652f43de1dd1c58b328060830ab804964da0417982",
    strip_prefix = "core-1.0.0",
    urls = ["https://github.com/elm/core/archive/1.0.0.tar.gz"],
)

elm_repository(
    name = "elm_package_elm_html",
    sha256 = "73b885e0a3d2f9781b1c9bbcc1ee9ac032f503f5ef46a27da3ba617cebbf6fd8",
    strip_prefix = "html-1.0.0",
    urls = ["https://github.com/elm/html/archive/1.0.0.tar.gz"],
)

elm_repository(
    name = "elm_package_elm_url",
    sha256 = "840e9d45d8a9bd64a7f76421a1de2518e02c7cbea7ed42efd380b4e875e9682b",
    strip_prefix = "url-1.0.0",
    urls = ["https://github.com/elm/url/archive/1.0.0.tar.gz"],
)

elm_repository(
    name = "elm_package_elm_json",
    sha256 = "cbba2f0ea00fc83f5781207a7de1d49f5a1ad6ed3ce578f218060b87a75310bc",
    strip_prefix = "json-1.0.0",
    urls = ["https://github.com/elm/json/archive/1.0.0.tar.gz"],
)

elm_repository(
    name = "elm_package_elm_time",
    sha256 = "e18bca487adec67bfe4043a33b975d81527a7732377050d0421dd86d503c906d",
    strip_prefix = "time-1.0.0",
    urls = ["https://github.com/elm/time/archive/1.0.0.tar.gz"],
)

elm_repository(
    name = "elm_package_elm_virtual_dom",
    sha256 = "5899564798629e91ef95238f8ba7f4d40260d18496b622469d69fc03457aa842",
    strip_prefix = "virtual-dom-1.0.0",
    urls = ["https://github.com/elm/virtual-dom/archive/1.0.0.tar.gz"],
)

#elm_repository(
#    name = "elm_package_tiziano88_elm_protobuf",
#    sha256 = "624d6d1501d701bf04547558d7bc26f7f995493930d7d94854f782aaf9091303",
#    strip_prefix = "elm-protobuf-3.0.0",
#    urls = ["https://github.com/tiziano88/elm-protobuf/archive/3.0.0.tar.gz"],
#)
#elm_repository(
#    name = "elm_package_tiziano88_elm_protobuf",
#    patches = ["@com_github_buildbarn_bb_browser//:patches/com_github_tiziano88_elm_protobuf/bytes.diff"],
#    sha256 = "c4d499949e807e3dc96eaf91335be61e579a1c63f6a400139aba9d46292dc902",
#    strip_prefix = "elm-protobuf-7269bbd2da4740cf9dc85f307e1770050b29411b",
#    urls = ["https://github.com/tiziano88/elm-protobuf/archive/7269bbd2da4740cf9dc85f307e1770050b29411b.tar.gz"],
#)

load("@build_bazel_rules_nodejs//:defs.bzl", "node_repositories")

node_repositories()
"""

##############################################
######### Docker Dependency Junk #############
##############################################

http_archive(
    name = "io_bazel_rules_docker",
    sha256 = "aed1c249d4ec8f703edddf35cbe9dfaca0b5f5ea6e4cd9e83e99f3b0d1136c3d",
    strip_prefix = "rules_docker-0.7.0",
    urls = ["https://github.com/bazelbuild/rules_docker/archive/v0.7.0.tar.gz"],
)

load("@io_bazel_rules_docker//repositories:repositories.bzl", container_repositories = "repositories")

container_repositories()

load("@io_bazel_rules_docker//container:container.bzl", "container_pull")

container_pull(
    name = "nginx_base",
    digest = "sha256:98efe605f61725fd817ea69521b0eeb32bef007af0e3d0aeb6258c6e6fe7fc1a",
    registry = "index.docker.io",
    repository = "library/nginx",
    tag = "1.15.9",
)

# Manually override docker location
load(
    "@io_bazel_rules_docker//toolchains/docker:toolchain.bzl",
    docker_toolchain_configure = "toolchain_configure",
)

docker_toolchain_configure(
    name = "docker_config",
    docker_path = "/usr/local/bin/docker",
)

##############################################
########## npm Dependency Junk ###############
##############################################

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
http_archive(
    name = "build_bazel_rules_nodejs",
    sha256 = "3a3efbf223f6de733475602844ad3a8faa02abda25ab8cfe1d1ed0db134887cf",
    urls = ["https://github.com/bazelbuild/rules_nodejs/releases/download/0.27.12/rules_nodejs-0.27.12.tar.gz"],
)

load("@build_bazel_rules_nodejs//:defs.bzl", "npm_install")
npm_install(
    name = "npm",
    package_json = "//:package.json",
    package_lock_json = "//:package-lock.json",
)

load("@npm//:install_bazel_dependencies.bzl", "install_bazel_dependencies")
install_bazel_dependencies()
