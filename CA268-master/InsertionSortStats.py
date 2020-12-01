def insertion_sort(lst):
    comp = 0
    swap = 0
    for todo in range(1, len(lst)):
        i = todo
        comp += 1
        while i > 0 and lst[i] < lst[i-1]:
            lst[i], lst[i-1] = lst[i-1], lst[i]
            i -= 1
            if i != 0:	
            	comp += 1 
            swap += 1
    return comp, swap
