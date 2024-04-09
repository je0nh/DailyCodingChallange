def solution(number):
    """
    학생 3명의 정수 번호 더했 -> 0이면 삼총사
    """
    answer = 0
    for i in range(len(number) - 2):
        for j in range(i + 1, len(number) - 1):
            for k in range(j + 1, len(number)):
                if number[i] + number[j] + number[k] == 0:
                    answer += 1
    return answer