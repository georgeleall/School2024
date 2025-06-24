def evenOdd(a):
	return a % 2

number = int(input("Please enter a number: "))
result = evenOdd(number)
if result == 0:
	print("Your number is even")

else:
	print("Your number is odd")



