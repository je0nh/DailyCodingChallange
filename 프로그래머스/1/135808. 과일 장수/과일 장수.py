def solution(k, m, score):
    """
    k: 최상품, 1: 최하품
    m: 상자에 사과 개수
    상자 가격 = p(상자속 최하품) * m
    최대 이익계산
    """
    score.sort(reverse=True)
    answer = 0
    boxs = []
    for i in range(m, len(score) + 1, m):
        boxs.append(score[i-m:i])
    
    if len(boxs) != 0:
        for box in boxs:
            answer += box[-1] * m
    return answer