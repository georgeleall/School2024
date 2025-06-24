from decimal import Decimal, getcontext

def scientificCalculator(operator,a,b,*c):
	return operator(a,b,*c)

def complexNumberAdder(a,b):
#sum of both numbers 
	return a+b
	
def complexPartialAdder(a,b):
#a.real and b.real
	if isinstance(a,complex) and isinstance(b,complex):
		return a.real+b.real
	else:
		return "Please input complex numbers"

def precisionMultiplier(a,b,precision):
	getcontext().prec = precision
	return Decimal(a)*Decimal(b)

num1 = complex(1,2)
num2 = complex(3,4)

addition = scientificCalculator(complexNumberAdder,num1,num2)
partial = scientificCalculator(complexPartialAdder,num1,num2)
precision = scientificCalculator(precisionMultiplier,5.6,9.3,2)


print ("Num 1: ", num1)
print ("Num 2: ", num2)
print("Addition: ", addition)
print("PartialAdder: ", partial)
print("Precision: ", precision)
