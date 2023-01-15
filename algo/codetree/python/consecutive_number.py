n1, n2 = tuple(map(int, input().split()))
list_a = list(map(int, input().split()))
list_b = list(map(int, input().split()))

# print(list_a, list_b)


def is_consecutive_number(list_a: list, list_b: list):
    for i in range(len(list_a)):
        if i + len(list_b) > len(list_a):
            return False
        for j in range(len(list_b)):
            if list_a[i] != list_b[j]:
                return False
        return True


if is_consecutive_number(list_a, list_b):
    print("Yes")
else:
    print("No")
