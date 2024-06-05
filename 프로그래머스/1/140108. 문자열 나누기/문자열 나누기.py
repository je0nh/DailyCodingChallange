def solution(s):
    first_s = ''
    first_cnt = 0
    not_first = 0
    
    cnt = 0
    for _ in s:
        if first_s == '':
            first_s = _
            first_cnt += 1
            continue
        
        if _ == first_s:
            first_cnt += 1
        else:
            not_first += 1
        print(first_s, _, first_cnt, not_first)
        if first_cnt == not_first:
            first_s = ''
            first_cnt = 0
            not_first = 0
            cnt += 1
            
    if first_cnt != not_first:
        cnt += 1
    return cnt