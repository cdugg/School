from Stack import Stack
import sys

def reverse_input(stack):
    for line in sys.stdin:
        stack.push(line.strip())
    while not stack.is_empty():
        print(stack.pop())
