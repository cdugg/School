import os
class Task:
	def __init__(self, date, startTime, duration, attendees):
		self.date = date
		self.startTime = startTime
		self.duration = duration
		self.attendees = attendees

	def __str__(self):
		return "Task:\n   -Date: {}\n   -Time: {}\n   -Duration: {}\n   -Attendees: {}\n".format(self.date, self.startTime, self.duration, self.attendees) + "~" * os.get_terminal_size()[0]

class Event:
	def __init__(self, date, startTime, location):
		self.date = date
		self.startTime = startTime
		self.location = location

	def __str__(self):
		return "Event:\n   -Date: {}\n   -Time: {}\n   -Location: {}\n".format(self.date, self.startTime, self.location) + "~" * os.get_terminal_size()[0]

class toDoList:
	def __init__(self):
		self.q = []
	def add(self, item):
		self.q.append(item)
	def remove(self):
		if len(self.q) == 0:
			print('The to do list is empty.')
		else:
			self.q.pop(0)
	def __str__(self):
		if len(self.q) == 0:
			return "To do list is empty."
		send = "To do list:\n"
		for item in self.q:
			send += str(item) + "\n"
		return send.strip()

def startup(toDo):
	try:
		with open("todo.txt", "r") as f:
			for line in f:
				line = line.strip().split("{\/}")
				if line[0] == "event":
					toDo.add(Event(line[1], line[2], line[3]))
				elif line[0] == "task":
					toDo.add(Task(line[1], line[2], line[3], line[4]))
	except FileNotFoundError:
		with open("todo.txt", "w") as f:
			pass

def close(toDo):
	try:
		with open("toDo.txt", "w") as f:
			separate = "{\/}"
			for item in toDo.q:
				if isinstance(item, Event):
					f.write("event{}{}{}{}{}{}\n".format(separate, item.date, separate, item.startTime, separate, item.location))
				else:
					f.write("task{}{}{}{}{}{}{}{}\n".format(separate, item.date, separate, item.startTime, separate, item.duration, separate, item.attendees))
	except:
		print("todo.txt is missing.")

def run(toDo):
	cont = True
	while cont:
		x = input("Please make a selection:\n    -To add to the to do list type add and press enter\n    -To remove the first item from the to do list type remove and press enter\n    -To display your to do list type show and press enter\n    -To exit the to do list type exit and press enter\n").lower()
		if x == "add":
			ty = input('Is this item a task or and event? ').lower()
			if ty == "event":
				date = input('Please input a date: ')
				start = input('Please input a start time: ')
				location = input('Please input a location: ')
				toDo.add(Event(date, start, location))
			elif ty == "task":
				date = input('Please input a date: ')
				start = input('Please input a start time: ')
				duration = input('Please input a duration: ')
				attendees = []
				print("Please input attendees names. Type done when finished.")
				x = input()
				while x != "done":
					attendees.append(x)
					x = input()
				toDo.add(Task(date, start, duration, attendees))
			else:
				print("Invalid selection.")
		elif x == "remove":
			toDo.remove()
		elif x == "show":
			print(toDo)
		elif x == "exit":
			cont = False
		else:
			print("Invalid selection.")

def main():
	toDo = toDoList()
	startup(toDo)
	run(toDo)
	close(toDo)
	print('Exiting.')

if __name__ == '__main__':
	main()