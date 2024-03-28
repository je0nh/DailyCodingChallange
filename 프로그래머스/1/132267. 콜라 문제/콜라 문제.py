# Time out
# def solution(a, b, n):
#     cola = 0
    
#     while n >= a:
#         cola += b * (n // a)
#         n = cola + (n % a)
#     return cola

# a : b = n : y
# y = b * (n / a 의 몫)

def solution(a, b, n):
    cola = 0
    
    while n >= a:
        cola += b * (n // a)
        n = b * (n // a) + (n % a)
    return cola