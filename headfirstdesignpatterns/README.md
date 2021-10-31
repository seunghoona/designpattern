## 1.문제가 무엇인가?

---

- 상속을 사용하는 것이 그리 성공적이지 못하다
- Flyable과 Quackable 인터페이스 사용하는 방법들은 처음에는 괜찮아 보이지만
  자바 인터페이스에는 구현된 코드가 전혀 들어가지 않기 때문에 코드 재사용을 할수 없다.
  (자바 8부터는 default 를 이용해서 구현할 수 있다)

## 디자인 원칙
달라지는 부분과 달라지지 않는 부분을 분리 한다.   
상속보다는 구성을 활용한다.  
구현보다 인터페이스에 맞춰서 프로그래밍한다.

## 어떻게 해야할까?
요구사항이 있을 때마다 바뀌는 부분이 있다면 그 행동을 바뀌지 않는 다른 부분으로 골라내서
분리해야 한다는 것을 알 수 있다.

바뀌는 부분은 캡슐화 시킨다. ( 바뀌지 않는 부부넹 영향을 미치지 않아 수정 or 확장에 용이하다)

## 바뀌는 부분과 그렇지 않은 부분 분리 하기

- 아래 부분은  Duck 클래스에서 오리마다 달라지는 부분입니다.  

```java
    public void fly();
    public void quack();
```

-----
## 나는 행동과 꽥꽥거리는 행동을 구현하는 클래스 집합은 어떻게 디자인해야할까요?

--- 
### 이 문제의 시작은 오리의 행동의 변화 때문입니다.

- 이전까지는 Duck에 행동을 구현했지만 이제는 자체로 구현할 수 있더록 설계했습니다. (quackBehavior ,flybehavior)

### 하지만 왜 인터페이스를 이용해야할까요?

- "인터페이스에 맞춰서 프로그래밍한다는" 것은 "상위" 형식에 맞춰서 프로그래밍한다는 것을 의미합니다.
- 반드시 자바의 인터페이스를 사용하는 것이 아니라 실제 실행시에 쓰이는 객체가   
  코드에 의해서 고정되지 않도록, 어떤 상위 형식에 맞춰서 프로그래밍함으로써 '다형성'을 활용해야한다는 것입니다.   
  그렇게 함으로써 좀더 유연할 설계를 할 수있게 됩니다.


## 생각의 전환

1. 바뀔 수 있는 부분을 미리 예측하여 미리대처할 수 있는 유연하 설계를 해야한다.


## 결론 
1. 변화는 영역인 (소리, 날다)는 캡슐화를 통해 별도의 인터페으스로 설계 되었습니다.
2. 각각의 클래스는 연관관계 , 의존관계, 상속관계 ,구현관계로 나눌 수있습니다. 

### 스트래지 패턴
알고리즘을 정의하고 각각 캡슐화 하여 교환해서 사용할 수 있도록 만든다.   
스트래티지을 활용하면 알고리즘을 사용하는 클라이언트와 독립적으로 알고리즘을 변경할 수 있다.

### 활용편 
보험상품을 예를 들어보자 
고객사에서 각각의 상품(상품 제목 , 상품설명, 납입방법)


#2 옵저버 패턴

--- 

##2-1. 요구사항

+ 기상 정보 스테이션을 개발
  + Weather DATA 객체를 바탕으로 개발한다.
    + 기온, 습도, 기압 추적하는 객체이다.
  + 세개의 항목은 각각 현재 조건, 기상 통계, 기상예보를 최신 측정치를 수집할 때 실시간으로 갱신된다.
  + 다른 개발자들이 사용할 수 있도록 API를 만들 예정이다.

+ 정리 
  + 기상데이터를 사용하는 세개의 디스프레이 항목을 구현
    1. 현재조건을 표시
    2. 기상통계를 표시
    3. 기상예보를 표시
    4. WeatherData에서 새로운 측정값이 들어올 때마다 디스플레이스를 갱신해야한다.
    5. 시스템이 확장성이있어야한다.
       + 디스플레이 항목을 추가/제거할 수 있도록 해야한다.
         + 상위 1~3번 기능을 말함

