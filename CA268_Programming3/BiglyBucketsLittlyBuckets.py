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

    def __iter__(self):
        cursor = self.head
        while cursor is not None:
            yield cursor.item
            cursor = cursor.next

    def recursive_len(self, ptr):
        if ptr == None:
            return 0
        else:
            return 1 + self.recursive_len(ptr.next)

    def __len__(self):
        return self.recursive_len(self.head)

    def recursive_contains(self, ptr, item):
        if ptr == None:
            return False
        else:
            return item == ptr.item or self.recursive_contains(ptr.next)

    def __in__(self, item):
        return recursive_contains(self.head, item)

    def recursive_str(self, ptr):
        if ptr == None:
            return ""
        else:
            return str(ptr.item) + "->" + self.recursive_str(ptr.next)

    def __str__(self):
        return self.recursive_str(self.head)

def main():
    # Read each test case
    line = sys.stdin.readline()
    items = line.strip().split()
    nums = [int(item) for item in items]
    
    # First number is the capacity
    numset = HashSet(nums[0])

    for x in nums[1:]:
        numset.add(x)

    print(numset.min_max_bucket_length())

if __name__ == "__main__":
    main()
