def solution(k, score):
    """
    매일 출연한 가수의 점수 -> 지금까지 출연 가수들으 점수 중 상위 k 번째 이내 -> 목록에 올림
    방영시작 -> k일 까지는 모든 가수가 목록에
    """
    rank = []
    answer = []
    
    for i in range(len(score)):
        rank.append(score[i])
        rank.sort(reverse=True)
        
        if i < k:
            answer.append(rank[-1])
        else:
            answer.append(rank[:k][-1])
        
    return answer