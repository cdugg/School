class Node:
    def __init__(self, item, left = None, right = None):
        self.item = item
        self.left = left
        self.right = right

class BST:
    def __init__(self):
        self.root = None

    def recurse_add(self, ptr, item):
        if ptr == None:
            return Node(item)
        elif item < ptr.item:
            ptr.left = self.recurse_add(ptr.left, item)
        elif item > ptr.item:
            ptr.right = self.recurse_add(ptr.right, item)
        return ptr
        
    def add(self, item):
        self.root = self.recurse_add(self.root, item)
    def recursive_count(self, ptr, lo, hi):
        if ptr == None:
            return 0
        if ptr.item >= lo and ptr.item <= hi:
            return self.recursive_count(ptr.left, lo, hi) + self.recursive_count(ptr.right, lo, hi) + 1
        else:
            return self.recursive_count(ptr.left, lo, hi) + self.recursive_count(ptr.right, lo, hi)
                
    def count(self, hi, lo):
        return self.recursive_count(self.root, hi, lo)

    def height(self):
        return self.recursive_height(self.root)

    def recursive_height(self, ptr):
        if ptr == None:
            return 0
        else:
            return max(self.recursive_height(ptr.right), self.recursive_height(ptr.left)) + 1
    
    def total(self):
        return self.recursive_total(self.root)

    def recursive_total(self, ptr):
        if ptr == None:
            return 0
        else:
            return self.recursive_total(ptr.right) + self.recursive_total(ptr.left) + ptr.item

    def is_present(self, e):
        return self.recursive_is_present(self.root, e)

    def recursive_is_present(self, ptr, e):
        if ptr == None:
            return False
        if ptr.item == e:
            return True
        else:
            return self.recursive_is_present(ptr.left, e) or self.recursive_is_present(ptr.right, e)

    def count_leaves(self):
        return self.recursive_count_leaves(self.root)

    def recursive_count_leaves(self, ptr):
        if ptr == None:
            return 0
        elif ptr.right == None and ptr.left == None:
            return 1
        else:
            return self.recursive_count_leaves(ptr.right) + self.recursive_count_leaves(ptr.left)
