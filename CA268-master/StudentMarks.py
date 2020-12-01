import sys
def make_map():
	d = {}
	for line in sys.stdin.read().split("\n"):
		if len(line) > 0:
			line = line.strip().split()
			d[line[0]] = line[-1]
	return d
