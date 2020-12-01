class Node:
    def __init__(self, item, left = None, right = None):
        self.item = item
        self.left = left
        self.right = right

class BST:
    def __init__(self):
        self.root = None

    def add(self, item):
        """ Add this item to its correct position on the tree """
        # This is a non recursive add method. A recursive method would be cleaner.
        if self.root == None: # ... Empty tree ...
            self.root = Node(item, None, None) # ... so, make this the root
        else:
            # Find where to put the item
            child_tree = self.root
            while child_tree != None:
                parent = child_tree
                if item < child_tree.item:
                    child_tree = child_tree.left
                else:
                    child_tree = child_tree.right

            # child_tree should be pointing to the new node, but we've gone too far
            # we need to modify the parent nodes
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