```java

public class WeatherData {
    void getTemperature();  //온도 
    void getHumidity();     //습도
    void getPressure();     //기압

    /**
     * 기상 값이 갱신될 때마다 알려주기 위한 메소드
     * 현재조건, 기상통계, 기상예측
     */
    public void measurementsChanged() {
      float temp = getTemperature();
      float humidity = getHumidity();
      float pressure = getPressure();

      /**
       *  구체적인 구현에 맞춰서 고딩했기 때문에 프로그램을 고치지 않고서는 다른 디스플레이를 추가/삭제할 수 없다.
       *  파라미터는 동일한 인자값을 사용하고 있다는 것을 알 수있다.
       */
      currentConditionDisplay.update(temp, humidity, pressure);
      statisticsDisplay.update(temp, humidity, pressure);
      forecastDisplay.update(temp, humidity, pressure);
    }
} 
```

## 2.2 옵저버 패턴이란? 
 + 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식   
 + **일대 다** 의존성을 정의합니다.
   + 옵저버들은 주제에 의존합니다.
   + 주제의 상태가 바뀌면 옵저버한테 연락이 갑니다. 
   + 연락 방법에 따라 옵저에 있는 값이 새로운 값으로 갱신될 수도 있습니다.
   + subject인터페이스와 옵저 인터페이스가 들어있는 크래스 디자인을 바탕을 설계되어 있습니다.

## 느슨한 결합
  + 두 객체가 느슨하게 결합되어 있다는 것은 그 둘이 상호 작요을 하긴 하지만 서로에 대해 서로 잘 모른다는 것을 의미합니다.
  * 옵저버 : 구상클래스(주체)가 무엇인지 옵저버가 무엇을 하는지 등에 대해서는 알 필요가 없습니다.
  * 옵저버는 언제든지 생로 추가 할수 있습니다.
  * 새로운 형식의 옵저버를 추가하려고 할 때도 주제를 전혀 변경할 필요가 없습니다.
  * 주제와 옵저버는 서로 독립적으로 재사용할 수있습니다.
  * 주제나 옵저버가 바뀌더라도 서로한테 영향을 끼치지 않습니다.

## 자바 API에서 제공하는 옵저버 패턴을 사용해봅시다.
+ 객체가 옵저가 되는 방법 
  + Observer 인터페이스를 구현 
  + Observable 객체의 addObserver() 메소를 호출
+ Observable 에 알리는 방법
  + setChanged 메소드를 호출해서 객체의 상태가 바뀌었다는 것을 알리는 것
  + notifyObbservers(), notifyObservers(Object arg)
+ Observer 연락을 받는 방법 
  ```java
    // 연락을 보내느 주체 객체가 인자로 전달
    /** 
       notifyObservers() 메소드에서 인자로 전달된 데이터 객체, 
       데이터 객체가 지정되지 않느 경우 Null이다. 
    */
    update(Observable o ,Object arg)
  ```
### setChanged는 무엇인가? 
+ 상태가 변경되었다는 것을 밝히기 위한 용도로 사용된다.
+ notifyObservers() 메소드가 호출 되었을 때 setChanged가 호출되지 않은상태에서 notifyObservers()가 호출되면   
  옵저버들에게 아무런 연락을 하지 않습니다. 이러한 용도로 조건에 따라서 사용할 수 있도록 필요한 메소드입니다.

### 자바 API Observable의 단점
+ Observable은 인터페이스가 아닌 클래스인 데다가, 어떤 인터페이스를 구현하는 것도 아닙니다.   
  구현에 있어서 제약 조건으로 작용하는 몇 가지 문제점이 있습니다.
+ Observable이 클래스기 때문에 서브클래스를 만들어야한다는 점이 문제가 된다.
+ Observable에 기능을 추가할 수 없으며 핵심 메소드를 외부에서 호출할 수없습니다.

### 주의할점 
옵저버 패턴은 순서가 바뀐다고 해서 다른 결과가 나와서는 안됩니다.   
만약 바뀌게 된다면 이것은 느슨한 결합이라고 할 수 없게 됩니다.

## 디자인 원칙을 적용해서 생각해보자 
 + 애플리케이션에서 바뀌는 부분을 찾아내서 바뀌는 지 않는 부분으로부터 분리한다.
   + 옵저버 패턴에 변하는것은 주제의 상태와 옵저버의 개수,형식 주제를 변경하지 않아도   
   주제의 상태에 의존하는 객체들을 바꿀 수 있습니다.
 + 특정구현이 아닌 인터페이스에 맞춰서 프로그래밍한다.
   Subject와 Observer에서 모두 인터페이스를 사용했습니다. Subject에서는 Subject 인터페이스를 통해서 
   Observer 인터페이스를 구현하는 객체들의 등록/탈퇴를 관리하고 그런객체들에게 연락을 돌립니다.
 + 상속보다는 구성을 활용한다.
   + 옵저 패턴에서는 구성을 활용하여 옵저버들을 관리합니다
   + 주제와 옵저버 사이의 관계는 상속이 아니라 구성에 의해서 이루어지죠

