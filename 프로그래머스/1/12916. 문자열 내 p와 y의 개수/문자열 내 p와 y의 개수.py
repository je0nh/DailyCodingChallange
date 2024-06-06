"""
대문자 + 소문자 = s(문자열)
p와 y의 개수비교해서 같거나 하나도 없으면 True, 다르면 False
"""

def solution(s):
    s = s.lower()
    
    if 'p' not in s and 'y' not in s:
        return True
    
    p = 0
    y = 0
    for _ in s:
        if _ == 'p':
            p += 1
        elif _ == 'y':
            y += 1
            
    if p == y:
        return True
    else:
        return False