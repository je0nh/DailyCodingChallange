"""
["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]
데이터들 중 조건을 만족하는 데이터만 뽑아서 정렬
data : 데이터
ext : 기준
val_ext : 기준값
sort_by : 정보를 정렬할 기준이 되는 문자열
data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
"""
def qsort(arr, sort_by):
    ext_dict = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    
    if len(arr) < 2:
        return arr
    pivot = arr[0][ext_dict[sort_by]]
    low = []
    high = []
    for i in range(1, len(arr)):
        if arr[i][ext_dict[sort_by]] < pivot:
            low.append(arr[i])
        else:
            high.append(arr[i])
    return qsort(low, sort_by) + [arr[0]] + qsort(high, sort_by)

def solution(data, ext, val_ext, sort_by):
    ext_dict = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    
    data_ls = []
    for d in data:
        if d[ext_dict[ext]] < val_ext:
            data_ls.append(d)
    
    return qsort(arr=data_ls, sort_by=sort_by)