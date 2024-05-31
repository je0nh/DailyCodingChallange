"""
price : 원래 이용료
N : 번째 이용한다면 price * N
count번 탔을때 현재 자신이 가진 금액에서 얼마가 모자라는지
"""
def solution(price, money, count):
    sum_money = 0
    for cnt in range(1, count + 1):
        sum_money += price * cnt 
    
    if sum_money > money:
        return sum_money - money
    else:
        return 0