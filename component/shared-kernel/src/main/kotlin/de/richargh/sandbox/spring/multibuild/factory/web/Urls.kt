package de.richargh.sandbox.spring.multibuild.factory.web

object Urls {
    object Catalogue {
        const val index = "/catalogue"
        const val availablePizzaTypes = "$index/pizzaTypes"
    }

    object Factory {
        const val index = "/factory"
    }
}
