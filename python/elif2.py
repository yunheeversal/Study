number = int(input("정수를 입력해 주세요."))

if number %3 ==0 or number %2 == 0:
    if number %3 == 0 and number %2 !=0:
        print("3의 배수 입니다.")
    elif number %3 ==0 and number %2 ==0:
        print("3의 배수면서 짝수입니다.")
    else:
        print("짝수입니다.")
else:
    print("3의 배수도 짝수가 아닙니다.")