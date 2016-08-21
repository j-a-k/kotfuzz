/*
 * Copyright (c) 2016. jk http://stackexchange.com/users/71866/jk
 */

package kotfuzz.properties

private val indeterminate = true // we only care about properties that fail so we lump indeterminate and true ones together

fun<X> reflexive(relation: (X,X) -> Boolean ) = {x:X -> relation(x,x) }
fun<X> symmetric(relation: (X, X) -> Boolean) = commutative (relation)
fun<X> transitive(relation: (X, X) -> Boolean) = {x1:X, x2:X, x3:X -> if(relation(x1,x2) && relation(x2,x3)) relation(x1,x3) else indeterminate }
