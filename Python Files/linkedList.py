class LinkedList():
	def __init__(self):
		self.linkedList = []
		
	def isEmpty(self):
	#check isEmpty or not return true/false
		return len(self.linkedList) == 0
		
	def insertHead(self,x):
	#inserts a number at the top of the list
		return self.linkedList.insert(0,x)
		
	def removeHead(self):
	#removes the top element of the list
		return self.linkedList.pop(0)
		
	def insertTail(self,x):
	#adds an element at the end of the list
		return self.linkedList.append(x)
		
	def removeTail(self):
	#removes the final element of the list
		return self.linkedList.pop()
	
	def insertatPos(self,x,y):
	#inserts an element at a specified position and updates the neighboring elements
	#x is position, y is element
		return self.linkedList.insert(x,y)
		
	def traverse(self):
	#prints each element of the list
		return (' '.join(map(str, self.linkedList)))
		
ll1 = LinkedList()
print(ll1.isEmpty())
ll1.insertHead(5)
ll1.insertHead(4)
ll1.insertHead(3)
ll1.insertHead(2)
ll1.insertTail(6)
ll1.insertTail(7)
print(ll1.linkedList)
print(ll1.isEmpty())
ll1.removeTail()
print(ll1.traverse())
ll1.insertatPos(3,12)
print(ll1.linkedList)
print(ll1.traverse())
