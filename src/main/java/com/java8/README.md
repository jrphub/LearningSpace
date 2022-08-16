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
    ```

    #### Function

    A function is a type of functional interface in Java that receives only a single argument and returns a value after the required processing.

    ##### Bi-Function

    ```java
    @FunctionalInterface
    public interface BiFunction<T, U, R> 
    {
     
       R apply(T t, U u);
        .......
     
    }
    ```

​		T & U are inputs and there is only one output R

##### 		Unary Operator

```java
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, U> 
{
    ……...	
}
```

​		It accepts only one argument and returns a single argument. Both input and output values must be identical and of the same type.		

##### 		Binary Operator

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