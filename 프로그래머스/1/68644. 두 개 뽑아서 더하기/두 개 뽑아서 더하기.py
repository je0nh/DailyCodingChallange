def solution(numbers):
    answer = []
    n = len(numbers)
    for i in range(n):
        for j in range(i, n):
            sum = numbers[i] + numbers[j]
            if i != j and sum not in answer:
                answer.append(sum)
    return sorted(answer)