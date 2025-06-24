import math

class rightTriangle:
	def __init__(self,side1,side2, hyp=None):
		try:
			self.a = float(side1)
			self.b = float(side2)
			if hyp is None:
				self.c = math.sqrt(self.a**2 + self.b**2)
			else:
				self.c=float(hyp)
			
			if (self.a <= 0 or self.b <= 0 or self.c <=0):
				raise ValueError("All sides must be positive.")
			if hyp is not None and abs(self.a**2 +self.b**2-self.c**2) > 0:
				raise ValueError("Invalid right triangle sides.")
		except ValueError as e:
			raise ValueError(f"Invalid input: {e}")
	
	def __str__(self):
	# print triangle with all 3 sides
		return ("Side 1: " + str(self.a) + " Side 2: " + str(self.b) + " Hypotenuse: " + str(self.c))
	
def fetchTriangleDetail(promptText):
	values = input(promptText).split(',')
	return rightTriangle(*values)
		
triangle1 = fetchTriangleDetail("Enter two sides: ")
triangle2 = fetchTriangleDetail("Enter two sides and a hypotenuse: ")
	
#print both triangles
print(triangle1)
print(triangle2)
