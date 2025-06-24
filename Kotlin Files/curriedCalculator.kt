class curriedCalculator{

fun add(a: Int): (Int) -> Int {
	return {b: Int -> a+b}
	}

fun mult(a: Int): (Int) -> Int {
	return {b: Int -> a*b}
	}
	
fun pow2(a: Int): (Int) -> Int {
	return {a -> a*a}
	}

fun equationSolver(a: Int, b: Int, c: Int): Int{
val additionVar = add(a)
val multiplyVar = mult(b)
val powerVar = pow2(c)

return additionVar(multiplyVar(powerVar(c)))

}
}
fun main(){
val calculator = curriedCalculator()

val add100 = calculator.add(100)
val testOutput = add100(20)
println("the add100 output is $testOutput")

val mult10 = calculator.mult(10)
val testOutputt = mult10(20)
println("the mult10 output is $testOutputt")

val pow2 = calculator.pow2(2)
val testOutputtt = pow2(10)
println("the pow2 output is $testOutputtt")


println(calculator.equationSolver(2,3,4))
}
