fun main() {
//creating a user
val user = userProfile("John", 22, "john@example.com")
//calling printuserprofile to print it
user.printUserProfile()
//creating a user with a null for email
val user1 = userProfile("Eve", 23, null)
//calling printuserprofile to print the user
user1.printUserProfile()
}
//creating an immutable class with 3 properties
final class userProfile(val name: String, val age: Int, val email: String?)
{
//creating a function to print the user profile
fun printUserProfile(){
//if the email is null it will print the sentence that was on the instructions
	if(email == null){
	println("Name: $name Age: $age Email: No email provided.")
	}
	//else it will print the email.
	else{
	println("Name: $name Age: $age Email: $email")
	}
}

}

