fun main() {
//Lines 3-6 ask the user to input an integer and calls the function after converting the input to an integer
    println("Enter a positive integer n:")
    val input = readLine()
    val n = input?.toIntOrNull()
    println("Sum of numbers from 1 to $n: ${sumToN(n ?: 0)}")
    
//Lines 9-11 asks the user to input a string and calls the reverseString function
    println("Please enter a string:")
    val userStr = readLine()
    println("The string reversed is: ${reverseString(userStr ?: "")}")
    
//Lines 12-14 ask the user to input a string and the following line calls the isPalindrome function
    println("Please a word to check if it's a palindrome: ")
    val Str = readLine()
    println("Is $Str a palindrome: ${isPalindrome(Str ?:"")}")
    
//Lines 19-49 ask the user to input a height and width of a rectangle and then checks if the values are null and if they are not then the functions are called.
    println("Please enter the height of a rectangle: ")
    val hei = readLine()
    val height = hei?.toDoubleOrNull()
    
    println("Please enter the width of a rectangle: ")
    val wid = readLine()
    val width = wid?.toDoubleOrNull()
    
    
    if (height != null && width != null) {
    val rec = Rectangle(height,width)
    
    println("Area of rectangle: ${rec.area()}")
    println("Is square: ${rec.isSquare()}")
}

    println("Please enter another height of a rectangle: ")
    val hei1 = readLine()
    val height1 = hei1?.toDoubleOrNull()
    
    println("Please enter another width of a rectangle: ")
    val wid1 = readLine()
    val width1 = wid1?.toDoubleOrNull()

    if (height1 != null && width1 != null) {
    
    val rec1 = Rectangle(height1,width1)
    
    println("The area of this rectangle is ${rec1.area()} and the result of the square test is ${rec1.isSquare()}")
}
}


//This function is to return the sum of whatever number the user inputs, so if the user inputs 5, n will go down to 1 and return 1 since it's the base case and add all the numbers together until it gets there.
fun sumToN(n: Int): Int {
    if (n == 1) {
        return 1
    }
    
    return n + sumToN(n - 1)
}

//reverseString checks if the string is empty, if it is it returns the empty string. If it is not, we used substring to reverse the string.
fun reverseString(s: String): String{
    
    if (s.isEmpty()) {
        return s
    }

return reverseString(s.substring(1)) + s[0]
}
//This function returns true or false if the word equals the word reversed. I just used the built in reversed function.
fun isPalindrome(pali: String) : Boolean{
return pali == pali.reversed()
}
//Created a class that takes in x(height) and y(width). The function area multiples both elements to get the area and isSquare checks if they are equal to check if they are a square.
class Rectangle(val x: Double, val y: Double){

fun area () : Double {
return x*y
} 


fun isSquare () : Boolean{
return x==y
}

}
