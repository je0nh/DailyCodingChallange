"""
체육복 빌려주기
학생 번호 : 체격 순 -> 바로 앞이나 뒷번호의 학생에게만 체육복 빌려줄수 있음
최대한 많은 학생이 체육복이 있도록
n : 전체 학생 수
lost : 도난당한 학생 번호
reserve : 여벌의 체육복이 있는 학생
"""
def solution(n, lost, reserve):
    _lost = []
    for l in lost:
        if l in reserve:
            reserve.remove(l)
        else:
            _lost.append(l)
            
    _lost.sort()
    reserve.sort()
    answer = []
    for l in _lost:
        if l - 1 in reserve:
            reserve.remove(l - 1)
        elif l + 1 in reserve:
            reserve.remove(l + 1)
        else:
            answer.append(l)
    
    return n - len(answer)