# 3. 데코레이터 패턴

### OCP(OPEN-CLOSED PRINCIPLE) 개방폐쇄 원칙
+ 클래스는 확장에는 열려있어야 하지만 코드 변경에 대해서는 닫혀있어야한다.
+ OCP를 적용하는 것은 시간낭비가 될 수도 있고 쓸데없는 일을하는 것일 수도 있습니다.
+ 결과적으로 불 필요하게 복자하고 이해하기 힘든 코드만 만들게 되는 부작용이 될 수 있으니 주의해야합니다.

### 디자인패턴에서 OCP를 준수하려면 어떻게 해야할까요? 
+ 보통은 불가능합니다. 가장 많이 변경될 수 있는 여지가 있는 곳을 디자인패턴을 접목할 생각해봐야합니다.

### 데코레이터 패턴이란 무엇인가? 
> 객체에 추가적인 요건을 동적으로 첨가할 수 있는 패턴이다.
> 데코레이터는 서브클래스를 만드는 것을 통해서 기능을 유연하게 확장할 수 있는 방법을 제공한다.

+ 수퍼 클래스는 자신이 장식하고 있는 객체의 수퍼클래스와 같습니다.
+ 한 객체를 여러 개의 데코레이터롤 감쌀 수 있습니다.
+ 데코레이터는 자신이 감싸고 있는 객체와 같은 수퍼 클래스를 가지고 있기 때문에 원래 객체가 들어갈 자리에   
데코레이터 객체를 집어 넣어도 상관없습니다. 
> __데코레이터는 자신이 장식하고 있는 객체에게 어떤 행동을 위힘하는 것 외에 원하는 추가적인 작업을 수행할 수 있습니다.__


### 자바 API 데코레이터 패턴을 확인해보자
+ InputStream 데코레이턴의 수퍼클래스가됩니다.
+ FileInputStream , StringBufferInputStream, ByteArrayInputStream은 데코레이터로 포장 될 구상 구성요소 역할을 합니다.
+ FilterInputStream은 추상 데코레이터입니다.
+ PushbackInputStream BuffedInputStream DataInputStream 등이 데코레이터들입니다.


### 실습해봅시다
+ 사이즈 개념을 도입하기로 했습니다.
+ 커피를 이제는 톨, 그란데 벤티 중에서 골라서 주문할 수 있ㅅ브니다.
+ Beverage 클래스에 사이즈의 get/set을 추가했습니다.
+ 사이즈에 따라서 가격도 다르게 받을 계획입니다.

## 만약에 각음료마다 코스트가 달라야한다면 각 클래별로 금액을 설정하는 것이 맞는가? 

# 4. 팩토리 패턴 

--- 
> 팩토리 메소드 패턴   
> 객체를 생성하기 위한 인터페이스를 만듭니다. 
> 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하도록합니다.
> 팩토리 메소드를 이용하면 인스터스를 만드는 일을 서브 클래스로 미룰수 있습니다.

## 요구사항
+ 피자는 여러가지의 종류(불고기피자,양파피자)를 가지고 있습니다.
```java
public Pizza orderPizza(String type) {
    private Pizza pizza;
        if(type.equals) {
            pizza = new CheesePizza();
        }else if (type.equals("greek")) {
            pizza = new GreekPizza();
        }else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    return pizza;
}
```
+ 새로운 신제품인 조개피자와 야채피자가 추가되었습니다. 그리고 페퍼로니와 치즈 피자를 제외 시키려고 합니다.
+ 하지만 아래와 같은 방식은 OCP 위배하게 됩니다.
```java
public Pizza orderPizza(String type) {
    private Pizza pizza;
        if (type.equals("clam")) {
            pizza = new ClamPizza();
        }else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    return pizza;
}
```
+ 이를 통해 우리가 알 수 있는것은 변화는 부분과 변하지 않는 부분을 구분하는 것입니다.

