class monster:
	def __init__(self, mName, mSize):
		self.mName = mName
		self.mSize = mSize
	
	def attack(self, location):
	#print location
		return (self.mName + " attacks " +location)
	
	def __str__ (self):
	#print name and size
		return ("The monster's name is " + self.mName + " and it's size is " +str(self.mSize)+".")
	
	def __eq__(self, other):
	#compare name with == operator
		if ((self.mName == other.mName) and (self.mSize == other.mSize)):
			return "They are the same"
	
		else: 
			return "They are not the same"

	def __add__ (self,other):
	#print addition ofname and size
		m3name = self.mName + other.mName
		m3size = self.mSize + other.mSize
		return monster(m3name,m3size)
	
obj1 = monster("Test",10)
obj2 = monster("Godzilla", 5)
print(obj1.attack("Canada"))
print(obj1.__str__())
print(obj1.__eq__(obj2))
print(obj1.__add__(obj2))
