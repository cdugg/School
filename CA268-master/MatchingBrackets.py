class Stack:
     def __init__(self):
         self.items = []

     def is_empty(self):
         return self.items == []

     def push(self, item):
         self.items.append(item)

     def pop(self):
         return self.items.pop()

     def peek(self):
         return self.items[len(self.items)-1]

     def __len__(self):
         return len(self.items)

def check_brackets(line):
	brackets = {"(":")"}
	openb = Stack()
	closeb = Stack()
	for char in line:
		if char in brackets:
			openb.push(char)
		elif char in brackets.values():
			if len(openb) == len(closeb):
				return False
			closeb.push(char)
	while not openb.is_empty() and not closeb.is_empty():
		openb.pop()
		closeb.pop()
	if openb.is_empty() and closeb.is_empty():
		return True
	return False
