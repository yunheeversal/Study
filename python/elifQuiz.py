domain = input("웹사이트 주소를 입력해 주세요.")
nation = domain.split(".")


#주소들의 문자열 구분: split 메서드 사용
if nation [-1] == "kr":
    print("한국")
elif nation [-1] == "uk":
    print("영국")
elif nation [-1] == "com":
    print("기업")
elif nation [-1] == "org":
    print("기관")
else:
    print("알 수 없습니다.")