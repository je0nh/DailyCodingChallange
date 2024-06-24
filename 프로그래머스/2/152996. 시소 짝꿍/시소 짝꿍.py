from collections import Counter
def solution(weights):
    counter = Counter(weights)
    cnt = 0
    for i in counter:
        cnt += counter[i] * (counter[i] - 1) // 2
        cnt += counter[i] * counter[i * 2]
        cnt += counter[i] * counter[i * 3 / 2]
        cnt += counter[i] * counter[i * 4 / 3]
    return cnt