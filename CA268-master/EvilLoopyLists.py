def detect_loop(lst):
    ptr = lst.head
    encountered = []
    if ptr != None:
        while ptr.next != None:
            encountered.append(ptr.item)
            ptr = ptr.next
            if ptr.item in encountered:
                return True
    return False
