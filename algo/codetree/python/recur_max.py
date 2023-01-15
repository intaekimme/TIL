n = int(input())
list = [0] + list(map(int, input().split()))


def recur(n: int, res: int) -> int:
    if n == 0:
        return res
    if list[n] > res:
        res = list[n]
    return recur(n-1, res)


print(recur(n, 0))
