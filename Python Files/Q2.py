from threading import Thread

balance = 0

def credit(j):
    global balance
    for i in range(j):
        balance +=25
        print(balance)
        
def debit(j):
    global balance
    for i in range(j):
        balance -=25
        print(balance)
        
c = Thread(target=credit, args=(20,))
d = Thread(target=debit, args=(20,))

c.start()
d.start()

c.join()
d.join()

print(balance)
