def solution(n):
    n = str(n)
    n_ls = []
    for i in n:
        n_ls.append(i)
        
    n_ls.sort(reverse=True)
    return int(''.join(n_ls))