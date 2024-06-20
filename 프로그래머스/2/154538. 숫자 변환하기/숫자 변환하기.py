def solution(x, y, n):
    answer = 0
    sum_ls = [x]
    
    while sum_ls:
        if y in sum_ls:
            return answer
        
        sum = []
        for ls in sum_ls:
            if ls + n <= y:
                sum.append(ls + n)
            
            if ls * 2 <= y:
                sum.append(ls * 2)
            
            if ls * 3 <= y:
                sum.append(ls * 3)
            
        sum_ls = list(set(sum))
        answer += 1
    return -1