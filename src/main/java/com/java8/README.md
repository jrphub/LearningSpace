## Java8 Features



### Functional Interface

A **functional interface** is an interface that contains only one abstract method.

- It can have any number of default and static methods.

- Example : 

    - Runnable : run()
    - ActionListener: actionPerformed()
    - Comparable: compareTo()
    - Callable: call()

- Also called as Single Abstract Method (SAM) Interface.

- Lambda Expression and Method Reference are the instance of Functional Interface.

- Before Java8, we had to create anonymous inner class objects or implement these interfaces

    ```java
    //before Java8, we had to create anonymous inner class
    new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread Started!");
        }
    }).start();
    
    //lambda expression
    new Thread(() -> System.out.println("Thread Started!")).start();
    ```

- @FunctionalInterface annotation is used to ensure that the functional interface can’t have more than one abstract method. Not mandatory to use it.

    ```java
    @FunctionalInterface
    public interface BSquare {
        int calculate(int x);
    }
    
    class calculator {
        public static void main(String[] args) {
            int a = 5;
            //lambda expression : instance of Functional Interface
            BSquare s = (int x) -> x * x;
            System.out.println(s.calculate(a));
        }
    }
    ```

- Java8 includes 4 main kind of Functional Interfaces

    - Consumer -> BiConsumer : accept()
    - Predicate -> BiPredicate : test()
    - Function -> BiFunction, Unary Operator, Binary Operator : apply()
    - Supplier : get()

#### Consumer

```java
Consumer<Integer> consumer = (value) -> System.out.println(value);

consumer.accept(5);
```

#### Predicate

```java
Predicate predicate = (value) -> value != null;

predicate.test(5);
```

#### Function

A function is a type of functional interface in Java that receives only a single argument and returns a value after the required processing.

##### 	Bi-Function

```java
@FunctionalInterface
public interface BiFunction<T, U, R> 
{
 
   R apply(T t, U u);
    .......
 
}
```

​		T & U are inputs and there is only one output R

##### 			Unary Operator

```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, U> 
{
    ……...	
}
```

​		It accepts only one argument and returns a single argument. Both input and output values must be identical and of the same type.		

##### 			Binary Operator

```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, U, R> 
{
    ……...
}
```

​		It takes two values and returns one value, but input and output value type must be identical and of the same type.

#### 	Supplier

​	The Supplier functional interface is also a type of functional interface that does not take any input or argument and yet returns a single output.  

```java
@FunctionalInterface
public interface Supplier<T>{
 
// gets a result
………….
 
// returns the specific result
…………
 
T.get();
 
}
```

### Lambda Expression

Lambda expressions basically express instances of functional interfaces.

- lambda expressions provide below functionalities.
  - Enable to treat functionality as a method argument, or code as data.
  - A function that can be created without belonging to any class.
  - A lambda expression can be passed around as if it was an object and executed on demand.

```java
public class CLambdaExpressionTwoArgs {

    @FunctionalInterface
    interface FunctInterface1 {
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface FuncInterface2 {
        void sayMessage(String msg);
    }

    private int operate(int a, int b, FunctInterface1 obj1) {
        return obj1.operation(a, b);
    }

    public static void main(String[] args) {
        FunctInterface1 add = (x, y) -> x + y; //Integer::sum
        FunctInterface1 multiply = (x, y) -> x * y;

        CLambdaExpressionTwoArgs test = new CLambdaExpressionTwoArgs();
        System.out.println("Addition : " + test.operate(5, 2, add));
        System.out.println("Multiplication : " + test.operate(5, 2, multiply));

        FuncInterface2 fobj = m -> System.out.println(m); //System.out::println
        fobj.sayMessage("calculation completed");
    }

}
```

**Creating Thread using Lambda Expression**

```java
public class DThreadLambda {
    public static void main(String[] args) {
        // Creating Lambda expression for run() method in
        // functional interface "Runnable"
        Runnable runnable = () -> {
            Thread.currentThread().setName("Test Thread");
            System.out.println(Thread.currentThread().getName() + " is running");
        };

        // Instantiating Thread class by passing Runnable
        // reference to Thread constructor
        Thread thread = new Thread(runnable);

        //Starting the thread
        thread.start();
    }
}
```

**Checking if String contains only Alphabet**

```java
public class ECheckAllString {

    static Predicate<String> p = ECheckAllString::test;

    //sol2 : static Predicate<String> p = s -> s.matches("^[a-zA-Z]*$");

    public static boolean isAllString(String str) {
        //sol1 : return (str != null) && (str != "") && str.chars().allMatch(Character::isLetter);
        return (str != null) && (str != "") && p.test(str);
    }

    public static void main(String[] args) {
        System.out.println("For XYZ :" + ECheckAllString.isAllString("XYZ")); //true
        System.out.println("For XYZ12 :" + ECheckAllString.isAllString("XYZ12")); //false
        System.out.println("For null :" + ECheckAllString.isAllString(null)); //false
        System.out.println("For empty :" + ECheckAllString.isAllString("")); //false
    }

    private static boolean test(String s) {
        return s.matches("^[a-zA-Z]*$");
    }
}
```