## 추가된 요구사항
+ 분점을 만들려고 합니다. 
+ 다른 지역마다 특성과 입맛을 반영하여 다른 스타일의 피자 를 만들어야합니다.

### 해결방법
SimplePizzaFactory를 빼고 세가지 서로 다른 팩토리를 만든다음 
PizzaStore에서 적당한 팩토리르 사용하도록하면 다양한 피자를 더욱 추가할 수 있을 겁니다.

## 더욱 추가된 요구사항
+ 분점에서 우리가 만든 팩토리를 써서 피자를 만들긴 하는데 독자적인 방법들을 사용하기 시작했습니다.
+ 굽는 방식 달린다거나 종종 피자를 자르것을 까먹는 상황이 온 것입니다.


### 해결방법
+ 피자가게와 피자 제작과정 전체를 하나로 묶어주는 프레임워크를 만들어야 되겠다는 결론에 도달했습니다.
+ 이제 각 분점마다 달라질 수 있는 점은 피자의 스타일 뿐입니다.
+ 제주도 피자, 부산피자 그리고 달라지는 점들은 전부 createPizza() 메소드에 집어넣고 서브클래스에서   
createPizza를 구현하게 할 것입니다.

> PizzaStore는 생산자 클래스 입니다.   
> 제품을 생산하는 클래스는 구상생산자(concreteCreator라고 부릅니다)   
> Pizza를 구현한 클래스는 제품 클래스입니다.

> 팩토리 메소드 패턴에는 어떤 클래스의 인스터를 만들지를 서브클래스에서 결정한다라는 표현을 쓰곤합니다.
+ 결정한다라는 표현의 의미는 시행중에 어떤 클래스의 인스턴스를 만들지 결정하기 때문이 아니라   
+ 생산자 클래스 자체가 실제 생산될 제품에 대한 사전 지식이 전형 없는 상태에서 만들어지기 때문입니다.
+ 사실 더 정확하게 표현하자면 사용하는 서브클래스에 따라 생상되는 객체 인스턴스가 결정될 것입니다.

### 장점은 무엇인가?
+ 객체 생성 코드를 전부 한 객체 또는 메소드에 집어 넣으면 코드에서 중복되는 내용을 제거할 수 있다.
+ 관리도 한 곳만 신경쓸수 있다.
+ 유연하고 확장성 높게 만들 수 있다.

## DIP의 등장 
> 추상화 된것에 의존하게 만들어라   
> 구상 클래스에 의존하도록 만들지 않도록 한다.   
> 특정 구현이 아닌 인터페이스 에맞춰서 프로그래밍한다.
> 
### 예를들어보자 
+ 아래 코드를 살펴보자 
+ orderPizza() 메소드는 너무 많은 객체들을 의존하고 있다.
이 많은 의존들은 서브클래스(저수준)의 변경으로 인해 고수준(PizzaStore) 클래스까지 영향을 줄 수 있습니다.
+ PizzaStore는 여러개의 피자에 의존하고 있습니다.
```java
public class PizzaStore {
    public Pizza orderPizza(String type) {
        if (type.equals("clam")) {
            pizza = new ClamPizza();
        }else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }else if (type.equals("apple")) {
            pizza = new ApplePizza();
        }else if (type.equals("grape")) {
            pizza = new GrapePizza();
        }
        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
```
### 뒤집어서 생각해보자 
+ PizzaStore를 구현해야한다면 제일먼저 무엇을 해야할까? 
+ 피자가게(고수준)이 저수준(피자)를 알고 있으면 영향을 끼칠 수있다. 
+ 이런 경우 피자를 추상화할 개념을 생각하고 Pizza를 추상화 시켜서 PizzaStore와 Pizza(저수준) 구상객체를    
Pizza 추상화를 바라보게 하는 것입니다.


### 원칙을 지키고 싶다면 어떻게 하면 좋을까요? 
+ 어떤 변수에도 구상(구현) 클래스에 대한 레퍼런스를 저장하지 맙시다.
  + new 연산자를 사용하면 구상 클래스에 대한 레퍼런스를 사용하게 되는 것이다.
  + 팩토리를 써서 구상 클래스에 대한 레퍼런스를 변수에 저장하는 일을 미리 방지합시다.
+ 구상 클래스에서 유도된 클래스를 만들지 맙시다.
  + 구상 클래스에서 유도된 클래스를 만들면 특정 구상 클래스에 의존하게 됩니다.
  + 인터페이스나 추상화된 클래스로 만들어야합니다.
