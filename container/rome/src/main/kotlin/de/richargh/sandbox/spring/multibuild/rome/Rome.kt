package de.richargh.sandbox.spring.multibuild.rome

import de.richargh.sandbox.spring.multibuild.catalogue.config.catalogueBeans
import de.richargh.sandbox.spring.multibuild.factory.config.factoryBeans
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication(scanBasePackages = [
    "de.richargh.sandbox.spring.multibuild.catalogue",
    "de.richargh.sandbox.spring.multibuild.factory",

    "de.richargh.sandbox.spring.multibuild.margarita"
])
@PropertySource("classpath:application-rome.properties")
class Rome

fun main(args: Array<String>){
//    val catalogueController = CatalogueController()
//    val factoryController = FactoryController()
    runApplication<Rome>(*args){
        addInitializers(catalogueBeans())
        addInitializers(factoryBeans())
    }
}