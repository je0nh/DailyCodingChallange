def solution(babbling):
    """
    연속해서 같은 발음을 하지 못함
    """
    says = ["aya", "ye", "woo", "ma"]

    count = 0
    
    for bab in babbling:
        words = ''
        ex_word = ''
        for _ in bab:
            words += _
            if ex_word == words:
                break
            
            if words in says:
                ex_word = words
                words = ''
            
            if len(words) > 3:
                break
        
        if len(words) == 0 or words in says and ex_word != words:
            count += 1
        
    return count