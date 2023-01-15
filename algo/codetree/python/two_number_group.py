n = int(input())
arr = sorted(list(map(int, input().split())))


def f(arr: list) -> int:
    new_arr = []

    flag = False
    while arr:
        if flag:
            new_arr.append(min(arr))
            arr.pop(arr.index(min(arr)))
            flag = False
        else:
            new_arr.append(max(arr))
            arr.pop(arr.index(max(arr)))
            flag = True

    min_val = 0
    for i in range(0, len(new_arr), 2):
        if min_val < new_arr[i] + new_arr[i + 1]:
            min_val = new_arr[i] + new_arr[i + 1]

    return min_val


print(f(arr))
