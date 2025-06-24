fun main(){
//part 1 - works 
val addFunResult = mathOperation(5, 3, ::add)
println(addFunResult)

val subFunResult = mathOperation(5,3, ::subtract)
println(subFunResult)

val mutliplyFunResult = mathOperation(5,3, ::multiply)
println(mutliplyFunResult)

//part 2 - works
val addFunction = mathOperation(::add)
val addResult = addFunction(1,2)
println(addResult)

val subFunction = mathOperation(::subtract)
val subResult = subFunction(5,3)
println(subResult)

val multiplyFunction = mathOperation(::multiply)
val mpResult = multiplyFunction(5,5)
println(mpResult)
}

fun mathOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int{
return operation(a,b)
}

//part 2
fun mathOperation(operation: (Int, Int) -> Int): (Int, Int) -> Int {
    return operation
}

fun add(a: Int, b: Int): Int {
return a+b

}
fun subtract(a: Int, b: Int): Int {
return a-b
}

fun multiply(a: Int, b: Int): Int {
return a*b
}


