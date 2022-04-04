# a=10
# b=20

# # = 얘를 대입연산자로 사용했지만 프로그램에선 == 이다. 
# print(a<b) # 10 < 20 T
# print(a>b) # 10 > 20 F
# print(a<=b)
# print(a>=b)
# print(a==b)
# print(a!=b)

# # 논리형 자료
# is_true = True
# is_false = False

# print(is_true > is_false) #T
# print(is_true < is_false) #F

# # 문자형 자료
# print("Python" > "python") #F
# print("12345" > "12344") #T
# print("12.12" < "13.12") #T

# 복합 대입 연산자
# +=, -=, *=, /=, **=

# last_day_year = 1230
# last_day_year +=  1

# print(last_day_year)

# and



a= 10
b= 10
a, b = b, a+b
print(a, b)