def solution(x):
    sum_x = 0
    for i in str(x):
        sum_x += int(i)
    
    answer = False
    if x % sum_x == 0:
        return True
    return answer