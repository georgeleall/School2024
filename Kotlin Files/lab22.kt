fun main(){
println("Please enter your name: ")
 val name: String? = readLine()

println("Please enter your age: ")
val user = readLine()
val age = user?.toIntOrNull()

val person1 = Person(name, age)
person1.introduce()

val calc1 = Calculator(0,0)
println("1+5")
calc1.add(1,5)
println("5-1")
calc1.subtract(5,1)
println("3x5")
calc1.multiply(3,5)
println("4/2")
calc1.divide(4,2)
println("4/0")
calc1.divide(4,0)
}

class Person(var name: String?, var age: Int?){

fun introduce(){
println("Hello, my name is $name and I am $age years old.")
}

}

class Calculator(var a: Int, var b: Int){

fun add(a: Int, b: Int){
var sum = a+b
println("The sum is: $sum")
}

fun subtract(a: Int, b: Int){
var diff = a-b
println("The difference is: $diff")
}

fun multiply(a: Int, b: Int){
var prod = a*b
println("The product is: $prod")
}

fun divide(a: Int, b: Int){
if (b==0){
println("Can't divide by 0.")
} else{
var quotient = a/b
println("The quotient is: $quotient")
}
}
}
