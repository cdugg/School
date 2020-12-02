class Node:
    def __init__(self, item, left = None, right = None):
        self.item = item
        self.left = left
        self.right = right

class BST:
    def __init__(self):
        self.root = None

    def add(self, item):
        if self.root == None:
            self.root = Node(item, None, None)
        else:
            child_tree = self.root
            while child_tree != None:
                parent = child_tree
                if item < child_tree.item:
                    child_tree = child_tree.left
                else:
                    child_tree = child_tree.right
            if item < parent.item:
                parent.left = Node(item, None, None)
            else:
                parent.right = Node(item, None, None)
                
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
