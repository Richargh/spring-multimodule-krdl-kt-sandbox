package de.richargh.sandbox.spring.multibuild.catalogue

import de.richargh.sandbox.spring.multibuild.catalogue.builder.CatalogueEntryBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class SucceedSmallTest {

    @Test
    fun `can say its own name`() {
        // arrange
        val name = "Pineapple"
        val catalogueEntry = CatalogueEntryBuilder().withName(name).build()

        // act
        val actual = catalogueEntry.sayName()

        // assert
        assertEquals(name, actual)
    }
}