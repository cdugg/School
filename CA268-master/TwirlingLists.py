class Node:
    def __init__(self, item, nxt):
        self.item = item
        self.next = nxt

# Note, these are methods "A method is a function that is stored as a class attribute"
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

    def __str__(self):
        tmp_str = ""
        ptr = self.head
        while ptr != None:
            tmp_str += ptr.item + " "
            ptr = ptr.next
        return tmp_str

    def count(self):
        ptr= self.head
        count=0
        while ptr!= None:
            count+=1
            ptr=ptr.next
        return count

    def contains(self,e):
        ptr=self.head
        contain=False
        while ptr!=None:
            if e==ptr.item:
                contain=True
            ptr=ptr.next
        return contain

    def after(self,e):
        ptr=self.head
        while ptr!=None:
            if ptr.item==e:
                return ptr.next.item
            ptr=ptr.next
        return None

    def before(self,e):
        ptr=self.head
        if ptr!=None:
            while ptr.next!=None:
                if ptr.next.item==e:
                    return ptr.item
                ptr=ptr.next
        return None


    def append(self, item):
        ptr=self.head
        if ptr!=None:
            while ptr.next!=None:
                ptr=ptr.next
            ptr.next = Node(item, None)
        else:
            self.add(item)

    def rotate(self):
        first=self.remove()
        self.append(first)
