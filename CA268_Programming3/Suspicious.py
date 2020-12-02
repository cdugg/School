import sys

a = {line.strip() for line in open(sys.argv[1], "r")}
b = {line.strip() for line in open(sys.argv[2], "r")}
bad = [n for n in a&b]
#bad = " ".join(set(a&b)).split()
bad.sort()
for i in range(1, len(bad)+1):
    print(str(i) + ". " + str(bad[i-1]))
