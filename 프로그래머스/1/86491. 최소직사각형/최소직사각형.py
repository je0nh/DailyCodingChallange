def solution(sizes):
    width = 0
    height = 0
    for size in sizes:
        size.sort(reverse=True)
        if size[0] > width:
            width = size[0]
        
        if size[1] > height:
            height = size[1]
            
    return width * height