text = "w w w.GOOGLE.c o m"

# print(len(text)) #문자열 요소가 몇개인지 세어 주는 것.

# text_capitalize  = text.capitalize()
# print(text_capitalize) # 문자열 맨 첫글자 대문자로 변경

# text_uppper = text.upper() # 문자열 전체를 대문자로 변경 
# text_loewer = text.lower() # 문자열 전체를 소문자로 변경 

# print(text_uppper)
# print(text_loewer)

# count find index

# g_cnt = text.count('G')
# print(g_cnt ) # 해당 문자가 몇번 등장하냐

# f_fnd = text.find('G',5) # 5번째부터 G를 찾는 다는 의미. 
# print(f_fnd) # 해당 문자의 인덱스 번호를 반환 요소의 위치를 반환.(0부터 시작)
# # 찾는 값이 참조하는 데이터에 없을 경우 -1을 반환
# g_inx = text.rindex('G')
# print(g_inx)  # 찾는 문자의 인덱스를 반환 인덱스는 찾는 요소가 없을 경우
# # value 에러가 발생함.

# r = 리버스 왼쪽-> 오른쪽이 기본인데 r을 붙이면 오른쪽에서 왼쪽으로
# 끝에서부터 

# text_naver = text.replace("GOOGLE", "NAVER") 
# # .replace 앞의 값을 뒤의 인자로 바꿔주는 것 

# print(text_naver)

# text.split() # 기본값은 공백으로 분리
# print(text.split('OO') ) # .을 기준으로 분리하게 만들어줌.

# strip  공백을 없애주는 메서드

print(text)
str = text.strip()

print(str)