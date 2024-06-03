"""
부서별 물품 구매 예산 조사
각 부서가 신청한 금액만큼 모두 지원해 줘야함
d : 부서별로 신청한 금액
budget : 예산
return : 최대 몇 개의 부서에 물품을 지원할 수 있는지, 최대한 많은 부서에 물품을 지원
"""
def solution(d, budget):
    d.sort()
    d_index = 0
    for i in range(len(d)):
        sum_d = sum(d[:i+1])
        if sum_d <= budget:
            d_index = i + 1
    return d_index