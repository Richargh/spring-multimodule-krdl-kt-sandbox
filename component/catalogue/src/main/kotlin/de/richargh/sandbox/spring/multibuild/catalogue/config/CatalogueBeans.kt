package de.richargh.sandbox.spring.multibuild.catalogue.config

import de.richargh.sandbox.spring.multibuild.catalogue.web.CatalogueHandler
import de.richargh.sandbox.spring.multibuild.catalogue.web.catalogueRoutes
import org.springframework.context.support.beans
import org.springframework.web.servlet.function.router

fun catalogueBeans() = beans {
    bean {
        router { catalogueRoutes(CatalogueHandler()) }
    }
}