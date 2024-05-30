"""
4가지 지표로 성격 유형 구분
7개의 선택지 [매우 비동의, 비동의, 약간 비동의, 모르겠음, 약간 동의, 동의, 매우 동의]
매우 동의, 매우 비동의 = 3
동의, 비동의 = 2
약간 동의, 약간 비동의 = 1
모르겠음 = 0
판단 지표 1차원 문자열 배열 -> survey
질문마다 선택한 선택지 -> choices
"""
def solution(survey, choices):
    
    select = []
    for choice in choices:
        select.append(choice - 4)
        
    type_list = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N']
    type_dict = dict.fromkeys(type_list, 0)
    for i in range(len(select)):
        if select[i] < 0:
            type_dict[survey[i][0]] += abs(select[i])
        elif select[i] > 0:
            type_dict[survey[i][1]] += abs(select[i])
    
    mbti_sum = {1 : 0, 2 : 0, 3 : 0, 4 : 0}
    for type in type_list:
        if type == 'R' or type == 'T':
            if type == 'R':
                mbti_sum[1] -= type_dict.get(type)
            else:
                mbti_sum[1] += type_dict.get(type)
        elif type == 'C' or type == 'F':
            if type == 'C':
                mbti_sum[2] -= type_dict.get(type)
            else:
                mbti_sum[2] += type_dict.get(type)
        elif type == 'J' or type == 'M':
            if type == 'J':
                mbti_sum[3] -= type_dict.get(type)
            else:
                mbti_sum[3] += type_dict.get(type)
        elif type == 'A' or type == 'N':
            if type == 'A':
                mbti_sum[4] -= type_dict.get(type)
            else:
                mbti_sum[4] += type_dict.get(type)
    
    answer = ''
    mbti = [['R', 'T'], ['C', 'F'], ['J', 'M'], ['A', 'N']]
    for i in range(4):
        if mbti_sum.get(i + 1) <= 0:
            answer += mbti[i][0]
        else:
            answer += mbti[i][1]
    return answer