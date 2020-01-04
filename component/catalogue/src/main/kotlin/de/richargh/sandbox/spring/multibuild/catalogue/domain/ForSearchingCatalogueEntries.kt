package de.richargh.sandbox.spring.multibuild.catalogue.domain

interface ForSearchingCatalogueEntries {
    fun count(): Long
    fun findAll(): MutableList<CatalogueEntry>
}