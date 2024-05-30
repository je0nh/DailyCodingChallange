"""
0~9 숫자 일부가 들어있는 정수배열
배열에서 찾을 수 없는 숫자를 더하기
"""
def solution(numbers):
    answer = 0
    
    for i in range(10):
        if i not in numbers:
            answer += i
    return answer