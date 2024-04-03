def solution(keymap, targets):
    """
    1번 키 -> A, B, C 할당
    1번을 한번 누르면 A
    1번을 두번 누르면 B ...
    휴대폰 키의 개수 1~100개
    1. 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열
    2. 같은 문자가 자판 전체에 여러번 할당된 경우도 있음
    3. 키 하나에 같은 문자가 여러번 할당된 경우도 있음
    4. 키가 할당되지 않은경우도 있음 -> 몇몇 문자열은 작성할 수 없음
    keymap: 1번 키부터 차례대로 할당된 문자열이 순서대로 담김
    targets: 입력하려는 문자열들이 담긴 문자열 배열
    특정 문자열 작성할 때 -> 키를 최소 몇번 눌러야 작성할수 있는지?
    """
    answer = []
    # keymap = ["ABC"]
    # target = ["DA"]
    for i in range(len(targets)):
        total_press = 0
        for char in targets[i]:
            # char == 'D'
            # len(keymap) == 100 -> 최대 keymap[99] 까지 검색 가능
            key_press = 100
            for j in range(len(keymap)):
                # 해당하는 값이 없기 때문에 key_press == 100
                if char in keymap[j] and keymap[j].index(char) < key_press:
                    key_press = keymap[j].index(char) + 1
            # key_press == 100 라는 말은 검색되는 값이 없다는 뜻
            if key_press == 100:
                total_press = -1
                break # 반복문 중단 후 32번째 줄로 이동
            else:
                total_press += key_press
        answer.append(total_press)
    
    return answer