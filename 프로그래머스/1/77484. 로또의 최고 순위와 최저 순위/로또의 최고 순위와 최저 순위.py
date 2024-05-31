"""
로또 당첨이 가능했던 최고 순위와 최저 순위
알아볼수 없는 번호 -> 0

"""
def solution(lottos, win_nums):
    zero_cnt = 0
    correct_num = 0
    for win_num in win_nums:
        if win_num in lottos:
            correct_num += 1
    for lotto in lottos:
        if lotto == 0:
            zero_cnt += 1
    
    answer = []
    if correct_num + zero_cnt == 6:
        answer.append(1)
    elif correct_num + zero_cnt == 5:
        answer.append(2)
    elif correct_num + zero_cnt == 4:
        answer.append(3)
    elif correct_num + zero_cnt == 3:
        answer.append(4)
    elif correct_num + zero_cnt == 2:
        answer.append(5)
    else:
        answer.append(6)
        
    if correct_num == 6:
        answer.append(1)
    elif correct_num == 5:
        answer.append(2)
    elif correct_num == 4:
        answer.append(3)
    elif correct_num == 3:
        answer.append(4)
    elif correct_num == 2:
        answer.append(5)
    else:
        answer.append(6)
        
    return answer