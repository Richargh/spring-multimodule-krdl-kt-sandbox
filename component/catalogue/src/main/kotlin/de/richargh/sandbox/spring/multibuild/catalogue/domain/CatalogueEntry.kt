package de.richargh.sandbox.spring.multibuild.catalogue.domain

data class CatalogueEntry(private val name: String){
    fun sayName() = name
}