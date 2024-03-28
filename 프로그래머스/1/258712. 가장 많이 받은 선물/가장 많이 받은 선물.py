def solution(friends, gifts):
    n = len(friends)
    # * 을 사용해서 배열을 만들면 참조
    # arr = [[0] * n] * n
    arr = [[0 for j in range(n)] for i in range(n)]
    
    fnd = {str(b):int(a) for a, b in enumerate(friends)}
    
    for gift in gifts:
        a, b = gift.split(' ')
        arr[fnd.get(a)][fnd.get(b)] += 1
        arr[fnd.get(a)][fnd.get(a)] += 1
        arr[fnd.get(b)][fnd.get(b)] -= 1
    
    next_month = [0 for i in range(n)]
    for i in range(n):
        for j in range(n):
            a = fnd.get(friends[i])
            b = fnd.get(friends[j])
            if i == j:
                pass
            elif arr[a][b] > 0 or arr[b][a] > 0:
                if arr[a][b] > arr[b][a]:
                    next_month[i] += 1
                elif arr[a][b] == arr[b][a] and arr[a][a] > arr[b][b]:
                    next_month[i] += 1
            elif arr[a][b] == 0 and arr[b][a] == 0:
                if arr[a][a] > arr[b][b]:
                    next_month[i] += 1
    return max(next_month)