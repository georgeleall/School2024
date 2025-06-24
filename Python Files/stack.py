class stack():
	def __init__(self):
		self.list = []

	def push(self,x):
	#insert element into stack
		return self.list.append(x)

	def pop(self):
	#delete 0 index element
		return self.list.pop()

	def isEmpty(self):
	#check isEmpty or not return true/false
		return len(self.list) == 0

	def peek(self):
	#return 0 index element
		return self.list[0]

	def size(self):
	#return length
		return len(self.list)

s1 = stack()
s1.push(2)
s1.push(3)
s1.push(4)
s1.push(5)
s1.push(6)
print(s1.list)
s1.pop()
s1.pop()
print(s1.list)
print(s1.isEmpty())
s1.push(1)
s1.push(7)
print(s1.list)
print(s1.peek())
print(s1.size())
#perform all operations
