package de.richargh.sandbox.spring.multibuild.margarita

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class FooController {

    @GetMapping("/sup")
    fun index(): ModelAndView {
        return ModelAndView("factory")
    }

}