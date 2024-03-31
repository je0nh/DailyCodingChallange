def solution(food):
    """
    1:1 대결, 매 대결마다 음식 종류와 양이 바뀜
    음식을 일렬로 배치 -> 1번선수=> ---물--- <=2번선수
    물을 먼저 먹는 선수가 승리
    두 선수가 먹는 음식의 종류와 양이 같고, 음식 먹는 순서도 같음
    칼로리가 낮은 음식을 먼저 먹개 배치
    대회의 조건을 고려하지 않고 음식을 주문 -> 몇개의 음식은 사용하지 못함
    food: 칼로리가 낮은 순서대로 음식의 양
    food[0]: 준비한 물의 양 -> 항상 1
    """
    answer = ''
    n = len(food)
    for i in range(1, n):
        count = 0
        a = food[i] // 2
        while count < a:
            answer += str(i)
            count += 1
    return answer + '0' + answer[::-1]