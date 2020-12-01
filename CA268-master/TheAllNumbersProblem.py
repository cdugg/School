def get_evenodd_list():
	n = int(input())
	odd = []
	even = []
	while n != -1:
		if n % 2 == 1:
			odd.append(n)
		else:
			even.append(n)
		n = int(input())
	return (odd, even)
