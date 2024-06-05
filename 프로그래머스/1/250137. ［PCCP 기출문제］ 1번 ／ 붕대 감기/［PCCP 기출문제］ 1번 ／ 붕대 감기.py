"""
붕대감기
시전시간 : t 초, 1초마다 x 만큼 체력회복
t 초 연속으로 붕대를 감는데 성공 -> y 추가 체력회복
공격 당하면 기술 취소, 체력 감소, 연속 시간 0초 초기화
0 이하면 체력 회복 x
공격받고 남은 체력 구하기
bandage : [시전시간, 1초 회복량, 추가 회복량]
health : 최대 체력
attack : [[공격시간, 피해량]]
"""
def solution(bandage, health, attacks):
    time = attacks[-1][0]
    attack_dict = {}
    for attack in attacks:
        attack_dict[attack[0]] = attack[1]
    
    max_health = health
    success = 0
    for i in range(1, time+1):
        if attack_dict.get(i):
            print('시간:', i, '초', '(공격당함)')
            health -= attack_dict[i]
            success = 0
            if health < 1:
                return -1
            print('체력:', health, '성공 횟수:', success)
        else:
            print('시간:', i, '초', '(힐)')
            health += bandage[1]
            success += 1
            
            if success == bandage[0]:
                health += bandage[2]
                if health > max_health:
                    health = max_health
                success = 0
                print('체력:', health, '성공 횟수:', success)
                continue
                
            if health > max_health:
                health = max_health
            print('체력:', health, '성공 횟수:', success)
            
                
                
    return health