package de.richargh.sandbox.spring.multibuild.catalogue

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(value = ["/catalogue"])
class CatalogueController {

    @GetMapping("/")
    fun index(): ModelAndView {
        return ModelAndView("catalogue")
    }
}

private operator fun ModelAndView.set(key: String, value: Any) = this.addObject(key, value)
