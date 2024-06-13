"""
a,b == 길이가 같은 배열
각 배열은 자연수
a,b에서 숫자뽑아 두수 곱하기 -> 누적 합
누접 합이 최소로 만들기
"""
def solution(A,B):
    A.sort()
    B.sort(reverse=True)
    
    n = len(A)
    answer = 0
    for i in range(n):
        answer += A[i] * B[i]
    return answer