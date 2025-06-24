from queue import Queue
from threading import Thread
from time import sleep

def producer(Queue):
	for i in range(10):
		Queue.put(i)
		#print thread value i
		print(i)
		#sleep for 1 sec
		sleep(1)

def consumer(Queue):
	for i in range(10):
		Queue.get()
		Queue.task_done()
		#print item
		print(i)
		#sleep for 2 secs
		sleep(2)
#initializing queue
Queue=Queue()

#creating threads
p1 = Thread(target=producer, args=(Queue,))
c1 = Thread(target=consumer, args=(Queue,))
#staring threads
p1.start()
c1.start()
#joining threads
p1.join()
c1.join()
