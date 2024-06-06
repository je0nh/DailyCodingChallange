import math
def devision(n):
    sum_div = []
    for i in range(1, math.ceil(n / 2) + 1):
        div, mod = divmod(n, i)
        
        if mod == 0:
            sum_div.append(div)
            sum_div.append(i)
    return list(set(sum_div))
            

def solution(n):
    answer = sum(devision(n))
    return answer