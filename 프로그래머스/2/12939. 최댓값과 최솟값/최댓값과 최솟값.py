def solution(s):
    s_ls = [int(i) for i in s.split(' ')]
    return str(min(s_ls)) + ' ' + str(max(s_ls))
