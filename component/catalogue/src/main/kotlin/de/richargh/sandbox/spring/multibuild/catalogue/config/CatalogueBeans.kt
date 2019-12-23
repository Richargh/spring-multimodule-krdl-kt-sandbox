package de.richargh.sandbox.spring.multibuild.catalogue.config

import de.richargh.sandbox.spring.multibuild.catalogue.web.CatalogueHandler
import de.richargh.sandbox.spring.multibuild.catalogue.web.catalogueRoutes
import org.springframework.context.support.beans

fun catalogueBeans() = beans {
    bean {
        catalogueRoutes(CatalogueHandler())
    }
}