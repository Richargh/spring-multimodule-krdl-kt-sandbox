package de.richargh.sandbox.spring.multibuild.catalogue.web

import de.richargh.sandbox.spring.multibuild.shared_web.Urls
import org.springframework.web.servlet.function.router

fun catalogueRoutes(handler: CatalogueHandler) = router {
    GET(Urls.Catalogue.index, handler::index)
    GET(Urls.Catalogue.availablePizzaTypes, handler::availablePizzaTypes)
}