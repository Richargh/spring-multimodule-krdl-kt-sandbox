rootProject.name = "spring-multibuild"

include(
        "applications:margarita")

include(
        "components:factory",
        "components:catalogue",
        "components:catalogue_api",
        "components:shared_kernel")

