import kotlin.math.*

fun main(){
val numbers = listOf(1,2,3,4,5)
val maxnum : () -> Int = {numbers.maxOrNull() ?: 0}
println("The original list is $numbers");
print("The max num is: ");
println(maxnum());


val numbers1 =  listOf(1,2,3,4,5)
val squared = numbers1.map { it * it }
println("The list squared is $squared");

val listlength = numbers.size
val average : () -> Int = {numbers.sum()/listlength}
print("The average is: ")
println(average());



}
