from Queue import Queue
def split(q):
    qlen = len(q)
    qlen2 = len(q)
    q2 = Queue()
    q3 = Queue()
    while qlen > qlen2 // 2:
        a = q.dequeue()
        q2.enqueue(a)
        qlen -= 1
    qlen = len(q)
    while qlen > qlen2 // 2:
        a = q.dequeue()
        q3.enqueue(a)
        qlen -= 1
    return (q3, q2)
