def get_counts_dict(lstw):
	dick = {}
	for word in lstw:
		if len(word) in dick:
			dick[len(word)] += 1
		else:
			dick[len(word)] = 1
	return dick
