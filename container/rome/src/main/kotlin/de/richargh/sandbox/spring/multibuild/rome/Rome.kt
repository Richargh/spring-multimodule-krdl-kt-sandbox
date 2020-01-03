package de.richargh.sandbox.spring.multibuild.rome

import de.richargh.sandbox.spring.multibuild.catalogue.config.catalogueBeans
import de.richargh.sandbox.spring.multibuild.catalogue.web.CatalogueHandler
import de.richargh.sandbox.spring.multibuild.catalogue.web.catalogueRoutes
import de.richargh.sandbox.spring.multibuild.factory.config.factoryBeans
import de.richargh.sandbox.spring.multibuild.factory.web.FactoryHandler
import de.richargh.sandbox.spring.multibuild.factory.web.factoryRoutes
import de.richargh.sandbox.spring.multibuild.shared_web.config.sharedWebBeans
import org.springframework.boot.WebApplicationType
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.logging.LogLevel
import org.springframework.context.annotation.PropertySource
import org.springframework.fu.kofu.application
import org.springframework.fu.kofu.webmvc.mustache
import org.springframework.fu.kofu.webmvc.webMvc
import com.mongodb.client.MongoClients
import de.richargh.sandbox.spring.multibuild.catalogue.domain.CatalogueEntry
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query

@PropertySource("classpath:application-rome.properties")
class Rome

val app = application(WebApplicationType.SERVLET) {
    sharedWebBeans()
    catalogueBeans()
    factoryBeans()

    listener<ApplicationReadyEvent> {
        println("Application Ready")
    }

    logging {
        level = LogLevel.INFO
    }

    webMvc {
        port = 8080
        router {
            catalogueRoutes(CatalogueHandler())
            factoryRoutes(FactoryHandler())
        }
        mustache { }
        converters {
            string()
            resource()
        }
    }
}

fun main(args: Array<String>) {
    val mongoOps = MongoTemplate(MongoClients.create(), "database")
    mongoOps.insert<Any>(CatalogueEntry("Joe"))
    println(mongoOps.findOne(Query(where("name").`is`("Joe")), CatalogueEntry::class.java))
    app.run(args)
}