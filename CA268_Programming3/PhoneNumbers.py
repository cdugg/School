def main():
	print("Enter a name and number, or a name and ? to query (!! to exit)")
	inp = input()
	d = {}
	while inp != "!!":
		inp = inp.strip().split()
		if inp[1] == "?":
			if inp[0] in d:
				print(str(inp[0]) + " has number " + str(d[inp[0]]))
			else:
				print("Sorry, there is no " + str(inp[0]))
		else:
			d[inp[0]] = int(inp[1])
		inp = input()
	print("Bye")

if __name__ == '__main__':
	main()
