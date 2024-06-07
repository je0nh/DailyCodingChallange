"""
위, 아래, 왼, 오 중 같은 색깔로 칠해진 칸의 개수 구하기
board : 각 칸에 칠해진 색깔 이름
h, w : 고른 칸의 위치
"""
def solution(board, h, w):
    sel_color = board[h][w]
    
    location = [[h-1, w], [h, w-1], [h+1, w], [h, w+1]]
    
    cnt = 0
    for loc in location:
        if 0 <= loc[0] < len(board) and 0 <= loc[1] < len(board[0]):
            if sel_color == board[loc[0]][loc[1]]:
                cnt += 1
    return cnt