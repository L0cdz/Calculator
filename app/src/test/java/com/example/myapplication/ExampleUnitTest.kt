package com.example.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun testResultMath1() {
        // Arrange
        val input = "100+2"
        val expectedResult = "102"

        // Act
        val result = MainActivity().resultMath(input)

        // Assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun testResultMath2() {
        // Arrange
        val input = "-3-3"
        val expectedResult = "-6"

        // Act
        val result = MainActivity().resultMath(input)

        // Assert
        assertEquals(expectedResult, result)
    }
}
