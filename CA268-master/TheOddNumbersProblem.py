def get_odd_list():
    a = []
    n = int(input())
    while n != -1:
        if n % 2 == 1:
            a.append(n)
        n = int(input())

    return a
