def print_queue(lst, front, back):
	if back < front:
		for item in lst[front:]:
			print(item)
		for item in lst[:back]:
			print(item)
	else:
		for item in lst[front:back]:
			print(item)
