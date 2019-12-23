package de.richargh.sandbox.spring.multibuild.margarita

import de.richargh.sandbox.spring.multibuild.catalogue.web.CatalogueController
//import de.richargh.sandbox.spring.multibuild.factory.web.FactoryController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication(scanBasePackages = [
    "de.richargh.sandbox.spring.multibuild.catalogue",
    "de.richargh.sandbox.spring.multibuild.factory",

    "de.richargh.sandbox.spring.multibuild.margarita"
])
@PropertySource("classpath:application-margarita.properties")
class Margarita

fun main(args: Array<String>){
    val catalogueController = CatalogueController()
//    val factoryController = FactoryController()
    val applicationContext = runApplication<Margarita>(*args){

    }
    applicationContext.containsBean("CatalogueController")
}