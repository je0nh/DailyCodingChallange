def solution(s):
    num_dict = {'zero':'0', 'one':'1', 'two':'2', 'three':'3', 'four':'4', 'five':'5', 'six':'6', 'seven':'7', 'eight':'8', 'nine':'9'}
    
    s_str = ''
    a = 0
    for i in range(len(s)):
        if s[i].isdigit():
            s_str += str(s[i])
            a = i + 1
        elif s[a:i+1] in list(num_dict.keys()):
            s_str = s_str + str(num_dict.get(s[a:i+1]))
            a = i + 1
    return int(s_str)