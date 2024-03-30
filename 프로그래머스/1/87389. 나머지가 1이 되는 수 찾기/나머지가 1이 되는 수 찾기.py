def solution(n):
    """
    n / x -> 나머지가 1이되록하는 가장 작은 자연수 x
    """
    num = 0
    for i in range(1, n):
        if n % i == 1:
            num = i
            break
    
    return num