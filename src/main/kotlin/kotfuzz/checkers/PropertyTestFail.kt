/*
 * Copyright (c) 2016. jk http://stackexchange.com/users/71866/jk
 */

package kotfuzz.checkers

class PropertyTestFail(message : String) : Throwable(message)

fun fail(stimulus : Any): Unit = throw PropertyTestFail("Property test failed on value '${stimulus.toString()}'")
fun fail(vararg stimuli : Any): Unit = throw PropertyTestFail("Property test failed on values '${stimuli.joinToString{it.toString()}}'")