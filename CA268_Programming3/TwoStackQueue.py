from Stack import Stack
class Queue:
    def __init__(self):
      self.enq = Stack()
      self.deq = Stack()

    def isempty(self):
      return self.enq.isempty() and self.deq.isempty()

    def enqueue(self, item):
      return self.enq.push(item)

    def dequeue(self):
      while not self.enq.isempty():
         s = self.enq.pop()
         self.deq.push(s)
      s = self.deq.pop()
      while not self.deq.isempty():
         self.enq.push(self.deq.pop())
      return s
