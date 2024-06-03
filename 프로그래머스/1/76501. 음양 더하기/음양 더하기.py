"""
absolutes : 정수 절대값
signs : 부호
실제 정수 합 구하기
"""
def solution(absolutes, signs):
    n = len(absolutes)
    sum = 0
    for i in range(n):
        if signs[i] == True:
            sum += absolutes[i]
        else:
            sum -= absolutes[i]
    return sum