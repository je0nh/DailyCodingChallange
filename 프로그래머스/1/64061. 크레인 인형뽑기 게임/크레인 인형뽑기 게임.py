"""
정사각형 격자
뽑은 인형은 바구니에 아래칸부터 순서대로 쌓임
바구니에 같은 인형 2개 -> 바구니에서 사라짐
board : 인형 배열
moves : 크레인을 작동시킨 위치
터뜨린 인형 개수 구하기
"""
def solution(board, moves):
    doll_ls = []
    answer = 0
    for i in range(len(moves)):
        if board[len(board) - 1][moves[i] - 1] != 0:
            for j in range(len(board)):
                if board[j][moves[i] - 1] != 0:
                    doll = board[j][moves[i] - 1]
                    board[j][moves[i] - 1] = 0
                    break
                else:
                    doll = 0
        else:
            continue
                    

        if len(doll_ls) != 0 and doll == doll_ls[-1]:
            doll_ls.pop(-1)
            answer += 1
        else:
            doll_ls.append(doll)
    return answer * 2