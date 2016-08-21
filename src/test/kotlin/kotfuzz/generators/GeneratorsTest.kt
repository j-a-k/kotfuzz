/*
 * Copyright (c) 2016. jk http://stackexchange.com/users/71866/jk
 */

package kotfuzz.generators

import io.kotlintest.specs.StringSpec

class GeneratorsTest : StringSpec()
{
    init
    {
        "Default seed is 0" { seed == 0L }
        "bools contains true and false" { bools().toSet() == setOf(true, false) }
        "ints contains 0, 1, -1, MAX_VALUE, MIN_VALUE" {
            val expected = setOf(0, 1, -1, Int.MAX_VALUE, Int.MIN_VALUE)
            ints().take(5).toSet().intersect(expected) == expected
        }
        "ints with a range contains only that range" { !ints(1..1).take(100).any { it!= 1 } }

    }


}