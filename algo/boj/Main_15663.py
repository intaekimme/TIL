# n과 m(9) 15663

from itertools import permutations

n, m = map(int, input().split())
numbers = list(map(int, input().split()))

# Get all permutations of length M
perms = permutations(numbers, m)

# Remove duplicates and sort
perms = set(perms)
perms = sorted(perms)

# Print the result
for perm in perms:
    print(" ".join(str(x) for x in perm))
