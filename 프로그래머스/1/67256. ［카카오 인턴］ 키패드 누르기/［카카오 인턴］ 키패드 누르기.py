# """
# 왼손과 오른손의 엄지손가락으로 숫자 입력
# 왼손 엄지손가락 시작위치 : *
# 오른손 엄지손가락 시작위치 : #
# 엄지손가락 사용 규칙
# 1. 상하좌우 4가지 방향으로 이동
# 2. 1,4,7 -> 왼손 사용
# 3. 3,6,9 -> 오른손 사용
# 4. 2,5,8,0 -> 가장 가까운 엄지손가락
# 5. 거리가 같으면 오른손잡이는 오른손, 왼손잡이는 왼손

# numbers : 누를 번호 순서
# hand : 손잡이
# return -> 각 번호 누른 손가락이 어느 손가락인지
# """
def solution(numbers, hand):
    keys = {
        1 : (0, 0), 2 : (0, 1), 3 : (0, 2),
        4 : (1, 0), 5 : (1, 1), 6 : (1, 2),
        7 : (2, 0), 8 : (2, 1), 9 : (2, 2),
        '*' : (3, 0), 0 : (3, 1), '#' : (3, 2),
    }
    
    left_hand = '*'
    right_hand = '#'
    
    answer = ''
    for num in numbers:
        if num in [1, 4, 7, '*']:
            answer += 'L'
            left_hand = num
        elif num in [3, 6, 9, '#']:
            answer += 'R'
            right_hand = num
        else:
            left_dist = abs(keys[num][0] - keys[left_hand][0]) + abs(keys[num][1] - keys[left_hand][1])
            right_dist = abs(keys[num][0] - keys[right_hand][0]) + abs(keys[num][1] - keys[right_hand][1])
            
            if left_dist < right_dist:
                answer += 'L'
                left_hand = num
            elif left_dist > right_dist:
                answer += 'R'
                right_hand = num
            else:
                if hand == 'left':
                    answer += 'L'
                    left_hand = num
                else:
                    answer += 'R'
                    right_hand = num
    return answer