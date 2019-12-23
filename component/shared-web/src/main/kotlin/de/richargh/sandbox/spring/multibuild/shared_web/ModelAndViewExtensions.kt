package de.richargh.sandbox.spring.multibuild.shared_web

import org.springframework.web.servlet.ModelAndView

operator fun ModelAndView.set(key: String, value: Any) = this.addObject(key, value)