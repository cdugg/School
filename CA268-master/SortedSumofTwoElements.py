def sum_to_k(lst, k):
	i = 0
	j = len(lst)-1
	while i < j and j > i:
		if lst[i] + lst[j] == k:
			return True
		elif lst[i] + lst[j] > k:
			j -= 1
		elif lst[i] + lst[j] < k:
			i += 1
	if lst[i] + lst[j] == k and i != j:
		return True
	else:
		return False
