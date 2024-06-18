"""
절대값이 10의 n제곱
현재 층 수에 버튼에 적혀 있는 값을 더한 층으로 이동
엘리베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0 보다 작으면 이동 x
"""
def solution(storey):
    answer = 0
    while storey > 0:
        print(storey)
        storey, mod = divmod(storey, 10)
        print(mod)
        
        if mod > 5:
            answer += 10 - mod
            storey += 1
        elif mod == 5 and storey % 10 >= 5:
            storey += 1
            answer += mod
        else:
            answer += mod
    return answer