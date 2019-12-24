package de.richargh.sandbox.spring.multibuild.catalogue.web

import de.richargh.sandbox.spring.multibuild.shared_web.Urls
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.web.servlet.function.RouterFunctionDsl
import org.springframework.web.servlet.function.router

fun RouterFunctionDsl.catalogueRoutes(handler: CatalogueHandler) {
    accept(TEXT_HTML).nest {
        GET(Urls.Catalogue.index, handler::index)
    }
    accept(APPLICATION_JSON).nest {
        GET(Urls.Catalogue.availablePizzaTypes, handler::availablePizzaTypes)
    }
}