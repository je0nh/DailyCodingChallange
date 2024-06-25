"""
중앙에서 2, 3, 4 미터 거리의 지점에 좌석이 하나씩
시소의 토크가 같으면 시소짝꿍
"""
def solution(weights):
    w = list(set(weights))
    w_set = sorted(w)
    w_dict = dict.fromkeys(w_set, 0)
    for _ in weights:
        w_dict[_] += 1
        
    cnt = 0
    for _ in w_set:
        if w_dict[_] >= 2:
            cnt += (1 / 2) * w_dict[_] * (w_dict[_] - 1)
                
    n = len(w_set)
    for i in range(n - 1):
        for j in range(i + 1, n):
            if w_set[i] * 2 == w_set[j]:
                cnt += 1 * w_dict.get(w_set[i]) * w_dict.get(w_set[j])
            if w_set[i] * 3 == w_set[j] * 2:
                cnt += 1 * w_dict.get(w_set[i]) * w_dict.get(w_set[j])
            if w_set[i] * 4 == w_set[j] * 3:
                cnt += 1 * w_dict.get(w_set[i]) * w_dict.get(w_set[j])
    return cnt