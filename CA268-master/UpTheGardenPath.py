class Node:
    def __init__(self, item, left = None, right = None):
        self.item = item
        self.left = left
        self.right = right

class BST:
    def __init__(self, lst = None):
        self.root = None
        if lst != None:
            for item in lst:
                self.add(item)

    def add(self, item):
        if self.root == None:
            self.root = Node(item, None, None)
        else:
            lst = []
            child_tree = self.root
            while child_tree != None:
                lst.append(child_tree.item)
                parent = child_tree
                if item < child_tree.item:
                    child_tree = child_tree.left
                else:
                    child_tree = child_tree.right
            if item < parent.item:
                parent.left = Node(item, None, None)
            else:
                parent.right = Node(item, None, None)
            lst.reverse()
            return lst
