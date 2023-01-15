def f(x, y):
    if x == 0:
        return 0
    return f(x // 3, y * 3) + x % 3 * y


print(f(215, 5))
