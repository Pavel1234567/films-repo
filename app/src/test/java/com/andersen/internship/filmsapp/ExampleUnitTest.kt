package com.andersen.internship.filmsapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val list1 = mutableListOf(1, 2, 3, 4)
        val list2 = list1.toList()
        list1.clear()
        assertTrue(list1.size != list2.size)
    }
}
