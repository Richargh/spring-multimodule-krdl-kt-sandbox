package de.richargh.sandbox.spring.multibuild.factory.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class FactoryController {

    @GetMapping(Urls.Factory.index)
    fun index(): ModelAndView {
        return ModelAndView("factory")
    }
}

private operator fun ModelAndView.set(key: String, value: Any) = this.addObject(key, value)
