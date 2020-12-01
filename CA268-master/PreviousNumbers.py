def main():
	print("Enter numbers (-1 to end): ", end="")
	inp = int(input())
	nums = []
	while inp != -1:
		nums.append(inp)
		inp = int(input())
	unique = {}
	for n in nums:
		if n not in unique:
			unique[n] = 1
		else:
			unique[n] += 1
	seen = []
	for n in nums:
		if n not in seen:
			seen.append(n)
		elif unique[n] > 1:
			print((str(n) + " "), end="")
	print()
if __name__ == '__main__':
	main()
