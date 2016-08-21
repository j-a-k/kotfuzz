/*
 * Copyright (c) 2016. jk http://stackexchange.com/users/71866/jk
 */

package kotfuzz.properties

fun<X,Y> commutative(operator: (X,X) -> Y ) = {x1:X, x2:X -> operator(x1,x2) == operator(x2,x1)  }
fun<X> associative(operator: (X, X) -> X) = {x1:X, x2:X, x3:X -> operator(operator(x1,x2),x3) == operator(x1, operator(x2,x3)) }
fun<X> leftIdentity(id:X, operator: (X, X) -> X) = {x:X -> operator(id, x) == x}
fun<X> rightIdentity(id:X, operator: (X, X) -> X) = {x:X -> operator(x, id) == x}