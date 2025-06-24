def add(x,y,z):	#Creating add function
	return x+y+z

def subtract(x,y,z): #creating subtract function
	return z-y-x

def divide(x,y): #creating divide function
	if y==0: #if y=0, we will return denom is invalid so we dont get an error.
		return "This denominator is invalid";	
	
	else:
		return x/y
	
def multiply(x,y): #creating multiply function
	return x*y
	
x = 3 #lines 17-19 we are initializing variables
y = 4
z = 5

print(divide(multiply(add(x, y, z), x), x)) #we are printing the results of the code in 21-22
print(multiply(subtract(x, y, z), y))
