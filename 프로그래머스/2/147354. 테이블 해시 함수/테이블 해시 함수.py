"""
테이블 2차원 행렬, 열은 컬럼, 행은 튜플
첫 번쨰 컬럼 -> 기본키
튜플을 col번째 컬럼의 값을 기준으로 오름차순으로 정렬, 동일 기본키인 첫번째 컬럼의 값을 기준으로 내림차순
S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의
모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환
"""
def qsort(arr, col):
    if len(arr) < 2:
        return arr
    
    pivot = arr[0]
    equl = [pivot]
    high = []
    low = []
    for i in range(1, len(arr)):
        if pivot[col - 1] > arr[i][col - 1]:
            low.append(arr[i])
        elif pivot[col - 1] == arr[i][col - 1]:
            equl.append(arr[i])
        else:
            high.append(arr[i])
            
    equl.sort(key=lambda x: x[0], reverse=True)
    return qsort(low, col) + equl + qsort(high, col)

def solution(data, col, row_begin, row_end):
    data = qsort(arr=data, col=col)
    answer = 0
    
    for i in range(row_begin - 1, row_end):
        s = 0
        for d in data[i]:
            s += d % (i + 1)
        answer ^= s
    return answer