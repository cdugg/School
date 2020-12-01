class Node:
    def __init__(self, item, next):
        self.item = item
        self.next = next

class LinkedList:
    def __init__(self):
        self.head = None

    def add(self, item):
        self.head = Node(item, self.head)

    def remove(self):
        if self.is_empty():
            return None
        else:
            item = self.head.item
            self.head = self.head.next    # remove the item by moving the head pointer
            return item

    def is_empty(self):
        return self.head == None

    def count(self):
        return self.recursivecount(self.head)
    
    def recursivecount(self, ptr):
        count = 0
        if ptr != None:
            return LinkedList.recursivecount(self, ptr.next) + 1
        return count
