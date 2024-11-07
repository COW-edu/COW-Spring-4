# 2주차 학습 내용
과제를 완벽하게 하지 못했습니다.
함수를 최대한 작게 만드려고 노력했는데 클래스 구분을 잘 못한 것 같고 매직넘버도 너무 많은 것 같고 많이 부족한 거 같습니다.
솔직히 GPT 많이 썼고 인터넷에 올라와 있는거나 이전 COW 사람들이 올린 PR 보면서 해본다고 해봤는데 많이 부족한거 같네요 앞으로 공부 더 열심히 하겠습니다.
JDK 버전도 11로 맞춰두고 했는데 제 컴퓨터에선 작동엔 문제가 없는데 계속해서

WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by camp.nextstep.edu.missionutils.Console (file:/C:/Users/lc011/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.0.0/dad5230ec970560465a42a1cade24166e6a424f4/mission-utils-1.0.0.jar) to field java.util.Scanner.sourceClosed
WARNING: Please consider reporting this to the maintainers of camp.nextstep.edu.missionutils.Console
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release

이런 오류가 뜨네요 찾아보니까 자바 9이상에서 발생하는 스캐너 관련 오류 인거 같은데 실행에 문제 없으면 무시해도 된다고 해서 일단 제출해봅니다.
열심히 하겠습니다.

---

## enum

Enumeration, 열거형, 상수 데이터들의 집합
핵심은 상수를 객체 지향적으로 객체화해서 관리하자
C언어의 enum은 상수, C++의 enum은 타입이지만 JAVA의 enum은 독립된 특수한 클래스로, 객체 취급이라 힙 메모리에 저장된다.


enum을 사용하면 구현의 의도가 열거임을 분명히 할 수 있으며 자체 클래스 상수 같은건 switch문에서 사용 못하기도 하는데 이 친구는 가능하다.
또한 데이터의 그룹화 및 관리에 용이하다.

```
// 계절 열거 타입
enum Season {
    SPRING("봄"),
    SUMMER("여름"),
    FALL("가을"),
    WINTER("겨울");
}
```
```
//실제로는 이렇다 (enum 나오기 전에는 이렇게 썼다)
//자기자신의 인스턴스를 만들어서 상수화하는 것
final class Season {
    public static final Season SPRING = new Season("봄");
    public static final Season SUMMER = new Season("여름");
    public static final Season AUTUMN = new Season("가을");
    public static final Season WINTER = new Season("겨울");
```

[자바 Enum 열거형 타입 문법 & 응용 💯 정리](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%97%B4%EA%B1%B0%ED%98%95Enum-%ED%83%80%EC%9E%85-%EB%AC%B8%EB%B2%95-%ED%99%9C%EC%9A%A9-%EC%A0%95%EB%A6%AC#:~:text=Enum%20%EC%97%B4%EA%B1%B0%20%ED%83%80%EC%9E%85)

---

## Stream

스트림이란, 자바 8부터 추가된 컬렉션의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자이다.

```
//String 배열
String[] strArray = { "홍길동", "이순신", "임꺽정"};
Stream<String> strStream = Arrays.stream(strArray);
strStream.forEach(a -> System.out.print(a + ","));
System.out.println();
		
//int 배열
int[] intArray = { 1, 2, 3, 4, 5 };
IntStream intStream = Arrays.stream(intArray);
intStream.forEach(a -> System.out.print(a + ","));
System.out.println();

```

이 경우 stream() 메소드로 스트림 객체를 얻은 후 strStream.forEach()를 통해 실행된다.

스트림의 장점은 배열과 컬렉션을 함수형으로 처리해 코드를 간결하게 작성할 수 있다는 것,
스트림을 활용해 간단하게 병렬처리가 가능하다는 점 등이 있다.

[[Java] 자바 스트림(Stream) 사용법 & 예제](https://coding-factory.tistory.com/574)<br/>
[Java 스트림 Stream (1) 총정리](https://futurecreator.github.io/2018/08/26/java-8-streams/)

### 병렬처리

하나의 작업을 둘 이상의 작업으로 세분화해서 동시에 진행하는 것
list.parallelStream() 이라는 메소드를 사용하면 여러개의 스레드가 병렬적으로 데이터를 처리한다.

```
Sequential Stream:
one - Thread: main
two - Thread: main
three - Thread: main
four - Thread: main
five - Thread: main

Parallel Stream:
one - Thread: ForkJoinPool.commonPool-worker-3
two - Thread: ForkJoinPool.commonPool-worker-1
three - Thread: ForkJoinPool.commonPool-worker-2
four - Thread: ForkJoinPool.commonPool-worker-3
five - Thread: ForkJoinPool.commonPool-worker-1
```

이런 식으로 순차 스트림의 경우 단일 스레드 (main 스레드)를 통해, 병렬스트림의 경우 동시에 여러 스레드를 통해 데이터를 처리한다.
(또한 이름에서 보이듯 순차 스트림은 데이터 처리 순서 = 입력 순서이다. 병렬은 무작위)

### 람다식

람다식이란, 식별자없이 실행가능한 함수이다.
함수를 따로 생성하지 않고 코드 한줄로 간결하게 호출하는 방식이다.

```
//식별자(multiply)를 통해 일반 메서드로 정의된 함수
public int multiply(int x, int y) {
    return x * y;
}
```
```
//식별자 없이 정의된 람다식
(int x, int y) -> x * y
```
람다식을 사용하면 코드를 간결하게 만들 수 있지만, 재귀로 만들기엔 부적합하다는 단점이 있다.
또한, 기본적으로 즉석에서 정의되고 실행되기 때문에, 기본적으로는 재사용이 불가능하다.
람다식을 재사용가능한 함수로 만들기 위해서는 람다식을 변수에 저장하거나 또 다른 메소드로 정의해야한다.

[[Java] 람다식(Lambda Expressions) -> 사용법 & 예제](https://coding-factory.tistory.com/265)

---

## IllegalArgumentException

메소드가 유효하지 않거나 컨텍스트에서 부적절한 인수를 받았을 때 발생하는 런타임 예외처리이다.
과제에서 사용한 IllegalArgumentException의 경우 입력받은 당첨 로또 번호가 6개인지, 중복된 번호를 입력받았는지, 입력받은 번호의 범위가 1~45 인지 검증하는 메소드에서 사용됐다.

```
private void validateNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
```

---

## 매직 넘버

매직 넘버는 코드에서 값의 의미나 목적이 명확하게 알려지지 않은 것이다.
이러한 매직 넘버는 코드의 가독성이 떨어지고 유지 보수가 어렵게 만들기에 상수나 변수를 사용해야 한다.

```
// 3.14의 의미가 무엇인지 명확하게 명시되어 있지 않음
function calculateArea(radius) {
    return 3.14 * radius * radius;
}
```
```
// 이렇게 확장자 값을 직접적으로 사용해도 매직 넘버가 됨
function getFileType(fileName) {
    if (fileName.endsWith(".jpg")) {
        return "image";
    } else if (fileName.endsWith(".mp3")) {
        return "audio";
    } else if (fileName.endsWith(".txt")) {
        return "text";
    } else {
        return "unknown";
    }
}
```
```
// 이렇게 new Date(birthDate).getFullYear();가 어떤 의미인지 정확히 명시되어 있지 않은 것도 매직 넘버가 될 수 있음
function calculateAge(birthDate) {
  const currentYear = new Date().getFullYear();
  const birthYear = new Date(birthDate).getFullYear();
  return currentYear - birthYear;
}
```
