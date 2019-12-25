package de.richargh.sandbox.spring.multibuild.factory.web

import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse

class FactoryHandler {
    fun index(request: ServerRequest) =
            ServerResponse.ok().render("factory")
}
