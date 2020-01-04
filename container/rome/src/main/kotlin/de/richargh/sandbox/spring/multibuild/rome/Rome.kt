package de.richargh.sandbox.spring.multibuild.rome

import de.richargh.sandbox.spring.multibuild.catalogue.config.catalogueWebBeans
import de.richargh.sandbox.spring.multibuild.catalogue.web.CatalogueHandler
import de.richargh.sandbox.spring.multibuild.catalogue.web.catalogueRoutes
import de.richargh.sandbox.spring.multibuild.factory.config.factoryAppBeans
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
import de.richargh.sandbox.spring.multibuild.catalogue.application.CatalogueGate
import org.jdbi.v3.core.Jdbi
import javax.sql.DataSource
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import org.apache.tomcat.jni.User.username
import org.springframework.boot.jdbc.DataSourceBuilder





@PropertySource("classpath:application-rome.properties")
class Rome

val app = application(WebApplicationType.SERVLET) {
    sharedWebBeans()

//    catalogueDataBeans()
//    catalogueAppBeans()
//    catalogueWebBeans()

//    factoryAppBeans()

    beans {

        bean<DataSource>{
            val dataSourceBuilder = DataSourceBuilder.create()
            dataSourceBuilder.driverClassName("org.h2.Driver")
            dataSourceBuilder.url("jdbc:h2:mem:test")
            dataSourceBuilder.username("SA")
            dataSourceBuilder.password("")

            dataSourceBuilder.build()
        }

        bean {
            val ds = ref<DataSource>()
            val proxy = TransactionAwareDataSourceProxy(ds)

            Jdbi.create(proxy)
        }
    }

    listener<ApplicationReadyEvent> {
        val jdbi = ref<Jdbi>()
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
//    val mongoOps = MongoTemplate(MongoClients.create(), "database")
//    mongoOps.insert<Any>(CatalogueEntry("Joe"))
//    println(mongoOps.findOne(Query(where("name").`is`("Joe")), CatalogueEntry::class.java))
    app.run(args)
}