toDo = "~~~~~~~~~~\n"
cont = True
while cont:
	x = input("Please make a selection:\n    -To add to the to do list type add and press enter\n    -To remove the first item from the to do list type remove and press enter\n    -To display your to do list type show and press enter\n    -To exit the to do list type exit and press enter\n")
	if x == "add":
		ty = input('Is this item a task or and event? ')
		print('Note: do not use ~ when entering details of an event or task.')
		if ty == "event":
			date = input('Please input a date: ')
			start = input('Please input a start time: ')
			location = input('Please input a location: ')
			addition = "Event:\n   -Date: " + date + "\n   -Time: " + start + "\n   -Location: " + location + "\n"
			toDo += addition + "~~~~~~~~~~\n"
		elif ty == "task":
			date = input('Please input a date: ')
			start = input('Please input a start time: ')
			duration = input('Please input a duration: ')
			attendees = input('Please enter all attendees names separated by commas: ')
			addition = "Task:\n   -Date: " + date + "\n   -Time: " + start + "\n   -Duration: " + duration + "\n   -Attendees: " + attendees + "\n"
			toDo += addition + "~~~~~~~~~~\n"
		else:
			print("Invalid selection.")
	elif x == "remove":
		if toDo == "~~~~~~~~~~\n":
			print('To do list is empty.')
		else:
			i = 10
			while toDo[i] != "~":
				i += 1
			toDo = toDo[i:]
	elif x == "show":
		if toDo == "~~~~~~~~~~\n":
			print('To do list is empty.')
		else:
			print(toDo)
	elif x == "exit":
		cont = False
	else:
		print("Invalid selection.")
print('Exiting.')