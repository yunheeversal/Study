# num = 0

# while num < 5:
#     num += 1
#     print(num)
# else:
#     print("값이 {}이상이므로 종료 합니다.".format(num))


# num = 1
# while num <= 5:
#     num += 1
#     print(num)
# else:
#     print("num의 마지막 값은 {}입니다.".format(num))


fruits = ["사과","키위", "바나나","사과","바나나","망고"]
print(fruits)
fruit = input("빼낼 과일을 입력해 주세요. >")

while fruit in fruits:
    fruit.remove(fruit)

print(fruits)
print("{}를 모두 제거 되었습니다.".format(fruit))
