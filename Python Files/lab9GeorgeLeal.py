import math

inputString1 = "This is a test string"
inputString2 = "...it tests your functions"
inputString3 = "functions"

def findElement(str1,x):
	return str1[x]


def concatStrings(str1,str2):
	return str1+str2

def divideString(str1):
	x = math.floor((len(str1)/2))
	return str1[0:x]

def findSubstring(str1,str2):
	if str2 in str1:
		return True
	else:
		return False

print(findElement(inputString1, 0))
print(concatStrings(inputString1, inputString2))
print(divideString(inputString1))
print(findSubstring(inputString2, inputString3))
print(findSubstring(inputString1, inputString3))
