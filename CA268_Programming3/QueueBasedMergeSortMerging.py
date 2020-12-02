from Queue import Queue
def merge(q1, q2, q):
    while q2.linkedlist.head != None or q1.linkedlist.head != None:
        if q2.linkedlist.head == None or (q1.linkedlist.head != None and q1.linkedlist.head.item < q2.linkedlist.head.item):
            q.enqueue(q1.linkedlist.head.item)
            q1.linkedlist.head = q1.linkedlist.head.next
        else:
            q.enqueue(q2.linkedlist.head.item)
            q2.linkedlist.head = q2.linkedlist.head.next
