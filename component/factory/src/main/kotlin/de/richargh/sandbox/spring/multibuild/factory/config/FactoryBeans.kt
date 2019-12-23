package de.richargh.sandbox.spring.multibuild.factory.config

import de.richargh.sandbox.spring.multibuild.factory.web.FactoryHandler
import de.richargh.sandbox.spring.multibuild.factory.web.factoryRoutes
import org.springframework.context.support.beans

fun factoryBeans() = beans {
    bean {
        factoryRoutes(FactoryHandler())
    }
}