def solution(numbers):
    answer = [-1] * len(numbers)
    stack = []
    
    for i in range(len(numbers)):
        n = numbers[i]
        
        while stack and numbers[stack[-1]] < n:
            answer[stack.pop()] = n
            
        stack.append(i)
    return answer