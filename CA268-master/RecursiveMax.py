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

    def count_even(self):
        return self.recursivecount_even(self.head)
    
    def recursivecount_even(self, ptr):
        count = 0
        if ptr != None:
            if int(ptr.item) % 2 == 0:
                count += LinkedList.recursivecount_even(self, ptr.next) + 1
                return count
            else:
                return LinkedList.recursivecount_even(self, ptr.next)
        return count
    
    def count(self):
        return self.recursivecount(self.head)
    
    def recursivecount(self, ptr):
        count = 0
        if ptr != None:
            return LinkedList.recursivecount_even(self, ptr.next) + 1
        return count

    def is_present(self, e):
        return self.ispresent(self.head, e)

    def ispresent(self, ptr, e):
        if ptr != None:
            if ptr.item == e:
                return True
            return LinkedList.ispresent(self, ptr.next, e)
        return False

    def largest(self):
        return self.largerest(self.head)

    def largerest(self, ptr):
        if ptr != None:
            temp = LinkedList.largerest(self, ptr.next)
            if ptr.next == None:
                return ptr.item
            elif ptr.item > temp:
                return ptr.item
            elif ptr.item < temp:
                return temp