+ 베이스 클래스에 이미 구현되어 있던 메소드를 오버라이드 하지 맙시다.
  + 이미 구현되어 있는 메소드를 오버라이드 한다는 것은 애초부터 베이스 클래스가 제대로 
  추상화 된 것이 아니었다고 볼 수 있다.   
  베이스클래스에서 메소드를 정의 할 때 모든 서브클래스에서 공유 할수 있는 것만 정의해야합니다.

### 더욱x2 추가된 요구사항
+ 자잘 한 재료를 더 싼 재료로 바꿔서 원가를 줄이고 마진을 올리려고 하는 문제가 발생했습니다.
+ 다른 Store에서 좋은 재료를 사용하도록 관리할 수 있을까요 ? 


# 3.1 추상 팩토리 패턴 정의
> 추상 팩토리 패턴에서는 인터페이스를 이용하여 서로 연관된 또는 의존하는 객체를 구상 클래스를 지정하지 않고도 생성할 수있습니다.
> 
### 추상 팩토리 와 팩토메소드 패턴의 차이점은 무엇인가요? 
+ 팩토리 메소드 패턴 
  + 클라이언트 코드와 인스턴스를 만들어야 할구 상 클래스를 분리시켜야할 때
  + 상속을 통해서 객체를 생성 
    + 서브클래스를 만들고 팩토리 메소드를 오버라이드(Creator)
    + 객체를 생성하는 역할 즉, 클라이언트와 구상형식을 분리시켜주는 역할
    + 한가지 제품만 생산 복잡한 인터페이스도 필요하지 않으며 메소드도 하나만 있으면된다.
+ 추상 팩토리 
  + **서로 연관된 도메인정보를 만들어야할 때**
  + 객체의 구성을 통해서 생성 
    + 제품군을 만들기 위한 추상형식을 제공 
    + 제품이 생산되는 방법은 이 형식의 서브 클래스에서 정의 된다.
    + 연관이 높은 도메인 정보를 묶을 수있다.
    + 제품을 추가 또는 확대해야하는 경우 인터페이스 변경이 필요하다.

