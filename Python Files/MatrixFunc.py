
# Hello Professor, we have done this in our lab already.

arr1 = [[1,2],[3,4]] #initializing arrays 1-3
arr2 = [[0,1],[2,0]]
arr3 = [[0,0],[0,0]]

def matrixAdd(arr1,arr2,arr3):
	col = len(arr1[0]) #this line checks the number of columns
	row = len(arr1) #this line checks the number of rows
	
	for i in range(row):
		for j in range(col):
			arr3[i][j] = arr1[i][j] + arr2[i][j]	
	return arr3
#the nested for loop(9-12) goes through the 1st and 2nd array, adds their values and assigns the sum to arr3.
def matrixAddAsString(arr1, arr2, arr3):
	col = len(arr1[0]) #this line checks the number of columns
	row = len(arr1) #this line checks the number of rows

	for i in range(row):
		for j in range(col):
			arr3[i][j] = str(arr1[i][j]) + str(arr2[i][j])	
	return arr3
#the for loop is the same from 9-12 except they are being added as string which will bring them together instead of adding their values.
print(matrixAdd(arr1,arr2,arr3))
print(matrixAddAsString(arr1,arr2,arr3))
