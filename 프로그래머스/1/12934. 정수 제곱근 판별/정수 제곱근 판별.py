def solution(n):
    answer = -1
    if n ** (1/2) - int(n ** (1/2)) == 0:
        answer = ((n ** (1/2)) + 1) ** 2
    return answer