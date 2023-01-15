n = int(input())


def recur(n: int) -> int:
    return 2 if n == 1 else 4 if n == 2 else (recur(n - 1) * recur(n - 2)) % 100
    # if n == 1:
    #     return 2
    # if n == 2:
    #     return 4
    # return (recur(n - 1) * recur(n - 2)) % 100


print(recur(n))
