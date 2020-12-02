def get_counts(lstw):
	count = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	for word in lstw:
		count[len(word)] += 1
	return count
