#끝말잇기 함수 만들기
# 가장 끝 글자를 이어주고 다른거 쓰면 끝말이 이어지지 않는다고 나오게.

# 1. 선언 먼저
# 2. while 반복문
# 3. input 함수 이용
# 4. if로 글자 비교


def game(text):
    ''' 문자열을 입력 받아 끝말잇기 '''
    while True:
        print(text)
        keyword = input("끝말을 이어주세요. >")
        if text[-1] == keyword[0]:
            text = keyword # 변환시켜줌
        else: 
            print("끝말이 이어지지 않았습니다.")
            break

        

game("함수호출")