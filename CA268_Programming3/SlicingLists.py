def get_sliced_lists(a):
    l = []
    l.append(a[:-1])
    l.append(a[1:-1])
    l.append(a[::-1])
    return l
