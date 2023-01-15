_list = [1, 3, 7, 8, 4, 3, 5, 2, 9, 2]

def g(a, b, x):
    c = 0
    for i in range(a, b + 1):
        if _list[i] <= x:
            c += 1
    return c

def f(a, b, x, k):
    if a == b:
        return _list[a]
    
    mid = (a + b) // 2
    cnt = g(a, mid, x)

    return f(a, mid, x, k) if cnt >= k else f(mid + 1, b, x, k - cnt)

print(f(0,9,5,6))