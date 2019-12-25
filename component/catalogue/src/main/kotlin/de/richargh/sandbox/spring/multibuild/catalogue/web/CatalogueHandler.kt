package de.richargh.sandbox.spring.multibuild.catalogue.web

import de.richargh.sandbox.spring.multibuild.catalogue.api.Vegetarian
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse

class CatalogueHandler {

    fun index(request: ServerRequest) =
            ServerResponse.ok().render("catalogue")

    fun availablePizzaTypes(request: ServerRequest) =
            ServerResponse.ok().body(listOf(Vegetarian))
}