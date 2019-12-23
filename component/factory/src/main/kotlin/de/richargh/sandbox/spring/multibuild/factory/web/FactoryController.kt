package de.richargh.sandbox.spring.multibuild.factory.web

import de.richargh.sandbox.spring.multibuild.shared_web.Urls
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
