package de.richargh.sandbox.spring.multibuild.catalogue.builder

import de.richargh.sandbox.spring.multibuild.catalogue.domain.CatalogueEntry

class CatalogueEntryBuilder {

    private var name: String = "Cheese"

    fun build() = CatalogueEntry(
            name)

    fun withName(name: String) = apply { this.name = name }
}