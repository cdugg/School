import sys
from LinkedList import LinkedList
class HashSet:
    def __init__(self, capacity=10):
        # Create a list to use as the hash table
        self.table = [None] * capacity

    def add(self, item):
        
        x = 0
        # Find the hash code
        h = hash(item)
        index = h % len(self.table)

        # Check is it empty
        if self.table[index] == None:
            self.table[index] = LinkedList() # Need a new linked list for this entry
            x = 1

        if item not in self.table[index]:
            # Only add it if not already there (this is a set)
            self.table[index].add(item)

        if x == 0:
            return (index, self.table[index].head.item)
        else:
            return None

    def average_bucket_length(self):
        total = 0
        index = 0
        count = 0
        for item in self.table:
            if self.table[index] != None:
                total += len(self.table[index])
                count += 1
            index += 1
        return total / count
    
    def min_max_bucket_length(self):
        maximum = 0
        minimum = 0
        index = 0
        for item in self.table:
            if self.table[index] != None:
                if maximum == 0:
                    maximum = len(self.table[index])
                elif maximum < len(self.table[index]):
                    maximum = len(self.table[index])
                if minimum == 0:
                    minimum = len(self.table[index])
                elif minimum > len(self.table[index]):
                    minimum = len(self.table[index])
            index += 1
        return (minimum, maximum)

    def __iter__(self):
        index = 0
        for item in self.table:
            if self.table[index] != None:
                cursor = self.table[index].head
                while cursor is not None:
                    yield cursor.item
                    cursor = cursor.next
            index += 1
