def partition(lst, lo, hi):

    global comp, moves
    lst[lo], lst[(hi+lo)//2] = lst[(hi+lo)//2], lst[lo]
    part = lo
    moves += 3
    while lo < hi:

        comp += 1
        while lst[lo] <= lst[part] and lo < hi:
            comp += 1
            lo += 1

        comp += 1
        while lst[hi] > lst[part]: # Don't have to check for hi >= 0 cos part is there as a sentinel.
            comp += 1
            hi -= 1

        if lo < hi:
            # Swap the two entries
            lst[hi], lst[lo] = lst[lo], lst[hi]
            moves += 3

    # Swap part into position
    comp += 1
    if lst[part] > lst[hi]: # (this may happen of the array is small (size 2))
        moves += 3
        lst[part], lst[hi] = lst[hi], lst[part]

    return hi

def rec_qsort(lst, lo, hi):
    if lo < hi:
        pivot = partition(lst, lo, hi)
        rec_qsort(lst, lo, pivot - 1)
        rec_qsort(lst, pivot + 1, hi)

def qsort(lst):
    global comp, moves
    comp = 0
    moves = 0
    rec_qsort(lst, 0, len(lst) - 1)
    return comp, moves
