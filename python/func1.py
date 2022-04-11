def jeju_potato():
    potato = "고구마" #potato는 함수 안에서만 사용하는 것이라 바깥에서 사용 불가
    print(potato)

jeju_potato()

print(potato)

potato = "감자"

def jeju_potato():
     global potato
     print(potato)
     potato = "고구마"
     print(potato)
     

print(potato) #전역변수와 지역변수를 따로 사용하는 것이 좋다. 
jeju_potato()

def add(num1, num2 = 20, num3 = 30):
    return num1 +num2 + num3

print(add(num1 = 10))

a, b = 20, 40

def add(num1=a, num2=b):
    return num1 + num2

a, b = 5, 10

print(add())

def add(*args):
    return args

print(add(10,20,30,40))

def star_player(**kwargs):
    for i, j in kwargs.items:
        if "서장훈" in kwargs.values():
            print("저는 서장훈 좋아했어요")
        else:
            print("{}는 역시 {}지 ".format(i,j))

star_player(농구 = "서장훈")

# 키워드 매개변수

print(1,2,3,4, end = "^^&")



def func_a(name, *args, address = "한국", **kwargs):
    print(name, args, address, kwargs)

func_a("홍길동", "옛날", "사람", address="한양", 직업 = "도둑")