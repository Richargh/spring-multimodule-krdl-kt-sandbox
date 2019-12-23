package de.richargh.sandbox.spring.multibuild.catalogue.web

import de.richargh.sandbox.spring.multibuild.catalogue.api.PizzaType
import de.richargh.sandbox.spring.multibuild.catalogue.api.Vegetarian
import de.richargh.sandbox.spring.multibuild.factory.web.Urls
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class CatalogueController {

    @GetMapping(Urls.Catalogue.index)
    fun index(): ModelAndView {
        return ModelAndView("catalogue")
    }

    @GetMapping(Urls.Catalogue.availablePizzaTypes, headers = ["Accept=application/json"])
    fun availablePizzaTypes(): List<PizzaType> {
        // static list, this is just a sandbox after all
        return listOf(Vegetarian)
    }
}

private operator fun ModelAndView.set(key: String, value: Any) = this.addObject(key, value)
