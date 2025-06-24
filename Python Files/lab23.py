def maxNum():
	numbers = [1,2,3,4,5]
	maxNum = lambda numbers:max(numbers)
	print(maxNum(numbers))
	
maxNum()

def mapFunc():
	numbers = [1,2,3,4,5]
	squared = list(map(lambda x: x**2, numbers))
	print(squared)
mapFunc()

def average():
	numbers = [1,2,3,4,5]
	avg = lambda x,y: x/y
	print(avg(sum(numbers),len(numbers)))
average()

