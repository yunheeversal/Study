# def menu():
#     print("오늘의 메뉴")
#     print("오늘 점심메뉴는 제육볶음입니다.")
#     print("내일 메뉴")
#     print("내일 점심메뉴는 돈까스입니다.")

# menu()

# print("사용할 데이터")
# input("데이터")

def add(text1, text2): #매개변수(= 파라미터)
    '''문자열 두개(성, 이름)을 입력받아서 합쳐서 출력
    args
        text1: 성을 받는 문자열
        text2: 이름을 받는 문자열''' #독스트링? 
    text = text1+text2
    return text

print(add("길동","홍")) #인자(=아규먼트)

# input("데이터")
