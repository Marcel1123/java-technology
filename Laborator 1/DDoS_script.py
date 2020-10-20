import json
import time
import urllib.request
from datetime import datetime
import threading

l = threading.Semaphore(50)


def threadTask(list, thread_name):
    global l
    req = urllib.request.Request("http://localhost:8080/untitled6_war/hello?letters=eopeersczpvotiebnmt")
    response = urllib.request.urlopen(req)
    response.read().decode()
    start_date = datetime.now()
    with l:
        list += [thread_name + " server responde after:  " + str(datetime.now() - start_date)]
        print(thread_name + " server responde after:  " + str(datetime.now() - start_date))


threads = []
message_list = []
for i in range(0, 50):
    var = threading.Thread(target=threadTask, args=(message_list, "Thread -----> " + str(i)))
    threads.append(var)


for i in threads:
    i.start()
    time.sleep(1)


for i in threads:
    i.start()
    time.sleep(1)