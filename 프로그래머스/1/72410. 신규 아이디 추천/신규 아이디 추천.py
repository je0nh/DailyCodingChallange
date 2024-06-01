"""
규칙에 맞지 않는 아이디 -> 규칙에 맞는 아이디로 추천
길이 : 3 ~ 15
가능한 문자 : 소문자, 숫자, -, _, .(처음과 끝, 연속으로 사용 x)

처리과정
1. 대문자 -> 소문자
2. 가능한 문자를 제외한 모든 문자 제거
3. .가 두번 이상이면 하나로
4. .가 처음이나 끝이면 제거
5. 빈 문자열 -> a 대입
6. 16자 이상일 경우 15까지만, 만약 15가 .이면 . 제거
7. 2글자 이하 -> 마지막 문자를 길이가 3 될 때까지
"""
import re

def solution(new_id):
    p = re.compile('[a-z0-9\\.\\_\\-]+')

    new_id = p.findall(new_id.lower())
    
    rm_special = ''
    for id in new_id:
        rm_special += id
    
    if len(rm_special) > 1:
        rm_dot = rm_special[0]
        for i in range(1, len(rm_special)):
            if rm_special[i] == '.' and rm_dot[-1] == '.':
                pass
            else:
                rm_dot += rm_special[i]
    else:
        rm_dot = rm_special
    
    if len(rm_dot) == 1 and rm_dot == '.':
        rm_dot = ''
    elif len(rm_dot) > 1:
        while rm_dot[0] == '.':
            rm_dot = rm_dot[1:]
        while rm_dot[-1] == '.':
            rm_dot = rm_dot[:-1]
    
    if len(rm_dot) == 0:
        return 'aaa'
    elif len(rm_dot) < 3:
        while len(rm_dot) < 3:
            rm_dot += rm_dot[-1]
        return rm_dot
    elif len(rm_dot) > 15:
        rm_dot = rm_dot[:15]
        
    if rm_dot[-1] == '.':
        return rm_dot[:-1]
    
    return rm_dot