package de.richargh.sandbox.spring.multibuild.factory.web

import de.richargh.sandbox.spring.multibuild.shared_web.Urls
import org.springframework.web.servlet.function.router

fun factoryRoutes(handler: FactoryHandler) = router {
        GET(Urls.Factory.index, handler::index)
}

