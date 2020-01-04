package de.richargh.sandbox.spring.multibuild.catalogue.application

import de.richargh.sandbox.spring.multibuild.catalogue.domain.CatalogueEntry
import de.richargh.sandbox.spring.multibuild.catalogue.domain.ForSearchingCatalogueEntries

interface ForMutatingCatalogueEntries: ForSearchingCatalogueEntries {
    fun add(catalogueEntry: CatalogueEntry): CatalogueEntry
}