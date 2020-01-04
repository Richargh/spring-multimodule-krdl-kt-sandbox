package de.richargh.sandbox.spring.multibuild.catalogue.config

import de.richargh.sandbox.spring.multibuild.catalogue.application.CatalogueGate
import de.richargh.sandbox.spring.multibuild.catalogue.web.CatalogueHandler
import de.richargh.sandbox.spring.multibuild.catalogue.web.catalogueRoutes
import org.springframework.context.support.beans
import org.springframework.web.servlet.function.router

fun catalogueAppBeans() = beans {
    bean<CatalogueGate>()
}

fun catalogueWebBeans() = beans {
}

fun catalogueDataBeans() = beans {
//    bean<SpringCatalogueEntries>()
}