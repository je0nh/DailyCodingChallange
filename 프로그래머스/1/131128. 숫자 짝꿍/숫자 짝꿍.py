from collections import Counter
def solution(X, Y):
    answer = ''
    y_cnt = Counter(Y)
    
    for _ in X:
        if y_cnt.get(_):
            y_cnt[_] -= 1
            answer += _
    ans = sorted(list(answer), reverse=True)
    
    if set(ans) == {'0'}:
        return '0'
    
    if len(ans) == 0:
        return "-1"
    
    return "".join(ans)