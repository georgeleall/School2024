lower = int(input("Please enter lower bounds: "))
upper = int(input("Please enter upper bounds: "))

print("\nCelsius Fahrenheit")

for c in range(lower, upper + 1):
    f = (c * (9.0/5.0) + 32)
    print(f"{c:7} {f:10.1f}")
