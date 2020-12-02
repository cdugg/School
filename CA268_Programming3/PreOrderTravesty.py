import sys

class Node:
	""" A node in a BST. It may have left and right subtrees """
	def __init__(self, item, left = None, right = None):
		self.item = item
		self.left = left
		self.right = right

class BST:
	""" An implementation of a Binary Search Tree """
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
		""" Add this item to its correct position on the tree """
		self.root = self.recurse_add(self.root, item)

	def r_count(self, ptr):
		if ptr == None:
			return 0
		else:
			return 1 + self.r_count(ptr.left) + self.r_count(ptr.right)
			
	def count(self): return self.r_count(self.root)

	def r_height(self, ptr):
		if ptr == None:
			return 0
		else:
			return 1 + max(self.r_height(ptr.left), self.r_height(ptr.right))

	def height(self): 
		return self.r_height(self.root)

	def in_order(self):
		self.inorder = []
		self.rec_in_order(self.root, self.inorder)
		print(" ".join(self.inorder)+" ")

	def rec_in_order(self, ptr, inorder):
		if ptr is not None:
			self.rec_in_order(ptr.left, inorder)
			inorder.append(str(ptr.item))
			self.rec_in_order(ptr.right, inorder)

	def pre_order(self):
		self.preorder = [str(self.root.item)]
		self.rec_pre_order(self.root.left, self.preorder)
		self.rec_pre_order(self.root.right, self.preorder)
		print(" ".join(self.preorder)+" ")

	def rec_pre_order(self, ptr, preorder):
		if ptr is not None:
			preorder.append(str(ptr.item))
			self.rec_pre_order(ptr.left, preorder)
			self.rec_pre_order(ptr.right, preorder)
