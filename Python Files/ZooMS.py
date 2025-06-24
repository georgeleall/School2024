Animals = [
    {'name': 'Lion', 'species': 'Mammal', 'legs': 4, 'habitat': 'Grassland'},
    {'name': 'Shark', 'species': 'Fish', 'legs': 0, 'habitat': 'Ocean'},
        {'name': 'Spider', 'species': 'arachnid', 'legs': 8, 'habitat': 'Rainforest'}
]#I listed the animals in a dictionary

for animal in Animals:
	print(animal) #used a for loop to go through each of the animals in the dictionary and printed their details.

for animal in Animals:
    if animal['legs'] == 0:
        print(animal['name'], ": No legs - Snake or Fish")
    if animal['legs'] == 2:
        print(animal['name'], ": Two legs - Bird or Human")
    if animal['legs'] == 4:
        print(animal['name'], ": Four legs - Mammal or Reptile")
    if animal['legs'] > 4:
        print(animal['name'], ": More than four legs - Insect or Spider") #this for loop determines what species each animal is.