### 실습을 통해 이해한점 
추상 팩토리로 구현하게 된다면 연관된 정보를 통해 집합을 만들 수 있기에 하나의   
인터페이스를 통해서 여러개의 클래스를 출력할 수 있다    
그러나 팩토리 메소드 패턴으로 구현하는 경우 여러개의 팩토리를 생성해야하기에 
LG와 삼성의 집합으로 보기보단 키보드와 마우스 모니터등으로 각각의 팩토리를 통해 
여러개의 계열사의 제품들로 집합 할 수 있다.   
[출처](https://victorydntmd.tistory.com/300?category=719467)
```java
public class LGKeyboard implements Keyboard {
    public LGKeyboard(){
        System.out.println("LG 키보드 생성");
    }
}

public class SamsungKeyboard implements Keyboard {
    public SamsungKeyboard(){
        System.out.println("Samsung 키보드 생성");
    }
}

public interface Keyboard {
}

public class KeyboardFactory {
    public Keyboard createKeyboard(String type){
        Keyboard keyboard = null;
        switch (type){
            case "LG":
                keyboard = new LGKeyboard();
                break;

            case "Samsung":
                keyboard = new SamsungKeyboard();
                break;
        }

        return keyboard;
    }
}

public class LGMouse implements Mouse {
    public LGMouse(){
        System.out.println("LG 마우스 생성");
    }
}

public class SamsungMouse implements Mouse {
    public SamsungMouse(){
        System.out.println("Samsung 마우스 생성");
    }
}

public interface Mouse {
}

public class MouseFactory {
    public Mouse createMouse(String type){
        Mouse mouse = null;
        switch (type){
            case "LG":
                mouse = new LGMouse();
                break;

            case "Samsung":
                mouse = new SamsungMouse();
                break;
        }

        return mouse;
    }
}

public class ComputerFactory {
    public void createComputer(String type){
        KeyboardFactory keyboardFactory = new KeyboardFactory();
        MouseFactory mouseFactory = new MouseFactory();
        BodyFactory bodyFactory = new BodyFactory();
        MonitorFactory monitorFactory = new MonitorFactory();
        SpeakerFactory speakerFactory = new SpeakerFactory();
        PrinterFactory printerFactory = new PrinterFactory();

        keyboardFactory.createKeyboard(type);
        mouseFactory.createMouse(type);
        bodyFactory.createBody(type);
        monitorFactory.createMonitor(type);
        speakerFactory.createSpeaker(type);
        printerFactory.createPrinter(type);
        System.out.println("--- " + type + " 컴퓨터 완성 ---");
    }
}

public class Client {
    public static void main(String args[]){
        ComputerFactory computerFactory = new ComputerFactory();
        computerFactory.createComputer("LG");
    }
}

public class Main {
    public static void main(String[] args) {
        Computer monitor = new CompanyFactory();
        monitor.order("LG");
    }
}

public class SamsungComputerFactory implements ComputerFactory {
    public SamsungKeyboard createKeyboard() {
        return new SamsungKeyboard();
    }

    public SamsungMouse createMouse() {
        return new SamsungMouse();
    }
}
public class LGComputerFactory implements ComputerFactory {
    public LGKeyboard createKeyboard() {
        return new LGKeyboard();
    }

    public LGMouse createMouse() {
        return new LGMouse();
    }
}
public interface ComputerFactory {
    public Keyboard createKeyboard();
    public Mouse createMouse();
}

public class FactoryOfComputerFactory {
    public void createComputer(String type){
        ComputerFactory computerFactory= null;
        switch (type){
            case "LG":
                computerFactory = new LGComputerFactory();
                break;

            case "Samsung":
                computerFactory = new SamsungComputerFactory();
                break;
        }

        computerFactory.createKeyboard();
        computerFactory.createMouse();
    }
}

public class Client {
    public static void main(String args[]){
        FactoryOfComputerFactory factoryOfComputerFactory = new FactoryOfComputerFactory();
        factoryOfComputerFactory.createComputer("LG");
    }
}
```

#5. 싱글턴 패턴 

> 싱글턴 패턴은 해당 클래스의 인스턴스가 하나만 만들어지고, 어디서든지 그 인스턴스에 
> 접근할 수 있도록하기 위한 패턴입니다.

## 싱글턴 패턴은 어디에서 사용하고 있을까?
> 스레드풀, 캐시, JFRAME, 사용자 설정 , 레지스트리 설정을 처리하는 객체, 로그 기록용 객체, 프린터, 그래픽카드 같은 디바이스를 예를 들 수 있다. 

## 싱글톤 패턴으로 초콜리공장 시스템을 개발해보자 
+ 초콜릿과 우유를 받아서 끓이고 초코바를 만드는 단계로 넘겨줍니다.
+ 아직 끓지 않는 500갤런이나 되는 재료를 그냥 흘려 버린다거나 
+ 보일러가 가득 차 있는 상태에서 새로운 원료재료를 붓는다거나 
+ 빈 보일러에 불을 지핀다는 실수를 하지 않도록 세심하게 설계해야합니다.

# 6. 커맨드 패턴 (호출캡슐화)

> 요청 내역을 객체로 캡슐화하여 클라이언트를 서로 다른 요청 내역에 따라 매개변수화할 수 있는방법   
> 요청을 큐에 저장하거나 로그로 기록할 수 있고 작업 취소 기능를 지원할 수도 있습니다.

+ 커맨드 패턴은 요청을 하는 객체와 요청을 수행하는 객체를 분리할 수 있으며 분리 시키는 과정의 중심에는 **커맨드 객체**가 존재한다.

## 요구사항
+ 리모컨 개발을 해주시기를 원합니다. 
+ 리모컨에는 일곱 가지 프로그래밍이 가능한 슬롯과 각 슬롯에 대한 온/오프 스위치가 있습니다.
+ 각 슬롯은 서로 다른 가정용 기기에 연결할 수 있습니다. 리모컨에는 취소버튼도 장착되어있습니다.

## 무엇인 문제가 되는가 ? 
+ 리모컨에는 On/off 기능만 있지만 각 슬롯마다 제품이 다름에 따라
+ 호출하는 방식이 다르다면 추가 될 때마다 코드를 고쳐야하고 버그가 생길 가능성도 높아지게되는 문제가 생겼습니다.
```java
if ("light".equals(product)){
        light.on();
} else if ("hottub".equals(product)) {
        hottub.jetsOn();}    
}
```
## 어떠한 방법으로 동작하는지 이해해봅시다.
1. 고객이 주문합니다.
```java
createOrder();
```
2. ORDER은 계산서와 그 위에 적혀있는, 고객이 주문한 메뉴 항목으로 구성 됩니다.
```java
takeOrder();
```
3. 알바생은 그 주문을 받아서 주문을 처리하기 위한 준비를 시작하는 식사준비 메소드를 호출합니다.
```java
orderUp();
```
4. Order 객체에는 음식을 준비하기 위한 모든 지시 사항이 들어있습니다. Order객체가 주방장한테 만들것을 요청합니다.
```java
makeBurger(),makeShake();
```
5. 쉐프는 Order에서 전달받은 지시 사항에 따라서 음식을 준비합니다.

## 구현해봅시다. 
1. 클라이언트는 커맨드 객체를 생성해야합니다. 커맨드 객체는 리시버에 전달할 일련의 행동으로 구성합니다.
```java
createCommandObject();
```
2. 커맨드 객체에는 행동과 리시버에 대한 정보가 같이 들어있습니다.
+ 커맨드 객체에서 제공하는 메소드는 execute() 하나뿐입니다. 이 메소드에는 **행동**을 캡슐화합니다.
```java
execute();
```
3. 클라이언트에서 인보커 객체의 setCommand() 메소드를 호출하는데 이 때 커맨드 객체를 넘겨 줍니다.
+ 그 커맨드 객체는 나중에 쓰이기 전까지 인보커 객체에 보관됩니다.
```java
setCommand();
```
> 어떤 명령을 한번에 처리하고 커맨드 객체를 지우도록 하거나 
> 저장해둔 명령을 여러번 수행하도록 처리할 수 있습니다.

4. 인보커에서 커맨드 객체의 excute() 메소드를 호출하면 리시버에 있는 특정 행동을 하는 메소드가 호출됩니다.


## 추가되는 제품 클래스 
+ 차고 문을 열기위한 GarageDorrOpenCommand 클래스를 생성해보자.


## 이를 통해 우리가 알 수 있는점들을 살펴보자 
+ 커맨드 객체는 일련의 행동을 특정 리시버하고 연결시킴으로써 요구사항을 캡슐화한 패턴입니다.
+ 행동과 리시버를 한 객체에 집어넣고 excute()라는 메소드 하나만 외부에 공개하는 방법을 씁니다.
+ 이 메소드 호출에 의해서만 리시버에서 일련의 작업이 처리되는 것이죠 
+ 외부에 보았을 때는 어떤 객체가 리시버역할(특정메소드를 호출) 을 하고 있는지 알 수 없습니다.

```java
// execute 메소드를 호출해서 수행하게 되면 이 메소드에서는 리시버에 특정작업을 처리하라는 지시를 전달합니다. 
public interface Command {
    execute();    
}

// Invoker 란 커맨드 객체에게 특정작업을 수행해달라는 요구를하게 됩니다.
setCommand()

/**
  * Reciver 란 요구사항을 수행하기 위해 어떤일을 처리하는 지 알고있는 객체입니다.
  * ex)GarageDoor.java Light.java  
  */

action();


/**
  * ConcreateCommand 란 특정행동과 리시버 사이를 연결해주는 객체입니다.
  * ex)LightOnCommand.java,GarageDoorOpenCommand.java
  */
    

```

### 결론적으로
+ command pattern 을 이용하면 요청하는 객체와 그 요청을 수행하는 객체를 분리
+ 분리 시키는 과정의 중심에 Command 객체가 존재한다
+ 이 Command 는 Receiver 를 캡슐화 한다.
+ Invoker 는 Command 를 통해서 execute() 함수를 호출한다.
+ execute() 커맨드는 Command 를 확장하여 작업 취소 기능을 구현할 수 있다.

> 알바생 == 인보커객체    
> 주방장 == 리시버객체    
> 주문서 == 커맨드객체   
> orderUp == execute()   
> 손님  == 클라이언트 객체   
> takeOrder() == setCommand()   


# 7.템플릿메소드 패턴 
 
> 어떤 작 알고리즘의 골격을 정의합니다   
> 일부 단계는 서블클래스에서 구현하도록할 수 있습니다
> 템플릿 메소드를 이용하면 알고리즘의 구조는 그대로 유지 하면서 특정 단계만 서브 클래스에서 새로 정의하도록할 수 있습니다.

## 요구사항
1. 음료를 만들 때 아래와 같은 방법으로 제작해주세요 
   1. 스타버즈 커피 만드는법 
      1. 물을 끓인다.
      2. 끓는 물에 커피를 우려낸다
      3. 커피를 컵에 따른다.
      4. 설탕과 우유를 추가한다.
   2. 스타버즈 홍차 만드는법 
      1. 물을 끓인다.
      2. 끓는 물에 차를 우려낸다.
      3. 차를 컵에 따른다
      4. 레몬을 추가한다.


## 구현해봅시다. 

1. Coffee와 Tea는 서로 별반 다르지 않습니다.
2. 코드가 중복되어 있으면 디자인을 고쳐야하지 않을까하는 생각을 해야합니다.
3. 공통적인 부분을 추상화 시켜서 베이스 클래스를 만드는게 좋지 않을까요 ?

## 두가지 만드는 법의 알고리즘은 똑같 다는 것을 알 수있습니다. 
1. 물을 끓인다, 만들어진 음료를 컵에 따른다
2. 뜨거운 물을 이용하여 커피 또는 홍차를 만든다, 각 음료에 맞는 첨가물을 추가한다.

## prepareRecipe()를 추상화하기
1. Coffee에서는 `brewCoffeeGrinde`와 `addSugarAndMilk()` 를 쓰지만 
2. Tea에서는  `steepTeaBag`와 `addLemon`을 사용한다는 것입니다.

위를 통해 알 수 있는 것은 메소드의 이름 너무나 정확한다는 것입니다. 이를 추상화하여 둘을 동시에 쓸수 있는 메소드를 생성해봅시다   
첫번째는 `brew`라는 메소드를 사용하고 `addCondiments` 이름을 사용하게 합시다.

## 템플릿 메소드 패턴을 이해해봅시다. 
1. `prepareRecipe`는 템플릿 메소드 패턴입니다.
   1. prepareRecipe 메소드
   2. 어떤 알고리즘에 대한 템플릿 역할을 합니다.이 경우에는 카페인이 들어 있는 음료를 만들기 위한 알고리즘에 대한 템플릿이죠
   3. 어떤 메소드는 내부에서 구현되어 사용되지만 어떤 메소드는 외부에서 구현되어 사용되기도 합니다.
   4. 즉 `한 개 이상의 단계가 서브클래스에 의해 제공될 수있다는 것입니다.`

## 첫번째 방법과 템플릿 메소드 패턴을 적용한 차이점을 알아봅시다. 
|처음 만들었던 음료 | 템플릿 메소드 패턴을 적용한 음료 |
|:---:|:---:|
|Coffe와 Tea가 각각 작업을 처리 두 클래스에서 각자 알고리즘이 있다. | CoffeineBeverage 클래스에서 작업을 처리, 알고리즘을 혼자 독점 |
|Coffe와 Tea에 중복된 코드가 있다. | CoffeineBeverage 덕분에 서브 클래스에서 코드를 재사용할 수 있습니다. | 
|알고리즘이 바뀌면 서브클래스를 전부 열어서 여러군데를 고쳐야합니다. |  알고리즘을 한군데 모여있기 때문에 해당 부분만 수정하면됩니다.|
|클래스 구조상 새로운 음료를 추가하려면 꽤 많은 일을 해야합니다. | 다른 것을 추가할 때 좀 더 쉽게 적용이 가능합니다.| 
| 알고리즘에 대한 지식과 구현 방법이 여러 클래스에 분산되었습니다. | CoffeBeverage 클래스에 알고리즘에 대한 지식이 집중 되어있으며 일부 구현만 서브클래스에 의존합니다.|

## 구조를 좀더 들여다 봅시다.
1. AbstractClass
   + 템플릿 메소드가 들어 있습니다.
   + abstract 메소드로 선언된 단계들이 메소드에서 활용됩니다.
2. ConcreateClass 
   1. 여러개가 있을 수 있습니다. 
   2. 각 클래스에서는 템플릿 메소드에서 요구하는 모든 단계들을 제공해야합니다.
   3. 구현해야할 메소드들은 여기에서 구현하게 됩니다.

## 템프릿 메소드와 후크 
+ 후크는 추상클래스에서 선언되는 메소드긴 하지만 기본적인 내용만 구현되어 있거나 `아무코드도 들어있지 않은 메소드`입니다. 
+ 서브 클래스에서는 다양한 위치에서  알고리즘에 끼어들 수 있습니다.


