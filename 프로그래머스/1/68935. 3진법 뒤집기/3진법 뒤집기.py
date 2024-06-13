"""
3진법 상에서 앞뒤로 뒤집은 후 -> 10진법으로 리턴
"""
def solution(n):
    if n <= 3:
        return n
    ans_ls = []
    while True:
        n, mod = divmod(n, 3)
        ans_ls.insert(0, mod)
        
        if n == 1 or n == 2:
            break
    
    ans_ls.insert(0, n)
    answer = sum(map(lambda x:x[1]*(3**x[0]), enumerate(ans_ls)))
    return answer