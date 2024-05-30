"""
불량이용자 신고 -> 메일로 결과발송
유저는 한번에 한명의 유저 신고가능 (신고횟수 제한 x, 한 유저를 여러번 -> 1회만 신고처리)
k번 이상신고 -> 게시판 이용정지, 신고한 유저에게 알람
마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송
"""
def solution(id_list, report, k):
    answer = dict.fromkeys(id_list, 0)
    report_user = dict.fromkeys(id_list, '')
    set_report = list(set(report))
    
    for report_id in set_report:
        id = report_id.split(' ')
        answer[id[1]] += 1
        
        # 신고한 id 저장
        report_user[id[0]] += id[1] + ' '
    
    # 정지된 id
    stop = []
    for id in id_list:
        if answer.get(id) >= k:
            stop.append(id)
    
    # 알림 횟수
    report_ans = []
    for id in id_list:
        report_ls = list(set(report_user.get(id).split(' ')[:-1]))
        cnt = 0
        for ls in report_ls:
            if ls in stop:
                cnt += 1
        report_ans.append(cnt)

    return report_ans