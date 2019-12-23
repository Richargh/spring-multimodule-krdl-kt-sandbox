package de.richargh.sandbox.spring.multibuild.factory

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(value = ["/factory"])
class FactoryController {

    @GetMapping("/")
    fun index(): ModelAndView {
        return ModelAndView("factory")
    }
}

private operator fun ModelAndView.set(key: String, value: Any) = this.addObject(key, value)
