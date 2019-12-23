rootProject.name = "spring-multibuild"

include(
        "container:rome")

include(
        "component:factory",
        "component:catalogue",
        "component:catalogue-api",
        "component:shared-web",
        "component:shared-kernel")
