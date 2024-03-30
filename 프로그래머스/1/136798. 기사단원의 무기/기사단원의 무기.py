# 약수 개수 구하기
def divisor_count(n):
    count = 0
    for i in range(1, int(n**(1/2)) + 1):
        if n % i == 0:
            count += 1
            if i != n // i:
                count += 1
            
    return count

def solution(number, limit, power):
    '''
    기사단 -> 1 ~ number
    기사번호의 약수 개수에 해당하는 공격력을 가진 무기 구매 ==> 약수 계산
    공격력 제한수치 -> 제한수치보다 큰 공격력을 가진 무기를 구매해야하는 기사는 협약기관에서 정한 공격력을 가지는 무기를 구매해야함 ==> 조건절
    공 1 = 철 1kg -> 무기에 필요한 철 계산
    number: 기사단원의 수
    limit: 공격력 제한수치
    power: 공격력 제한수치를 초과한 기사가 사용할 무기의 공격력
    '''
    sum = 0
    for i in range(1, number + 1):
        att = divisor_count(i)
        print(att)
        if att > limit:
            sum += power
        else:
            sum += att
    
    return sum