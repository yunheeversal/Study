odd =  int(input("정수를 입력해 주세요. >"))

#홀수, 짝수
# 1,3,5,7,9
#2,4,6,8,0
# 음수 인덱스를 이용

# print(input)
if odd % 2 == 1 : # 입력 받은 값의 나머지가 1이라면 홀수
    print("홀수입니다.")
else :
    print("짝수입니다.")