/*
 * Copyright (c) 2016. jk http://stackexchange.com/users/71866/jk
 */

package kotfuzz.generators


import java.util.Random


var seed : Long = 0
    get() = field
    set(seed)
    {
        prng.setSeed(seed)
        field = seed
    }

private val prng = Random(seed)

fun bools() = sequenceOf(true, false)

@JvmOverloads
fun ints(range: ClosedRange<Int> = Int.MIN_VALUE..Int.MAX_VALUE) : Sequence<Int>
{
    val common = sequenceOf(0, 1, -1, Int.MAX_VALUE, Int.MIN_VALUE)
    val random = generateSequence { prng.longs(range.start.toLong(), (range.endInclusive.toLong()+1L)).iterator().nextLong().toInt()}
    return common.plus(random).filter { it in range }
}

@JvmOverloads
fun doubles(range: ClosedRange<Double> = Double.NaN..Double.NaN) : Sequence<Double>
{
    val common = sequenceOf(0.0, 1.0, -1.0, Double.MAX_VALUE, -Double.MAX_VALUE, Double.MIN_VALUE, -Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)
    val r = if ((range.endInclusive + 1.0 - range.start).isFinite()) range else 1e-300..1e300
    val random = generateSequence { prng.doubles(r.start, r.endInclusive +1).iterator().nextDouble()  }
    if (range.start.isNaN() && range.endInclusive.isNaN() )
    {

        return common + random
    }
    return (common + random).filter { it in range }

}

fun strings()
{
    val common = sequenceOf("0123456789", "abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "!£$%^&*", "{}()[]", ",.;:'?/#" )

    fun permuteStrings(n : Int) = ""

    tailrec fun genStrings(n : Int, acc : Sequence<String>) : Sequence<String> =
        when (n)
        {
            0 -> acc
            else -> genStrings(n-1, acc + permuteStrings(n) )
        }

    genStrings(10, sequenceOf(""))

}
