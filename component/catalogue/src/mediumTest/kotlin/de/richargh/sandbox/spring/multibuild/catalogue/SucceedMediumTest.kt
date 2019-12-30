package de.richargh.sandbox.spring.multibuild.catalogue

import de.richargh.sandbox.spring.multibuild.catalogue.builder.CatalogueEntryBuilder
import de.richargh.sandbox.spring.multibuild.catalogue.domain.CatalogueEntry
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SucceedMediumTest {

    @Test
    fun `can say its own name`() {
        // arrange
        val name = "Pineapple"
        val catalogueEntry: CatalogueEntry = CatalogueEntryBuilder().withName(name).build()

        // act
        val actual = catalogueEntry.sayName()

        // assert
        assertEquals(name, actual)
    }
}