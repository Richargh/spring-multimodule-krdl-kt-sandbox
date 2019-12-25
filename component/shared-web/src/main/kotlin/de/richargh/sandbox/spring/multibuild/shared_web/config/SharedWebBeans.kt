package de.richargh.sandbox.spring.multibuild.shared_web.config

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.context.support.beans
//import org.thymeleaf.TemplateEngine
//import org.thymeleaf.spring5.view.ThymeleafViewResolver
//import org.thymeleaf.spring5.SpringTemplateEngine
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun sharedWebBeans() = beans {
    bean { PropertySourcesPlaceholderConfigurer().apply { setPlaceholderPrefix("%{") } }

    bean("messageSource") {
        ReloadableResourceBundleMessageSource().apply {
            setBasename("messages")
            setDefaultEncoding("UTF-8")
        }
    }

//    bean<ClassLoaderTemplateResolver> {
//        val templateResolver = ClassLoaderTemplateResolver()
//        templateResolver.prefix = "mytemplates/"
//        templateResolver.isCacheable = false
//        templateResolver.suffix = ".html"
//        templateResolver.setTemplateMode("HTML5")
//        templateResolver.characterEncoding = "UTF-8"
//
//        templateResolver
//    }
//
//    bean<SpringTemplateEngine> {
//        val templateResolver = ref<ClassLoaderTemplateResolver>()
//
//        val templateEngine = SpringTemplateEngine()
//        templateEngine.setTemplateResolver(templateResolver)
//        templateEngine
//    }
//
//    bean<ThymeleafViewResolver> {
//        val templateEngine = ref<SpringTemplateEngine>()
//
//        val viewResolver = ThymeleafViewResolver()
//        viewResolver.templateEngine = templateEngine
//        viewResolver.characterEncoding = "UTF-8"
//
//        viewResolver
//    }
}