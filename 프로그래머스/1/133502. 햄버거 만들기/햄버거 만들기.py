"""
상수는 빵 -> 야채 -> 고기 -> 빵
상수 : [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]
[야채, 빵, 빵, 야채, 고기, 빵] 일때 [빵, 야채, 고기, 빵] 가능 -> [야채, 빵]
[야채, 빵, 야채, 고기, 빵] 일때 [빵, 야채, 고기, 빵] 가능 -> [야채]

1: 빵
2: 야채
3: 고기
"""

def solution(ingredient):
#     cnt = 0
#     n = len(ingredient)
#     i = 4
#     burger = [1, 2, 3, 1]
    
#     while i != n:
#         if ingredient[i - 4 : i] == burger:
#             del ingredient[i - 4 : i]
#             i -= 4
#             cnt += 1
#         else:
#             i += 1
                
#     return cnt

    burger_stack = []
    n = len(ingredient)
    
    cnt = 0
    for i in range(n):
        burger_stack.append(ingredient[i])
        if burger_stack[-4:] == [1, 2, 3, 1]:
            del burger_stack[-4:]
            cnt += 1
            
    return cnt