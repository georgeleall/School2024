class Discount{

fun applyDiscount(discount: Double): (Double) -> Double {
	return {total: Double -> total - (discount*total)}
	}
}
	
fun main(){
val dscnt = Discount()

val seventyfiveoff = dscnt.applyDiscount(.75)
println(seventyfiveoff(100.00))
}
