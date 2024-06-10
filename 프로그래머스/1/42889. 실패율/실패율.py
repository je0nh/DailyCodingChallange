"""
신규 사용자와 기존 사용자의 스테이지 차이 극복
동적으로 게임시간 늘려서 난이도 조절
실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
N : 전체 스테이 수
stages : 사용자의 현재 스테이지
실패율이 높은 스테이지 부터 내림차순으로 스테이지의 번호가 담긴 배열을 리턴
"""
def solution(N, stages):
    answer = []
    people = len(stages)
    stage_ls = [i for i in range(1, N + 1)]
    N_fail = []
    for i in stage_ls:
        if people != 0:
            N_fail.append([i, stages.count(i) / people])
        else:
            N_fail.append([i, stages.count(i) / 1])
        people -= stages.count(i)
        
    N_fail.sort(key=lambda x:x[1], reverse=True)
    
    for n in N_fail:
        answer.append(n[0])
    return answer