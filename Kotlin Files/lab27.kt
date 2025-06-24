class StringUtil(){

	fun concatenate(str1: String, str2: String): String {
	return str1+str2
	}
	
	fun reverse(str:String): String {
	return str.reversed()
	}
	
	//same way create uppercase and empty function

	fun upper(str:String): String {
	return str.uppercase()
	}
	
	fun isEmpty(str: String): Boolean{
	return str.isEmpty()
	}
}
fun main(){

	val instance = StringUtil()
	println(instance.concatenate("Kinnari","CS"))
	println(instance.reverse("Hello"))
	println(instance.upper("hello"))
	println(instance.isEmpty("hello"))

}

