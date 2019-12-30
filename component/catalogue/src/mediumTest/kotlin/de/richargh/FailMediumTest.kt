package de.richargh

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class FailMediumTest {

    @Disabled
    @Test
    fun `tests nothing`() {
        // arrange

        // act

        // assert
        fail("expected")
    }
}