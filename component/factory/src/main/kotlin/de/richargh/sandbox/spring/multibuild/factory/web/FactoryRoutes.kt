package de.richargh.sandbox.spring.multibuild.factory.web

import de.richargh.sandbox.spring.multibuild.shared_web.Urls
import org.springframework.http.MediaType
import org.springframework.web.servlet.function.RouterFunctionDsl
import org.springframework.web.servlet.function.router

fun RouterFunctionDsl.factoryRoutes(handler: FactoryHandler) {
    accept(MediaType.TEXT_HTML).nest {
        GET(Urls.Factory.index, handler::index)
    }
}

