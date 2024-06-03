def divisor(num):
    if num == 1:
        return [1]
    
    divs = []
    n = num // 2
    for i in range(1, n + 1):
        div, mod = divmod(num, i) 
        if mod == 0:
            divs.append(div)
            divs.append(i)
    return list(set(divs))

def solution(left, right):
    if right == 1:
        return -1
    
    num_ls = [i for i in range(left, right + 1)]
    div_n = [len(divisor(n)) for n in num_ls]
    
    n = len(num_ls)
    num_sum = 0
    for i in range(n):
        if div_n[i] % 2 == 0:
            num_sum += num_ls[i]
        elif div_n[i] % 2 == 1:
            num_sum -= num_ls[i]
    return num_sum