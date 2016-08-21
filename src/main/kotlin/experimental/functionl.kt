/*
 * Copyright (c) 2016. jk http://stackexchange.com/users/71866/jk
 */

package experimental


inline infix fun<T,U> T.pipe(f: (T) -> U): U = f(this)

infix fun<V, T, R> Function1<T, R>.compose(before: (V) -> T): (V) -> R {
    return { v: V -> this(before(v)) }
}

inline infix fun<T, R> Function1<T, R>.ap(value: T) = this(value)

fun<A,B,R> flip(f : (A,B) -> R) = {b:B, a:A -> f(a,b)}

inline fun id(x : Any) = x

