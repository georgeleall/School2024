fun main(){
	bank()
	evenorodd()
	stringlength()
	dayofweek()
}

fun bank(){
println("Please enter a pin number:")
val pin = readLine();
//taking account number and 4 digit pin from user.
println("Your pin is: $pin")
println("Account Balance: $20,000.97")
}

fun evenorodd(){
println("Please enter a number")
val num = readLine();
val number = num?.toIntOrNull()
//checking if it's even or odd, if it == 0, then it's even
if (number == null){
println("Value is invalid.")
}else{
if(number % 2 == 0){
	println("Your number is even.")
} else{
	println("Your number is odd.")
}
}
}

fun stringlength(){
println("Please enter a word: ")

val word = readLine() ?: ""
val wordlength = word.length

println("The length of $word is $wordlength")
}

fun dayofweek(){
println("Please input a number from 1 through 7.")
val user = readLine()
val day = user?.toIntOrNull()

val dayOfweek = when (day){
	1 -> println("Monday")
	2 -> println("Tuesday")
	3 -> println("Wednesday")
	4 -> println("Thursday")
	5 -> println("Friday")
	6 -> println("Saturday")
	7 -> println("Sunday")
	else -> println("Invalid Number")
}
}

