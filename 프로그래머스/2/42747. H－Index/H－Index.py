"""
과학자의 생산성과 영향력
논문 : n, 인용된 논문 : h, 
"""
def solution(citations):
    citations.sort(reverse=True)
    answer = 0
    for i in range(len(citations)):
        h_ls = [i+1, citations[i]]
        h_index = min(h_ls)
        if answer < h_index:
            answer = h_index
        
    return answer