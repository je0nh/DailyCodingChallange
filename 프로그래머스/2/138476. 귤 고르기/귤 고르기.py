"""
귤 k개를 골라 상자 하나에 담아 판매
귤의 크기가 일정하지 않아 크기별로 분류했을 때 다른 종류의 수를 최소화
"""
def solution(k, tangerine):
    t_uq = list(set(tangerine))
    t_dict = dict.fromkeys(t_uq, 0)
    
    for i in tangerine:
        t_dict[i] += 1
    
    
    t_ls = sorted(list(t_dict.values()), reverse=True)
    answer = 0
    cnt = 0
    for t in t_ls:
        answer += t
        cnt += 1
        if answer >= k:
            return cnt