package de.richargh.sandbox.spring.multibuild.rome

import de.richargh.sandbox.spring.multibuild.catalogue.config.catalogueBeans
import de.richargh.sandbox.spring.multibuild.catalogue.web.CatalogueHandler
import de.richargh.sandbox.spring.multibuild.catalogue.web.catalogueRoutes
import de.richargh.sandbox.spring.multibuild.factory.config.factoryBeans
import de.richargh.sandbox.spring.multibuild.factory.web.FactoryHandler
import de.richargh.sandbox.spring.multibuild.factory.web.factoryRoutes
import de.richargh.sandbox.spring.multibuild.shared_web.config.sharedWebBeans
import org.springframework.boot.WebApplicationType
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.fu.kofu.application
import org.springframework.fu.kofu.webmvc.webMvc

@PropertySource("classpath:application-rome.properties")
class Rome

val app = application(WebApplicationType.SERVLET) {
    sharedWebBeans()
    catalogueBeans()
    factoryBeans()
    webMvc {
        port = 8081
        router {
            catalogueRoutes(CatalogueHandler())
            factoryRoutes(FactoryHandler())
        }
    }
}

fun main(args: Array<String>){
    app.run(args)
}