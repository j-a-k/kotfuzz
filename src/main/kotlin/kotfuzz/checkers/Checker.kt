/*
 * Copyright (c) 2016. jk http://stackexchange.com/users/71866/jk
 */

package kotfuzz.checkers

fun <A : Any> test(genA: Sequence<A>) = Checker1(genA)
fun <A : Any, B : Any> test(genA: Sequence<A>, genB: Sequence<B>) = Checker2(genA, genB)

class Checker1<out A : Any>(val generator: Sequence<A>)
{
    @JvmOverloads
    fun forAll(count: Int = 100, property: (A) -> Boolean) = generator.take(count).filter { !property(it) }.forEach { fail(it) }
}

class Checker2<out A : Any, out B : Any>(val genA: Sequence<A>, val genB: Sequence<B>)
{
    @JvmOverloads
    fun forAll(count: Int = 100, property: (A, B) -> Boolean) =
            genA.zip(genB).take(count).filter { !property(it.first, it.second) }.forEach { fail(it.first, it.second) }
}