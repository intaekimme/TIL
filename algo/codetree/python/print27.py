def f(a, b):
    return f(b, a % b) + b if b else 0


print(f(21, 34))
print(f(123, 12))
print(f(2021, 4))
print(f(107, 36))
print(f(66, 60))
