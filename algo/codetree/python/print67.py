def f(n):
    if (n < 2):
        return 0
    for d in range(n - 1, 1, -1):
        if n % d == 0:
            return 0
    return 1

print(f(1), f(11), f(21), f(31))