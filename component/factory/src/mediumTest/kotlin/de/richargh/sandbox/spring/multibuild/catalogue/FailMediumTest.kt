package de.richargh.sandbox.spring.multibuild.catalogue

import de.richargh.sandbox.spring.multibuild.shared_kernel.excluded
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class FailMediumTest {

    @Tag(excluded)
    @Test
    fun `tests nothing`() {
        // arrange

        // act

        // assert
        fail("expected")
    }
}