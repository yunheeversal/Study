# i = 0

# while True :
#     print("{}번째 반복입니다.".format(i))
#     i+= 1
#     if i > 10:
#         break


# sum_ = 0
# while True:
#     num = int(input("정수를 입력해주세요 (0: 종료) >"))
#     if num == 0:
#         break
#     sum_ += num
#     print("현재 정수의 합은 {}입니다.".format(sum_))
    

# numbers = [[1,2,3],[10, 20, 30]]

# for i in numbers:
#     for j in i:
#         print(j)
#         break

menu = {"아이스 아메리카노": 3000, "아메리카노" : 2500, "아이스라떼": 4000, "라떼":3500, "아이스크림" : 8000}

ice_menu={}
hot_menu = {}

for i,j in menu.items():
    if i[0:3] == "아이스":    # 슬라이싱을 이용해서 2번까지 
        ice_menu[i] = j
    else:
        hot_menu[i] = j

print("차가운 메뉴")
for i, j in ice_menu.items():
    print("제품명 : {}, 가격: {}".format(i,j))
print("뜨거운 메뉴")
for i, j in hot_menu.items():
    print("제품명 : {}, 가격: {}".format(i,j))


    


